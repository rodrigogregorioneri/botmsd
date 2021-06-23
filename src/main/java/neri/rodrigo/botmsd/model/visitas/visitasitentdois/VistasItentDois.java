package neri.rodrigo.botmsd.model.visitas.visitasitentdois;

public class VistasItentDois {

    private String regional;

    private String acao;

    private String statusVisita;

    private String qtdVisitas;

    public VistasItentDois() {
    }

    public VistasItentDois(String regional, String acao, String statusVisita, String qtdVisitas) {
        this.regional = regional;
        this.acao = acao;
        this.statusVisita = statusVisita;
        this.qtdVisitas = qtdVisitas;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getStatusVisita() {
        return statusVisita;
    }

    public void setStatusVisita(String statusVisita) {
        this.statusVisita = statusVisita;
    }

    public String getQtdVisitas() {
        return qtdVisitas;
    }

    public void setQtdVisitas(String qtdVisitas) {
        this.qtdVisitas = qtdVisitas;
    }

    public void convert(IVistasItentDois e) {
        this.regional = e.getRegional();
        this.acao = e.getAcao();
        this.statusVisita = e.getStatusVisita();
        this.qtdVisitas = e.getQtdVisitas();
    }

    @Override
    public String toString() {
        return " " +
                "  regional :" + regional + '\'' +
                ", açao :" + acao + '\'' +
                ", Status Visita: " + statusVisita + '\'' +
                ", Quantidade Visitas: " + qtdVisitas + '\'' ;
    }
}
