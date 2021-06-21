package neri.rodrigo.botmsd.model.vendas.quantidadedevendastotaiparacadacliente;

public class QuantidadeDeVendasTotalParaCadaCliente {

    private String cliente;

    private String vendasRealizadas;

    public QuantidadeDeVendasTotalParaCadaCliente() {
    }

    public QuantidadeDeVendasTotalParaCadaCliente(String cliente, String vendasRealizadas) {
        this.cliente = cliente;
        this.vendasRealizadas = vendasRealizadas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendasRealizadas() {
        return vendasRealizadas;
    }

    public void setVendasRealizadas(String vendasRealizadas) {
        this.vendasRealizadas = vendasRealizadas;
    }

    public void convert(IQuantidadeDeVendasTotalParaCadaCliente i){
        this.cliente = i.getCliente();
        this.vendasRealizadas = i.getVendasRealizadas();
    }

    @Override
    public String toString() {
        return " " +
                "cliente: " + cliente + '\'' +
                ", vendasRealizadas: " + vendasRealizadas + '\'';
    }
}
