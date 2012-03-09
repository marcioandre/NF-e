/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author marcio
 */
@Entity
@Table(name="TRIBUTACAO_ESTADUAL")
public class TributacaoEstadual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "DATA_ALTERACAO")
    @Temporal(TemporalType.DATE)
    private Date dataAlteracao;
    @Column(name = "TAXA_ISSQN")
    private BigDecimal taxaIssqn;
    @Column(name = "TAXA_ICMS")
    private BigDecimal taxaIcms;
    @Column(name = "CFOP_FORA")
    private Integer cfopFora;
    @Column(name = "CFOP_DENTRO")
    private Integer cfopDentro;
    @Column(name = "CST_A_ICMS")
    private Character cstAIcms;
    @Column(name = "CST_B_ICMS")
    private String cstBIcms;
    @Column(name = "CST_ECF")
    private String cstEcf;
    @Column(name = "CSOSN")
    private String csosn;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Empresa empresa;

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
        if (!(object instanceof TributacaoEstadual)) {
            return false;
        }
        TributacaoEstadual other = (TributacaoEstadual) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.TributacaoEstadual[ id=" + id + " ]";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public BigDecimal getTaxaIssqn() {
        return taxaIssqn;
    }

    public void setTaxaIssqn(BigDecimal taxaIssqn) {
        this.taxaIssqn = taxaIssqn;
    }

    public BigDecimal getTaxaIcms() {
        return taxaIcms;
    }

    public void setTaxaIcms(BigDecimal taxaIcms) {
        this.taxaIcms = taxaIcms;
    }

    public Integer getCfopFora() {
        return cfopFora;
    }

    public void setCfopFora(Integer cfopFora) {
        this.cfopFora = cfopFora;
    }

    public Integer getCfopDentro() {
        return cfopDentro;
    }

    public void setCfopDentro(Integer cfopDentro) {
        this.cfopDentro = cfopDentro;
    }

    public Character getCstAIcms() {
        return cstAIcms;
    }

    public void setCstAIcms(Character cstAIcms) {
        this.cstAIcms = cstAIcms;
    }

    public String getCstBIcms() {
        return cstBIcms;
    }

    public void setCstBIcms(String cstBIcms) {
        this.cstBIcms = cstBIcms;
    }

    public String getCstEcf() {
        return cstEcf;
    }

    public void setCstEcf(String cstEcf) {
        this.cstEcf = cstEcf;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
