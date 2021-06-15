package neri.rodrigo.botmsd.model.vendas.realizadoparaoclienteenumdeterminadoperiodo;

import neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto.IRealizadoXcotaFamiliaProduto;

public class RealizadoParaOclienteEnumDeterminadoPeriodo {

    private String grupoMercado;

    private String produto;

    private String ano;

    private String mes;


    private String valorLiquido;

    public RealizadoParaOclienteEnumDeterminadoPeriodo() {
    }

    public RealizadoParaOclienteEnumDeterminadoPeriodo(String grupoMercado, String produto, String ano, String mes,  String valorLiquido) {
        this.grupoMercado = grupoMercado;
        this.produto = produto;
        this.ano = ano;
        this.mes = mes;

        this.valorLiquido = valorLiquido;
    }

    public String getGrupoMercado() {
        return grupoMercado;
    }

    public void setGrupoMercado(String grupoMercado) {
        this.grupoMercado = grupoMercado;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
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

    public String getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(String valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public void iResponseToResponseTest(IRealizadoParaOclienteEnumDeterminadoPeriodo iResponse){
        this.grupoMercado = iResponse.getGrupoMercado();
        this.produto = iResponse.getProduto();
        this.ano = iResponse.getAno();
        this.mes = iResponse.getMes();
        this.valorLiquido = iResponse.getValorLiquido();
    }

    @Override
    public String toString() {
        return " " +
                "  Grupo Mercado: " + grupoMercado + '\'' +
                ", Produto: " + produto + '\'' +
                ", Ano: " + ano + '\'' +
                ", mes: " + mes + '\'' +
                ", Valor Liquido: " + valorLiquido + '\'';
    }
}
