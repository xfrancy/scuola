package passioni;

public class Film extends Passione implements Classificabile {
    private final String regitsa;
    private final int anno;
    private final String attore;
    private final String attrice;

    public Film(String titolo, String regitsa, int anno, String attore, String attrice) {
        super(titolo);
        this.regitsa = regitsa;
        this.anno = anno;
        this.attore = attore;
        this.attrice = attrice;
    }

    

    @Override
    public String nomeClassifica() {
        return titolo + " di " + regitsa + " (starring " + attore + " , " + attrice + ")";
    }



    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "]" + super.toString();
    }

    
}