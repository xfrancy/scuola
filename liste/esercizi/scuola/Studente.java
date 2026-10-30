package liste.esercizi.scuola;

public class Studente {
    private String nome;
    private Tesi tesi;

    public Studente(String nome, Tesi tesi) {
        this.nome = nome;
        this.tesi = tesi;
    }

    public String getNome() {
        return nome;
    }

    public Tesi getTesi() {
        return tesi;
    }
    
}
