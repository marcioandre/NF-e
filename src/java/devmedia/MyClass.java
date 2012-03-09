/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devmedia;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.*;

/**
 *
 * @author marcio
 */
@XmlRootElement(name="MyRootElement")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyClass {
    @XmlElement
    private String nome;
    @XmlElement
    private int age;
    @XmlAttribute
    private String typeOfRootElement;
    @XmlElementWrapper(name="myAddresses")
    private List<String> address = new LinkedList<String>();
    
    @XmlElementWrapper(name="girls")
    private final List<GirlFriend> grilFriend;

    public MyClass(List<GirlFriend> grilFriend) {
        this.grilFriend = grilFriend;
    }

    public MyClass() {
        this.grilFriend = null;
    }

   
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTypeOfRootElement() {
        return typeOfRootElement;
    }

    public void setTypeOfRootElement(String typeOfRootElement) {
        this.typeOfRootElement = typeOfRootElement;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
    
    
    
}
