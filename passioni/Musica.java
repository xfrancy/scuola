package passioni;

public class Musica extends Passione implements Classificabile{
    private final String artista;
    private final int tracce;

    public Musica(String titolo, String artista, int tracce) {
        super(titolo);
        this.artista = artista;
        this.tracce = tracce;
    }

    @Override
    public String nomeClassifica() {
        return artista + " - " + titolo;
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "]" + super.toString();
    }
}