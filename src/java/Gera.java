
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.COFINS;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.COFINS.COFINSNT;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ICMS;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.PISNT;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod;
import br.inf.portalfiscal.nfe.*;
import java.io.*;
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
import javax.xml.bind.JAXBException;
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcio
 */
public class Gera {

    public static void main(String[] args) throws JAXBException, IOException {

        SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormatSymbols simboloDecimal = DecimalFormatSymbols.getInstance();
        simboloDecimal.setDecimalSeparator('.');
        DecimalFormat formatoQuantidade = new DecimalFormat("0.0000", simboloDecimal);
        DecimalFormat formatValor = new DecimalFormat("0.00", simboloDecimal);

        TNFe nfe = new TNFe();

        TNFe.InfNFe infNFe = new TNFe.InfNFe();
        infNFe.setId("NFe31120307408744000199550010000000202000000052");
        infNFe.setVersao("2.00");
        nfe.setInfNFe(infNFe);

        TNFe.InfNFe.Ide ide = new TNFe.InfNFe.Ide();
        nfe.getInfNFe().setIde(ide);

        // cabecalho
        ide.setCNF("12345678"); // Codigo Numerico que compoe a Chave de Acesso
        ide.setCUF("31"); // Codigo da UF do emintente do Documento Fiscal
        ide.setNatOp("VENDAS"); // Natureza da Operacao
        ide.setIndPag("1"); // Indicador da forma de pagamento07
        ide.setMod("55"); // Modelo do Documento Fiscal
        ide.setSerie("1"); // Serie do Documento Fiscal
        ide.setNNF("44239"); // Numero do documento Fiscal
        ide.setDEmi("2012-03-05"); // Data de emissao do documento fiscal
        ide.setDSaiEnt("2012-03-05"); //Data de saida ou da entrada da mercadoria/produto
        ide.setHSaiEnt("16:48:00"); // Hora de saida ou da entrada da mercadoria produto
        ide.setTpNF("0"); // tipo operacao
        ide.setCMunFG("3170107"); //Codigo do municipio de Ocorrencia do Fato Gerado do icms. Utiliza a tabela do ibge municipios e paises
        ide.setTpEmis("1"); // Tipo de emissao da nfe
        ide.setTpImp("1"); // Fator de Impressao do DANFe
        ide.setCDV("8"); //Digito Verificador da Chave de Acesso da NFe
        ide.setTpAmb("1"); // 1 - Produ�ao/ 2 - Homologado
        ide.setFinNFe("1");  // Identificacao do Ambiente 1 - NFe normal/ 2 -  Nfe complementar /3 - nfe de ajuste
        ide.setProcEmi("0"); // Idenficador do processo de emissao da NF-e: Identificador do processo de
        //emiss�o da NF-e: 0 - emiss�o de NF-e com aplicativo do contribuinte; 1 - emiss�o de NF-e avulsa pelo Fisco;
        //2 - emiss�o de NF-e avulsa, pelo contribuinte com seu certificado digital, atrav�s do site do Fisco;
        //3- emiss�o NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.

        ide.setVerProc("1.0"); //Identificador da vers�o do processo de emiss�o (informar a vers�o do aplicativo emissor de NF-e).


        //emitente 
        TNFe.InfNFe.Emit emit = new TNFe.InfNFe.Emit();
        nfe.getInfNFe().setEmit(emit);
        TEnderEmi enderecoEmitente = new TEnderEmi();
        nfe.getInfNFe().getEmit().setEnderEmit(enderecoEmitente);

        emit.setCNPJ("05841502000169"); // CNPJ
        emit.setXNome("RWR COMERCIAL LTDA"); // RAZAO SOCIAL
        emit.setXFant("RWR COMERCIAL L"); // NOME FANTAZIA
        emit.setIE("7012462510053");
        emit.getEnderEmit().setXLgr("Sao PauloS"); //Logradouro 


        emit.getEnderEmit().setNro("123"); // Numero do Logradouro
        emit.getEnderEmit().setXCpl("Casa"); // Coplemente
        emit.getEnderEmit().setXBairro("Centro"); // Bairro
        emit.getEnderEmit().setCMun("3159803"); // Codigo do Municipio
        emit.getEnderEmit().setXMun("Santa Vitoria");
        emit.getEnderEmit().setUF(TUfEmi.MA); // UF
        emit.getEnderEmit().setCEP("38320000");
        emit.setCRT("1"); /* Este campo ser� obrigatoriamente preenchido com: 1 ? Simples Nacional; 2 ? Simples Nacional ? excesso de sublimite de receita bruta;
         3 ? Regime Normal. (v2.0). */
        emit.getEnderEmit().setCPais("1058"); // 1058 - Brasil
        emit.getEnderEmit().setXPais("Brasil"); //Brasil ou BRASIL
        emit.getEnderEmit().setFone("553432511651"); // Telefone

        // Destinatario
        TNFe.InfNFe.Dest dest = new TNFe.InfNFe.Dest();
        nfe.getInfNFe().setDest(dest);
        TEndereco enderecoDest = new TEndereco();
        nfe.getInfNFe().getDest().setEnderDest(enderecoDest);

        dest.setCNPJ("07408744000199"); // CNPJ do Destinatario
        dest.setXNome("NFe-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
        dest.setIE("5983475550032");
        dest.setEmail("brasvel@hotmail.com");
        dest.getEnderDest().setXLgr("Rua Sao Paulo");
        dest.getEnderDest().setNro("912");
        dest.getEnderDest().setXCpl("Brasvel");
        dest.getEnderDest().setNro("912");
        dest.getEnderDest().setXBairro("Centro");
        dest.getEnderDest().setCMun("3159803");
        dest.getEnderDest().setXMun("Santa Vitoria");
        dest.getEnderDest().setUF(TUf.MG);
        dest.getEnderDest().setCEP("38320000");
        dest.getEnderDest().setCPais("1058");
        dest.getEnderDest().setFone("3432511651");
        // dest.getEnderDest().s



        //Informacoes Adicionais
        TNFe.InfNFe.InfAdic infAdic = new TNFe.InfNFe.InfAdic();
        nfe.getInfNFe().setInfAdic(infAdic);
        infAdic.setInfAdFisco("informarcoes ao Fisco");
        infAdic.setInfCpl("Informacoes Complementares");


        // Detalhes
        List<TNFe.InfNFe.Det> listaDet = nfe.getInfNFe().getDet();
        TNFe.InfNFe.Det det = new TNFe.InfNFe.Det();
       

        listaDet.add(det);
        for (int i = 0; i < listaDet.size(); i++) {
            //Prod prod = new Prod();
            Prod prod = new Prod();
            det.setNItem("1");
            prod.setCProd("2");
            prod.setCEAN("1234561234561");
            prod.setXProd("Produto de Teste");
            prod.setNCM("99");
            prod.setEXTIPI(null);
            prod.setCFOP("5102");
            prod.setUCom("2.0000");
            prod.setQCom("10");
            prod.setVUnCom("18"); // Valor Unitario  de Comercializacao
            prod.setVProd("180.00");
            prod.setCEANTrib("1234561234561"); // Preencher com o codigo GTIN 8, GTIN-12, GTIN-13 ou GTIN 14) da unidade tributavel do produto, nao informar
            //o conteudo da TAG  em caso de o produto nao possuir este codigo 
            prod.setUTrib("8"); // Valor Unit�rio de tributa��o 
            prod.setQTrib("8");// Quantidade Tributavel
            prod.setVUnTrib("90.0000");
            prod.setIndTot("1");
            prod.setVFrete(null);
            prod.setVSeg(null);
            prod.setVDesc(null);
            TNFe.InfNFe.Det.Imposto imp = new TNFe.InfNFe.Det.Imposto();
            det.setImposto(imp);
            TNFe.InfNFe.Det.Imposto.ICMS nicms = new TNFe.InfNFe.Det.Imposto.ICMS();
            det.getImposto().setICMS(nicms);
            TNFe.InfNFe.Det.Imposto.ICMS.ICMS00 icms00 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMS00();
            det.getImposto().getICMS().setICMS00(icms00);

            det.getImposto().getICMS().getICMS00().setCST("");
            det.getImposto().getICMS().getICMS00().setOrig(null);
            det.getImposto().getICMS().getICMS00().setModBC(null);
            det.getImposto().getICMS().getICMS00().setVBC(null);
            det.getImposto().getICMS().getICMS00().setPICMS(null);
            det.getImposto().getICMS().getICMS00().setVICMS(null);

            TNFe.InfNFe.Det.Imposto.PIS pis = new TNFe.InfNFe.Det.Imposto.PIS();
            det.getImposto().setPIS(pis);
            TNFe.InfNFe.Det.Imposto.PIS.PISOutr pISOutr = new TNFe.InfNFe.Det.Imposto.PIS.PISOutr();
            det.getImposto().getICMS().setICMS00(icms00);

            det.getImposto().getICMS().getICMS00().setCST(null);

            det.getImposto().getICMS().getICMS00().setOrig("1"); // Origem da Mercadoria
            det.getImposto().getICMS().getICMS00().setCST("00");
            det.getImposto().getICMS().getICMS00().setModBC("0"); // Modalidade de Bc Icms
            det.getImposto().getICMS().getICMS00().setVBC("180");
            det.getImposto().getICMS().getICMS00().setPICMS("18");
            det.getImposto().getICMS().getICMS00().setVICMS("3440");

            TNFe.InfNFe.Det.Imposto.PIS npis = new TNFe.InfNFe.Det.Imposto.PIS();
            det.getImposto().setPIS(npis);
            TNFe.InfNFe.Det.Imposto.PIS.PISOutr pisOutr = new TNFe.InfNFe.Det.Imposto.PIS.PISOutr();
            det.getImposto().getPIS().setPISOutr(pisOutr);

            det.getImposto().getPIS().setPISOutr(pisOutr);

            det.getImposto().getPIS().getPISOutr().setCST("50");
            det.getImposto().getPIS().getPISOutr().setVBC("0");
            det.getImposto().getPIS().getPISOutr().setPPIS("0");
            det.getImposto().getPIS().getPISOutr().setVPIS("0");

            TNFe.InfNFe.Det.Imposto.COFINS confis = new TNFe.InfNFe.Det.Imposto.COFINS();
            det.getImposto().setCOFINS(confis);
            TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr cofinsOutr = new TNFe.InfNFe.Det.Imposto.COFINS.COFINSOutr();
            det.getImposto().getCOFINS().setCOFINSOutr(cofinsOutr);

            det.getImposto().getCOFINS().getCOFINSOutr().setCST("50");
            det.getImposto().getCOFINS().getCOFINSOutr().setVBC("0");
            det.getImposto().getCOFINS().getCOFINSOutr().setPCOFINS("0");
            det.getImposto().getCOFINS().getCOFINSOutr().setVCOFINS("0");


            det.setProd(prod);

//            det.setProd(prod);
//             listaDet.get(i).getProd().setXProd("Prdouto de Teste ");
//             listaDet.get(i).getProd().setCProd("2");
//             listaDet.get(i).getProd().setNCM("99");
//             listaDet.get(i).getProd().setCFOP("5102");
//             listaDet.get(i).getProd().setQCom("UND");
//             listaDet.get(i).getProd().setUCom("2.0000");
//             listaDet.get(i).getProd().setVProd("180.00");
//             listaDet.get(i).getProd().setUTrib("UND");
//             listaDet.get(i).getProd().setVUnTrib("90.0000");
//             listaDet.get(i).getProd().setIndTot("1");
//             //det.setProd(null);
        }
//        Imposto imposto = new Imposto();
//
//        ICMS icms = new ICMS();
//        ICMSSN500 icmssn500 = new ICMSSN500();
//        icmssn500.setOrig("0");
//        icmssn500.setCSOSN("500");
//        icmssn500.setVBCSTRet("0.00");
//        icmssn500.setVICMSSTRet("0.00");
//        icms.setICMSSN500(icmssn500);

//        IPI ipi = new IPI();
//        ipi.setCEnq("N");
//        ipi.setIPITrib();


//        PIS pis = new PIS();
//        PISNT pisnt = new PISNT();
//        pisnt.setCST("07");
//        pis.setPISNT(pisnt);
//
//        COFINS cofins = new COFINS();
//
//        COFINSNT cofinsnt = new COFINSNT();
//        cofinsnt.setCST("07");
//        cofins.setCOFINSNT(cofinsnt);



        //  imposto.setICMS(icms);
//        imposto.setIPI(ipi);
        // imposto.setCOFINS(cofins);

        //   det.setImposto(imposto);


        //  det.setImposto(imposto);

        TNFe.InfNFe.Total total = new TNFe.InfNFe.Total();
        nfe.getInfNFe().setTotal(total);
        TNFe.InfNFe.Total.ICMSTot imCMSTot = new TNFe.InfNFe.Total.ICMSTot();
        nfe.getInfNFe().getTotal().setICMSTot(imCMSTot);

        total.getICMSTot().setVBC("180"); //Base de Calculo ICMS
        total.getICMSTot().setVICMS("3240"); // Valor do Icms
        total.getICMSTot().setVBCST("3240"); // Base de Calculo do IcmsSt

        total.getICMSTot().setVST("180"); // Valor do ICMS ST
        total.getICMSTot().setVProd("180"); // Valor do Total de Produtos


        total.getICMSTot().setVDesc("0"); // Valor do Desconto
        total.getICMSTot().setVII("0");
        total.getICMSTot().setVIPI("0"); //Valor do IPI
        total.getICMSTot().setVPIS("0"); //Valor do Pis
        total.getICMSTot().setVCOFINS("0"); // Valor do Cofins
        total.getICMSTot().setVOutro("0");// Despesas acessorias
        total.getICMSTot().setVFrete("0");
        total.getICMSTot().setVSeg("0"); // Valor do Seguro
        total.getICMSTot().setVNF("180");

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


//        System.out.println(xmlEnviNfe);
        //MyClass instance = new MyClass(girls)

        nfe = assinarXML(nfe, , senha, xmlEnviNfe, xmlEnviNfe)

        marshaller.marshal(nfe, new FileWriter("/home/marcio/teste.xml"));
        System.out.println(xmlEnviNfe);




    }
    
     private static String assinarXML(String xml, String caminhoCertificado, char[] senha, String chaveAcesso, String digitoChaveAcesso){
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
