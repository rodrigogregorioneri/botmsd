package neri.rodrigo.botmsd.model.vendas.itentquatro;

import neri.rodrigo.botmsd.model.vendas.itentnove.IItent9;

public class Itent4 {

    private String linha;

    private String ano;

    private String mes;

    private String meta;

    private String realizado;

    private String desempenho;

    public Itent4() {
    }

    public Itent4(String linha, String ano, String mes, String meta, String realizado, String desempenho) {
        this.linha = linha;
        this.ano = ano;
        this.mes = mes;
        this.meta = meta;
        this.realizado = realizado;
        this.desempenho = desempenho;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
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

    public void convert(IItent4 i) {

        this.linha = i.getLinha();
        this.ano = i.getAno();
        this.mes = i.getMes();
        this.meta = i.getMeta();
        this.realizado = i.getRealizado();
        this.desempenho = i.getDesempenho();

    }

    @Override
    public String toString() {
        return "Itent4{" +
                "linha: " + linha + '\'' +
                ", ano: " + ano + '\'' +
                ", mes='" + mes + '\'' +
                ", meta: " + meta + '\'' +
                ", realizado: " + realizado + '\'' +
                ", desempenho: " + desempenho + '\''
                ;
    }
}
