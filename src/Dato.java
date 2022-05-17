/**
 * Esta clase se encarga representar todos los elementos de un dato
 * @author Esteban Muriel Roldan
 * @author Miguel Vasquez Bojanini
 * @author Manuel Villegas Michel
 */

public class Dato {
    private String estacion;
    private String nombre;
    private String pais;
    private String fecha;
    private String presipitacion;
    private String tavg;
    private String tmax;
    private String tmin;

    /**
     * Constructor que recibe un arreglo de datos y hace que a cada atributo se le asigne el valor correspondiente
     * @param datos un arreglo de Strings con los datos leidos del archivo
     */
    public Dato(String[] datos) {

        try {
            this.estacion = datos[0];
            this.nombre = datos[1];
            this.pais = datos[2];
            this.fecha = datos[3];
            this.presipitacion = datos.length >= 5 ? !datos[4].equals("") ? datos[4] : " 0.0 " : " 0.0 ";
            this.tavg = datos.length >= 6 ? !datos[5].equals("") ? datos[5] : " 0.0 " : " 0.0 ";
            this.tmax = datos.length >= 7 ? !datos[6].equals("") ? datos[6] : " 0.0 " : " 0.0 ";
            this.tmin = datos.length >= 8 ? !datos[7].equals("") ? datos[7] : " 0.0 " : " 0.0 ";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return la estacion
     */
    public String getEstacion() {
        return estacion;
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @return la fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return la precipitacion
     */
    public String getPresipitacion() {
        return presipitacion;
    }

    /**
     * @return la temperatura promedio
     */
    public String getTavg() {
        return tavg;
    }

    /**
     * @return la temperatura maxima
     */
    public String getTmax() {
        return tmax;
    }

    /**
     * @return la temperatura minima
     */
    public String getTmin() {
        return tmin;
    }

    /**
     * El metodo toString predeterminado del objeto dato
     * @return todos los datos del objeto en forma de String
     */
    @Override
    public String toString() {
        return
                 estacion + ' ' +
                 nombre + ' ' +
                 pais + ' ' +
                 fecha + ' ' +
                 presipitacion + ' ' +
                 tavg + ' ' +
                 tmax + ' ' +
                 tmin;
    }
}
