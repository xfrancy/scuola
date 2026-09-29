package centroAssistenza;

public class Gestore {
    private Coda<? extends Processabile>[] code;
    private int numeroCode;

    public Gestore(int capacita) {
        code = new Coda[capacita];
    }

    public void aggiungiCoda(Coda<? extends Processabile> coda){
        if (coda == null) return ;

        for (int i = 0; i < numeroCode; i++) {
            if (code[i] == coda) return;
        }

        if (numeroCode == code.length) return;
        code[numeroCode++] = coda;
    }

    public <E extends Processabile> void inserisciRichiesta(int numeroCoda, E elemento, int posizione){
        
    }
}