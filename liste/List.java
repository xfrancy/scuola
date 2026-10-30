package liste;

import java.util.Iterator;


public class List<T> implements Iterable<T> {
    protected class Nodo {
        private final T dato;
        private Nodo succ;

        public Nodo(T dato) {
            this.dato = dato;
            this.succ = null;
        }

        public Nodo(T dato, Nodo succ) {
            this.dato = dato;
            this.succ = succ;
        }

        public T getDato() {
            return this.dato;
        }

        public Nodo getSucc() {
            return this.succ;
        }

        public void setSucc(Nodo succ) {
            this.succ = succ;
        }
    }
      
    protected class Iteratore implements Iterator<T>{
        private Nodo cursore;
   
        public Iteratore() {
            cursore = testa;
        }

        @Override
        public boolean hasNext() {
            return cursore != null;
        }

        @Override
        public T next() {
            T temp = cursore.getDato();
            cursore = cursore.getSucc();
            return temp;
        }
        
    }

    protected Nodo testa;

    public List() {
        this.testa = null;
    }

    public int length() {
        int l = 0;
        Nodo scan = this.testa;
        while(scan != null) {
            l++;
            scan = scan.getSucc();
        }
        return l;
    }

    public T get(int i){
        if (i < 0 || i >= this.length()){
            throw new IndexOutOfBoundsException();
        }
        Nodo temp = this.testa;
        for (int j = 0; j < i; j++) {
            temp = temp.getSucc();
        }
        return temp.getDato();
    }

    public void insert(T dato , int i){
        if (i < 0 || i > length()){
            throw new IndexOutOfBoundsException();
        }
        if (i == 0){
            Nodo nuovo = new Nodo(dato, testa);
            this.testa = nuovo;
        }
        else {
            Nodo temp = testa;
            for (int j = 0; j < i -1; j++) {
                temp = temp.getSucc();
            }
            Nodo nuovo = new Nodo(dato, temp.getSucc());
            temp.setSucc(nuovo);
        }
    }

    

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iteratore();
    }

    public void add(T dato){
        insert(dato, this.length());
    }

    public void remove(int i){
        if (i < 0 || i >= length()){
            throw new IndexOutOfBoundsException();
        }
        if (i == 0){
            testa = testa.getSucc();
        }
        else {
            Nodo temp = testa;
            for (int j = 0; j < i -1; j++) {
                temp = temp.getSucc();
            }
            temp.setSucc(temp.getSucc().getSucc());
        }

    }

    public void stampaLista(){
        this.forEach(t -> IO.print(t + " "));
        IO.println("");
    }

    public void swapConsecutive(int pos1 , int pos2){
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

        public void swap(int pos1, int pos2) {
        if (pos1 > pos2) {
            throw new IllegalArgumentException("La prima posizione deve essere minore della seconda");
        }

        if (pos1 == pos2) return;

        int length = length();

        if (pos1 < 0 || pos1 >= length || pos2 < 0 || pos2 >= length) {
            throw new IndexOutOfBoundsException("Posizione fuori dai limiti");
        }

        Nodo temp1 = null, temp2 = testa;
        Nodo temp3 = null, temp4 = testa;

        for (int i = 0; i < pos1; i++) {
            temp1 = temp2;
            temp2 = temp2.getSucc();
        }

        for (int i = 0; i < pos2; i++) {
            temp3 = temp4;
            temp4 = temp4.getSucc();
        }

        if (temp1 == null) {
            testa = temp4;
        } else {
            temp1.setSucc(temp4);
        }

        if (temp3 == temp2) {
            temp2.setSucc(temp4.getSucc());
            temp4.setSucc(temp2);
        } else {
            Nodo temp5 = temp2.getSucc();

            temp2.setSucc(temp4.getSucc());
            temp4.setSucc(temp5);
            temp3.setSucc(temp2);
        }
    }


    public static void main(String[] args) {
        List<Integer> ints = new List<>();
        ints.insert(43, 0);
        System.out.println(ints.get(0));
    }
}