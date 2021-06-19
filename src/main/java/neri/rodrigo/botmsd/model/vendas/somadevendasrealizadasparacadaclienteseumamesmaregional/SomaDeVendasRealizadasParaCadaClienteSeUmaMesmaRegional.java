package neri.rodrigo.botmsd.model.vendas.somadevendasrealizadasparacadaclienteseumamesmaregional;

public class SomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional {

    private String regional;

    private String mes;

    private String vendido;

    public SomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional() {
    }

    public SomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional(String regional, String mes, String vendido) {
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

    public void convert(ISomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional i){
        this.regional = i.getRegional();
        this.mes = i.getMes();
        this.vendido = i.getVendido();
    }

    @Override
    public String toString() {
        return "SomaDeVendasRealizadasParaCadaClienteSeUmaMesmaRegional{" +
                "regional='" + regional + '\'' +
                ", mes='" + mes + '\'' +
                ", vendido='" + vendido + '\'' +
                '}';
    }
}
