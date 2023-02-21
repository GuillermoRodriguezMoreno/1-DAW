package EjerciciosArrays.examen;


import java.util.Scanner;

public class Ejercicio2_MattiaLu {
    // declarar las variables estaticas.
    static Scanner sc = new Scanner(System.in);

    static String[] frutasArray = new String[0];
    static double[] preciosArray = new double[0];
    static double[] cantidadVendidaArray = new double[0];
    // un main para llamar al menu
    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        // booleano para salir
        boolean seguir = true;
        // menu
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
        // segun la opcion entra en diferentes funciones y vuelve al menu si seguir es
        // true
        switch (opcion) {
            case "a":
                insertarFruta();
                break;
            case "b":
                añadirCompra();
                break;
            case "c":
                modificarPrecio();
                break;
            case "d":
                modificarTodo();
                break;
            case "e":
                mostrarInforme();
                break;
            // para salir seguir se convierte en false
            case "x":
                seguir = false;
                break;
            // si no se ha entrado en ninguna de delante será una opcion incorrecta.
            default:
                System.out.println("Opcion incorrecta");
        }
        // para repetir
        if (seguir) {
            menu();
        }
    }

    /**
     * insertar al final de la lista, String
     * 
     * @param array
     * @param elemento
     * @return
     */
    public static String[] insertarAlFinal(String[] array, String elemento) {
        String[] nuevo = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            nuevo[i] = array[i];
        }
        nuevo[nuevo.length - 1] = elemento;
        array = nuevo;
        return array;
    }

    /**
     * insertar al final de la lista, double
     * 
     * @param array
     * @param elemento
     * @return
     */
    public static double[] insertarAlFinal(double[] array, double elemento) {
        double[] nuevo = new double[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            nuevo[i] = array[i];
        }
        nuevo[nuevo.length - 1] = elemento;
        array = nuevo;
        return array;
    }

    /**
     * devuelve la posicion del nombre en la lista si no encuentra devuelve -1
     * 
     * @return
     */
    static int pedirNombre() {
        // dar a posicion un numero que no puede ser para decir que no existe
        int pos = -1;
        System.out.print("Fruta: ");
        String fruta = sc.nextLine();
        for (int i = 0; i < frutasArray.length; i++) {
            // si está almacena la posición
            if (frutasArray[i].equalsIgnoreCase(fruta)) {
                pos = i;
            }
        }
        return pos;
    }
    /**
     * pide un numero
     * 
     * @param objeto el nombre de la cosa que se quiere pedir
     * @return
     */
    static double pedir(String objeto) {
        double cantidad;
        // pide la cantidad y si no hubiera introducido un int dará error
        try {
            System.out.print(objeto + ": ");
            cantidad = sc.nextDouble();
            sc.nextLine();
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("Error");
            cantidad = pedir(objeto);
        }
        return cantidad;
    }
    /**
     * obtener la media del array
     * 
     * @param array
     * @return
     */
    static double obtenerMedia(double[] array) {
        if (array.length == 0) {
            System.out.println("Error, array vacío");
            return 0;
        }
        double tot = 0;
        for (int i = 0; i < array.length; i++) {
            tot += array[i];
        }
        double media = tot / array.length;
        return media;
    }
    static void insertarFruta() {
        // no se ha utilizado el pedirNombre porque hace falta el nombre de la fruta.
        // booleano para comprobar que la fruta todavia no existe
        boolean repetido = false;
        System.out.print("Fruta: ");
        String fruta = sc.nextLine();
        // pasa por todo el array si encuentra una fruta con el mismo nombre advierte y
        // no hace nada.
        for (int i = 0; i < frutasArray.length; i++) {
            if (frutasArray[i].equalsIgnoreCase(fruta)) {
                System.out.println("Está ya.");
                repetido = true;
            }
        }
        // si no se ha encontrado añade la fruta, precio y cantidad vendido
        if (!repetido) {
            frutasArray = insertarAlFinal(frutasArray, fruta);
            preciosArray = insertarAlFinal(preciosArray, 1);
            cantidadVendidaArray = insertarAlFinal(cantidadVendidaArray, 0);
        }
    }
    /**
     * comprar fruta
     */
    static void añadirCompra() {
        int pos = pedirNombre();
        // si la posicion es un numero positivo significa que existe y pide la cantidad
        // y lo suma a la posición que le pertenece
        if (pos >= 0) {
            double cantidad = pedir("Cantidad");
            cantidadVendidaArray[pos] += cantidad;
        } else {
            // si no se ha encontrado sale un error y no hace nada
            System.out.println("No se ha encontrado");
        }
    }
    /**
     * modificar precio
     */
    static void modificarPrecio() {
        int pos = pedirNombre();
        // si la posicion es un numero positivo significa que existe y pide la cantidad
        // y lo suma a la posición que le pertenece
        if (pos >= 0) {
            double precio = pedir("Precio");
            preciosArray[pos] += precio;
        } else {
            // si no se ha encontrado sale un error y no hace nada
            System.out.println("No se ha encontrado");
        }
    }

    /**
     * (Modifica todos los precios de las frutas, si la cantidad vendida
     * ha sido mayor a la media entonces le suma 0,25 y si ha sido menor a la media
     * le resta 0.15 a
     * todos los precios, el precio nunca puede ser negativo)
     */
    static void modificarTodo() {
        double media = obtenerMedia(cantidadVendidaArray);
        // pasar por todo el array
        for (int i = 0; i < preciosArray.length; i++) {
            // si está mayor a la media entonces le suma 0,25 al precio
            if (cantidadVendidaArray[i] > media) {
                preciosArray[i] += 0.25;
                // ha sido menor a la media le resta 0.15 comprobando que no va a salir negativo
            } else if (cantidadVendidaArray[i] < media && preciosArray[i] - 0.15 > 0) {
                preciosArray[i] -= 0.15;
            }
        }
    }
    /**
     * Mostrar informe
     * Saca un informe de todas las frutas:
     * ◦ “Nombre – Precio – Cantidad vendida - Cantidad ganada - simbolo+/- (debe
     * aparecer un simbolo + si la cantidad vendida es mayor a la media de
     * cantidades vendidas y – si es menor.
     * ◦ Linea final con el total de kg vendidos y la facturación total de la
     * frutería.
     */
    static void mostrarInforme() {
        //declarar las variables
        double media = obtenerMedia(cantidadVendidaArray);
        String simbolo;
        double totCantidad=0,totGanancia=0;

        System.out.println("\t\tPrecio\tCantidad Ganancia");
        for (int i = 0; i < frutasArray.length; i++) {
            // obtener el simbolo "+" o "-" o "="
            // se podria usar una ternaria pero asi se entiende mejor
            if (cantidadVendidaArray[i] > media) {
                simbolo = "+";
            } else if (cantidadVendidaArray[i] < media) {
                simbolo = "-";
            } else {
                simbolo = "=";
            }
            //calculos
            Double ganancia=preciosArray[i] * cantidadVendidaArray[i];
            totCantidad+=cantidadVendidaArray[i];
            totGanancia+=ganancia;
            //imprimir los numeros
            System.out.print("Fruta: " + frutasArray[i] + "\t");
            System.out.print(preciosArray[i]+"\t");
            System.out.print("-" + cantidadVendidaArray[i] + "-\t");
            System.out.println(ganancia + "(" + simbolo + ")");
        }
        //imprimir el total
        System.out.println("\t\t\t"+totCantidad+"\t"+totGanancia);
    }

}
