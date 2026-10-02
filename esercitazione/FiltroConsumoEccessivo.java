package esercitazione;

public class FiltroConsumoEccessivo<T extends Dispositivo> implements Filtro<T>{
    private int soglia;
    

    public FiltroConsumoEccessivo(int soglia) {
        this.soglia = soglia;
    }


    @Override
    public boolean accetta(T elemento) {
        if (elemento.consumo > soglia) return false;
        return true;
    }
    
}
