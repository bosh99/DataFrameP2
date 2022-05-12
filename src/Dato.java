import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Dato {
    private String estacion;
    private String nombre;
    private String pais;
    private String fecha;
    private String presipitacion;
    private String tavg;
    private String tmax;
    private String tmin;

    public Dato(int i) {
        ArrayList<String[]> datos = new ArrayList<String[]>();
        lecturaDeDatos(datos);

        try {
            this.estacion = datos.get(i)[0];
            this.nombre = datos.get(i)[1];
            this.pais = datos.get(i)[2];
            this.fecha = datos.get(i)[3];
            this.presipitacion = datos.get(i)[4];
            this.tavg = datos.get(i)[5];
            this.tmax = datos.get(i)[6];
            this.tmin = datos.get(i)[7];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Dato{" +
                "estacion='" + estacion + ' ' +
                ", nombre='" + nombre + ' ' +
                ", pais='" + pais + ' ' +
                ", fecha='" + fecha + ' ' +
                ", presipitacion=" + presipitacion +
                ", tavg=" + tavg +
                ", tmax=" + tmax +
                ", tmin=" + tmin +
                '}';
    }

    public static void lecturaDeDatos(ArrayList<String[]> datos) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Medellin.csv"));
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] datosUsuario = line.split(",");
                datos.add(datosUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
