package neri.rodrigo.botmsd.model.vendas.itentdez;

import neri.rodrigo.botmsd.model.vendas.itentcinco.IItent5;

public class Itent10 {

    private String vendedor;

    private String produto;

    private String vendidoAnoPassado;

    private String vendidoAnoAtual;

    private String desempenho;




    public Itent10() {
    }

    public Itent10(String vendedor, String produto, String vendidoAnoPassado, String vendidoAnoAtual, String desempenho) {
        this.vendedor = vendedor;
        this.produto = produto;
        this.vendidoAnoPassado = vendidoAnoPassado;
        this.vendidoAnoAtual = vendidoAnoAtual;
        this.desempenho = desempenho;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getVendidoAnoPassado() {
        return vendidoAnoPassado;
    }

    public void setVendidoAnoPassado(String vendidoAnoPassado) {
        this.vendidoAnoPassado = vendidoAnoPassado;
    }

    public String getVendidoAnoAtual() {
        return vendidoAnoAtual;
    }

    public void setVendidoAnoAtual(String vendidoAnoAtual) {
        this.vendidoAnoAtual = vendidoAnoAtual;
    }

    public String getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(String desempenho) {
        this.desempenho = desempenho;
    }

    public void convert(IItent10 i) {
        this.vendedor = i.getVendedor();
        this.produto = i.getProduto();
        this.vendidoAnoPassado = i.getVendidoAnoPassado();
        this.vendidoAnoAtual = i.getVendidoAnoAtual();
        this.desempenho = i.getProduto();

    }

    @Override
    public String toString() {
        return "Itent10{" +
                "vendedor: " + vendedor + '\'' +
                ", produto: " + produto + '\'' +
                ", vendidoAnoPassado: " + vendidoAnoPassado + '\'' +
                ", vendidoAnoAtual: " + vendidoAnoAtual + '\'' +
                ", desempenho: " + desempenho + '\''
                ;
    }
}
