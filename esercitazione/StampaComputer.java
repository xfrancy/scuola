package esercitazione;

public class StampaComputer<T extends Dispositivo> implements Elaboratore<T>{

    @Override
    public void elabora(T elemento) {
        elemento.accendi();
    }
    
}
