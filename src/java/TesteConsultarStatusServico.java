
import br.com.status.StatusServico;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author marcio
 */
public class TesteConsultarStatusServico extends JFrame{

    public static void main(String[] args) {
        StatusServico status = new StatusServico();
        char[] nn = new char[6];
        

  
        status.verificaStatusServico("/home/marcio/miranda.p12", new char[123456] );
    }
}
