package esercitazione;

public class CalcolatoreDispositivi {
    public double sommaConsumi(Cella<? extends Dispositivo> c1,Cella<? extends Dispositivo> c2){
        return c1.estrai().consumo + c2.estrai().consumo;
    }
    public <E extends Dispositivo> void trasferisci(Cella<E> c1,Cella<? super E> c2){
        c2.inserisci(c1.estrai());
    }
}