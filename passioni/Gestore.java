package passioni;

public class Gestore {
    private Classifica<?>[] classifiche;
    private int numeroClassifiche;

    public Gestore(int capacita) {
        classifiche = new Classifica<?>[capacita];
    }

    public void aggiungiClassifica(Classifica<? extends Passione> classifica){
        if (classifica == null) return ;

        for (int i = 0; i < numeroClassifiche; i++) {
            if (classifiche[i] == classifica) return;
        }

        if (numeroClassifiche == classifiche.length) return;

        classifiche[numeroClassifiche++] = classifica;
    }

    public <E extends Passione> boolean inserisciNuovo(Classifica<? super E> classifica, E elemento, int posizione){
        verificaClassifica(classifica);
        return classifica.inserisciNuovo(elemento, posizione);
    }

    public <E extends Passione> int cercaElemento(Classifica<? super E> classifica, E elemento){
        verificaClassifica(classifica);
        return classifica.cercaElemento(elemento, 0);
    }

    public <E extends Passione> void rimuoviElemento(Classifica<? super E> classifica, int indice){
        verificaClassifica(classifica);
        classifica.rimuoviElemento(indice);
    }

    public void stampaClassifiche(){
        for (int i = 0; i < classifiche.length; i++) {
            classifiche[i].stampaClassifica();
        }
    }

    public void verificaClassifica(Classifica<?> classifica){
        for (int i = 0; i < numeroClassifiche; i++) {
            if (classifiche[i] == classifica) return;
        }
    }
}
