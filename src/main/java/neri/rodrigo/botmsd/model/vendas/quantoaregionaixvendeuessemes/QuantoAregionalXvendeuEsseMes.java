package neri.rodrigo.botmsd.model.vendas.quantoaregionaixvendeuessemes;

public class QuantoAregionalXvendeuEsseMes {

    private String regional;

    private String mes;

    private String vendido;

    public QuantoAregionalXvendeuEsseMes() {
    }

    public QuantoAregionalXvendeuEsseMes(String regional, String mes, String vendido) {
        this.regional = regional;
        this.mes = mes;
        this.vendido = vendido;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getVendido() {
        return vendido;
    }

    public void setVendido(String vendido) {
        this.vendido = vendido;
    }

    public void convert(IQuantoAregionalXvendeuEsseMes i){
        this.regional = i.getRegional();
        this.mes = i.getMes();
        this.vendido = i.getVendido();
    }

    @Override
    public String toString() {
        return "QuantoAregionalXvendeuEsseMes{" +
                "regional='" + regional + '\'' +
                ", mes='" + mes + '\'' +
                ", vendido='" + vendido + '\'' +
                '}';
    }
}
