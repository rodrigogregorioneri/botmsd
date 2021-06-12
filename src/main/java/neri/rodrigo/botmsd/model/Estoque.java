package neri.rodrigo.botmsd.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_Estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CODPRODUTO")
    private String cod_produto;

    @Column(name = "NOMEFAMILIAPRODUTO")
    private String nomefamiliaproduto;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "NUMLOTE")
    private String numlote;

    @Column(name = "NOMEPRODUTO")
    private String nomeproduto;

    @Column(name = "DATAVENCIMENTO")
    private String datavencimento;

    @Column(name = "NOMECENTRODISTRIBUICAO")
    private String nome_centro_distribuicao;

    @Column(name = "TOTALESTOQUE")
    private String total_estoque;

    @Column(name = "VALORTOTAL")
    private String valor_total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNomefamiliaproduto() {
        return nomefamiliaproduto;
    }

    public void setNomefamiliaproduto(String nomefamiliaproduto) {
        this.nomefamiliaproduto = nomefamiliaproduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumlote() {
        return numlote;
    }

    public void setNumlote(String numlote) {
        this.numlote = numlote;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(String datavencimento) {
        this.datavencimento = datavencimento;
    }

    public String getNome_centro_distribuicao() {
        return nome_centro_distribuicao;
    }

    public void setNome_centro_distribuicao(String nome_centro_distribuicao) {
        this.nome_centro_distribuicao = nome_centro_distribuicao;
    }

    public String getTotal_estoque() {
        return total_estoque;
    }

    public void setTotal_estoque(String total_estoque) {
        this.total_estoque = total_estoque;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
}
