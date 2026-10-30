package liste;

public class SortedList<T  extends Comparable<T>> extends List<T> {
    private boolean isSorted;

    public SortedList() {
        this.isSorted = true;
    }

    @Override
    public void insert(T element, int i) {
        this.isSorted = false;
        super.insert(element, i);
    }

    @Override
    public void add(T element) {
        this.isSorted = false;
        super.add(element);
    }

    public void insertSorted(T dato){
        if (!this.isSorted) { 
            this.sort();
        }
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

/*    public void sort(){
        SortedList<T> nuovaLista = new SortedList<>();
        int lenght = this.length();
        for (int i = 0; i < lenght; i++) {
            T dato = this.get(0);
            nuovaLista.insertSorted(dato);
            this.remove(0);
        }
        this.testa = nuovaLista.testa;
    } */


    public void sort(){
        if (isSorted) return;
        int length = length();
        boolean swapped;
        int count = 0;
        do {
            swapped = false;
            for (int i = 0; i < length - count -1; i++) {
                if (get(i).compareTo(get(i +1)) > 0){
                    swapConsecutive(i, i +1);
                    swapped = true;
                }
            }
            count++;
        } while (swapped);
        this.isSorted = true;
    }



    public static void main(String[] args) {
        SortedList<Integer> r = new SortedList<>();
        r.add(3);
        r.add(1);
        r.add(7);
        r.add(4);
        r.insertSorted(9);
        r.stampaLista();
    }
}