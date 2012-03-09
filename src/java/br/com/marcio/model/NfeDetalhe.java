/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 *
 * @author marcio
 */
@Entity
public class NfeDetalhe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NUMERO_ITEM")
    private Integer numeroItem;
    @Column(name = "CODIGO_PRODUTO")
    private String codigoProduto;
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "NCM")
    private String ncm;
    @Column(name = "EX_TIPI")
    private Integer exTipi;
    @Column(name = "CFOP")
    private Integer cfop;
    @Column(name = "UNIDADE_COMERCIAL")
    private String unidadeComercial;
    @Column(name = "QUANTIDADE_COMERCIAL")
    private BigDecimal quantidadeComercial;
    @Column(name = "VALOR_UNITARIO_COMERCIAL")
    private BigDecimal valorUnitarioComercial;
    @Column(name = "VALOR_BRUTO_PRODUTOS")
    private BigDecimal valorBrutoProdutos;
    @Column(name = "GTIN_UNIDADE_TRIBUTAVEL")
    private String gtinUnidadeTributavel;
    @Column(name = "UNIDADE_TRIBUTAVEL")
    private String unidadeTributavel;
    @Column(name = "QUANTIDADE_TRIBUTAVEL")
    private BigDecimal quantidadeTributavel;
    @Column(name = "VALOR_UNITARIO_TRIBUTACAO")
    private BigDecimal valorUnitarioTributacao;
    @Column(name = "VALOR_FRETE")
    private BigDecimal valorFrete;
    @Column(name = "VALOR_SEGURO")
    private BigDecimal valorSeguro;
    @Column(name = "VALOR_DESCONTO")
    private BigDecimal valorDesconto;
    @Column(name = "VALOR_OUTRAS_DESPESAS")
    private BigDecimal valorOutrasDespesas;
    @Column(name = "ENTRA_TOTAL")
    private String entraTotal;
    @Column(name = "ORIGEM_MERCADORIA")
    private String origemMercadoria;
    @Column(name = "CST_ICMS")
    private String cstIcms;
    @Column(name = "CSOSN")
    private String csosn;
    @Column(name = "MODALIDADE_BC_ICMS")
    private String modalidadeBcIcms;
    @Column(name = "TAXA_REDUCAO_BC_ICMS")
    private BigDecimal taxaReducaoBcIcms;
    @Column(name = "BASE_CALCULO_ICMS")
    private BigDecimal baseCalculoIcms;
    @Column(name = "ALIQUOTA_ICMS")
    private BigDecimal aliquotaIcms;
    @Column(name = "VALOR_ICMS")
    private BigDecimal valorIcms;
    @Column(name = "MOTIVO_DESONERACAO_ICMS")
    private String motivoDesoneracaoIcms;
    @Column(name = "MODALIDADE_BC_ICMS_ST")
    private String modalidadeBcIcmsSt;
    @Column(name = "PERCENTUAL_MVA_ICMS_ST")
    private BigDecimal percentualMvaIcmsSt;
    @Column(name = "REDUCAO_BC_ICMS_ST")
    private BigDecimal reducaoBcIcmsSt;
    @Column(name = "BASE_CALCULO_ICMS_ST")
    private BigDecimal baseCalculoIcmsSt;
    @Column(name = "ALIQUOTA_ICMS_ST")
    private BigDecimal aliquotaIcmsSt;
    @Column(name = "VALOR_ICMS_ST")
    private BigDecimal valorIcmsSt;
    @Column(name = "VALOR_BC_ICMS_ST_RETIDO")
    private BigDecimal valorBcIcmsStRetido;
    @Column(name = "VALOR_ICMS_ST_RETIDO")
    private BigDecimal valorIcmsStRetido;
    @Column(name = "ALIQUOTA_CREDITO_ICMS_SN")
    private BigDecimal aliquotaCreditoIcmsSn;
    @Column(name = "VALOR_CREDITO_ICMS_SN")
    private BigDecimal valorCreditoIcmsSn;
    @Column(name = "ENQUADRAMENTO_IPI")
    private String enquadramentoIpi;
    @Column(name = "CNPJ_PRODUTOR")
    private String cnpjProdutor;
    @Column(name = "CODIGO_SELO_IPI")
    private String codigoSeloIpi;
    @Column(name = "QUANTIDADE_SELO_IPI")
    private Integer quantidadeSeloIpi;
    @Column(name = "ENQUADRAMENTO_LEGAL_IPI")
    private String enquadramentoLegalIpi;
    @Column(name = "CST_IPI")
    private String cstIpi;
    @Column(name = "BASE_CALCULO_IPI")
    private BigDecimal baseCalculoIpi;
    @Column(name = "ALIQUOTA_IPI")
    private BigDecimal aliquotaIpi;
    @Column(name = "VALOR_IPI")
    private BigDecimal valorIpi;
    @Column(name = "VALOR_BC_II")
    private BigDecimal valorBcIi;
    @Column(name = "VALOR_DESPESAS_ADUANEIRAS")
    private BigDecimal valorDespesasAduaneiras;
    @Column(name = "VALOR_IMPOSTO_IMPORTACAO")
    private BigDecimal valorImpostoImportacao;
    @Column(name = "VALOR_IOF")
    private BigDecimal valorIof;
    @Column(name = "CST_PIS")
    private String cstPis;
    @Column(name = "VALOR_BASE_CALCULO_PIS")
    private BigDecimal valorBaseCalculoPis;
    @Column(name = "ALIQUOTA_PIS_PERCENTUAL")
    private BigDecimal aliquotaPisPercentual;
    @Column(name = "ALIQUOTA_PIS_REAIS")
    private BigDecimal aliquotaPisReais;
    @Column(name = "VALOR_PIS")
    private BigDecimal valorPis;
    @Column(name = "CST_COFINS")
    private String cstCofins;
    @Column(name = "BASE_CALCULO_COFINS")
    private BigDecimal baseCalculoCofins;
    @Column(name = "ALIQUOTA_COFINS_PERCENTUAL")
    private BigDecimal aliquotaCofinsPercentual;
    @Column(name = "ALIQUOTA_COFINS_REAIS")
    private BigDecimal aliquotaCofinsReais;
    @Column(name = "VALOR_COFINS")
    private BigDecimal valorCofins;
    @Column(name = "BASE_CALCULO_ISSQN")
    private BigDecimal baseCalculoIssqn;
    @Column(name = "ALIQUOTA_ISSQN")
    private BigDecimal aliquotaIssqn;
    @Column(name = "VALOR_ISSQN")
    private BigDecimal valorIssqn;
    @Column(name = "MUNICIPIO_ISSQN")
    private Integer municipioIssqn;
    @Column(name = "ITEM_LISTA_SERVICOS")
    private Integer itemListaServicos;
    @Column(name = "TRIBUTACAO_ISSQN")
    private String tributacaoIssqn;
    @Column(name = "VALOR_SUBTOTAL")
    private BigDecimal valorSubtotal;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @Lob
    @Column(name = "INFORMACOES_ADICIONAIS")
    private String informacoesAdicionais;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne
    private Produto produto;
    @JoinColumn(name = "ID_NFE_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NfeCabecalho nfeCabecalho;
    @JoinColumn(name = "ID_LOTE_PRODUTO", referencedColumnName = "ID")
    @ManyToOne
    private LoteProduto loteProduto;

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
        if (!(object instanceof NfeDetalhe)) {
            return false;
        }
        NfeDetalhe other = (NfeDetalhe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.NfeDetalhe[ id=" + id + " ]";
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        this.numeroItem = numeroItem;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public Integer getExTipi() {
        return exTipi;
    }

    public void setExTipi(Integer exTipi) {
        this.exTipi = exTipi;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public String getUnidadeComercial() {
        return unidadeComercial;
    }

    public void setUnidadeComercial(String unidadeComercial) {
        this.unidadeComercial = unidadeComercial;
    }

    public BigDecimal getQuantidadeComercial() {
        return quantidadeComercial;
    }

    public void setQuantidadeComercial(BigDecimal quantidadeComercial) {
        this.quantidadeComercial = quantidadeComercial;
    }

    public BigDecimal getValorUnitarioComercial() {
        return valorUnitarioComercial;
    }

    public void setValorUnitarioComercial(BigDecimal valorUnitarioComercial) {
        this.valorUnitarioComercial = valorUnitarioComercial;
    }

    public BigDecimal getValorBrutoProdutos() {
        return valorBrutoProdutos;
    }

    public void setValorBrutoProdutos(BigDecimal valorBrutoProdutos) {
        this.valorBrutoProdutos = valorBrutoProdutos;
    }

    public String getGtinUnidadeTributavel() {
        return gtinUnidadeTributavel;
    }

    public void setGtinUnidadeTributavel(String gtinUnidadeTributavel) {
        this.gtinUnidadeTributavel = gtinUnidadeTributavel;
    }

    public String getUnidadeTributavel() {
        return unidadeTributavel;
    }

    public void setUnidadeTributavel(String unidadeTributavel) {
        this.unidadeTributavel = unidadeTributavel;
    }

    public BigDecimal getQuantidadeTributavel() {
        return quantidadeTributavel;
    }

    public void setQuantidadeTributavel(BigDecimal quantidadeTributavel) {
        this.quantidadeTributavel = quantidadeTributavel;
    }

    public BigDecimal getValorUnitarioTributacao() {
        return valorUnitarioTributacao;
    }

    public void setValorUnitarioTributacao(BigDecimal valorUnitarioTributacao) {
        this.valorUnitarioTributacao = valorUnitarioTributacao;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(BigDecimal valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public String getEntraTotal() {
        return entraTotal;
    }

    public void setEntraTotal(String entraTotal) {
        this.entraTotal = entraTotal;
    }

    public String getOrigemMercadoria() {
        return origemMercadoria;
    }

    public void setOrigemMercadoria(String origemMercadoria) {
        this.origemMercadoria = origemMercadoria;
    }

    public String getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(String cstIcms) {
        this.cstIcms = cstIcms;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getModalidadeBcIcms() {
        return modalidadeBcIcms;
    }

    public void setModalidadeBcIcms(String modalidadeBcIcms) {
        this.modalidadeBcIcms = modalidadeBcIcms;
    }

    public BigDecimal getTaxaReducaoBcIcms() {
        return taxaReducaoBcIcms;
    }

    public void setTaxaReducaoBcIcms(BigDecimal taxaReducaoBcIcms) {
        this.taxaReducaoBcIcms = taxaReducaoBcIcms;
    }

    public BigDecimal getBaseCalculoIcms() {
        return baseCalculoIcms;
    }

    public void setBaseCalculoIcms(BigDecimal baseCalculoIcms) {
        this.baseCalculoIcms = baseCalculoIcms;
    }

    public BigDecimal getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(BigDecimal aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public String getMotivoDesoneracaoIcms() {
        return motivoDesoneracaoIcms;
    }

    public void setMotivoDesoneracaoIcms(String motivoDesoneracaoIcms) {
        this.motivoDesoneracaoIcms = motivoDesoneracaoIcms;
    }

    public String getModalidadeBcIcmsSt() {
        return modalidadeBcIcmsSt;
    }

    public void setModalidadeBcIcmsSt(String modalidadeBcIcmsSt) {
        this.modalidadeBcIcmsSt = modalidadeBcIcmsSt;
    }

    public BigDecimal getPercentualMvaIcmsSt() {
        return percentualMvaIcmsSt;
    }

    public void setPercentualMvaIcmsSt(BigDecimal percentualMvaIcmsSt) {
        this.percentualMvaIcmsSt = percentualMvaIcmsSt;
    }

    public BigDecimal getReducaoBcIcmsSt() {
        return reducaoBcIcmsSt;
    }

    public void setReducaoBcIcmsSt(BigDecimal reducaoBcIcmsSt) {
        this.reducaoBcIcmsSt = reducaoBcIcmsSt;
    }

    public BigDecimal getBaseCalculoIcmsSt() {
        return baseCalculoIcmsSt;
    }

    public void setBaseCalculoIcmsSt(BigDecimal baseCalculoIcmsSt) {
        this.baseCalculoIcmsSt = baseCalculoIcmsSt;
    }

    public BigDecimal getAliquotaIcmsSt() {
        return aliquotaIcmsSt;
    }

    public void setAliquotaIcmsSt(BigDecimal aliquotaIcmsSt) {
        this.aliquotaIcmsSt = aliquotaIcmsSt;
    }

    public BigDecimal getValorIcmsSt() {
        return valorIcmsSt;
    }

    public void setValorIcmsSt(BigDecimal valorIcmsSt) {
        this.valorIcmsSt = valorIcmsSt;
    }

    public BigDecimal getValorBcIcmsStRetido() {
        return valorBcIcmsStRetido;
    }

    public void setValorBcIcmsStRetido(BigDecimal valorBcIcmsStRetido) {
        this.valorBcIcmsStRetido = valorBcIcmsStRetido;
    }

    public BigDecimal getValorIcmsStRetido() {
        return valorIcmsStRetido;
    }

    public void setValorIcmsStRetido(BigDecimal valorIcmsStRetido) {
        this.valorIcmsStRetido = valorIcmsStRetido;
    }

    public BigDecimal getAliquotaCreditoIcmsSn() {
        return aliquotaCreditoIcmsSn;
    }

    public void setAliquotaCreditoIcmsSn(BigDecimal aliquotaCreditoIcmsSn) {
        this.aliquotaCreditoIcmsSn = aliquotaCreditoIcmsSn;
    }

    public BigDecimal getValorCreditoIcmsSn() {
        return valorCreditoIcmsSn;
    }

    public void setValorCreditoIcmsSn(BigDecimal valorCreditoIcmsSn) {
        this.valorCreditoIcmsSn = valorCreditoIcmsSn;
    }

    public String getEnquadramentoIpi() {
        return enquadramentoIpi;
    }

    public void setEnquadramentoIpi(String enquadramentoIpi) {
        this.enquadramentoIpi = enquadramentoIpi;
    }

    public String getCnpjProdutor() {
        return cnpjProdutor;
    }

    public void setCnpjProdutor(String cnpjProdutor) {
        this.cnpjProdutor = cnpjProdutor;
    }

    public String getCodigoSeloIpi() {
        return codigoSeloIpi;
    }

    public void setCodigoSeloIpi(String codigoSeloIpi) {
        this.codigoSeloIpi = codigoSeloIpi;
    }

    public Integer getQuantidadeSeloIpi() {
        return quantidadeSeloIpi;
    }

    public void setQuantidadeSeloIpi(Integer quantidadeSeloIpi) {
        this.quantidadeSeloIpi = quantidadeSeloIpi;
    }

    public String getEnquadramentoLegalIpi() {
        return enquadramentoLegalIpi;
    }

    public void setEnquadramentoLegalIpi(String enquadramentoLegalIpi) {
        this.enquadramentoLegalIpi = enquadramentoLegalIpi;
    }

    public String getCstIpi() {
        return cstIpi;
    }

    public void setCstIpi(String cstIpi) {
        this.cstIpi = cstIpi;
    }

    public BigDecimal getBaseCalculoIpi() {
        return baseCalculoIpi;
    }

    public void setBaseCalculoIpi(BigDecimal baseCalculoIpi) {
        this.baseCalculoIpi = baseCalculoIpi;
    }

    public BigDecimal getAliquotaIpi() {
        return aliquotaIpi;
    }

    public void setAliquotaIpi(BigDecimal aliquotaIpi) {
        this.aliquotaIpi = aliquotaIpi;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    public BigDecimal getValorBcIi() {
        return valorBcIi;
    }

    public void setValorBcIi(BigDecimal valorBcIi) {
        this.valorBcIi = valorBcIi;
    }

    public BigDecimal getValorDespesasAduaneiras() {
        return valorDespesasAduaneiras;
    }

    public void setValorDespesasAduaneiras(BigDecimal valorDespesasAduaneiras) {
        this.valorDespesasAduaneiras = valorDespesasAduaneiras;
    }

    public BigDecimal getValorImpostoImportacao() {
        return valorImpostoImportacao;
    }

    public void setValorImpostoImportacao(BigDecimal valorImpostoImportacao) {
        this.valorImpostoImportacao = valorImpostoImportacao;
    }

    public BigDecimal getValorIof() {
        return valorIof;
    }

    public void setValorIof(BigDecimal valorIof) {
        this.valorIof = valorIof;
    }

    public String getCstPis() {
        return cstPis;
    }

    public void setCstPis(String cstPis) {
        this.cstPis = cstPis;
    }

    public BigDecimal getValorBaseCalculoPis() {
        return valorBaseCalculoPis;
    }

    public void setValorBaseCalculoPis(BigDecimal valorBaseCalculoPis) {
        this.valorBaseCalculoPis = valorBaseCalculoPis;
    }

    public BigDecimal getAliquotaPisPercentual() {
        return aliquotaPisPercentual;
    }

    public void setAliquotaPisPercentual(BigDecimal aliquotaPisPercentual) {
        this.aliquotaPisPercentual = aliquotaPisPercentual;
    }

    public BigDecimal getAliquotaPisReais() {
        return aliquotaPisReais;
    }

    public void setAliquotaPisReais(BigDecimal aliquotaPisReais) {
        this.aliquotaPisReais = aliquotaPisReais;
    }

    public BigDecimal getValorPis() {
        return valorPis;
    }

    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }

    public String getCstCofins() {
        return cstCofins;
    }

    public void setCstCofins(String cstCofins) {
        this.cstCofins = cstCofins;
    }

    public BigDecimal getBaseCalculoCofins() {
        return baseCalculoCofins;
    }

    public void setBaseCalculoCofins(BigDecimal baseCalculoCofins) {
        this.baseCalculoCofins = baseCalculoCofins;
    }

    public BigDecimal getAliquotaCofinsPercentual() {
        return aliquotaCofinsPercentual;
    }

    public void setAliquotaCofinsPercentual(BigDecimal aliquotaCofinsPercentual) {
        this.aliquotaCofinsPercentual = aliquotaCofinsPercentual;
    }

    public BigDecimal getAliquotaCofinsReais() {
        return aliquotaCofinsReais;
    }

    public void setAliquotaCofinsReais(BigDecimal aliquotaCofinsReais) {
        this.aliquotaCofinsReais = aliquotaCofinsReais;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public BigDecimal getBaseCalculoIssqn() {
        return baseCalculoIssqn;
    }

    public void setBaseCalculoIssqn(BigDecimal baseCalculoIssqn) {
        this.baseCalculoIssqn = baseCalculoIssqn;
    }

    public BigDecimal getAliquotaIssqn() {
        return aliquotaIssqn;
    }

    public void setAliquotaIssqn(BigDecimal aliquotaIssqn) {
        this.aliquotaIssqn = aliquotaIssqn;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public void setValorIssqn(BigDecimal valorIssqn) {
        this.valorIssqn = valorIssqn;
    }

    public Integer getMunicipioIssqn() {
        return municipioIssqn;
    }

    public void setMunicipioIssqn(Integer municipioIssqn) {
        this.municipioIssqn = municipioIssqn;
    }

    public Integer getItemListaServicos() {
        return itemListaServicos;
    }

    public void setItemListaServicos(Integer itemListaServicos) {
        this.itemListaServicos = itemListaServicos;
    }

    public String getTributacaoIssqn() {
        return tributacaoIssqn;
    }

    public void setTributacaoIssqn(String tributacaoIssqn) {
        this.tributacaoIssqn = tributacaoIssqn;
    }

    public BigDecimal getValorSubtotal() {
        return valorSubtotal;
    }

    public void setValorSubtotal(BigDecimal valorSubtotal) {
        this.valorSubtotal = valorSubtotal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NfeCabecalho getNfeCabecalho() {
        return nfeCabecalho;
    }

    public void setNfeCabecalho(NfeCabecalho nfeCabecalho) {
        this.nfeCabecalho = nfeCabecalho;
    }

    public LoteProduto getLoteProduto() {
        return loteProduto;
    }

    public void setLoteProduto(LoteProduto loteProduto) {
        this.loteProduto = loteProduto;
    }
}
