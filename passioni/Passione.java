package passioni;

public class Passione implements Classificabile{
    protected final String titolo;
    
    public Passione(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "\"" + titolo + "\"";
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Passione)) return  false;

        Passione altra = (Passione) obj;
        return titolo.equals(altra.titolo);
    }

    @Override
    public String nomeClassifica() {
        return toString();
    }
}