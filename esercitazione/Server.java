package esercitazione;

public class Server extends Computer{

    public Server(double consumo) {
        super(consumo);
    }
    
    @Override
    public void accendi() {
        System.out.println("Server avviato");
    }
}
