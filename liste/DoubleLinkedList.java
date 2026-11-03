package liste;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T>{
    private class Nodo{
        private final T dato;
        private Nodo succ;
        private Nodo prec;

        public Nodo(T dato , Nodo prec) {
            this.dato = dato;
            this.prec = prec;
            this.succ = null;
        }


        public Nodo(T dato, Nodo prec, Nodo succ) {
            this.dato = dato;
            this.prec = prec;
            this.succ = succ;
        }


        public T getDato() {
            return dato;
        }

        public Nodo getSucc() {
            return succ;
        }


        public void setSucc(Nodo succ) {
            this.succ = succ;
        }


        public Nodo getPrec() {
            return prec;
        }


        public void setPrec(Nodo prec) {
            this.prec = prec;
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

    @Override
    public java.util.Iterator<T> iterator() {
        return new Iteratore();
    }


    protected int l = 0;
    protected Nodo testa;
    protected Nodo coda;


    public DoubleLinkedList() {
        this.testa = null;
        this.coda = null;
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
        if (i < 0 || i >= this.l){
            throw new IndexOutOfBoundsException();
        }
        Nodo temp = null;
        if (i < this.l / 2 ){
            temp = this.testa;
            for (int j = 0; j < i; j++) {
                temp = temp.getSucc();
            }
        }
        else {
            temp = coda;
            for (int j = 0; j <  this.l - i -1; j++) {
                temp = temp.getPrec();
            }
        }
        return temp.getDato();
    }

    public void insert(T dato , int i){
        if (i < 0 || i > l){
            throw new IndexOutOfBoundsException();
        }
        if (l == 0){
            Nodo nuovo = new Nodo(dato, null);
            this.testa = nuovo;
            this.coda = nuovo;
        }
        else if (i == 0){
            Nodo nuovo = new Nodo(dato, null ,testa);
            testa.setPrec(nuovo);
            this.testa = nuovo;
        }
        else if (i == l){
            Nodo nuovo = new Nodo(dato, coda);
            this.coda.setSucc(nuovo);
            this.coda = nuovo;
        }
        else if (i < l/2){
            Nodo temp = testa;
            Nodo temp2 = testa.getSucc();

            for (int j = 0; j < i -1; j++) {
                temp = temp.getSucc();
                temp2 = temp2.getSucc();
            }

            Nodo nuovo = new Nodo(dato, temp, temp2);
            temp.setSucc(nuovo);
            temp2.setPrec(nuovo);
        }
        else {
            Nodo temp = coda.getPrec();
            Nodo temp2 = coda;

            for (int j = 0; j < i -1; j++) {
                temp = temp.getPrec();
                temp2 = temp2.getPrec();
            }

            Nodo nuovo = new Nodo(dato, temp, temp2);
            temp.setSucc(nuovo);
            temp2.setPrec(nuovo);
        }
        l++;
    }

    public void remove(int i){
        if (i < 0 || i >= length()){
            throw new IndexOutOfBoundsException();
        }
        if (i == 0){
            testa = testa.getSucc();
        } 
        else if (i == l -1){
            coda.getPrec().setSucc(null);
        }
        else if (i < l/2){
            Nodo temp = testa;
            for (int j = 0; j < i -1; j++) {
                temp = temp.getSucc();
            }
            temp.setSucc(temp.getSucc().getSucc());
            temp.getSucc().setPrec(temp);
        }
        else {
            Nodo temp = coda;
            for (int j = 0; j < l - i -2; j++) {
                temp = temp.getPrec();
            }
            temp.setPrec(temp.getPrec().getPrec());
            temp.getPrec().setSucc(temp);
        }
        l--;
    }

    public boolean contains(T dato){
        Nodo temp = testa;
        Nodo temp2 = coda;

        for (int i = 0; i < ((l % 2 == 1) ? (l / 2) +1 : (l / 2) ); i++) {
            if (temp.getDato().equals(dato) || (temp2.getDato().equals(dato))) return true;
            temp = temp.getSucc();
            temp2 = temp2.prec;
        }
        
        return false;
    }

    public void add(T dato){
        insert(dato, this.length());
    }

    public void stampaLista(){
        this.forEach(t -> IO.print(t + " "));
        IO.println("");
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(5, 0);
        list.insert(7, 1);
        list.insert(10, 2);
        list.insert(0, 3);
        list.insert(9, 2);
        list.insert(90, 0);
        list.insert(50, 2);
        list.stampaLista();
        list.remove(list.length()-1);
        list.remove(4);
        list.remove(1);
        list.stampaLista();
    }
}