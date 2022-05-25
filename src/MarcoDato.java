import java.io.*;
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

    /**
     * Se encarga de generar un archivo .txt con las respuestas de los promedios, los maximos y minimos.
     * @param marcoDeDatos es la matriz con los datos del archivo.csv
     */

    public static void archivoRespuestas(String[][] marcoDeDatos){


        File f = new File("Resultados.txt");
        FileWriter datos = null;
        PrintWriter pw = null;


        if (!f.exists()) {
            try{
                f.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creating the file");
            }
        }

        try {
            datos = new FileWriter("Resultados.txt"); //true
            pw = new PrintWriter(datos);
            pw.println("RESULTADOS: " + "\n");
            pw.println("PROMEDIOS: ");
            pw.println("El promedio total de precipitaciones es: " + Operaciones.promedio(marcoDeDatos,4)+ "°C"+ "\n"
                    + "El promedio total de la temperatura promedio es: " + Operaciones.promedio(marcoDeDatos,5)+"°C"+ "\n"
                    + "El promedio total de la temperatura maxima es: " + Operaciones.promedio(marcoDeDatos,6)+"°C"+ "\n"
                    + "El promedio total de la temperatura minima es: " + Operaciones.promedio(marcoDeDatos,7)+"°C" + "\n");
            pw.println("NUMERO MAYOR: ");
            pw.println("El mayor numero de precipitaciones es: " + Operaciones.mayor(marcoDeDatos,4)+ "°C"+"\n"
                    + "La mayor cifra de temperatura promedio es: " + Operaciones.mayor(marcoDeDatos, 5)+"°C"+ "\n"
                    + "La mayor cifra de temperatura maxima es: " + Operaciones.mayor(marcoDeDatos, 6)+"°C"+ "\n"
                    + "La mayor cifra de temperatura minima es: " + Operaciones.mayor(marcoDeDatos, 7)+"°C"+ "\n");
            pw.println("NUMERO MENOR: ");
            pw.println("El menor numero de precipitaciones es: " + Operaciones.menor(marcoDeDatos, 4)+ "°C"+ "\n"
                    + "La menor cifra de temperatura promedio es: " + Operaciones.menor(marcoDeDatos, 5)+"°C"+ "\n"
                    + "La menor cifra de temperatura maxima es: " + Operaciones.menor(marcoDeDatos, 6)+"°C"+ "\n"
                    + "La menor cifra de temperatura minima es: " + Operaciones.menor(marcoDeDatos, 7)+"°C");
            datos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
