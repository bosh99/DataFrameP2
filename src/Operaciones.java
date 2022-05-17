import java.text.DecimalFormat;
import java.util.Arrays;

public class Operaciones {

    public static String promedioPrcp(String[][] marcoDeDatos) {
        DecimalFormat formato = new DecimalFormat("#.##"); //Limitar la cantidad de decimales
        double total = 0;
        for(int i = 0; i < Main.tamañoArchivo(); i++) {
            total += Double.parseDouble(marcoDeDatos[i][4]);
        }
        return formato.format(total/Main.tamañoArchivo());
    }

    public static String promedioTavg(String[][] marcoDeDatos) {
        DecimalFormat formato = new DecimalFormat("#.##");
        double total = 0;
        for(int i = 0; i < Main.tamañoArchivo(); i++) {
            total += Double.parseDouble(marcoDeDatos[i][5]);
        }
        return formato.format(total/Main.tamañoArchivo());
    }

    public static String promedioTmax(String[][] marcoDeDatos) {
        DecimalFormat formato = new DecimalFormat("#.##");
        double total = 0;
        for(int i = 0; i < Main.tamañoArchivo(); i++) {
            total += Double.parseDouble(marcoDeDatos[i][6]);
        }
        return formato.format(total/Main.tamañoArchivo());
    }

    public static String promedioTmin(String[][] marcoDeDatos) {
        DecimalFormat formato = new DecimalFormat("#.##");
        double total = 0;
        for(int i = 0; i < Main.tamañoArchivo(); i++) {
            total += Double.parseDouble(marcoDeDatos[i][7]);
        }
        return formato.format(total/Main.tamañoArchivo());
    }

    public static double mayorPrcp(String[][] marcoDeDatos){
        DecimalFormat formato = new DecimalFormat("#.##");
        double mayor = 0;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][4]) > mayor){
                mayor = Double.parseDouble(marcoDeDatos[i][4]);
            }
        }
        return mayor;
    }

    public static double mayorTavg(String[][] marcoDeDatos){
        DecimalFormat formato = new DecimalFormat("#.##");
        double mayor = 0;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][5]) > mayor){
                mayor = Double.parseDouble(marcoDeDatos[i][5]);
            }
        }
        return mayor;
    }

    public static double mayorTmax(String[][] marcoDeDatos){
        double mayor = 0;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][6]) > mayor){
                mayor = Double.parseDouble(marcoDeDatos[i][6]);
            }
        }
        return mayor;
    }

    public static double mayorTmin(String[][] marcoDeDatos){
        double mayor = 0;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][7]) > mayor){
                mayor = Double.parseDouble(marcoDeDatos[i][7]);
            }
        }
        return mayor;
    }

    // Los minimos serian todos 0.0, entonces no se si poner que sea diferente a 0.0

    public static double menorPrcp(String[][] marcoDeDatos){
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][4]) < menor && Double.parseDouble(marcoDeDatos[i][4]) != 0.0){
                menor = Double.parseDouble(marcoDeDatos[i][4]);
            }
        }
        return menor;
    }
    public static double menorTavg(String[][] marcoDeDatos){
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][5]) < menor && Double.parseDouble(marcoDeDatos[i][5]) != 0.0){
                menor = Double.parseDouble(marcoDeDatos[i][5]);
            }
        }
        return menor;
    }

    public static double menorTmax(String[][] marcoDeDatos){
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][6]) < menor && Double.parseDouble(marcoDeDatos[i][6]) != 0.0){
                menor = Double.parseDouble(marcoDeDatos[i][6]);
            }
        }
        return menor;
    }

    public static double menorTmin(String[][] marcoDeDatos){
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < Main.tamañoArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][7]) < menor && Double.parseDouble(marcoDeDatos[i][7]) != 0.0){
                menor = Double.parseDouble(marcoDeDatos[i][7]);
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

    public static String[][] ordenarMayorMenorPrcp(String[][] marcoDeDatos){
        
    }



}
