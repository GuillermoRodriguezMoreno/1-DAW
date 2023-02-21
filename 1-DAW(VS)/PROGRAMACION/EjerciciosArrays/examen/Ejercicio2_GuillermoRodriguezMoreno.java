
// falta el control de que las frutas no esten repetidas y que se compre una fruta que este en la lista

package EjerciciosArrays.examen;

import java.util.Scanner;

public class Ejercicio2_GuillermoRodriguezMoreno {

    // Scanner
    static Scanner sc = new Scanner(System.in);
    
    // Arrays
    static String[] frutas = new String[0];
    static double[] precios = new double[0];
    static double[] cantidadVendida = new double[0];
    
    public static void main(String[] args) {

        boolean salir = false;

        String opcion = "";

        do{

            opcion = menu();

            switch(opcion){
            
                case "a": // insertar

                    System.out.println("Que fruta quieres añadir?");

                    insertarFruta(sc.nextLine());

                    break;

                case "b": // comprar

                    System.out.println("Que fruta vas a comprar?");

                    String nombreFruta = sc.nextLine();

                    System.out.println("Cuanta cantidad?");

                    double cantidadAComprar = sc.nextDouble();
                    sc.nextLine(); //limpiar

                    comprarFruta(nombreFruta, cantidadAComprar);

                    break;

                case "c": // cambiar precio

                    System.out.println("Que fruta vas a cambiar el precio?");

                    nombreFruta = sc.nextLine();

                    System.out.println("Cual es el nuevo precio?");

                    cantidadAComprar = sc.nextDouble();
                    sc.nextLine(); //limpiar

                    modificarPrecio(nombreFruta, cantidadAComprar);

                    break;

                case "d": // cambiar todos los precios

                    modificarTodosPrecios();

                    break;

                case "e": // salida por pantalla

                    mostrarInforme();

                    break;

                case "x": // salir

                    salir = true;

                    System.out.println("has salido del programa");

                    break;

                default: // opcion incorrecta

                    System.out.println("opcion invalida, selecciona una correcta");

            }

            System.out.println();

            }while(!salir);

    }
        
        
    // Metodos

    // mostrar menu

    /**
     * Muestra el menu
     * @return
     */

    static String menu(){
        
        System.out.println("a - Insertar fruta");
        System.out.println("b - Añadir compra");
        System.out.println("c - modificar precio fruta");
        System.out.println("d - Modificar todos los precios");
        System.out.println("e - mostrar informe");
        System.out.println("x - salir");
        System.out.println("---------------------------------------------");
        System.out.println(" Indique opción...");
        System.out.println();
        String opcion = sc.nextLine();

        return opcion;

    }

    // Insertar fruta

    /**
     * inserta todos los datos de una fruta en todas las listas
     * @param nombreFruta
     */

    static void insertarFruta(String nombreFruta){

        String[] nuevaListaFrutas = new String[frutas.length + 1];


        for (int i = 0; i < frutas.length; i++) {
            
            nuevaListaFrutas[i] = frutas[i];
        }

        nuevaListaFrutas[nuevaListaFrutas.length-1] = nombreFruta;

        frutas = nuevaListaFrutas;

        // inserto precio
        double[] nuevaListaPrecios = new double[precios.length +1];

        for (int i = 0; i < precios.length; i++) {
            
            nuevaListaPrecios[i] = precios[i];
        }

        nuevaListaPrecios[nuevaListaPrecios.length-1] = 1;

        precios = nuevaListaPrecios;

        // inserto cantidad vendida
        double[] nuevaListaCantidad = new double[cantidadVendida.length +1];

        for (int i = 0; i < cantidadVendida.length; i++) {
            
            nuevaListaCantidad[i] = cantidadVendida[i];
        }

        nuevaListaCantidad[nuevaListaCantidad.length-1] = 0;

        cantidadVendida = nuevaListaCantidad;

    }

    /**
     * busca una fruta en la lista
     * @param nombreFruta
     * @return la posisicion de la fruta
     */

    static int buscarFruta(String nombreFruta){

        int posicionFruta = -1;

        for (int i = 0; i < frutas.length; i++) {
            
            if(nombreFruta.equalsIgnoreCase(frutas[i])){

                posicionFruta = i;
            }
        }

        return posicionFruta;
    }

    // Comprar fruta

    /**
     * actualiza la cantidad de fruta vendida
     * @param fruta
     * @param cantidad
     */

    static void comprarFruta(String fruta, double cantidad){

        cantidadVendida[buscarFruta(fruta)] = cantidad;

    }

    // Modificar precio de una fruta

    /**
     * modifica el precio de una fruta concreta
     * @param fruta
     * @param nuevoPrecio
     */

    static void modificarPrecio(String fruta, double nuevoPrecio){

        precios[buscarFruta(fruta)] = nuevoPrecio;

    }

    // Obtener media precios

    /**
     * obtiene la media de las cantidades vendidas
     * @return media
     */

    static double obtenerMedia(){

        double media = 0.0;
        double suma = 0.0;

        // Recorrer array y actualizar suma

        for (int i = 0; i < cantidadVendida.length; i++) {
            
            suma = suma + cantidadVendida[i];
        }

        media = suma/cantidadVendida.length;

        return media;
    }


    // Modificar todo los precios

    /**
     * Modifica todos los precios segun la cantidad vendida
     */

    static void modificarTodosPrecios(){

        // Recorro lista cantidad vendida
        for (int i = 0; i < cantidadVendida.length; i++) {

            // si es superior a la media
            if(cantidadVendida[i] > obtenerMedia()){

                precios[i] = precios[i] + 0.25;
            }

            // si es menor a la media
            else if(cantidadVendida[i] < obtenerMedia()){

                // si se le puede restar
                if((precios[i] - 0.15) > 0){

                    precios[i] = precios[i] - 0.15;
                }
            }
        }
    }

    // Mostrar informe

    /**
     *  Muestra la informacion de todas las frutas
     */

    static void mostrarInforme(){

        double ganancia = 0.0;

        for (int i = 0; i < frutas.length; i++) {

            ganancia = precios[i] * cantidadVendida[i];
            
            System.out.print("Fruta: " + frutas[i] + " - " + precios[i] + " - " + cantidadVendida[i] + " - " +
            ganancia + " (");

            if(cantidadVendida[i] > obtenerMedia()) System.out.println("+)");
            else if (cantidadVendida[i] == obtenerMedia()) System.out.println("=)");
            else System.out.println("-)");

        }


        System.out.println("--------------------------------------");
        System.out.println("Kilos totales vendidos: " + kilosTotales());
        System.out.println("Facturacion total: " + facturacionTotal());

    }

    // oobtener kilos totales

    /**
     * obtiene los kilos totales
     * @return kilos totales
     */

    static double kilosTotales(){

        double kilos = 0.0;

        for (int i = 0; i < cantidadVendida.length; i++) {
            
            kilos = kilos + cantidadVendida[i];

        }

        return kilos;
    }

    // Facturacion total

    /**
     * obtiene la facturacion total
     * @return facturacion total
     */

    static double facturacionTotal(){

        double total = 0.0;

        for (int i = 0; i < cantidadVendida.length; i++) {
            
            total = total + (cantidadVendida[i] * precios[i]);
        }

        return total;
    }
}
