package centroAssistenza;

public class RichiestaLaboratorio extends RichiestaGenerica {
    public String categoria;
    public String precisione;
    public int numeroDiSerie;

    public RichiestaLaboratorio(String codice, String categoria, String precisione, int numeroDiSerie) {
        super(codice);
        this.categoria = categoria;
        this.precisione = precisione;
        this.numeroDiSerie = numeroDiSerie;
    }

    @Override
    public String toString() {
        return "[LABORATORIO]" + super.toString();
    }

    @Override
    public String prospetto() {
        return categoria + " [N. " + numeroDiSerie + "] - Precisione: " + precisione + " (Codice: " + super.toString() + ")";
    }
}
