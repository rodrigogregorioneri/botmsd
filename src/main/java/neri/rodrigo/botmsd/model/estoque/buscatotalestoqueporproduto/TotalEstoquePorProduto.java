package neri.rodrigo.botmsd.model.estoque.buscatotalestoqueporproduto;

public class TotalEstoquePorProduto {

    private String codProduto;

    private String nomeProduto;

    private String somaEstoque;

    public TotalEstoquePorProduto() {
    }

    public TotalEstoquePorProduto(String codProduto, String nomeProduto, String somaEstoque) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.somaEstoque = somaEstoque;
    }

    public String getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(String codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getSomaEstoque() {
        return somaEstoque;
    }

    public void setSomaEstoque(String somaEstoque) {
        this.somaEstoque = somaEstoque;
    }

    public void convert(ITotalEstoquePorProduto iTotalEstoquePorProduto) {
        this.codProduto = iTotalEstoquePorProduto.getCodProduto();
        this.nomeProduto = iTotalEstoquePorProduto.getNomeProduto();
        this.somaEstoque = iTotalEstoquePorProduto.getSomaEstoque();
    }

    @Override
    public String toString() {
        return " " +
                "  Código do Produto:" + codProduto + '\'' +
                ", Nome Produto: " + nomeProduto + '\'' +
                ", Soma Estoque: " + somaEstoque + '\'';
    }
}
