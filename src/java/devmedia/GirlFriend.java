/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devmedia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcio
 */
@XmlRootElement(name="girlfriend")
@XmlAccessorType(XmlAccessType.FIELD)
public class GirlFriend {

    @XmlElement
    public String nome;
    @XmlElement
    public Integer age;
    
    

    public GirlFriend(String nome, Integer age) {
        this.nome = nome;
        this.age = age;
    }

    public GirlFriend() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
}
