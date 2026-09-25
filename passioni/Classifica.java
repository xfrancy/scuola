package passioni;

public class Classifica<T extends  Classificabile> {
    private Classificabile[] top = new Classificabile[5];

    public void stampaClassifica(Classifica<T> c){
        for (int i = 0; i < 5; i++) {
            System.out.println(c.top[i].nomeClassifica());
        }
    }

    public boolean inserisciNuovo(Classifica<T> c, T elemento, int posizione){
        if (posizione < 0 || posizione > 4) return false;
        if (c.top[posizione] == null) {
            c.top[posizione] = elemento;
            return false;
        }
        
        for (int i = 4; posizione < i ; i--) {
            c.top[i] = c.top[i -1];
        }
        c.top[posizione] = elemento;
        return true;
    }

    public void rimuoviElemento(Classifica<T> c, int posizione){
        if (posizione < 0 || posizione > 4) return;
      
        for (int i = posizione; posizione < 4 ; i++) {
            c.top[i] = c.top[i +1];
        }
        c.top[4] = null;
    }

    public void primoElemento(Classifica<T> c){
        if (c.top[0] != null) System.out.println(c.top[0]);
    }

    public int cercaElemento(Classifica<T> c, T elemento, int index){
        int posizione;
        if (index > 4) return  -1;
        if (c.top[index].titolo.equals(elemento.titolo)) posizione = index;
        else posizione = cercaElemento(c, elemento, index +1);
        return posizione +1;
    }
}