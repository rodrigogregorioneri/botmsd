package neri.rodrigo.botmsd.model.vendas.realizadoxcotafamiliaproduto;

import neri.rodrigo.botmsd.model.estoque.estoqueinfo.IEstoqueInfo;

public class RealizadoXcotaFamiliaProduto {

    private String grupoMercado;

    private String regional;

    private String vendedor;

    private String nomeFamiliaProduto;

    private String produto;

    String ano;

    String mes;

    String valorLiquidoCota;

    String valorLiquido;

    public RealizadoXcotaFamiliaProduto() {
    }

    public RealizadoXcotaFamiliaProduto(String grupoMercado, String regional, String vendedor, String nomeFamiliaProduto, String produto, String ano, String mes, String valorLiquidoCota, String valorLiquido) {
        this.grupoMercado = grupoMercado;
        this.regional = regional;
        this.vendedor = vendedor;
        this.nomeFamiliaProduto = nomeFamiliaProduto;
        this.produto = produto;
        this.ano = ano;
        this.mes = mes;
        this.valorLiquidoCota = valorLiquidoCota;
        this.valorLiquido = valorLiquido;
    }

    public String getGrupoMercado() {
        return grupoMercado;
    }

    public void setGrupoMercado(String grupoMercado) {
        this.grupoMercado = grupoMercado;
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

    public String getNomeFamiliaProduto() {
        return nomeFamiliaProduto;
    }

    public void setNomeFamiliaProduto(String nomeFamiliaProduto) {
        this.nomeFamiliaProduto = nomeFamiliaProduto;
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

    public String getValorLiquidoCota() {
        return valorLiquidoCota;
    }

    public void setValorLiquidoCota(String valorLiquidoCota) {
        this.valorLiquidoCota = valorLiquidoCota;
    }

    public String getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(String valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public void iResponseToResponseTest(IRealizadoXcotaFamiliaProduto iResponse){
        this.grupoMercado = iResponse.getGrupoMercado();
        this.regional = iResponse.getRegional();
        this.vendedor = iResponse.getVendedor();
        this.nomeFamiliaProduto = iResponse.getNomeFamiliaProduto();
        this.produto = iResponse.getProduto();
        this.ano = iResponse.getAno();
        this.mes = iResponse.getMes();
        this.valorLiquidoCota = iResponse.getValorLiquidoCota();
        this.valorLiquido = iResponse.getValorLiquido();
    }

    @Override
    public String toString() {
        return " " +
                "  Grupo Mercado: " + grupoMercado + '\'' +
                ", Regional: " + regional + '\'' +
                ", Vendedor: " + vendedor + '\'' +
                ", Nome da Familia do Produto: " + nomeFamiliaProduto + '\'' +
                ", Produto: " + produto + '\'' +
                ", Ano: " + ano + '\'' +
                ", Mes: " + mes + '\'' +
                ", Valor Liquido Cota: " + valorLiquidoCota + '\'' +
                ", Valor Liquido: " + valorLiquido + '\'';
    }
}
