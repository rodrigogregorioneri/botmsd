package neri.rodrigo.botmsd.model.vendas.itentcinco;

public class Itent5 {

    private String regional;

    private String ano;

    private String mes;

    private String meta;

    private String realizado;

    private String desempenho;


    public Itent5() {
    }

    public Itent5(String regional, String ano, String mes, String meta, String realizado, String desempenho) {
        this.regional = regional;
        this.ano = ano;
        this.mes = mes;
        this.meta = meta;
        this.realizado = realizado;
        this.desempenho = desempenho;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
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

    public void convert(IItent5 i) {
        this.regional = i.getRegional();
        this.ano = i.getAno();
        this.mes = i.getMes();
        this.meta = i.getMeta();
        this.realizado = i.getRealizado();
        this.desempenho = i.getDesempenho();
    }

    @Override
    public String toString() {
        return "Itent5{" +
                "regional: " + regional + '\'' +
                ", ano: " + ano + '\'' +
                ", mes: " + mes + '\'' +
                ", meta: " + meta + '\'' +
                ", realizado: " + realizado + '\'' +
                ", desempenho: " + desempenho + '\''
                ;
    }
}
