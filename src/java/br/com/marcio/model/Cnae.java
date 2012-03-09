/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcio.model;


import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author marcio
 */
@Entity
@Table(name = "CNAE")
public class Cnae implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "DENOMINACAO")
    private String denominacao;
    @JoinColumn(name = "ID_CNAE_SECAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CnaeSecao cnaeSecao;
    @JoinColumn(name = "ID_CNAE_DIVISAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CnaeDivisao cnaeDivisao;
    @JoinColumn(name = "ID_CNAE_GRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CnaeGrupo cnaeGrupo;
    @JoinColumn(name = "ID_CNAE_CLASSE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CnaeClasse cnaeClasse;
    @JoinColumn(name = "ID_CNAE_SUBCLASSE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CnaeSubClasse cnaeSubclasse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cnae)) {
            return false;
        }
        Cnae other = (Cnae) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.Cnae[ id=" + id + " ]";
    }

    public String getDenominacao() {
        return denominacao;
    }

    public void setDenominacao(String denominacao) {
        this.denominacao = denominacao;
    }

    public CnaeSecao getCnaeSecao() {
        return cnaeSecao;
    }

    public void setCnaeSecao(CnaeSecao cnaeSecao) {
        this.cnaeSecao = cnaeSecao;
    }

    public CnaeDivisao getCnaeDivisao() {
        return cnaeDivisao;
    }

    public void setCnaeDivisao(CnaeDivisao cnaeDivisao) {
        this.cnaeDivisao = cnaeDivisao;
    }

    public CnaeGrupo getCnaeGrupo() {
        return cnaeGrupo;
    }

    public void setCnaeGrupo(CnaeGrupo cnaeGrupo) {
        this.cnaeGrupo = cnaeGrupo;
    }

    public CnaeClasse getCnaeClasse() {
        return cnaeClasse;
    }

    public void setCnaeClasse(CnaeClasse cnaeClasse) {
        this.cnaeClasse = cnaeClasse;
    }

    public CnaeSubClasse getCnaeSubclasse() {
        return cnaeSubclasse;
    }

    public void setCnaeSubclasse(CnaeSubClasse cnaeSubclasse) {
        this.cnaeSubclasse = cnaeSubclasse;
    }
}
