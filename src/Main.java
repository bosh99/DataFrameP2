import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[][] marcoDeDatos = new String[tamañoArchivo()][8];
        ArrayList<String[]> datos = new ArrayList<String[]>();
        lecturaDeDatos(datos);
        for(int i = 0; i < tamañoArchivo() ; i++) {
            Dato d1 = new Dato(datos.get(i));
            //System.out.println(d1);
            marcoDeDatos[i][0] = d1.getEstacion();
            marcoDeDatos[i][1] = d1.getNombre();
            marcoDeDatos[i][2] = d1.getPais();
            marcoDeDatos[i][3] = d1.getFecha();
            marcoDeDatos[i][4] = d1.getPresipitacion();
            marcoDeDatos[i][5] = d1.getTavg();
            marcoDeDatos[i][6] = d1.getTmax();
            marcoDeDatos[i][7] = d1.getTmin();
        }
        System.out.println("STATION " + " NAME "+" DATE "+" PRCP "+" TAVG "+" TMAX "+" TMIN");
        imprimirMatriz(marcoDeDatos);
    }

    public static void imprimirMatriz(String[][] marcoDeDatos) {
        for(int i = 0; i < marcoDeDatos.length; i++) {
            for(int j = 0; j < marcoDeDatos[i].length; j++) {
                System.out.print(marcoDeDatos[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int tamañoArchivo() {
        int tamaño=0;
        try {
            File file = new File("1719435.csv");
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

    public static void lecturaDeDatos(ArrayList<String[]> datos) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("1719435.csv"));
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] datosFile = line.split(",");
                datos.add(datosFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
