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
@Table(name = "CNAE_SECAO")
public class CnaeSecao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private char codigo;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;

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
        if (!(object instanceof CnaeSecao)) {
            return false;
        }
        CnaeSecao other = (CnaeSecao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.CnaeSecao[ id=" + id + " ]";
    }

    public char getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
