import java.text.DecimalFormat;

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
}
