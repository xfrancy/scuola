package liste.ospedale;

public class Paziente implements Comparable<Paziente>{
    private String nome;    
    private int eta;
    private Codice codice;

    public Paziente(String nome, int eta, Codice codice) {
        this.nome = nome;
        this.eta = eta;
        this.codice = codice;
    }

    @Override
    public int compareTo(Paziente arg0) {
        return (this.codice.getNumero() == arg0.codice.getNumero()) ? 0 : (this.codice.getNumero() > arg0.codice.getNumero()) ? -1 : +1;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    public Codice getCodice() {
        return codice;
    }

    @Override
    public String toString() {
        return nome + " [eta: " + eta + ", codice: " + codice + "]";
    }
    

}