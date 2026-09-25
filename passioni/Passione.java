package passioni;

public class Passione {
    protected final String titolo;
    
    public Passione(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "\"" + titolo + "\"";
    }

}