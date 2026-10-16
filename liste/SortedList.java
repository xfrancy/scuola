package liste;

public class SortedList<T  extends Comparable<T>> extends List<T> {
    @Override
    public void insert(T dato, int i) {
        if (this.testa == null){
            this.testa = new Nodo(dato);
            return;
        }
        Nodo temp = this.testa;
        Nodo prec = null;
        while (true){
           if (temp == null || dato.compareTo(temp.getDato()) < 0){
                break;
           }
           prec = temp;
           temp = temp.getSucc();
        }
        Nodo nuovo = new Nodo(dato,temp);
        if (temp != testa) prec.setSucc(nuovo);
        else this.testa = nuovo;
    }


    public static void main(String[] args) {
        SortedList<Integer> l = new SortedList<>();
        l.insert(1, 0);
        l.insert(2, 0);
        l.insert(4, 0);
        l.stampaLista();
        l.insert(3, 0);
        l.stampaLista();
        l.insert(-5, 0);
        l.stampaLista();
        l.add(-1);
        l.add(-7);
        l.add(0);
        l.add(3);
        l.add(-7);
        l.stampaLista();
    }
}