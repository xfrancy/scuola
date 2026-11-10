package liste.esercizi.treni;

public class VagoneMerci extends Vagone{
    private final int capacitaKG;

    public VagoneMerci(String nome, int capacitaKG) {
        super(nome);
        this.capacitaKG = capacitaKG;
    }

    public int getCapacitaKG() {
        return capacitaKG;
    }
    
}