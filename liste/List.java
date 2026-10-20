package liste;

import java.util.Iterator;

import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML.Tag;


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
            return cursore.getDato() != null;
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
        Nodo temp = this.testa;
        for (int i = 0; i < this.length(); i++) {
            System.out.print(temp.getDato() + " ");
            temp = temp.getSucc();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        List<Integer> ints = new List<>();
        ints.insert(43, 0);
        System.out.println(ints.get(0)); 
    }
}