/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcio.teste;

import br.com.marcio.model.NfeCabecalho;
import br.com.marcio.model.NfeDestinatario;
import br.com.marcio.model.NfeDetalhe;
import br.com.marcio.model.NfeEmitente;
import br.inf.portalfiscal.nfe.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * @author marcio
 */
public class GeraXMLEnvio {

    public String gerarXMLEnvio(NfeCabecalho nfeCabecalho, NfeEmitente emitente, NfeDestinatario destinatario, List<NfeDetalhe> listaNfeDetalhe, String caminhoCertificado, char[] senha) {
        try {
            SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
            DecimalFormatSymbols simboloDecimal = DecimalFormatSymbols.getInstance();
            simboloDecimal.setDecimalSeparator('.');
            DecimalFormat formatoQuantidade = new DecimalFormat("0.0000", simboloDecimal);
            DecimalFormat formataValor = new DecimalFormat("0.00", simboloDecimal);

            TNFe nfe = new TNFe();


            TNFe.InfNFe infNFe = new TNFe.InfNFe();
            infNFe.setId("NFe" + nfeCabecalho.getChaveAcesso() + nfeCabecalho.getDigitoChaveAcesso());
            infNFe.setVersao("2.00");
            nfe.setInfNFe(infNFe);

            TNFe.InfNFe.Ide ide = new TNFe.InfNFe.Ide();
            nfe.getInfNFe().setIde(ide);

            //cabecalho
            ide.setCNF(nfeCabecalho.getCodigoNumerico());
            ide.setNatOp(nfeCabecalho.getNaturezaOperacao());
            ide.setIndPag(nfeCabecalho.getIndicadorFormaPagamento());
            ide.setMod(nfeCabecalho.getCodigoModelo());
            ide.setSerie(Integer.valueOf(nfeCabecalho.getSerie()).toString());
            ide.setNNF(Integer.valueOf(nfeCabecalho.getNumero()).toString());
            ide.setDEmi(formataData.format(nfeCabecalho.getDataEntradaSaida()));
            ide.setTpEmis(nfeCabecalho.getTipoEmissao());
            ide.setVerProc(nfeCabecalho.getVersaoProcessoEmissao().toString());
   //         ide.setCUF(emitente.getCodigoMunicipio().toString().substring(0, 2));
            ide.setCMunFG(nfeCabecalho.getCodigoMunicipio().toString());
            ide.setFinNFe(nfeCabecalho.getFinalidadeEmissao());
            ide.setTpNF(nfeCabecalho.getTipoOperacao());
            ide.setCDV(nfeCabecalho.getDigitoChaveAcesso());
            ide.setTpImp(nfeCabecalho.getFormatoImpressaoDanfe());
            ide.setProcEmi("0");
            ide.setTpAmb("2");

            //emitente
            TNFe.InfNFe.Emit emit = new TNFe.InfNFe.Emit();
            nfe.getInfNFe().setEmit(emit);
            TEnderEmi enderecoEmi = new TEnderEmi();
            nfe.getInfNFe().getEmit().setEnderEmit(enderecoEmi);

            emit.setCNPJ(emitente.getCpfCnpj());
            emit.setIE(emitente.getIe());
            emit.setXNome(emitente.getRazaoSocial());
            emit.setXFant(emitente.getFantasia());
            emit.getEnderEmit().setXLgr(emitente.getLogradouro());
            emit.getEnderEmit().setNro(emitente.getNumero());
            emit.getEnderEmit().setXCpl(emitente.getComplemento());
            emit.getEnderEmit().setXBairro(emitente.getBairro());
            emit.getEnderEmit().setCMun(emitente.getNomeMunicipio());
            emit.getEnderEmit().setUF(TUfEmi.fromValue(emitente.getUf()));
            emit.getEnderEmit().setCEP(emitente.getCep());
       //     emit.setCRT(emitente.getCrt().toString());
            emit.getEnderEmit().setCPais(emitente.getCodigoPais().toString());
            emit.getEnderEmit().setXPais(emitente.getNomePais());
            emit.getEnderEmit().setFone(emitente.getTelefone());

            // destinatario
            TNFe.InfNFe.Dest dest = new TNFe.InfNFe.Dest();
            nfe.getInfNFe().setDest(dest);
            TEndereco enderecoDest = new TEndereco();
            nfe.getInfNFe().getDest().setEnderDest(enderecoDest);

            dest.setXNome(destinatario.getRazaoSocial());
            dest.setXNome("NFe-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
            if (destinatario.getCpfCnpj().length() == 14) {
                dest.setCNPJ(destinatario.getCpfCnpj());
            } else {
                dest.setCPF(destinatario.getCpfCnpj());
            }

            dest.setIE(destinatario.getIe());
            dest.getEnderDest().setXLgr(destinatario.getLogradouro());
            dest.getEnderDest().setNro(destinatario.getNumero());
            dest.getEnderDest().setXCpl(destinatario.getComplemento().equals("") ? null : destinatario.getComplemento());
            dest.getEnderDest().setXBairro(destinatario.getBairro());
            dest.getEnderDest().setCMun(destinatario.getCodigoMunicipio().toString());
            dest.getEnderDest().setXMun(destinatario.getNomeMunicipio());
            dest.getEnderDest().setUF(TUf.fromValue(destinatario.getUf()));
            dest.getEnderDest().setCEP(destinatario.getCep());
            dest.getEnderDest().setCPais(destinatario.getCodigoPais().toString());
            dest.getEnderDest().setXPais(destinatario.getNomePais());
            dest.getEnderDest().setFone(destinatario.getTelefone().equals("") ? null : destinatario.getTelefone());

            //informacao adicionais
            TNFe.InfNFe.InfAdic infAdic = new TNFe.InfNFe.InfAdic();
            nfe.getInfNFe().setInfAdic(infAdic);

            infAdic.setInfAdFisco(nfeCabecalho.getInformacoesAddFisco());
            infAdic.setInfCpl(nfeCabecalho.getInformacoesComplementares());

            //detalhes 
            List<TNFe.InfNFe.Det> listDet = nfe.getInfNFe().getDet();
            TNFe.InfNFe.Det det;
            NfeDetalhe nfeDetalhe;
            for (int i = 0; i < listaNfeDetalhe.size(); i++) {
                nfeDetalhe = listaNfeDetalhe.get(i);

                det = new TNFe.InfNFe.Det();
                TNFe.InfNFe.Det.Prod prod = new TNFe.InfNFe.Det.Prod();
             //   det.setNItem(nfeDetalhe.getNumeroItem().toString());
                det.setProd(prod);

                det.getProd().setCProd(nfeDetalhe.getGtin());
                det.getProd().setCEAN(nfeDetalhe.getGtin());
                det.getProd().setXProd(nfeDetalhe.getNomeProduto());
                det.getProd().setNCM(nfeDetalhe.getNcm());
                det.getProd().setEXTIPI(null);
//                det.getProd().setCFOP(nfeDetalhe.getCfop().toString());
//                det.getProd().setUCom(nfeDetalhe.getValorUnitarioComercial().toPlainString());
//                det.getProd().setVProd(formataValor.format(nfeDetalhe.getValorTotal()));
                det.getProd().setCEANTrib(nfeDetalhe.getGtinUnidadeTributavel());
                det.getProd().setUTrib(nfeDetalhe.getUnidadeTributavel());
//                det.getProd().setQTrib(formatoQuantidade.format(nfeDetalhe.getQuantidadeTributavel()));
//                det.getProd().setVUnTrib(nfeDetalhe.getValorUnitarioTributacao().toPlainString());
                det.getProd().setIndTot("1");
                det.getProd().setVFrete(null);
                det.getProd().setVSeg(null);
                det.getProd().setVDesc(null);
                det.setInfAdProd(nfeDetalhe.getInformacoesAdicionais());

                TNFe.InfNFe.Det.Imposto imposto = new TNFe.InfNFe.Det.Imposto();
                det.setImposto(imposto);
                TNFe.InfNFe.Det.Imposto.ICMS icms = new TNFe.InfNFe.Det.Imposto.ICMS();
                det.getImposto().setICMS(icms);
                TNFe.InfNFe.Det.Imposto.ICMS.ICMS00 icms00 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMS00();
                det.getImposto().getICMS().setICMS00(icms00);

//                det.getImposto().getICMS().getICMS00().setCST(nfeDetalhe.getCstIcms().substring(1, 3));
//                det.getImposto().getICMS().getICMS00().setOrig(nfeDetalhe.getOrigemMercadoria());
//                det.getImposto().getICMS().getICMS00().setModBC(nfeDetalhe.getModalidadeBcIcms());
//                det.getImposto().getICMS().getICMS00().setVBC(formataValor.format(nfeDetalhe.getBaseCalculoIcms()));
//                det.getImposto().getICMS().getICMS00().setPICMS(formataValor.format(nfeDetalhe.getAliquotaIcms()));
//                det.getImposto().getICMS().getICMS00().setVICMS(formataValor.format(nfeDetalhe.getValorIcms()));

                TNFe.InfNFe.Det.Imposto.PIS pis = new TNFe.InfNFe.Det.Imposto.PIS();
                det.getImposto().setPIS(pis);
                TNFe.InfNFe.Det.Imposto.PIS.PISOutr pisOutr = new TNFe.InfNFe.Det.Imposto.PIS.PISOutr();
                det.getImposto().getPIS().setPISOutr(pisOutr);

////                det.getImposto().getPIS().getPISOutr().setCST(nfeDetalhe.getCstPis());
////                det.getImposto().getPIS().getPISOutr().setVBC(formataValor.format(nfeDetalhe.getValorBaseCalculoPis()));
////                det.getImposto().getPIS().getPISOutr().setPPIS(formataValor.format(nfeDetalhe.getValorPis()));
////                det.getImposto().getPIS().getPISOutr().setVPIS(formataValor.format(nfeDetalhe.getValorPis()));

                TNFe.InfNFe.Det.Imposto.COFINS cofins = new TNFe.InfNFe.Det.Imposto.COFINS();
                det.getImposto().setCOFINS(cofins);
                TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr cofinsOutr = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr();
                det.getImposto().getCOFINS().setCOFINSOutr(cofinsOutr);
//
//                det.getImposto().getCOFINS().getCOFINSOutr().setCST(nfeDetalhe.getCstCofins());
//                det.getImposto().getCOFINS().getCOFINSOutr().setVBC(formataValor.format(nfeDetalhe.getBaseCalculoCofins()));
//                det.getImposto().getCOFINS().getCOFINSOutr().setPCOFINS(formataValor.format(nfeDetalhe.getValorCofins()));
//                det.getImposto().getCOFINS().getCOFINSOutr().setVCOFINS(formataValor.format(nfeDetalhe.getValorCofins()));

                listDet.add(det);
            }

            TNFe.InfNFe.Total total = new TNFe.InfNFe.Total();
            nfe.getInfNFe().setTotal(total);
            TNFe.InfNFe.Total.ICMSTot icmsTot = new TNFe.InfNFe.Total.ICMSTot();
            nfe.getInfNFe().getTotal().setICMSTot(icmsTot);
//
//            total.getICMSTot().setVBC(formataValor.format(nfeCabecalho.getBaseCalculoIcms()));
//            total.getICMSTot().setVICMS(formataValor.format(nfeCabecalho.getValorIcms()));
//            total.getICMSTot().setVBCST(formataValor.format(nfeCabecalho.getBaseCalculoIcmsSt()));
//            total.getICMSTot().setVST(formataValor.format(nfeCabecalho.getValorIcmsSt()));
//            total.getICMSTot().setVProd(formataValor.format(nfeCabecalho.getValorTotalProdutos()));
//            total.getICMSTot().setVFrete(formataValor.format(nfeCabecalho.getValorFrete()));
//            total.getICMSTot().setVSeg(formataValor.format(nfeCabecalho.getValorSeguro()));
//            total.getICMSTot().setVDesc(formataValor.format(nfeCabecalho.getValorDesconto()));
//            total.getICMSTot().setVII(formataValor.format(BigDecimal.ZERO));
//            total.getICMSTot().setVIPI(formataValor.format(nfeCabecalho.getValorIpi()));
//            total.getICMSTot().setVPIS(formataValor.format(nfeCabecalho.getValorPis()));
//            total.getICMSTot().setVCOFINS(formataValor.format(nfeCabecalho.getValorCofins()));
//            total.getICMSTot().setVOutro(formataValor.format(nfeCabecalho.getValorDespesasAcessorias()));
//            total.getICMSTot().setVNF(formataValor.format(nfeCabecalho.getValorTotal()));

            TNFe.InfNFe.Transp transp = new TNFe.InfNFe.Transp();
            nfe.getInfNFe().setTransp(transp);
            TNFe.InfNFe.Transp.Transporta transporta = new TNFe.InfNFe.Transp.Transporta();
            nfe.getInfNFe().getTransp().setTransporta(transporta);

            transp.setModFrete("1");
            /*transp.getTransporta().setCNPJ("");
             transp.getTransporta().setXNome("");
             transp.getTransporta().setIE("");
             transp.getTransporta().setXEnder("");
             transp.getTransporta().setXMun("");
             transp.getTransporta().setUF(null);*/

            TEnviNFe enviNFe = new TEnviNFe();
            enviNFe.setIdLote("1");
            enviNFe.setVersao("2.00");
            enviNFe.getNFe().add(nfe);

            JAXBContext jc = JAXBContext.newInstance("br.inf.portalfiscal.nfe");
            Marshaller marshaller = jc.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            JAXBElement<TEnviNFe> element = new ObjectFactory().createEnviNFe(enviNFe);

            StringWriter writer = new StringWriter();
            marshaller.marshal(element, writer);

            String xmlEnviNfe = writer.toString();
            xmlEnviNfe = xmlEnviNfe.replaceAll("xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "");
            xmlEnviNfe = xmlEnviNfe.replaceAll("<NFe>", "<NFe xmlns=\"http://www.portalfiscal.inf.br/nfe\">");
            
            System.out.println(xmlEnviNfe);
            return  assinarXML(xmlEnviNfe, caminhoCertificado , senha, nfeCabecalho.getChaveAcesso(), nfeCabecalho.getDigitoChaveAcesso());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    
    private String assinarXML(String xml, String caminhoCertificado, char[] senha, String chaveAcesso, String digitoChaveAcesso){
         try {
            XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

            List<Transform> listTransforms = new ArrayList<Transform>();
            listTransforms.add(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
            listTransforms.add(fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null));

            Reference ref = fac.newReference("#NFe" + chaveAcesso + digitoChaveAcesso,
                    fac.newDigestMethod(DigestMethod.SHA1, null),
                    listTransforms, null, null);
            SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                    (C14NMethodParameterSpec) null),
                    fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));

            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream(caminhoCertificado), senha);
            String alias = ks.aliases().nextElement();
            KeyStore.PrivateKeyEntry keyEntry =
                    (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(senha));
            X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

            KeyInfoFactory kif = fac.getKeyInfoFactory();
            List x509Content = new ArrayList();
            x509Content.add(cert);
            X509Data xd = kif.newX509Data(x509Content);
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));

            DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getElementsByTagName("NFe").item(0));

            XMLSignature signature = fac.newXMLSignature(si, ki);

            signature.sign(dsc);

            StringWriter writer = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.transform(new DOMSource(doc), new StreamResult(writer));
           
            return writer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
