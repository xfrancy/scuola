package liste;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private class Iteratore implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public T next() {
            return dequeue();
        }
        
    }

    @Override
    public Iterator<T> iterator() {
        return new Iteratore();
    }

    private DoubleLinkedList<T> queue;

    public Queue() {
        this.queue = new DoubleLinkedList<>();
    }
 
    public void enqueue(T e){
        queue.add(e);
    }

    public T dequeue(){
        if (this.isEmpty()) return null;
        T temp = queue.get(0);
        queue.remove(0);
        return temp;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> c = new Queue<>();
        c.enqueue(4);
        c.enqueue(7);
        c.enqueue(12);
        c.forEach(t -> System.out.println(t));
        System.out.println(c.dequeue());
    }
}
