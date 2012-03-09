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
@Table(name = "IMPOSTO_ST_UF")
public class ImpostoStUf implements Serializable {

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
    @Column(name = "TAXA_ACRESCIMO_AC")
    private BigDecimal taxaAcrescimoAc;
    @Column(name = "TAXA_ACRESCIMO_AL")
    private BigDecimal taxaAcrescimoAl;
    @Column(name = "TAXA_ACRESCIMO_AP")
    private BigDecimal taxaAcrescimoAp;
    @Column(name = "TAXA_ACRESCIMO_AM")
    private BigDecimal taxaAcrescimoAm;
    @Column(name = "TAXA_ACRESCIMO_BA")
    private BigDecimal taxaAcrescimoBa;
    @Column(name = "TAXA_ACRESCIMO_CE")
    private BigDecimal taxaAcrescimoCe;
    @Column(name = "TAXA_ACRESCIMO_DF")
    private BigDecimal taxaAcrescimoDf;
    @Column(name = "TAXA_ACRESCIMO_ES")
    private BigDecimal taxaAcrescimoEs;
    @Column(name = "TAXA_ACRESCIMO_GO")
    private BigDecimal taxaAcrescimoGo;
    @Column(name = "TAXA_ACRESCIMO_MA")
    private BigDecimal taxaAcrescimoMa;
    @Column(name = "TAXA_ACRESCIMO_MT")
    private BigDecimal taxaAcrescimoMt;
    @Column(name = "TAXA_ACRESCIMO_MS")
    private BigDecimal taxaAcrescimoMs;
    @Column(name = "TAXA_ACRESCIMO_MG")
    private BigDecimal taxaAcrescimoMg;
    @Column(name = "TAXA_ACRESCIMO_PA")
    private BigDecimal taxaAcrescimoPa;
    @Column(name = "TAXA_ACRESCIMO_PB")
    private BigDecimal taxaAcrescimoPb;
    @Column(name = "TAXA_ACRESCIMO_PR")
    private BigDecimal taxaAcrescimoPr;
    @Column(name = "TAXA_ACRESCIMO_PE")
    private BigDecimal taxaAcrescimoPe;
    @Column(name = "TAXA_ACRESCIMO_PI")
    private BigDecimal taxaAcrescimoPi;
    @Column(name = "TAXA_ACRESCIMO_RJ")
    private BigDecimal taxaAcrescimoRj;
    @Column(name = "TAXA_ACRESCIMO_RN")
    private BigDecimal taxaAcrescimoRn;
    @Column(name = "TAXA_ACRESCIMO_RS")
    private BigDecimal taxaAcrescimoRs;
    @Column(name = "TAXA_ACRESCIMO_RO")
    private BigDecimal taxaAcrescimoRo;
    @Column(name = "TAXA_ACRESCIMO_RR")
    private BigDecimal taxaAcrescimoRr;
    @Column(name = "TAXA_ACRESCIMO_SC")
    private BigDecimal taxaAcrescimoSc;
    @Column(name = "TAXA_ACRESCIMO_SP")
    private BigDecimal taxaAcrescimoSp;
    @Column(name = "TAXA_ACRESCIMO_SE")
    private BigDecimal taxaAcrescimoSe;
    @Column(name = "TAXA_ACRESCIMO_TO")
    private BigDecimal taxaAcrescimoTo;
    @Column(name = "VALOR_PAUTA_AC")
    private BigDecimal valorPautaAc;
    @Column(name = "VALOR_PAUTA_AL")
    private BigDecimal valorPautaAl;
    @Column(name = "VALOR_PAUTA_AP")
    private BigDecimal valorPautaAp;
    @Column(name = "VALOR_PAUTA_AM")
    private BigDecimal valorPautaAm;
    @Column(name = "VALOR_PAUTA_BA")
    private BigDecimal valorPautaBa;
    @Column(name = "VALOR_PAUTA_CE")
    private BigDecimal valorPautaCe;
    @Column(name = "VALOR_PAUTA_DF")
    private BigDecimal valorPautaDf;
    @Column(name = "VALOR_PAUTA_ES")
    private BigDecimal valorPautaEs;
    @Column(name = "VALOR_PAUTA_GO")
    private BigDecimal valorPautaGo;
    @Column(name = "VALOR_PAUTA_MA")
    private BigDecimal valorPautaMa;
    @Column(name = "VALOR_PAUTA_MT")
    private BigDecimal valorPautaMt;
    @Column(name = "VALOR_PAUTA_MS")
    private BigDecimal valorPautaMs;
    @Column(name = "VALOR_PAUTA_MG")
    private BigDecimal valorPautaMg;
    @Column(name = "VALOR_PAUTA_PA")
    private BigDecimal valorPautaPa;
    @Column(name = "VALOR_PAUTA_PB")
    private BigDecimal valorPautaPb;
    @Column(name = "VALOR_PAUTA_PR")
    private BigDecimal valorPautaPr;
    @Column(name = "VALOR_PAUTA_PE")
    private BigDecimal valorPautaPe;
    @Column(name = "VALOR_PAUTA_PI")
    private BigDecimal valorPautaPi;
    @Column(name = "VALOR_PAUTA_RJ")
    private BigDecimal valorPautaRj;
    @Column(name = "VALOR_PAUTA_RN")
    private BigDecimal valorPautaRn;
    @Column(name = "VALOR_PAUTA_RS")
    private BigDecimal valorPautaRs;
    @Column(name = "VALOR_PAUTA_RO")
    private BigDecimal valorPautaRo;
    @Column(name = "VALOR_PAUTA_RR")
    private BigDecimal valorPautaRr;
    @Column(name = "VALOR_PAUTA_SC")
    private BigDecimal valorPautaSc;
    @Column(name = "VALOR_PAUTA_SP")
    private BigDecimal valorPautaSp;
    @Column(name = "VALOR_PAUTA_SE")
    private BigDecimal valorPautaSe;
    @Column(name = "VALOR_PAUTA_TO")
    private BigDecimal valorPautaTo;
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
        if (!(object instanceof ImpostoStUf)) {
            return false;
        }
        ImpostoStUf other = (ImpostoStUf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.ImpostoStUf[ id=" + id + " ]";
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

    public BigDecimal getTaxaAcrescimoAc() {
        return taxaAcrescimoAc;
    }

    public void setTaxaAcrescimoAc(BigDecimal taxaAcrescimoAc) {
        this.taxaAcrescimoAc = taxaAcrescimoAc;
    }

    public BigDecimal getTaxaAcrescimoAl() {
        return taxaAcrescimoAl;
    }

    public void setTaxaAcrescimoAl(BigDecimal taxaAcrescimoAl) {
        this.taxaAcrescimoAl = taxaAcrescimoAl;
    }

    public BigDecimal getTaxaAcrescimoAp() {
        return taxaAcrescimoAp;
    }

    public void setTaxaAcrescimoAp(BigDecimal taxaAcrescimoAp) {
        this.taxaAcrescimoAp = taxaAcrescimoAp;
    }

    public BigDecimal getTaxaAcrescimoAm() {
        return taxaAcrescimoAm;
    }

    public void setTaxaAcrescimoAm(BigDecimal taxaAcrescimoAm) {
        this.taxaAcrescimoAm = taxaAcrescimoAm;
    }

    public BigDecimal getTaxaAcrescimoBa() {
        return taxaAcrescimoBa;
    }

    public void setTaxaAcrescimoBa(BigDecimal taxaAcrescimoBa) {
        this.taxaAcrescimoBa = taxaAcrescimoBa;
    }

    public BigDecimal getTaxaAcrescimoCe() {
        return taxaAcrescimoCe;
    }

    public void setTaxaAcrescimoCe(BigDecimal taxaAcrescimoCe) {
        this.taxaAcrescimoCe = taxaAcrescimoCe;
    }

    public BigDecimal getTaxaAcrescimoDf() {
        return taxaAcrescimoDf;
    }

    public void setTaxaAcrescimoDf(BigDecimal taxaAcrescimoDf) {
        this.taxaAcrescimoDf = taxaAcrescimoDf;
    }

    public BigDecimal getTaxaAcrescimoEs() {
        return taxaAcrescimoEs;
    }

    public void setTaxaAcrescimoEs(BigDecimal taxaAcrescimoEs) {
        this.taxaAcrescimoEs = taxaAcrescimoEs;
    }

    public BigDecimal getTaxaAcrescimoGo() {
        return taxaAcrescimoGo;
    }

    public void setTaxaAcrescimoGo(BigDecimal taxaAcrescimoGo) {
        this.taxaAcrescimoGo = taxaAcrescimoGo;
    }

    public BigDecimal getTaxaAcrescimoMa() {
        return taxaAcrescimoMa;
    }

    public void setTaxaAcrescimoMa(BigDecimal taxaAcrescimoMa) {
        this.taxaAcrescimoMa = taxaAcrescimoMa;
    }

    public BigDecimal getTaxaAcrescimoMt() {
        return taxaAcrescimoMt;
    }

    public void setTaxaAcrescimoMt(BigDecimal taxaAcrescimoMt) {
        this.taxaAcrescimoMt = taxaAcrescimoMt;
    }

    public BigDecimal getTaxaAcrescimoMs() {
        return taxaAcrescimoMs;
    }

    public void setTaxaAcrescimoMs(BigDecimal taxaAcrescimoMs) {
        this.taxaAcrescimoMs = taxaAcrescimoMs;
    }

    public BigDecimal getTaxaAcrescimoMg() {
        return taxaAcrescimoMg;
    }

    public void setTaxaAcrescimoMg(BigDecimal taxaAcrescimoMg) {
        this.taxaAcrescimoMg = taxaAcrescimoMg;
    }

    public BigDecimal getTaxaAcrescimoPa() {
        return taxaAcrescimoPa;
    }

    public void setTaxaAcrescimoPa(BigDecimal taxaAcrescimoPa) {
        this.taxaAcrescimoPa = taxaAcrescimoPa;
    }

    public BigDecimal getTaxaAcrescimoPb() {
        return taxaAcrescimoPb;
    }

    public void setTaxaAcrescimoPb(BigDecimal taxaAcrescimoPb) {
        this.taxaAcrescimoPb = taxaAcrescimoPb;
    }

    public BigDecimal getTaxaAcrescimoPr() {
        return taxaAcrescimoPr;
    }

    public void setTaxaAcrescimoPr(BigDecimal taxaAcrescimoPr) {
        this.taxaAcrescimoPr = taxaAcrescimoPr;
    }

    public BigDecimal getTaxaAcrescimoPe() {
        return taxaAcrescimoPe;
    }

    public void setTaxaAcrescimoPe(BigDecimal taxaAcrescimoPe) {
        this.taxaAcrescimoPe = taxaAcrescimoPe;
    }

    public BigDecimal getTaxaAcrescimoPi() {
        return taxaAcrescimoPi;
    }

    public void setTaxaAcrescimoPi(BigDecimal taxaAcrescimoPi) {
        this.taxaAcrescimoPi = taxaAcrescimoPi;
    }

    public BigDecimal getTaxaAcrescimoRj() {
        return taxaAcrescimoRj;
    }

    public void setTaxaAcrescimoRj(BigDecimal taxaAcrescimoRj) {
        this.taxaAcrescimoRj = taxaAcrescimoRj;
    }

    public BigDecimal getTaxaAcrescimoRn() {
        return taxaAcrescimoRn;
    }

    public void setTaxaAcrescimoRn(BigDecimal taxaAcrescimoRn) {
        this.taxaAcrescimoRn = taxaAcrescimoRn;
    }

    public BigDecimal getTaxaAcrescimoRs() {
        return taxaAcrescimoRs;
    }

    public void setTaxaAcrescimoRs(BigDecimal taxaAcrescimoRs) {
        this.taxaAcrescimoRs = taxaAcrescimoRs;
    }

    public BigDecimal getTaxaAcrescimoRo() {
        return taxaAcrescimoRo;
    }

    public void setTaxaAcrescimoRo(BigDecimal taxaAcrescimoRo) {
        this.taxaAcrescimoRo = taxaAcrescimoRo;
    }

    public BigDecimal getTaxaAcrescimoRr() {
        return taxaAcrescimoRr;
    }

    public void setTaxaAcrescimoRr(BigDecimal taxaAcrescimoRr) {
        this.taxaAcrescimoRr = taxaAcrescimoRr;
    }

    public BigDecimal getTaxaAcrescimoSc() {
        return taxaAcrescimoSc;
    }

    public void setTaxaAcrescimoSc(BigDecimal taxaAcrescimoSc) {
        this.taxaAcrescimoSc = taxaAcrescimoSc;
    }

    public BigDecimal getTaxaAcrescimoSp() {
        return taxaAcrescimoSp;
    }

    public void setTaxaAcrescimoSp(BigDecimal taxaAcrescimoSp) {
        this.taxaAcrescimoSp = taxaAcrescimoSp;
    }

    public BigDecimal getTaxaAcrescimoSe() {
        return taxaAcrescimoSe;
    }

    public void setTaxaAcrescimoSe(BigDecimal taxaAcrescimoSe) {
        this.taxaAcrescimoSe = taxaAcrescimoSe;
    }

    public BigDecimal getTaxaAcrescimoTo() {
        return taxaAcrescimoTo;
    }

    public void setTaxaAcrescimoTo(BigDecimal taxaAcrescimoTo) {
        this.taxaAcrescimoTo = taxaAcrescimoTo;
    }

    public BigDecimal getValorPautaAc() {
        return valorPautaAc;
    }

    public void setValorPautaAc(BigDecimal valorPautaAc) {
        this.valorPautaAc = valorPautaAc;
    }

    public BigDecimal getValorPautaAl() {
        return valorPautaAl;
    }

    public void setValorPautaAl(BigDecimal valorPautaAl) {
        this.valorPautaAl = valorPautaAl;
    }

    public BigDecimal getValorPautaAp() {
        return valorPautaAp;
    }

    public void setValorPautaAp(BigDecimal valorPautaAp) {
        this.valorPautaAp = valorPautaAp;
    }

    public BigDecimal getValorPautaAm() {
        return valorPautaAm;
    }

    public void setValorPautaAm(BigDecimal valorPautaAm) {
        this.valorPautaAm = valorPautaAm;
    }

    public BigDecimal getValorPautaBa() {
        return valorPautaBa;
    }

    public void setValorPautaBa(BigDecimal valorPautaBa) {
        this.valorPautaBa = valorPautaBa;
    }

    public BigDecimal getValorPautaCe() {
        return valorPautaCe;
    }

    public void setValorPautaCe(BigDecimal valorPautaCe) {
        this.valorPautaCe = valorPautaCe;
    }

    public BigDecimal getValorPautaDf() {
        return valorPautaDf;
    }

    public void setValorPautaDf(BigDecimal valorPautaDf) {
        this.valorPautaDf = valorPautaDf;
    }

    public BigDecimal getValorPautaEs() {
        return valorPautaEs;
    }

    public void setValorPautaEs(BigDecimal valorPautaEs) {
        this.valorPautaEs = valorPautaEs;
    }

    public BigDecimal getValorPautaGo() {
        return valorPautaGo;
    }

    public void setValorPautaGo(BigDecimal valorPautaGo) {
        this.valorPautaGo = valorPautaGo;
    }

    public BigDecimal getValorPautaMa() {
        return valorPautaMa;
    }

    public void setValorPautaMa(BigDecimal valorPautaMa) {
        this.valorPautaMa = valorPautaMa;
    }

    public BigDecimal getValorPautaMt() {
        return valorPautaMt;
    }

    public void setValorPautaMt(BigDecimal valorPautaMt) {
        this.valorPautaMt = valorPautaMt;
    }

    public BigDecimal getValorPautaMs() {
        return valorPautaMs;
    }

    public void setValorPautaMs(BigDecimal valorPautaMs) {
        this.valorPautaMs = valorPautaMs;
    }

    public BigDecimal getValorPautaMg() {
        return valorPautaMg;
    }

    public void setValorPautaMg(BigDecimal valorPautaMg) {
        this.valorPautaMg = valorPautaMg;
    }

    public BigDecimal getValorPautaPa() {
        return valorPautaPa;
    }

    public void setValorPautaPa(BigDecimal valorPautaPa) {
        this.valorPautaPa = valorPautaPa;
    }

    public BigDecimal getValorPautaPb() {
        return valorPautaPb;
    }

    public void setValorPautaPb(BigDecimal valorPautaPb) {
        this.valorPautaPb = valorPautaPb;
    }

    public BigDecimal getValorPautaPr() {
        return valorPautaPr;
    }

    public void setValorPautaPr(BigDecimal valorPautaPr) {
        this.valorPautaPr = valorPautaPr;
    }

    public BigDecimal getValorPautaPe() {
        return valorPautaPe;
    }

    public void setValorPautaPe(BigDecimal valorPautaPe) {
        this.valorPautaPe = valorPautaPe;
    }

    public BigDecimal getValorPautaPi() {
        return valorPautaPi;
    }

    public void setValorPautaPi(BigDecimal valorPautaPi) {
        this.valorPautaPi = valorPautaPi;
    }

    public BigDecimal getValorPautaRj() {
        return valorPautaRj;
    }

    public void setValorPautaRj(BigDecimal valorPautaRj) {
        this.valorPautaRj = valorPautaRj;
    }

    public BigDecimal getValorPautaRn() {
        return valorPautaRn;
    }

    public void setValorPautaRn(BigDecimal valorPautaRn) {
        this.valorPautaRn = valorPautaRn;
    }

    public BigDecimal getValorPautaRs() {
        return valorPautaRs;
    }

    public void setValorPautaRs(BigDecimal valorPautaRs) {
        this.valorPautaRs = valorPautaRs;
    }

    public BigDecimal getValorPautaRo() {
        return valorPautaRo;
    }

    public void setValorPautaRo(BigDecimal valorPautaRo) {
        this.valorPautaRo = valorPautaRo;
    }

    public BigDecimal getValorPautaRr() {
        return valorPautaRr;
    }

    public void setValorPautaRr(BigDecimal valorPautaRr) {
        this.valorPautaRr = valorPautaRr;
    }

    public BigDecimal getValorPautaSc() {
        return valorPautaSc;
    }

    public void setValorPautaSc(BigDecimal valorPautaSc) {
        this.valorPautaSc = valorPautaSc;
    }

    public BigDecimal getValorPautaSp() {
        return valorPautaSp;
    }

    public void setValorPautaSp(BigDecimal valorPautaSp) {
        this.valorPautaSp = valorPautaSp;
    }

    public BigDecimal getValorPautaSe() {
        return valorPautaSe;
    }

    public void setValorPautaSe(BigDecimal valorPautaSe) {
        this.valorPautaSe = valorPautaSe;
    }

    public BigDecimal getValorPautaTo() {
        return valorPautaTo;
    }

    public void setValorPautaTo(BigDecimal valorPautaTo) {
        this.valorPautaTo = valorPautaTo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
