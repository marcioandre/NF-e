/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcio
 */
public class ChaveAcessoNFe {

    public static void main(String[] args) {
        try {
            String cUF = "31"; // Codigo da UF  do emitente do Documento Fiscal.
            String dataAAMM = "1203"; // Ano de Mes de emissao da NF-e;
            String cnpjCpf = "07.408.744.0001-99"; //CNPJ do emitente.
            String mod = "55"; // Modelo do Documento Fiscal
            String serie = "1"; // Serie do Documento Fiscal.
            String tpEmis = "2"; // Forma de emissao da NF-e;
            String nNF = "20"; // Numero do Documento da NFe;
            String cNF = "5"; // Codigo Numerico que compoe a Chave de Acesso.

            StringBuilder chave = new StringBuilder();
            chave.append(lpadTo(cUF, 2, '0'));
            chave.append(lpadTo(dataAAMM, 4, '0'));
            chave.append(lpadTo(cnpjCpf.replaceAll("\\D", ""), 14, '0'));
            chave.append(lpadTo(mod, 2, '0'));
            chave.append(lpadTo(serie, 3, '0'));
            chave.append(lpadTo(String.valueOf(nNF), 9, '0'));
            chave.append(lpadTo(tpEmis, 1, '0'));
            chave.append(lpadTo(cNF, 8, '0'));
            
            chave.append(modulo11(chave.toString()));
            chave.insert(0, "NFe");
            info("Chave NF-e: " + chave.toString());
        } catch (Exception e) {
            error(e.toString());
        }
    }

    public static int modulo11(String chave) {  
        int total = 0;  
        int peso = 2;  
              
        for (int i = 0; i < chave.length(); i++) {  
            total += (chave.charAt((chave.length()-1) - i) - '0') * peso;  
            peso ++;  
            if (peso == 10)  
                peso = 2;  
        }  
        int resto = total % 11;  
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);  
    }  

  public static String lpadTo(String input, int width, char ch) {  
        String strPad = "";  
  
        StringBuffer sb = new StringBuffer(input.trim());  
        while (sb.length() < width)  
            sb.insert(0,ch);  
        strPad = sb.toString();  
          
        if (strPad.length() > width) {  
            strPad = strPad.substring(0,width);  
        }  
        return strPad;  
    }  
   private static void error(String error) {  
        System.out.println("| ERROR: " + error);  
    }  
  
    /** 
     * Log INFO. 
     * @param info 
     */  
    private static void info(String info) {  
        System.out.println("| INFO: " + info);  
    }  
}
