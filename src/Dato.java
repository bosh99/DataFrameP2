public class Dato {
    private String estacion;
    private String nombre;
    private String pais;
    private String fecha;
    private String presipitacion;
    private String tavg;
    private String tmax;
    private String tmin;


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

    public String getEstacion() {
        return estacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getFecha() {
        return fecha;
    }

    public String getPresipitacion() {
        return presipitacion;
    }

    public String getTavg() {
        return tavg;
    }

    public String getTmax() {
        return tmax;
    }

    public String getTmin() {
        return tmin;
    }

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
