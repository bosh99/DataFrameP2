import java.text.DecimalFormat;
import java.util.Arrays;

public class Operaciones {


    public static String promedio(String[][] marcoDeDatos, int columna){
        DecimalFormat formato = new DecimalFormat("#.##"); //Limitar la cantidad de decimales
        double total = 0;
        for(int i = 0; i < Main.tamañoArchivo(); i++) {
            total += Double.parseDouble(marcoDeDatos[i][columna]);
        }
        return formato.format(total/Main.tamañoArchivo());
    }



    public static double mayor(String[][] marcoDeDatos, int columna){
        double mayor = 0;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][columna]) > mayor){
                mayor = Double.parseDouble(marcoDeDatos[i][columna]);
            }
        }
        return mayor;
    }


    // Los minimos serian todos 0.0, entonces no se si poner que sea diferente a 0.0

    public static double menor(String[][] marcoDeDatos, int columnas){
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][columnas]) < menor && Double.parseDouble(marcoDeDatos[i][columnas]) != 0.0){
                menor = Double.parseDouble(marcoDeDatos[i][columnas]);
            }
        }
        return menor;
    }


/*
// La moda de demora 3 dias en ejecutarse

    public static void modaPrcp(String[][] marcoDeDatos) {
        int maximoNumRepeticiones = 0;
        String moda = "";

        for(int i = 0; i < Main.tamañoArchivo(); i++) {
            int numRepeticiones = 0;

            for(int j = 0; j < Main.tamañoArchivo(); j++)
                if(marcoDeDatos[i][4].equals(marcoDeDatos[j][4])){
                    numRepeticiones++;
                }
                if(numRepeticiones>maximoNumRepeticiones) {
                    moda = marcoDeDatos[i][4];
                    maximoNumRepeticiones= numRepeticiones;
                }
        }
        System.out.println("La moda es:" + moda);
    }

 */


    public static String[][] ordenarMenorMayor(String[][] marcoDeDatos, int orderBy){
        String[] temp = new String[7];
        for(int i = 0; i < Main.tamañoArchivo(); i++){
            int pos = i;
            temp = marcoDeDatos[i];
            while((pos > 0) && (Double.parseDouble(marcoDeDatos[pos-1][orderBy]) > Double.parseDouble(temp[orderBy]))){
                marcoDeDatos[pos] = marcoDeDatos[pos-1];
                pos--;
            }
            marcoDeDatos[pos] = temp;

        }
        return marcoDeDatos;
    }

    public static String[][] ordenarMayorMenor(String[][] marcoDeDatos, int orderBy){
        String[] temp = new String[7];
        for(int i = 0; i < Main.tamañoArchivo(); i++){
            int pos = i;
            temp = marcoDeDatos[i];
            while((pos > 0) && (Double.parseDouble(marcoDeDatos[pos-1][orderBy]) < Double.parseDouble(temp[orderBy]))){
                marcoDeDatos[pos] = marcoDeDatos[pos-1];
                pos--;
            }
            marcoDeDatos[pos] = temp;

        }
        return marcoDeDatos;
    }

}
