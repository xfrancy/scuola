package liste.esercizi.treni;

public class VagonePasseggeri extends Vagone{
    private final int capacitaPersone;

    public VagonePasseggeri(String nome, int capacitaPersone) {
        super(nome);
        this.capacitaPersone = capacitaPersone;
    }

    public int getCapacitaPersone() {
        return capacitaPersone;
    }

    
}
