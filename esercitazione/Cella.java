package esercitazione;
import java.util.NoSuchElementException;

public class Cella<T> implements Contenitore<T> {
    private T elemento;

    @Override
    public T estrai() {
        if (isVuoto()) throw new NoSuchElementException();
        T temp = elemento;
        this.elemento = null;
        return temp;
    }

    @Override
    public void inserisci(T elemento) {
        if (!isVuoto()) throw new IllegalStateException();
        this.elemento = elemento;  
    }

    @Override
    public boolean isVuoto() {
        return elemento == null;
    }
    
}