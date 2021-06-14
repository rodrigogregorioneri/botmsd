package neri.rodrigo.botmsd.model.vendas.vendasxcota;


import neri.rodrigo.botmsd.model.estoque.estoqueinfo.IEstoqueInfo;

public class VendasXestoqueResponse {

    private String grupo_mercado;

    private String regional;

    private String ano;

    private String mes;

    private String valor_liquido_cota;

    private String  valor_liquido;

    public VendasXestoqueResponse() {
    }

    public VendasXestoqueResponse(String grupo_mercado, String regional, String ano, String mes, String valor_liquido_cota, String valor_liquido) {
        this.grupo_mercado = grupo_mercado;
        this.regional = regional;
        this.ano = ano;
        this.mes = mes;
        this.valor_liquido_cota = valor_liquido_cota;
        this.valor_liquido = valor_liquido;
    }

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

    public void iVendasXcotaToVendasXestoqueResponse(IVendasXcota iVendasXcota){
        this.grupo_mercado = iVendasXcota.getGrupoMercado();
        this.regional = iVendasXcota.getRegional();
        this.ano = iVendasXcota.getAno();
        this.mes = iVendasXcota.getMes();
        this.valor_liquido_cota = iVendasXcota.getValorLiquidoCota();
        this.valor_liquido = iVendasXcota.getValorLiquido();
    }


    @Override
    public String toString() {
        return "" +
                "Grupo Mercado: " + grupo_mercado + '\'' +
                ", Regional: " + regional + '\'' +
                ", Ano: " + ano + '\'' +
                ", Mês: " + mes + '\'' +
                ", Valor Liquido da Cota: R$ " +(valor_liquido_cota == null ? "0,0" : String.valueOf(valor_liquido_cota))+ '\'' +
                ", Valor Liquido: R$ " + (valor_liquido == null ? "0,0" : String.valueOf(valor_liquido));
    }


}
