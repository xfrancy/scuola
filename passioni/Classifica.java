package passioni;

public class Classifica<T extends  Classificabile> {

    private Classificabile[] top = new Classificabile[5];

    public void stampaClassifica(){
        for (int i = 0; i < top.length; i++) {
            System.out.println(top[i].nomeClassifica());
        }
    }

    public boolean inserisciNuovo(T elemento, int posizione){
        if (posizione < 0 || posizione >= top.length) return false;

        boolean rimosso = top[top.length-1] != null;
        
        for (int i = top.length -1; i > posizione ; i--) {
            top[i] = top[i -1];
        }
        top[posizione] = elemento;
        return rimosso;
    }

    public void rimuoviElemento(int posizione){
        if (posizione < 0 || posizione >= top.length) return;
      
        for (int i = posizione; posizione < top.length -1 ; i++) {
            top[i] = top[i +1];
        }
        top[top.length-1] = null;
    }

    public void primoElemento(){
        if (top[0] != null) System.out.println(top[0]);
    }

    public int cercaElemento(T elemento, int index){
        if (index >= top.length) return  -1;

        if (top[index] != null && top[index].equals(elemento)) return index +1;

        return cercaElemento(elemento, index +1);
    }
}