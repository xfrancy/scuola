package liste.esercizi.ospedale;

import liste.SortedList;

public class Main {
    public static void main(String[] args) {
        SortedList<Paziente> pazienti = new SortedList<>();
        Paziente p1 = new Paziente("Marco", 54, Codice.AZZURRO);
        Paziente p2 = new Paziente("Luca", 24, Codice.BIANCO);
        Paziente p3 = new Paziente("Simone", 4, Codice.ROSSO);
        Paziente p4 = new Paziente("Patrizio", 154, Codice.GIALLO);

        pazienti.insertSorted(p1);
        pazienti.add(p2);
        pazienti.insert(p3, 0);
        pazienti.insertSorted(p4);

        pazienti.forEach(p -> IO.println(p));
    }
}
