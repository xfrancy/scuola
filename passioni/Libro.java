package passioni;

public class Libro extends Passione{
    private final String autore;
    private final String ISBN;
    private final int pagine;

    public Libro(String titolo, String autore, String iSBN, int pagine) {
        super(titolo);
        this.autore = autore;
        ISBN = iSBN;
        this.pagine = pagine;
    }

    @Override
    public String nomeClassifica() {
        return autore + " " + super.toString() + " (ISBN: " + ISBN + ")";
    }

    @Override
    public String toString() {
        return "[LIBRO] " + super.toString();
    }

    
}
