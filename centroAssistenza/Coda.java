package centroAssistenza;

public class Coda<T extends Processabile> {
    @SuppressWarnings("unchecked")
    T[] coda = (T[]) new Object[5];

    public boolean inserisciRichiesta(T richiesta, int posizione){
        if (posizione < 0 || posizione >= coda.length) return false;

        boolean rimosso = coda[coda.length-1] != null;
        
        for (int i = coda.length -1; i > posizione ; i--) {
            coda[i] = coda[i -1];
        }
        coda[posizione] = richiesta;
        return rimosso;
    }

    public void evadiRichiesta(int posizione){
        if (posizione < 0 || posizione >= coda.length) return;
      
        for (int i = posizione; posizione < coda.length -1 ; i++) {
            coda[i] = coda[i +1];
        }
        coda[coda.length-1] = null;
    }

    public void prossimaInLavorazione(){
        if (coda[1] != null) System.out.println(coda[1].toString());
    }

    public int cercaRichiesta(T richiesta, int index){
        if (index >= coda.length) return  -1;

        if (coda[index] != null && coda[index].equals(richiesta)) return index +1;
       
        return cercaRichiesta(richiesta, index +1);
    }
}