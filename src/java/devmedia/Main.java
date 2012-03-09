/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devmedia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author marcio
 */
public class Main {
    
    public static void main(String[] args) throws JAXBException, IOException {
        System.out.println("Creating the XML File....");
        JAXBContext ctx =JAXBContext.newInstance(MyClass.class);
        Marshaller mar = ctx.createMarshaller();
        
        List<GirlFriend> girls = new LinkedList<GirlFriend>();
        girls.add(new GirlFriend("Keli Santos", 29));
        girls.add(new GirlFriend("Keli Santos", 29));
        girls.add(new GirlFriend("Keli Santos", 29));
        girls.add(new GirlFriend("Keli Santos", 29));
        girls.add(new GirlFriend("Keli Santos", 29));
        girls.add(new GirlFriend("Keli Santos", 29));
        girls.add(new GirlFriend("Keli Santos", 29));
        
        
        MyClass instance = new MyClass(girls);
        instance.setTypeOfRootElement("MALE");
        instance.setNome("Marcio Andre");
        instance.setAge(23);
        instance.getAddress().add("Address 1");
        instance.getAddress().add("Address 2");
        instance.getAddress().add("Address 3");
        instance.getAddress().add("Address 4");
        instance.getAddress().add("Address 5");
        instance.getAddress().add("Address 6");
        
        
        mar.marshal(instance, new FileWriter("myXML.xml"));
        System.out.println("The file is done");
        
        
    }
    
}
