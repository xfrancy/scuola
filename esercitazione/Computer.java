package esercitazione;

public class Computer extends Dispositivo {

    public Computer(double consumo) {
        super(consumo);
    }
    
    @Override
    public void accendi() {
        System.out.println("Computer avviato");
    }
}
