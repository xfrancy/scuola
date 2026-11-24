package liste.esercizi.conversioni;
import liste.Stack;

public class ControlloParentesi {
    private Stack<Character> aperte;
    
    public ControlloParentesi() {
        this.aperte = new Stack<>();
    }

    private boolean controllo(String exp){
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '{'){
                if (aperte.peek() != null) return false; 
                aperte.push(c);
            }
            else if (c == '['){
                if (aperte.peek() != '{') return false;
                aperte.push(c);
            }
            else if (c == '('){
                if (aperte.peek() == '(') return false;
                aperte.push(c);
            }
            else if (c == ')' ){
                if (aperte.pop() != '(') return false;
            }
            else if (c == ']' ) {
                if (aperte.pop() != '[') return false;
            }
            else if (c == '}' ) {
                if (aperte.pop() != '{') return false;
            }
        }
        if (aperte.peek() != null) return false;
        return true;
    }
    public static void main(String[] args) {
        ControlloParentesi c = new ControlloParentesi();
        System.out.println(c.controllo("{[()()][()]}"));
    }
}