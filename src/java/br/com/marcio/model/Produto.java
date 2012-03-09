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
@Table(name="PRODUTO")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    @Column(name = "NOME")
    private String nome;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DESCRICAO_PDV")
    private String descricaoPdv;
    @Column(name = "VALOR_COMPRA")
    private BigDecimal valorCompra;
    @Column(name = "VALOR_VENDA")
    private BigDecimal valorVenda;
    @Column(name = "PRECO_VENDA_MINIMO")
    private BigDecimal precoVendaMinimo;
    @Column(name = "PRECO_SUGERIDO")
    private BigDecimal precoSugerido;
    @Column(name = "CUSTO_MEDIO_LIQUIDO")
    private BigDecimal custoMedioLiquido;
    @Column(name = "PRECO_LUCRO_ZERO")
    private BigDecimal precoLucroZero;
    @Column(name = "PRECO_LUCRO_MINIMO")
    private BigDecimal precoLucroMinimo;
    @Column(name = "PRECO_LUCRO_MAXIMO")
    private BigDecimal precoLucroMaximo;
    @Column(name = "MARKUP")
    private BigDecimal markup;
    @Column(name = "QUANTIDADE_ESTOQUE")
    private BigDecimal quantidadeEstoque;
    @Column(name = "ESTOQUE_MINIMO")
    private BigDecimal estoqueMinimo;
    @Column(name = "ESTOQUE_MAXIMO")
    private BigDecimal estoqueMaximo;
    @Column(name = "EXCLUIDO")
    private Character excluido;
    @Column(name = "INATIVO")
    private Character inativo;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Lob
    @Column(name = "IMAGEM")
    private String imagem;
    @Column(name = "EX_TIPI")
    private String exTipi;
    @Column(name = "CODIGO_LST")
    private String codigoLst;
    @Column(name = "CLASSE_ABC")
    private Character classeAbc;
    @Column(name = "IAT")
    private Character iat;
    @Column(name = "IPPT")
    private Character ippt;
    @JoinColumn(name = "ID_UNIDADE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeProduto unidade;
    @JoinColumn(name = "ID_SUB_GRUPO", referencedColumnName = "ID")
    @ManyToOne
    private SubGrupoProduto subGrupo;
    @JoinColumn(name = "ID_NCM", referencedColumnName = "ID")
    @ManyToOne
    private Ncm ncm;
    @JoinColumn(name = "ID_TIPO_ITEM_SPED", referencedColumnName = "ID")
    @ManyToOne
    private TipoItemSped tipoItemSped;
    @JoinColumn(name = "ID_MARCA_PRODUTO", referencedColumnName = "ID")
    @ManyToOne
    private MarcaProduto marcaProduto;
    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne
    private Empresa empresa;
    @JoinColumn(name = "ID_IMPOSTO_ST_UF", referencedColumnName = "ID")
    @ManyToOne
    private ImpostoStUf impostoStUf;
    @JoinColumn(name = "ID_BASE_CALCULO_REDUZIDA", referencedColumnName = "ID")
    @ManyToOne
    private BaseCalculoReduzida baseCalculoReduzida;
    @JoinColumn(name = "ID_TRIBUTACAO_ESTADUAL", referencedColumnName = "ID")
    @ManyToOne
    private TributacaoEstadual tributacaoEstadual;

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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.marcio.model.Produto[ id=" + id + " ]";
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoPdv() {
        return descricaoPdv;
    }

    public void setDescricaoPdv(String descricaoPdv) {
        this.descricaoPdv = descricaoPdv;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public BigDecimal getPrecoVendaMinimo() {
        return precoVendaMinimo;
    }

    public void setPrecoVendaMinimo(BigDecimal precoVendaMinimo) {
        this.precoVendaMinimo = precoVendaMinimo;
    }

    public BigDecimal getPrecoSugerido() {
        return precoSugerido;
    }

    public void setPrecoSugerido(BigDecimal precoSugerido) {
        this.precoSugerido = precoSugerido;
    }

    public BigDecimal getCustoMedioLiquido() {
        return custoMedioLiquido;
    }

    public void setCustoMedioLiquido(BigDecimal custoMedioLiquido) {
        this.custoMedioLiquido = custoMedioLiquido;
    }

    public BigDecimal getPrecoLucroZero() {
        return precoLucroZero;
    }

    public void setPrecoLucroZero(BigDecimal precoLucroZero) {
        this.precoLucroZero = precoLucroZero;
    }

    public BigDecimal getPrecoLucroMinimo() {
        return precoLucroMinimo;
    }

    public void setPrecoLucroMinimo(BigDecimal precoLucroMinimo) {
        this.precoLucroMinimo = precoLucroMinimo;
    }

    public BigDecimal getPrecoLucroMaximo() {
        return precoLucroMaximo;
    }

    public void setPrecoLucroMaximo(BigDecimal precoLucroMaximo) {
        this.precoLucroMaximo = precoLucroMaximo;
    }

    public BigDecimal getMarkup() {
        return markup;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    public BigDecimal getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(BigDecimal quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public BigDecimal getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public BigDecimal getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public Character getExcluido() {
        return excluido;
    }

    public void setExcluido(Character excluido) {
        this.excluido = excluido;
    }

    public Character getInativo() {
        return inativo;
    }

    public void setInativo(Character inativo) {
        this.inativo = inativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getExTipi() {
        return exTipi;
    }

    public void setExTipi(String exTipi) {
        this.exTipi = exTipi;
    }

    public String getCodigoLst() {
        return codigoLst;
    }

    public void setCodigoLst(String codigoLst) {
        this.codigoLst = codigoLst;
    }

    public Character getClasseAbc() {
        return classeAbc;
    }

    public void setClasseAbc(Character classeAbc) {
        this.classeAbc = classeAbc;
    }

    public Character getIat() {
        return iat;
    }

    public void setIat(Character iat) {
        this.iat = iat;
    }

    public Character getIppt() {
        return ippt;
    }

    public void setIppt(Character ippt) {
        this.ippt = ippt;
    }

    public UnidadeProduto getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeProduto unidade) {
        this.unidade = unidade;
    }

    public SubGrupoProduto getSubGrupo() {
        return subGrupo;
    }

    public void setSubGrupo(SubGrupoProduto subGrupo) {
        this.subGrupo = subGrupo;
    }

    public Ncm getNcm() {
        return ncm;
    }

    public void setNcm(Ncm ncm) {
        this.ncm = ncm;
    }

    public TipoItemSped getTipoItemSped() {
        return tipoItemSped;
    }

    public void setTipoItemSped(TipoItemSped tipoItemSped) {
        this.tipoItemSped = tipoItemSped;
    }

    public MarcaProduto getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(MarcaProduto marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ImpostoStUf getImpostoStUf() {
        return impostoStUf;
    }

    public void setImpostoStUf(ImpostoStUf impostoStUf) {
        this.impostoStUf = impostoStUf;
    }

    public BaseCalculoReduzida getBaseCalculoReduzida() {
        return baseCalculoReduzida;
    }

    public void setBaseCalculoReduzida(BaseCalculoReduzida baseCalculoReduzida) {
        this.baseCalculoReduzida = baseCalculoReduzida;
    }

    public TributacaoEstadual getTributacaoEstadual() {
        return tributacaoEstadual;
    }

    public void setTributacaoEstadual(TributacaoEstadual tributacaoEstadual) {
        this.tributacaoEstadual = tributacaoEstadual;
    }
}
