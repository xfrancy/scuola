package liste.esercizi.ordinaNomi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import liste.SortedList;

public class OrdinaNomi {
    File file;

    public OrdinaNomi(String filePath) {
        this.file = new File(filePath);
    }

    public SortedList<String> leggiFile() throws FileNotFoundException {
        SortedList<String> dati = new SortedList<>();

        Scanner s = new Scanner(file);
        while(s.hasNext()) {
            dati.insertSorted(s.nextLine());
        }
        s.close();
        
        return dati;
    }

    public void creaFile() throws IOException{
        SortedList<String> dati = leggiFile();
        File creato = new File("liste/esercizi/ordinaNomi/nomiOrdinati.txt");
        PrintWriter writer = new PrintWriter(new FileWriter(creato.getPath()));
        dati.forEach(s -> writer.println(s));
        writer.close();
    }

    public static void main(String[] args) {
        String path = "liste/esercizi/ordinaNomi/file.txt";
        OrdinaNomi o = new OrdinaNomi(path);
        try {
            o.creaFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
