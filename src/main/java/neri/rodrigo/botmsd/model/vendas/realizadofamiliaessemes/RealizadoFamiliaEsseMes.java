package neri.rodrigo.botmsd.model.vendas.realizadofamiliaessemes;

public class RealizadoFamiliaEsseMes {

    private String familia;

    private String ano;

    private String mes;

    private String realizado;

    private String desempenho;

    public RealizadoFamiliaEsseMes() {
    }

    public RealizadoFamiliaEsseMes(String familia, String ano, String mes, String realizado, String desempenho) {
        this.familia = familia;
        this.ano = ano;
        this.mes = mes;
        this.realizado = realizado;
        this.desempenho = desempenho;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
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

    public void convert(IRealizadoFamiliaEsseMes i){
        this.familia = i.getFamilia();
        this.ano = i.getAno();
        this.mes = i.getMes();
        this.realizado = i.getRealizado();
        this.desempenho = i.getDesempenho();
    }

    @Override
    public String toString() {
        return "RealizadoFamiliaEsseMes{" +
                "familia='" + familia + '\'' +
                ", ano='" + ano + '\'' +
                ", mes='" + mes + '\'' +
                ", realizado='" + realizado + '\'' +
                ", desempenho='" + desempenho + '\'' +
                '}';
    }
}
