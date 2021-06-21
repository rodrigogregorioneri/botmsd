package neri.rodrigo.botmsd.model.vendas.itentnove;

public class Itent9 {

    private String vendedor;

    private String cliente;

    private String realizado;

    public Itent9() {
    }

    public Itent9(String vendedor, String cliente, String realizado) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.realizado = realizado;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public void convert(IItent9 i) {
        this.vendedor = i.getVendedor();
        this.cliente = i.getCliente();
        this.realizado = i.getRealizado();

    }

    @Override
    public String toString() {
        return "Itent9{" +
                "vendedor: " + vendedor + '\'' +
                ", cliente: " + cliente + '\'' +
                ", realizado: " + realizado + '\''
                ;
    }
}
