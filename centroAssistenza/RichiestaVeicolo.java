package centroAssistenza;

public class RichiestaVeicolo extends  RichiestaGenerica{
    public String targa;
    public String proprietario;
    public int chilometri;
    public RichiestaVeicolo(String codice, String targa, String proprietario, int chilometri) {
        super(codice);
        this.targa = targa;
        this.proprietario = proprietario;
        this.chilometri = chilometri;
    }

    @Override
    public String toString() {
        return "[VEICOLO]" + super.toString();
    }

    @Override
    public String prospetto() {
        return targa + " (Proprietario: " + proprietario + ") - KM: " + chilometri + " (Codice: " + super.toString() + ")";
    }
}
