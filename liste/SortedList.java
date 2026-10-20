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
            sort();
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
                Nodo temp = testa.getSucc();
                Nodo prec = testa;
                if (prec.getDato().compareTo(temp.getDato()) > 0){
                    swap(i, i +1);
                    swapped = true;
                }
                prec = temp;
                temp = temp.getSucc();
            }
            count++;
        } while (swapped);
        
        this.isSorted = true;
    }

    private void swap(int pos1 , int pos2){
        Nodo temp1 = null, temp2 = null, temp3 = testa;
        for (int i = 0; i < pos2; i++) {
            temp1 = temp2;
            temp2 = temp3;
            temp3 = temp3.getSucc();
        }
        if (temp1 == null){
            temp2.setSucc(temp3.getSucc());
            temp3.setSucc(temp2);
            testa = temp3;

        } else {
            temp1.setSucc(temp3);
            temp2.setSucc(temp3.getSucc());
            temp3.setSucc(temp2);
        }
    }


    public static void main(String[] args) {
        SortedList<Integer> r = new SortedList<>();
        r.insert(3, 0);
        r.insert(1, 1);
        r.insert(7, 2);
        r.insert(4, 3);
        r.sort();
        r.stampaLista();
    }
}