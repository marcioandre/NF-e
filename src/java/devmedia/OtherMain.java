/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devmedia;

import com.sun.jmx.remote.internal.Unmarshal;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author marcio
 */
public class OtherMain {
    
    public static void main(String[] args) throws JAXBException {
        System.out.println("Reading the XML File ...");
        JAXBContext ctx = JAXBContext.newInstance(MyClass.class);
        Unmarshaller unm = ctx.createUnmarshaller();
        MyClass theClasse = (MyClass) unm.unmarshal(new File("myXML.xml"));
        System.out.println("The MyClasse is " + theClasse.getNome());
        
    }
    
}
