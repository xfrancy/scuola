package liste;

public class List<T> {
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
        if (this instanceof SortedList) {
            throw new MetodoNonUtilizzabileException("Metodo non esiste per questa lista");
        }
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