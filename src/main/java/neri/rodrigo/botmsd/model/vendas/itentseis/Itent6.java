package neri.rodrigo.botmsd.model.vendas.itentseis;

public class Itent6 {

    private String produto;

   private String ano;

    private String mes;

    private String meta;

    private String realizado;

    private String desempenho;

    public Itent6() {
    }

    public Itent6(String produto, String ano, String mes, String meta, String realizado, String desempenho) {
        this.produto = produto;
        this.ano = ano;
        this.mes = mes;
        this.meta = meta;
        this.realizado = realizado;
        this.desempenho = desempenho;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
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

    public void convert(IItent6 i) {

        this.produto = i.getProduto();
        this.ano = i.getAno();
        this.mes = i.getMes();
        this.meta = i.getMeta();
        this.realizado = i.getRealizado();
        this.desempenho = i.getDesempenho();

    }

    @Override
    public String toString() {
        return "Itent6{" +
                "produto: " + produto + '\'' +
                ", ano: " + ano + '\'' +
                ", mes: " + mes + '\'' +
                ", meta: " + meta + '\'' +
                ", realizado: " + realizado + '\'' +
                ", desempenho: " + desempenho + '\''
                ;
    }
}
