
package neri.rodrigo.botmsd.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Parameters {

    private String produtos;

    @JsonProperty("Regional")
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
