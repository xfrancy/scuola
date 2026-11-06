package liste;

public class Coda<T> {
    private List<T> coda;

    public Coda() {
        this.coda = new List<>();
    }
 
    public void enqueue(T e){
        coda.add(e);
    }

    public T dequeue(){
        if (this.isEmpty()) return null;
        T temp = coda.get(0);
        coda.remove(0);
        return temp;
    }

    public boolean isEmpty(){
        return coda.isEmpty();
    }
}
