import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase se encarga de la ejejucion de la totalidad del codigo
 * @author Esteban Muriel Roldan
 * @author Miguel Vasquez Bojanini
 * @author Manuel Villegas Michel
 */

public class Main {

    /**
     *  Se encarga de meter los datos del archivo en una matriz y se disponen las operacion para trabajar con ella
     * @param args
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Procesando... Por favor espere." + "\n");
        String[][] marcoDeDatos = new String[tamanioArchivo()][8];
        ArrayList<String[]> datos = new ArrayList<String[]>();
        lecturaDeDatos(datos);
        for(int i = 0; i < tamanioArchivo() ; i++) {
            Dato d1 = new Dato(datos.get(i));
            marcoDeDatos[i][0] = d1.getEstacion();
            marcoDeDatos[i][1] = d1.getNombre();
            marcoDeDatos[i][2] = d1.getPais();
            marcoDeDatos[i][3] = d1.getFecha();
            marcoDeDatos[i][4] = d1.getPresipitacion();
            marcoDeDatos[i][5] = d1.getTavg();
            marcoDeDatos[i][6] = d1.getTmax();
            marcoDeDatos[i][7] = d1.getTmin();
        }
        System.out.println("Bienvendio... Ingrese que desea hacer con los datos climaticos de San Fransisco Downtown (2000 - 2019)");
        System.out.println("*Recuerde que al ser un archivo extenso, las operciones mas complicadas pueden tomar un tiempo*" + "\n");
        Main.mostrarOpciones(marcoDeDatos);
    }

    /**
     * Imrpime el menu con las opciones del programa
     */
     public static void imprimirMenu(){
       System.out.println("------------------------------------------------------------------------------");
       System.out.println("| Digite [0] para finalizar el programa                                       |");
       System.out.println("| Digite [1] para mostrar los datos en su totalidad                           |");
       System.out.println("| Digite [2] para mostrar el promedio de las diferentes medidas climaticas    |");
       System.out.println("| Digite [3] para mostrar los maximos de cada medida climatica                |");
       System.out.println("| Digite [4] para mostrar los minimos de cada medida climatica                |");
       System.out.println("| Digite [5] Para ordenar la lista de menor a mayor                           |");
       System.out.println("| Digite [6] Para ordenar la lista de mayor a menor                           |");
       System.out.println("------------------------------------------------------------------------------");
     }

    /**
     * Se encarga de correr la opcion correspondiente de acuerdo con el numero que ingrese el usuario
     * Implementa los metodos de la clase Operaciones
     * @param marcoDeDatos es la matriz con los datos del archivo.csv
     */
        public static void mostrarOpciones (String [][] marcoDeDatos){
                Scanner esc = new Scanner(System.in);

                while (true){
                    imprimirMenu();
                    System.out.println();
                    System.out.print("Digite la opcion seleccionada: ");
                    int opcion = esc.nextInt();
                    if (opcion != 0){
                        switch (opcion){
                            case 1:{
                                imprimirMatriz(marcoDeDatos);
                                break;
                            }
                            case 2:{
                                System.out.println("Procesando... Por favor espere." + "\n");
                                System.out.println("El promedio total de precipitaciones es: " + Operaciones.promedio(marcoDeDatos,4)+ "\n"
                                 + "El promedio total de la temperatura promedio es: " + Operaciones.promedio(marcoDeDatos,5)+"°C"+ "\n"
                                + "El promedio total de la temperatura maxima es: " + Operaciones.promedio(marcoDeDatos,6)+"°C"+ "\n"
                                 + "El promedio total de la temperatura minima es: " + Operaciones.promedio(marcoDeDatos,7)+"°C");
                                break;
                            }
                            case 3:{
                                System.out.println("Procesando... Por favor espere." + "\n");
                                System.out.println("El mayor numero de precipitaciones es: " + Operaciones.mayor(marcoDeDatos,4)+ "\n"
                                + "La mayor cifra de temperatura promedio es: " + Operaciones.mayor(marcoDeDatos, 5)+"°C"+ "\n"
                                + "La mayor cifra de temperatura maxima es: " + Operaciones.mayor(marcoDeDatos, 6)+"°C"+ "\n"
                                + "La mayor cifra de temperatura minima es: " + Operaciones.mayor(marcoDeDatos, 7)+"°C");
                                break;
                            }
                            case 4:{
                                System.out.println("Procesando... Por favor espere." + "\n");
                                System.out.println("El menor numero de precipitaciones es: " + Operaciones.menor(marcoDeDatos, 4)+ "\n"
                                + "La menor cifra de temperatura promedio es: " + Operaciones.menor(marcoDeDatos, 5)+"°C"+ "\n"
                                + "La menor cifra de temperatura maxima es: " + Operaciones.menor(marcoDeDatos, 6)+"°C"+ "\n"
                                + "La menor cifra de temperatura minima es: " + Operaciones.menor(marcoDeDatos, 7)+"°C");
                                break;
                            }
                            case 5:{
                                System.out.println("Digite por que parametro lo quiere ordenar: ");
                                System.out.println("[1]prcp [2]Tavg  [3]Tmax [4]Tmin ");
                                opcion = esc.nextInt();
                                System.out.println("Procesando... Por favor espere." + "\n");
                                switch (opcion){
                                    case 1:{
                                        imprimirMatriz(Operaciones.ordenarMenorMayor(marcoDeDatos,4));
                                        break;
                                    }
                                    case 2:{
                                        imprimirMatriz(Operaciones.ordenarMenorMayor(marcoDeDatos,5));
                                        break;
                                    }
                                    case 3:{
                                        imprimirMatriz(Operaciones.ordenarMenorMayor(marcoDeDatos,6));
                                        break;
                                    }
                                    case 4:{
                                        imprimirMatriz(Operaciones.ordenarMenorMayor(marcoDeDatos,7));
                                        break;
                                    }
                                }
                                break;
                            }
                            case 6:{
                                System.out.println("Digite por que parametro lo quiere ordenar: ");
                                System.out.println("[1]prcp [2]Tavg  [3]Tmax [4]Tmin ");
                                opcion = esc.nextInt();
                                System.out.println("Procesando... Por favor espere." + "\n");
                                switch (opcion){
                                    case 1:{
                                        imprimirMatriz(Operaciones.ordenarMayorMenor(marcoDeDatos,4));
                                        break;
                                    }
                                    case 2:{
                                        imprimirMatriz(Operaciones.ordenarMayorMenor(marcoDeDatos,5));
                                        break;
                                    }
                                    case 3:{
                                        imprimirMatriz(Operaciones.ordenarMayorMenor(marcoDeDatos,6));
                                        break;
                                    }
                                    case 4:{
                                        imprimirMatriz(Operaciones.ordenarMayorMenor(marcoDeDatos,7));
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                    else{
                        System.out.println("Gracias por consultar... Adios");
                        break;
                    }
                }
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
}
