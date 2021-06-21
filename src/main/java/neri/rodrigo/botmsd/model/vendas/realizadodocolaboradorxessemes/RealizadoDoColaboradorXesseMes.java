package neri.rodrigo.botmsd.model.vendas.realizadodocolaboradorxessemes;

public class RealizadoDoColaboradorXesseMes {

    private String vendedor;

    private String realizado;

    private String cota;

    public RealizadoDoColaboradorXesseMes() {
    }

    public RealizadoDoColaboradorXesseMes(String familia, String ano, String mes) {
        this.vendedor = familia;
        this.realizado = ano;
        this.cota = mes;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public String getCota() {
        return cota;
    }

    public void setCota(String cota) {
        this.cota = cota;
    }

    public void convert(IRealizadoDoColaboradorXesseMes i){
        this.vendedor = i.getVendedor();
        this.realizado = i.getRealizado();
        this.cota = i.getCota();
    }

    @Override
    public String toString() {
        return " " +
                "familia: " + vendedor + '\'' +
                ", ano: " + realizado + '\'' +
                ", mes: " + cota + '\''
                ;
    }
}
