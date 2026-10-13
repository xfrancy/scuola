public class Lista<T> {
    private class Nodo {
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

    private Nodo testa;

    public Lista() {
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

    public static void main(String[] args) {
        Lista<Integer> ints = new Lista<>();
        ints.add(5);
        ints.add(9);
        ints.add(2);
        ints.add(19);
        ints.remove(0);
        System.out.println(ints.get(0)); 

    }
}