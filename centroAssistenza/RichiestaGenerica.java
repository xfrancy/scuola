package centroAssistenza;

public class RichiestaGenerica implements Processabile{
    public String codice;

    public RichiestaGenerica(String codice) {
        this.codice = codice;
    }

    @Override
    public String toString() {
        return "{" + codice + "}";
    }

    @Override
    public String prospetto() {
        return toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RichiestaGenerica)) return  false;

        RichiestaGenerica altra = (RichiestaGenerica) obj;
        return codice.equals(altra.codice);
    }
}
