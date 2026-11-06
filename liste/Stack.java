package liste;

import java.util.Iterator;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T>{
    private class Iteratore implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return peek() != null;
        }

        @Override
        public T next() {
            return pop();
        }
        
    }

    @Override
    public Iterator<T> iterator() {
        return new Iteratore();
    }

    private DoubleLinkedList<T> stack;

    public Stack() {
        this.stack = new DoubleLinkedList<>();
    }
 
    public void push(T e){
        stack.insert(e, 0);
    }

    public T pop(){
        T temp = peek();
        if (peek() != null) stack.remove(0);
        return temp;
    }

    public T peek(){
        return (stack.l == 0) ? null : stack.get(0);
    }

    public void doFunction(Consumer<T> func){
        this.forEach(func);
    }

    public static void main(String[] args) {
        Stack<Integer> c = new Stack<>();
        c.push(4);
        c.push(7);
        c.push(12);
        c.doFunction(d -> System.out.println(d));
    }

}
