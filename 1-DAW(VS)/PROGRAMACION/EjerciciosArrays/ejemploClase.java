package EjerciciosArrays;

import java.util.Scanner;

public class ejemploClase {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        /*
         *  Crear array de String de 10 posiciones
         *  menu:
         *  1- limpiar (null)
         *  2 - insertar en posicion
         *  3 - mostrar valor en posicion 
         *  4 - llenar todo el array con " cadena n"
         *  5 - mostrar todo el array
         *  0 - salir
         */

        String[] nombres = new String[10];

        int opcion;

        do{

            opcion = menu();

            switch (opcion){

                case 1:

                    limpiar(nombres);
                    break;

                case 2:

                    insertarPosicion(nombres);
                    break;

                case 3:

                    mostrarValor(nombres);
                    break;

                case 4:

                    llenarArray(nombres);
                    break;

                case 5:

                    mostrarArray(nombres);
                    break;

                case 0:

                    System.out.println("has salido del programa");
                    break;

                default:

                    System.out.println("la opcion no es correcta");
            }

        }while (opcion != 0);

    }

    static int menu(){

        int opcion;

        System.out.println("selecciona una opcion:");
        System.out.println("1 - limpiar");
        System.out.println("2 - insertar en posicion");
        System.out.println("3 - mostrar valor en posicion");
        System.out.println("4 - llenar array");
        System.out.println("5 - mostrar array");
        System.out.println("0 - salir");
        
        opcion = sc.nextInt();
        sc.nextLine(); // limpiar bf

        return opcion;
    }

    static void limpiar(String[] nombres){

        for (String posicion : nombres) {
            
            posicion = null;

        }
    }

    static void insertarPosicion(String[] nombres){

        System.out.println("introduce la posicion donde insertar");

        int posicion = sc.nextInt();
        sc.nextLine(); // limpiar bf

        System.out.println("introduce la cadena que quieres introducir");

        String cadena = sc.nextLine();

        nombres[posicion] = cadena;

    }

    static void mostrarValor(String[] nombres){

        System.out.println("introduce la posicion a mostrar");

        int posicion = sc.nextInt();
        sc.nextLine(); // limpiar bf

        System.out.println("el valor en la posicion " + posicion + " es: " + nombres[posicion]);

    }

    static void llenarArray(String[] nombres){

        for(int posicion = 0; posicion < nombres.length; posicion++){

            System.out.println("introduce la cadena a insertar en posicion " + posicion);

            nombres[posicion] = sc.nextLine();

        }

    }

    static void mostrarArray(String[] nombres){

        for (String posicion : nombres) {

            System.out.println(posicion);
            
        }

    }
}
