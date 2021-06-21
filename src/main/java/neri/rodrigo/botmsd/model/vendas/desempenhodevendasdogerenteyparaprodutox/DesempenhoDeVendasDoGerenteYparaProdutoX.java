package neri.rodrigo.botmsd.model.vendas.desempenhodevendasdogerenteyparaprodutox;

public class DesempenhoDeVendasDoGerenteYparaProdutoX {

    private String vendedor;

    private String produto;

    private String meta;

    private String realizado;

    private String desempenho;

    public DesempenhoDeVendasDoGerenteYparaProdutoX() {
    }

    public DesempenhoDeVendasDoGerenteYparaProdutoX(String vendedor, String produto, String meta, String realizado, String desempenho) {
        this.vendedor = vendedor;
        this.produto = produto;
        this.meta = meta;
        this.realizado = realizado;
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

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getRealizado() {
        return realizado;
    }

    public void setRealizado(String realizado) {
        this.realizado = realizado;
    }

    public String getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(String desempenho) {
        this.desempenho = desempenho;
    }

    public void convert(IDesempenhoDeVendasDoGerenteYparaProdutoX i){
        this.vendedor = i.getVendedor();
        this.produto = i.getProduto();
        this.meta = i.getMeta();
        this.realizado = i.getRealizado();
        this.desempenho = i.getDesempenho();
    }


    @Override
    public String toString() {
        return " " +
                "  vendedor: " + vendedor + '\'' +
                ", produto: " + produto + '\'' +
                ", meta: " + meta + '\'' +
                ", realizado: " + realizado + '\'' +
                ", desempenho: " + desempenho + '\'';
    }
}
