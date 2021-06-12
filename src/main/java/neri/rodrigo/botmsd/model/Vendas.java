package neri.rodrigo.botmsd.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_Vendas")
public class Vendas {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "GRUPOMERCADO")
    private String grupo_mercado;

    @Column(name = "VENDEDOR")
    private String vendedor;

    @Column(name = "REGIONAL")
    private String regional;

    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "NOMEFAMILIAPRODUTO")
    private String nome_familia_produto;

    @Column(name = "PRODUTO")
    private String produto;

    @Column(name = "NOMERAMOATIVIDADE")
    private String nome_ramo_atividade;

    @Column(name = "ANO")
    private String ano;

    @Column(name = "MES")
    private String mes;

    @Column(name = "QUANTIDADEITEM")
    private String qtd_item;

    @Column(name = "QUANTIDADEITEM_COTA")
    private String qtd_cota;

    @Column(name = "VALORLIQUIDO_COTA")
    private String valor_liquido_cota;

    @Column(name = "VALORLIQUIDO")
    private String valor_liquido;


    public String getGrupo_mercado() {
        return grupo_mercado;
    }

    public void setGrupo_mercado(String grupo_mercado) {
        this.grupo_mercado = grupo_mercado;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNome_familia_produto() {
        return nome_familia_produto;
    }

    public void setNome_familia_produto(String nome_familia_produto) {
        this.nome_familia_produto = nome_familia_produto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getNome_ramo_atividade() {
        return nome_ramo_atividade;
    }

    public void setNome_ramo_atividade(String nome_ramo_atividade) {
        this.nome_ramo_atividade = nome_ramo_atividade;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getQtd_item() {
        return qtd_item;
    }

    public void setQtd_item(String qtd_item) {
        this.qtd_item = qtd_item;
    }

    public String getQtd_cota() {
        return qtd_cota;
    }

    public void setQtd_cota(String qtd_cota) {
        this.qtd_cota = qtd_cota;
    }

    public String getValor_liquido_cota() {
        return valor_liquido_cota;
    }

    public void setValor_liquido_cota(String valor_liquido_cota) {
        this.valor_liquido_cota = valor_liquido_cota;
    }

    public String getValor_liquido() {
        return valor_liquido;
    }

    public void setValor_liquido(String valor_liquido) {
        this.valor_liquido = valor_liquido;
    }
}
