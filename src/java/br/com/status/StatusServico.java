package br.com.status;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.inf.portalfiscal.www.nfe.wsdl.nfestatusservico2.NfeStatusServico2Stub;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.commons.httpclient.protocol.Protocol;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class StatusServico {

    public String verificaStatusServico(String caminhoCertificado, char[] senha) {
        try {
            String codigoUf = "53";
            String ambiente = "2";
            String versaoDados = "2.00";
            String url = "https://homologacao.nfe.sefazvirtual.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";

            //cria o xml de requisição
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                    + "<consStatServ versao=\"2.00\" xmlns=\"http://www.portalfiscal.inf.br/nfe\">"
                    + "<tpAmb>" + ambiente + "</tpAmb>"
                    + "<cUF>" + codigoUf + "</cUF>"
                    + "<xServ>STATUS</xServ>"
                    + "</consStatServ>";

            //busca os dados do certificado digital
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream(caminhoCertificado), senha);
            String alias = ks.aliases().nextElement();
            X509Certificate certificate = (X509Certificate) ks.getCertificate(alias);
            PrivateKey privatekey = (PrivateKey) ks.getKey(alias, senha);
            SocketFactoryDinamico socketFactory = new SocketFactoryDinamico(certificate, privatekey);
            //arquivo que contém a cadeia de certificados do serviço a ser consumido
            socketFactory.setFileCacerts(this.getClass().getResourceAsStream("/br/inf/portalfiscal/nfe/jssecacerts"));

            //define o protocolo a ser utilizado na conexão
            Protocol protocol = new Protocol("https", socketFactory, 443);
            Protocol.registerProtocol("https", protocol);

            //cria os dados da mensagem
            OMElement omeElement = AXIOMUtil.stringToOM(xml);
            NfeStatusServico2Stub.NfeDadosMsg nfeDadosMsg = new NfeStatusServico2Stub.NfeDadosMsg();
            nfeDadosMsg.setExtraElement(omeElement);

            //define os dados do cabecalho da mensagem
            NfeStatusServico2Stub.NfeCabecMsg nfeCabecMsg = new NfeStatusServico2Stub.NfeCabecMsg();
            nfeCabecMsg.setCUF(codigoUf);
            nfeCabecMsg.setVersaoDados(versaoDados);
            NfeStatusServico2Stub.NfeCabecMsgE nfeCabecMsgE = new NfeStatusServico2Stub.NfeCabecMsgE();
            nfeCabecMsgE.setNfeCabecMsg(nfeCabecMsg);

            //cria o serviço
            NfeStatusServico2Stub stub = new NfeStatusServico2Stub(url);

            //busca o resutado
            NfeStatusServico2Stub.NfeStatusServicoNF2Result result = stub.nfeStatusServicoNF2(nfeDadosMsg, nfeCabecMsgE);

            //processa o resultado
            ByteArrayInputStream in = new ByteArrayInputStream(result.getExtraElement().toString().getBytes());

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            Document doc = dbf.newDocumentBuilder().parse(in);


            NodeList nodeList = doc.getDocumentElement().getElementsByTagName("xMotivo");

            String retorno = "Status: ";
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                retorno += element.getTextContent();
            }

            return retorno;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Erro ao consultar o status do serviço!";
    }
}
