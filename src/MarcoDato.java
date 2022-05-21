import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase Contiene las operaciones relacionadas con el marco de datos
 * @author Esteban Muriel Roldan
 * @author Miguel Vasquez Bojanini
 * @author Manuel Villegas Michel
 */

public class MarcoDato {

    /**
     * se encarga de leer el archivo en su totalidad y separar las palabras por comas y aniadirlas al ArrayList datos
     * @param datos es un ArrayList donde se van a almacenar los datos del achivo independientes
     */

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

    /**
     * Se encarga de analizar cuantas lineas tiene el archivo.csv
     * @return retorna un entero que representa las lineas del tamanio total del archivo
     */

    public static int tamanioArchivo() {
        int tamanio=0;
        try {
            File file = new File("1719435.csv");
            Scanner scan = new Scanner(file);
            String line;
            while(scan.hasNextLine()) {
                line = scan.nextLine();
                tamanio++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tamanio;
    }

    /**
     * Se encarga de imprimir la matriz con los datos del archivo sin ninguna modificacion
     * @param marcoDeDatos es la matriz con los datos del archivo.csv
     */
    public static void imprimirMatriz(String[][] marcoDeDatos) {
        System.out.println("STATION " + " NAME "+" DATE "+" PRCP "+" TAVG "+" TMAX "+" TMIN");
        for(int i = 0; i < marcoDeDatos.length; i++) {
            for(int j = 0; j < marcoDeDatos[i].length; j++) {
                System.out.print(marcoDeDatos[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n"+"Los datos que no encontrados se reemplazaron con 0");
    }
}
