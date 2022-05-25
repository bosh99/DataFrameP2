import java.text.DecimalFormat; //Limitar la cantidad de decimales

/**
 * Esta clase se encarga de contener todas las operaciones utilizadas dentro de la clase Main
 * @author Esteban Muriel Roldan
 * @author Miguel Vasquez Bojanini
 * @author Manuel Villegas Michel
 */

public class Operaciones {

    /**
     * Se encarga de calcular el promedio de la columna correspondiente
     * @param marcoDeDatos La matriz con los datos del archivo.csv
     * @param columna El valor de la columna correspondiente donde se calcula el promedio
     * @return El valor promedio que haya calculado con un maximo de dos decimales
     */


    public static String promedio(String[][] marcoDeDatos, int columna){
        DecimalFormat formato = new DecimalFormat("#.##");
        double total = 0;
        for(int i = 0; i < MarcoDato.tamanioArchivo(); i++) {
            total += Double.parseDouble(marcoDeDatos[i][columna]);
        }
        return formato.format(total/MarcoDato.tamanioArchivo());
    }

    /**
     * Se encarga de calcular el valor mas grande de la columna ingresada
     * @param marcoDeDatos Recibe la matriz marco de datos con toda la informacion del archivo.csv
     * @param columna Sirve para saber sobre que columna de la matriz se va a buscar el valor mas grande
     * @return El valor mas grande de la columna determinada
     */

    public static double mayor(String[][] marcoDeDatos, int columna){
        double mayor = 0;
        for (int i = 0; i < MarcoDato.tamanioArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][columna]) > mayor){
                mayor = Double.parseDouble(marcoDeDatos[i][columna]);
            }
        }
        return mayor;
    }

    /**
     * Se encarga de buscar el valor mas pequenio dentro de la columna correspondiente (ingnorando los valores 0.0)
     * @param marcoDeDatos Recibe la matriz marco de datos con toda la informacion del archivo.csv
     * @param columnas Sirve para saber sobre que columna de la matriz se va a buscar el valor mas pequenio
     * @return El valor mas pequenio de la columna seleccionda
     */

    public static double menor(String[][] marcoDeDatos, int columnas){
        double menor = Double.MAX_VALUE;
        for (int i = 0; i < MarcoDato.tamanioArchivo(); i++){
            if (Double.parseDouble(marcoDeDatos[i][columnas]) < menor && Double.parseDouble(marcoDeDatos[i][columnas]) != 0.0){
                menor = Double.parseDouble(marcoDeDatos[i][columnas]);
            }
        }
        return menor;
    }

    /**
     * Se encarga de ordenar la matriz de menor a mayor bajo el ordenamiento por insercion, segun el parametro seleccionado
     * @param marcoDeDatos Recibe la matriz marco de datos con toda la informacion del archivo.csv
     * @param orderBy  Sirve para saber sobre que columna de la matriz se va a ordenar de menor a mayor
     * @return La matriz de datos ordenada desde menor a mayor
     */
    public static String[][] ordenarMenorMayor(String[][] marcoDeDatos, int orderBy){
        String[] temp = new String[7];
        for(int i = 0; i < MarcoDato.tamanioArchivo(); i++){
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

    /**
     * Se encarga de ordenar la matriz de mayor a menor bajo el ordenamiento por insercion, segun el parametro seleccionado
     * @param marcoDeDatos Recibe la matriz marco de datos con toda la informacion del archivo.csv
     * @param orderBy  Sirve para saber sobre que columna de la matriz se va a ordenar de mayor a menor.
     * @return La matriz de datos ordenada desde mayor a menor
     */

    public static String[][] ordenarMayorMenor(String[][] marcoDeDatos, int orderBy){
        String[] temp = new String[7];
        for(int i = 0; i < MarcoDato.tamanioArchivo(); i++){
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

    /**
     * Este metodo nos permite absabeair cual es la dispersion media de la variable donde se aplica.
     * @param marcoDeDatos Recibe la matriz marco de datos con toda la informacion del archivo.csv 
     * @param OrderBy  Sirve para saber sobre que columna de la matriz se va aplicar la desviacion estandar
     * @return El valor de la desviacion estandar del dato correspondiente.
     */

    public static double desEstandar (String [][] marcoDeDatos , int OrderBy) {
        double desviacion = 0;
        String promedio = Operaciones.promedio(marcoDeDatos, OrderBy).replace(",",".");
        try {
            double promPrc = Double.parseDouble(promedio);
            double sumaResto = 0.0;

            for (int i = 0; i < MarcoDato.tamanioArchivo(); i++) {
                sumaResto += Double.parseDouble(marcoDeDatos[i][OrderBy]) - promPrc;
            }

            double cuadrado = Math.pow(sumaResto, 2);
            desviacion =  cuadrado / (MarcoDato.tamanioArchivo() -1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return desviacion;
    }

}
