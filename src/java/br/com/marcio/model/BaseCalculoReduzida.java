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
@Table(name = "BASE_CALCULO_REDUZIDA")
public class BaseCalculoReduzida implements Serializable {

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
    @Column(name = "UF_AC")
    private BigDecimal ufAc;
    @Column(name = "UF_AL")
    private BigDecimal ufAl;
    @Column(name = "UF_AP")
    private BigDecimal ufAp;
    @Column(name = "UF_AM")
    private BigDecimal ufAm;
    @Column(name = "UF_BA")
    private BigDecimal ufBa;
    @Column(name = "UF_CE")
    private BigDecimal ufCe;
    @Column(name = "UF_DF")
    private BigDecimal ufDf;
    @Column(name = "UF_ES")
    private BigDecimal ufEs;
    @Column(name = "UF_GO")
    private BigDecimal ufGo;
    @Column(name = "UF_MA")
    private BigDecimal ufMa;
    @Column(name = "UF_MT")
    private BigDecimal ufMt;
    @Column(name = "UF_MS")
    private BigDecimal ufMs;
    @Column(name = "UF_MG")
    private BigDecimal ufMg;
    @Column(name = "UF_PA")
    private BigDecimal ufPa;
    @Column(name = "UF_PB")
    private BigDecimal ufPb;
    @Column(name = "UF_PR")
    private BigDecimal ufPr;
    @Column(name = "UF_PE")
    private BigDecimal ufPe;
    @Column(name = "UF_PI")
    private BigDecimal ufPi;
    @Column(name = "UF_RJ")
    private BigDecimal ufRj;
    @Column(name = "UF_RN")
    private BigDecimal ufRn;
    @Column(name = "UF_RS")
    private BigDecimal ufRs;
    @Column(name = "UF_RO")
    private BigDecimal ufRo;
    @Column(name = "UF_RR")
    private BigDecimal ufRr;
    @Column(name = "UF_SC")
    private BigDecimal ufSc;
    @Column(name = "UF_SP")
    private BigDecimal ufSp;
    @Column(name = "UF_SE")
    private BigDecimal ufSe;
    @Column(name = "UF_TO")
    private BigDecimal ufTo;
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
        if (!(object instanceof BaseCalculoReduzida)) {
            return false;
        }
        BaseCalculoReduzida other = (BaseCalculoReduzida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.BaseCalculoReduzida[ id=" + id + " ]";
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

    public BigDecimal getUfAc() {
        return ufAc;
    }

    public void setUfAc(BigDecimal ufAc) {
        this.ufAc = ufAc;
    }

    public BigDecimal getUfAl() {
        return ufAl;
    }

    public void setUfAl(BigDecimal ufAl) {
        this.ufAl = ufAl;
    }

    public BigDecimal getUfAp() {
        return ufAp;
    }

    public void setUfAp(BigDecimal ufAp) {
        this.ufAp = ufAp;
    }

    public BigDecimal getUfAm() {
        return ufAm;
    }

    public void setUfAm(BigDecimal ufAm) {
        this.ufAm = ufAm;
    }

    public BigDecimal getUfBa() {
        return ufBa;
    }

    public void setUfBa(BigDecimal ufBa) {
        this.ufBa = ufBa;
    }

    public BigDecimal getUfCe() {
        return ufCe;
    }

    public void setUfCe(BigDecimal ufCe) {
        this.ufCe = ufCe;
    }

    public BigDecimal getUfDf() {
        return ufDf;
    }

    public void setUfDf(BigDecimal ufDf) {
        this.ufDf = ufDf;
    }

    public BigDecimal getUfEs() {
        return ufEs;
    }

    public void setUfEs(BigDecimal ufEs) {
        this.ufEs = ufEs;
    }

    public BigDecimal getUfGo() {
        return ufGo;
    }

    public void setUfGo(BigDecimal ufGo) {
        this.ufGo = ufGo;
    }

    public BigDecimal getUfMa() {
        return ufMa;
    }

    public void setUfMa(BigDecimal ufMa) {
        this.ufMa = ufMa;
    }

    public BigDecimal getUfMt() {
        return ufMt;
    }

    public void setUfMt(BigDecimal ufMt) {
        this.ufMt = ufMt;
    }

    public BigDecimal getUfMs() {
        return ufMs;
    }

    public void setUfMs(BigDecimal ufMs) {
        this.ufMs = ufMs;
    }

    public BigDecimal getUfMg() {
        return ufMg;
    }

    public void setUfMg(BigDecimal ufMg) {
        this.ufMg = ufMg;
    }

    public BigDecimal getUfPa() {
        return ufPa;
    }

    public void setUfPa(BigDecimal ufPa) {
        this.ufPa = ufPa;
    }

    public BigDecimal getUfPb() {
        return ufPb;
    }

    public void setUfPb(BigDecimal ufPb) {
        this.ufPb = ufPb;
    }

    public BigDecimal getUfPr() {
        return ufPr;
    }

    public void setUfPr(BigDecimal ufPr) {
        this.ufPr = ufPr;
    }

    public BigDecimal getUfPe() {
        return ufPe;
    }

    public void setUfPe(BigDecimal ufPe) {
        this.ufPe = ufPe;
    }

    public BigDecimal getUfPi() {
        return ufPi;
    }

    public void setUfPi(BigDecimal ufPi) {
        this.ufPi = ufPi;
    }

    public BigDecimal getUfRj() {
        return ufRj;
    }

    public void setUfRj(BigDecimal ufRj) {
        this.ufRj = ufRj;
    }

    public BigDecimal getUfRn() {
        return ufRn;
    }

    public void setUfRn(BigDecimal ufRn) {
        this.ufRn = ufRn;
    }

    public BigDecimal getUfRs() {
        return ufRs;
    }

    public void setUfRs(BigDecimal ufRs) {
        this.ufRs = ufRs;
    }

    public BigDecimal getUfRo() {
        return ufRo;
    }

    public void setUfRo(BigDecimal ufRo) {
        this.ufRo = ufRo;
    }

    public BigDecimal getUfRr() {
        return ufRr;
    }

    public void setUfRr(BigDecimal ufRr) {
        this.ufRr = ufRr;
    }

    public BigDecimal getUfSc() {
        return ufSc;
    }

    public void setUfSc(BigDecimal ufSc) {
        this.ufSc = ufSc;
    }

    public BigDecimal getUfSp() {
        return ufSp;
    }

    public void setUfSp(BigDecimal ufSp) {
        this.ufSp = ufSp;
    }

    public BigDecimal getUfSe() {
        return ufSe;
    }

    public void setUfSe(BigDecimal ufSe) {
        this.ufSe = ufSe;
    }

    public BigDecimal getUfTo() {
        return ufTo;
    }

    public void setUfTo(BigDecimal ufTo) {
        this.ufTo = ufTo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
