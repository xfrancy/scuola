package liste.esercizi.conversioni;

import liste.Stack;

public class Esadecimale {
    private static final char[] HEX = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
    private Stack<Integer> s;

    public Esadecimale(){
        s = new Stack<>();
    }
    
    private int valore(char c){
        for (int i = 0; i < HEX.length; i++) {
            if (Character.toUpperCase(c) == HEX[i]){
                return i;
            }
        }
        return  -1;
    }


    public int converti(String hex){        
        int decimale = 0;

        for (int i = 0; i < hex.length(); i++) {
            s.push(valore(hex.charAt(i)));
        }

        for (int i = 0; i < hex.length(); i++) {
            decimale += s.pop() * Math.pow(16, i);
        }

        return decimale;
    }

    public static void main(String[] args) {
        Esadecimale es = new Esadecimale();
        System.out.println(es.converti("F0f"));
    }
}
