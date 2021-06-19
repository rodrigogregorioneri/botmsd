package neri.rodrigo.botmsd.model.visitas.listadzclientessemvisitastrintadias;

public class ListaDezClientesSemVisitasTrintaDias {

    private String cliente;

    private String dias;

    public ListaDezClientesSemVisitasTrintaDias() {
    }

    public ListaDezClientesSemVisitasTrintaDias(String regional, String acao) {
        this.cliente = regional;
        this.dias = acao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public void convert(IListaDezClientesSemVisitasTrintaDias i){
        this.cliente = i.getCliente();
        this.dias = i.getDias();
    }

    @Override
    public String toString() {
        return "ListaDezClientesSemVisitasTrintaDias{" +
                "regional='" + cliente + '\'' +
                ", acao='" + dias + '\'' +
                '}';
    }
}
