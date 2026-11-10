package liste.esercizi.treni;

import liste.DoubleLinkedList;

public class Convoglio {
    DoubleLinkedList<Vagone> convoglio;

    public Convoglio(Locomotiva testa , Locomotiva coda) {
        convoglio = new DoubleLinkedList<>();
        convoglio.add(testa);
        convoglio.add(coda);
    }

    public void aggiungiVagone(Vagone v){
        if (v instanceof Locomotiva) {
            throw new IllegalArgumentException("non puoi inserire una locomotiva");
        } 
        convoglio.insert(v, convoglio.length()-1);
    }

    public void rimuoviVagone(int idx){
        if (idx <= 0 || idx >= (convoglio.length() -1)) {
            throw new IllegalArgumentException("indice sbagliato");
        }
        convoglio.remove(idx);
    }

    public Vagone getVagone(int idx){
        return convoglio.get(idx);
    }

    public void stampaConvoglio(){
        convoglio.stampaLista();
    }

}
