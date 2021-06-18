
package neri.rodrigo.botmsd.model.request;


import java.util.List;

public class Parameters {

    private String produtos;

    private List<String> regional;

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }
    public List<String> getRegional() {
        return regional;
    }
    public void setRegional(List<String> regional) {
        this.regional = regional;
    }
}
