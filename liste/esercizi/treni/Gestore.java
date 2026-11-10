package liste.esercizi.treni;

import liste.DoubleLinkedList;

public class Gestore {
    private DoubleLinkedList<Vagone> parcheggio;
    private Convoglio[] convogli;

    public Gestore() {
        convogli = new Convoglio[4];
        parcheggio = new DoubleLinkedList<>();
    }

    public void parcheggia(int nConvoglio, int idx){
        
    }

    public void creaConvoglio(Locomotiva testa,Locomotiva coda, int nConvoglio){
        if (nConvoglio < 0 || nConvoglio > 4) {
            throw new IndexOutOfBoundsException();
        }
        if (convogli[nConvoglio] != null) {
            throw new IllegalArgumentException("esiste gia un convoglio in questo binario");
        }
        convogli[nConvoglio] = new Convoglio(testa, coda);
    }

    public void aggiungiVagone(Vagone v, int nConvoglio){
        if (convogli[nConvoglio] == null) {
            throw new IllegalArgumentException("non esiste un convoglio in questo binario");
        }
        
        convogli[nConvoglio].aggiungiVagone(v);
    }

    public void rimuoviVagone(Vagone v, int nConvoglio, int idx){
        if (convogli[nConvoglio] == null){
            throw new IllegalArgumentException("non esiste un convoglio in questo binario");
        } 

        convogli[nConvoglio].rimuoviVagone(idx);
    }
}