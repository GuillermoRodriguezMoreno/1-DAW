package colecciones;

import java.util.HashMap;
import java.util.Scanner;

public class EjemploDeMap {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        HashMap <String, Integer> repuestos = new HashMap<>();

        
        int opcion;

        do{

            System.out.println("1 - Insertar producto");
            System.out.println("2 - Borrar producto");
            System.out.println("3 - Cambiar stock");
            System.out.println("4 - Mostrar informacion");
            System.out.println("0 - Salir");


            opcion = sc.nextInt();

            sc.nextLine();

            switch(opcion){

                case 1:
    
                    System.out.println("que producto?");

                    String producto = sc.nextLine();
    
                    añadir(repuestos, producto);
    
                    break;
    
                case 2:
    
                    System.out.println("que producto quieres borrar?");

                    producto = sc.nextLine();
    
                    borrar(repuestos, producto);
    
                    break;
    
                case 3:
    
                    System.out.println("que producto quieres actualizar?");
    
                    producto = sc.nextLine();

                    System.out.println("cuanto");

                    int cantidad = sc.nextInt();
                    sc.nextLine();
    
                    actualizar(repuestos, producto, cantidad);
    
                    break;
    
                case 4:
    
                    System.out.println(repuestos);
    
                    break;

                case 0:

                    break;

                default:

                    System.out.println("introduce una opcion correcta");
            }

        }while(opcion != 0);

        System.out.println("has salido correctamente");

        repuestos.
    }

    // Funciones

    public static void añadir(HashMap repuestos, String codigo){

        if(repuestos.containsKey(codigo)){

            System.out.println("ese producto ya se encuentra en la base de datos");

        }

        else {

            repuestos.put(codigo, 0);

            System.out.println("Producto añadido correctamente");
        }
    }

    public static void borrar(HashMap repuestos, String codigo){

        if(!repuestos.containsKey(codigo)){

            System.out.println("ese producto no se encuentra en la base de datos");

        }

        else {

            repuestos.remove(codigo);

            System.out.println("Producto borrado correctamente");
        }
    }

    public static void actualizar(HashMap repuestos, String codigo, int cantidad){

        if(repuestos.containsKey(codigo)){

            repuestos.replace(codigo, cantidad);

            System.out.println("producto actualizado correctamente");

        }

        else {

            System.out.println("Producto no se escuentra");
        }
    }
}
