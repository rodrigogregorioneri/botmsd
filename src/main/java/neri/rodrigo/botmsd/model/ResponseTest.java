package neri.rodrigo.botmsd.model;


public class ResponseTest {

    private String produto;

    private String quantidade;

    private String cod_produto;

    private String nome_centro_distribuicao;

    private String valor_total;

    public ResponseTest(String produto, String quantidade, String cod_produto, String nome_centro_distribuicao, String valor_total) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.cod_produto = cod_produto;
        this.nome_centro_distribuicao = nome_centro_distribuicao;
        this.valor_total = valor_total;
    }

    public ResponseTest() {
    }

    public void iResponseToResponseTest(IResponse iResponse){
        this.produto = iResponse.getProduto();
        this.quantidade = String.valueOf(iResponse.getQuantidade());
        this.cod_produto = iResponse.getCodProduto();
        this.nome_centro_distribuicao = iResponse.getNomeCentroDistribuicao();
        this.valor_total = String.valueOf(iResponse.getValorTotal());
    }

    @Override
    public String toString() {
        return "ResponseTest{" +
                "produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", cod_produto='" + cod_produto + '\'' +
                ", nome_centro_distribuicao='" + nome_centro_distribuicao + '\'' +
                ", valor_total=" + valor_total +
                '}';
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNome_centro_distribuicao() {
        return nome_centro_distribuicao;
    }

    public void setNome_centro_distribuicao(String nome_centro_distribuicao) {
        this.nome_centro_distribuicao = nome_centro_distribuicao;
    }

    public String getValor_total() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }
}
