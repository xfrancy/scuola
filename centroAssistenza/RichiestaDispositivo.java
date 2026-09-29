package centroAssistenza;

public class RichiestaDispositivo extends RichiestaGenerica{
    public String modello;
    public String guasto;

    public RichiestaDispositivo(String codice, String modello, String guasto) {
        super(codice);
        this.modello = modello;
        this.guasto = guasto;
    }

    @Override
    public String toString() {
        return "[DISPOSITIVO]" + super.toString();
    }

    @Override
    public String prospetto() {
        return modello + " - Guasto: " + guasto + " (Codice: " + super.toString() + ")";
    }
}
