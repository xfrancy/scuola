package esercitazione;

public class Dispositivo {
    double consumo;

    public Dispositivo(double consumo) {
        this.consumo = consumo;
    }
    
    public void accendi(){
        System.out.println("Dispositivo acceso");
    }
}
