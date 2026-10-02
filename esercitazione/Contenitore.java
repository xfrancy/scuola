package esercitazione;

public interface Contenitore<T> {
    public void inserisci(T elemento);
    public T estrai();
    public boolean isVuoto();
}
