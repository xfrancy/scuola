package esercitazione;

import liste.Queue;
import liste.Stack;

public class NotazionePolaccaInversa {
    private final String equazione;
    private Queue<Character> codaOutput;
    private Stack<Character> stackOperatori;

    public NotazionePolaccaInversa(String equazione) {
        this.equazione = equazione;
        codaOutput = new Queue<>();
        stackOperatori = new Stack<>();
    }


    public void converti(){
        Character c;
        for (int i = 0; i < equazione.length(); i++) {
            c = equazione.charAt(i);
            if (c == ')') {
                char t = stackOperatori.pop();
                do {
                    codaOutput.enqueue(t);
                    t = stackOperatori.pop();
                } while (t != '(');
            }
            else if (Character.isDigit(c)){
                do {
                    codaOutput.enqueue(c);
                    i++;
                } while (i < equazione.length() && Character.isDigit(equazione.charAt(i)));
                i--;
            }
            else if (c != ' ') {
                if (stackOperatori.peek() != null && stackOperatori.peek() != '(' && (c == '+' || c == '-')){
                    codaOutput.enqueue(stackOperatori.pop());
                }
                if (stackOperatori.peek() != null && ((c == '*' || c == '/') && (stackOperatori.peek() == '*' || stackOperatori.peek() == '/'))){
                    codaOutput.enqueue(stackOperatori.pop());
                }
                stackOperatori.push(c);
            }
        }
        while (stackOperatori.peek() != null) {
            codaOutput.enqueue(stackOperatori.pop());
        }
        while (!codaOutput.isEmpty()) {
            System.out.print(codaOutput.dequeue() + " ");
        }
    }


    public static void main(String[] args) {
        NotazionePolaccaInversa c = new NotazionePolaccaInversa("(2 + 4) / (1 + 1 + 1) * 3 + 4");
        c.converti();
    }
}
