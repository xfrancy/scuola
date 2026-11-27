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
    public Iterator<T> iterator() {
        return new Iteratore();
    }


    protected int l;
    protected Nodo testa;
    protected Nodo coda;


    public DoubleLinkedList() {
        this.testa = null;
        this.coda = null;
        this.l = 0;
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

    public void swap(int pos1 , int pos2){
          if (pos1 < 0 || pos1 >= l) {
            throw new IndexOutOfBoundsException("Posizione " + pos1 + " fuori dai limiti");
        }

        if (pos2 < 0 || pos2 >= l) {
            throw new IndexOutOfBoundsException("Posizione " + pos2 + " fuori dai limiti");
        }

        if (pos1 > pos2) {
            throw new IllegalArgumentException("La prima posizione deve essere minore della seconda");
        }

        if (pos1 == pos2) return;

        Nodo scanTesta, scanCoda;

        if (pos1 < getPuntoMedio()) {
            scanTesta = testa;


            for (int i = 0; i < pos1; i++) {
                scanTesta = scanTesta.getSucc();
            }
        }

        else {
            scanTesta = coda;

            for (int i = l - 1; pos1 < i; i--) {
                scanTesta = scanTesta.getPrec();
            }
        }
        
        if (pos2 < getPuntoMedio()) {
            scanCoda = testa;

            for (int i = 0; i < pos2; i++) {
                scanCoda = scanCoda.getSucc();
            }
        }

        else {
            scanCoda = coda;

            for (int i = l - 1; pos2 < i; i--) {
                scanCoda = scanCoda.getPrec();
            }
        }

        if (scanTesta.getSucc() == scanCoda){
            scanTesta.setSucc(scanCoda.getSucc());
            scanCoda.setPrec(scanTesta.getPrec());
            scanCoda.setSucc(scanTesta);
            scanTesta.setPrec(scanCoda);

            if (scanTesta != testa)  scanCoda.getPrec().setSucc(scanCoda);
            if (scanCoda != coda)  scanTesta.getSucc().setPrec(scanTesta);

            if (scanTesta == testa) testa = scanCoda;
            if (scanCoda == coda) coda = scanTesta;
            
            
        }
        else if (scanTesta == testa && scanCoda != coda) {
            Nodo temp = scanTesta.getSucc();
            scanTesta.getSucc().setPrec(scanCoda);
            scanCoda.getPrec().setSucc(scanTesta);
            scanCoda.getSucc().setPrec(scanTesta);

            scanTesta.setPrec(scanCoda.getPrec());
            scanCoda.setPrec(null);

            scanTesta.setSucc(scanCoda.getSucc());
            scanCoda.setSucc(temp);
            testa = scanCoda;
        }

        else if (scanCoda == coda && scanTesta != testa) {
            Nodo temp = scanCoda.getPrec();
            scanCoda.getPrec().setSucc(scanTesta);
            scanTesta.getPrec().setSucc(scanCoda);
            scanTesta.getSucc().setPrec(scanCoda);

            scanCoda.setSucc(scanTesta.getSucc());
            scanTesta.setSucc(null);

            scanCoda.setPrec(scanTesta.getPrec());
            scanTesta.setPrec(temp);

            coda = scanTesta;
        }

        else if (scanTesta == testa && scanCoda == coda){
            scanCoda.setSucc(scanTesta.getSucc());
            scanTesta.setPrec(scanCoda.getPrec());

            scanTesta.setSucc(null);
            scanCoda.setPrec(null);

            scanTesta.getPrec().setSucc(scanTesta);
            scanCoda.getSucc().setPrec(scanCoda);

            testa = scanCoda;
            coda = scanTesta;
        }

        else {
            Nodo temp = scanTesta;
            scanTesta.getPrec().setSucc(scanCoda);
            scanTesta.getSucc().setPrec(scanCoda);

            scanCoda.getPrec().setSucc(scanTesta);
            scanCoda.getSucc().setPrec(scanTesta);

            scanTesta.setPrec(scanCoda.getPrec());
            scanTesta.setSucc(scanCoda.getSucc());
            
            scanCoda.setPrec(temp.getPrec());
            scanCoda.setSucc(temp.getSucc());
        }
    }    
    
    private int getPuntoMedio(){
        return (l + 1) / 2;
    }

    public boolean contains(T dato){
        Nodo temp = testa;
        Nodo temp2 = coda;

        for (int i = 0; i < getPuntoMedio(); i++) {
            if (temp.getDato().equals(dato) || (temp2.getDato().equals(dato))) return true;
            temp = temp.getSucc();
            temp2 = temp2.prec;
        }
        
        return false;
    }

    public boolean isEmpty(){
        return l == 0;
    }

    public void add(T dato){
        insert(dato, this.length());
    }

    public void stampaLista(){
        this.forEach(t -> IO.print(t + " "));
        IO.println("");
    }

    public void stampaListaAlContrario(){
        Nodo temp = coda;
        for (int i = 0; i < l; i++) {
            System.out.print(temp.getDato() + " ");
            temp = temp.getPrec();
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.insert(5, 0);
        list.insert(7, 1);
        list.insert(10, 2);
        list.insert(0, 3);
        list.insert(9, 2);
        list.stampaListaAlContrario();
        System.out.println();
        list.swap(1, 3);
        list.stampaListaAlContrario();

    }
}