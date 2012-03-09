/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcio.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author marcio
 */
@Entity
@Table(name = "LOTE_PRODUTO")
public class LoteProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CODIGO")
    private String codigo;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "DATA_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "DATA_FABRICACAO")
    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;
    @Column(name = "DATA_VENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

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
        if (!(object instanceof LoteProduto)) {
            return false;
        }
        LoteProduto other = (LoteProduto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.LoteProduto[ id=" + id + " ]";
    }
}
