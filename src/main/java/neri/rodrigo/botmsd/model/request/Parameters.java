
package neri.rodrigo.botmsd.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Parameters {

    private String produtos;

    private String produto;

    @JsonProperty("Regional")
    private String regional;

    private String vendedor;

    private String cliente;

    private String nomeFamiliaProduto;

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }
    public String getRegional() {
        return regional;
    }
    public void setRegional(String regional) {
        this.regional = regional;
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

    public String getNomeFamiliaProduto() {
        return nomeFamiliaProduto;
    }

    public void setNomeFamiliaProduto(String nomeFamiliaProduto) {
        this.nomeFamiliaProduto = nomeFamiliaProduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
