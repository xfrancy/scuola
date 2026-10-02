package esercitazione;

public class Main {
    public static void main(String[] args) {
        Cella<Dispositivo> cella = new Cella<>();
        Computer c = new Computer(100); 
        cella.inserisci(c);

        Cella<Dispositivo> cella2 = new Cella<>();
        Server s = new Server(100);
        cella2.inserisci(s);

        Cella<Server> cella3 = new Cella<>();

        CalcolatoreDispositivi calc = new CalcolatoreDispositivi();
        System.out.println(calc.sommaConsumi(cella, cella2));

        calc.trasferisci(cella3, cella2);
        FiltroConsumoEccessivo<Dispositivo> f = new FiltroConsumoEccessivo<>(1000);
        StampaComputer<Dispositivo> st = new StampaComputer<>();
        GestorePipeLine g = new GestorePipeLine();

        Computer cp = new Computer(13);
        g.applicaSeAccettato(cp, f, st);
    }

}
