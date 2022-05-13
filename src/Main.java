import java.io.File;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) {
        Dato[][] marcoDeDatos = new Dato[tamañoArchivo()][8];
        for(int i = 1; i <= tamañoArchivo() ; i++) {
            Dato d1 = new Dato(i);
            System.out.println(d1);
        }
    }

    public static int tamañoArchivo() {
        int tamaño=0;
        try {
            File file = new File("Medellin.csv");
            Scanner scan = new Scanner(file);
            String line;
            while(scan.hasNextLine()) {
                line = scan.nextLine();
                tamaño++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tamaño;
    }
}
