/*/ho
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcio.teste;

import br.com.marcio.model.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcio
 */
public class CriarNFe {

    NfeEmitente emitente = new NfeEmitente();

    public static void main(String[] args) {
        String caminhoCertificado = "/home/marcio/miranda.p12";
        char[] senha = new char[6];
        
        
        NfeCabecalho nfeCabecalho = new NfeCabecalho();
        NfeEmitente emitente = new NfeEmitente();
        
        emitente.setCpfCnpj("12345678912345");
        emitente.setIe("123456789");
        emitente.setRazaoSocial("Marcio Andre Pereria Costa");
        emitente.setFantasia("TOTAL SERVICE INFORMATICA");
        emitente.setLogradouro("Av. Lazaro Moreira 907");
        emitente.setNumero("1234");
        emitente.setComplemento("Casa");
        emitente.setBairro("Jardim Planalto");
        emitente.setNomeMunicipio("Santa Vitoria");
        emitente.setUf("MG");
        emitente.setCep("38320-000");
        emitente.setCodigoPais(12);
        emitente.setNomePais("Brasil");
        emitente.setTelefone("32511651");
        

        nfeCabecalho.setCodigoNumerico("12345678");

        nfeCabecalho.setNaturezaOperacao("5102");
        nfeCabecalho.setIndicadorFormaPagamento("0");
        nfeCabecalho.setCodigoModelo("55");
        nfeCabecalho.setSerie("1");
        nfeCabecalho.setNumero("101");
        nfeCabecalho.setDataEntradaSaida(new Date());
        nfeCabecalho.setTipoEmissao("1");
        nfeCabecalho.setVersaoProcessoEmissao(3);
        //    nfeCabecalho.setCUF(emitente.getCodigoMunicipio());
        nfeCabecalho.setCodigoMunicipio(12);
        nfeCabecalho.setCodigoMunicipio(12);
        nfeCabecalho.setFinalidadeEmissao("123");
        nfeCabecalho.setTipoOperacao("2");
        nfeCabecalho.setDigitoChaveAcesso("1212");
        nfeCabecalho.setFormatoImpressaoDanfe("0");
        Ncm ncm = new Ncm();
        ncm.setId(1);
        ncm.setCodigo("99");

        //Detalhe
        NfeDetalhe nfeDetalhe = new NfeDetalhe();
        Produto produto = new Produto();
        produto.setDescricao("Exemplo geracao XML JAXB");
        produto.setId(1);
        produto.setNcm(ncm);
        produto.setValorVenda(BigDecimal.valueOf(12));
        List<NfeDetalhe> listaNfeDetalhe = new ArrayList<NfeDetalhe>();


        
        
        
        
//        for (int i = 0; i < 10; i++) {
         //   nfeDetalhe.setProduto(produto);
            listaNfeDetalhe.add(nfeDetalhe);
//        }


        /**
         * // * Dados do Produro //
         */
//        Prod prod = new Prod();  
//        prod.setCProd("2");  
//        prod.setXProd("Exemplo geracao XML JAXB");  
//        prod.setNCM("99");  
//        prod.setCFOP("5102");  
//        prod.setUCom("UND");  
//        prod.setQCom("2.0000");  
//        prod.setVUnCom("90.0000");  
//        prod.setVProd("180.00");  
//        prod.setUTrib("UND");  
//        prod.setQTrib("2.0000");  
//        prod.setVUnTrib("90.0000");  
//        prod.setIndTot("1");  
//        det.setProd(prod);  
        NfeDestinatario destinatario = new NfeDestinatario();
        destinatario.setRazaoSocial("");
        destinatario.setCpfCnpj("12345678912345");
        destinatario.setIe("123456789");
        destinatario.setLogradouro("Av. Sao Paulo, 145");
        destinatario.setComplemento("Casa");
        destinatario.setBairro("Centro");
        destinatario.setCodigoMunicipio(12);
        destinatario.setNomeMunicipio("Santa Vitoria");
        destinatario.setUf("MG");
        destinatario.setCep("38320-000");
        destinatario.setCodigoPais(12);
        destinatario.setNomePais("Brasil");
        destinatario.setTelefone("3432511651");

        GeraXMLEnvio gera = new GeraXMLEnvio();
        String teste = gera.gerarXMLEnvio(nfeCabecalho, emitente, destinatario, listaNfeDetalhe, caminhoCertificado, senha);
        System.out.println(teste);



    }
}
