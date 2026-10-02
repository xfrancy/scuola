package esercitazione;

public class GestorePipeLine{

    public static <T> void applicaSeAccettato(T elemento, Filtro<? super T> filtro, Elaboratore<? super T> elaboratore){
        if (filtro.accetta(elemento)) elaboratore.elabora(elemento);
    }
}
