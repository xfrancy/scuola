package liste.esercizi.ospedale;

public enum Codice{
    BIANCO(0) , VERDE(1) , AZZURRO(2) , GIALLO(3) , ROSSO(4);
    private final int numero;

    private Codice(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }
}