package neri.rodrigo.botmsd.model.visitas;

import javax.persistence.*;

@Entity
@Table(name = "TB_Visitas")
public class Visitas {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "GRUPOMERCADO")
    private String grupo_mercado;

    @Column(name = "REGIONAL")
    private String regional;

    @Column(name = "VENDEDOR")
    private String vendedor;

    @Column(name = "ACAO")
    private String acao;

    @Column(name = "DATA")
    private String data;

    @Column(name = "ANO")
    private String ano;

    @Column(name = "MES")
    private String mes;

    @Column(name = "NOMEVISITA")
    private String nome_visita;

    @Column(name = "STATUS_VISITA")
    private String status_visita;

    @Column(name = "CLIENTE")
    private String cliente;

    @Column(name = "TIPO_VISITA")
    private String tipo_visita;

    public String getGrupo_mercado() {
        return grupo_mercado;
    }

    public void setGrupo_mercado(String grupo_mercado) {
        this.grupo_mercado = grupo_mercado;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public String getNome_visita() {
        return nome_visita;
    }

    public void setNome_visita(String nome_visita) {
        this.nome_visita = nome_visita;
    }

    public String getStatus_visita() {
        return status_visita;
    }

    public void setStatus_visita(String status_visita) {
        this.status_visita = status_visita;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipo_visita() {
        return tipo_visita;
    }

    public void setTipo_visita(String tipo_visita) {
        this.tipo_visita = tipo_visita;
    }
}
