package liste.esercizi.scuola;

import liste.List;

public class Assegnazioni {
    private List<Tesi> tesi;
    private List<Studente> laureandi;


    public Assegnazioni(){
        tesi = new List<>();
        laureandi = new List<>();
    }

    public void aggiungiTesi(Tesi titoloTesi){
        tesi.add(titoloTesi);
    }

    public void aggiungiStudente(Studente nomeStudente, Tesi titoloTesi){
        if (!tesi.contains(titoloTesi)) tesi.add(titoloTesi);
        laureandi.add(nomeStudente);
    }

    public void laureato(Studente nomeStudente){
        int idx = laureandi.indexOf(nomeStudente);
        tesi.remove(laureandi.get(idx).getTesi());
        laureandi.remove(idx);
    }

    public void liberaTesi(Tesi titoloTesi){

    }

    public int disponibili(){
        return -1;
    }
}
