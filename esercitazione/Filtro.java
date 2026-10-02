package esercitazione;

public interface Filtro<T> {
    public boolean accetta(T elemento);
}
