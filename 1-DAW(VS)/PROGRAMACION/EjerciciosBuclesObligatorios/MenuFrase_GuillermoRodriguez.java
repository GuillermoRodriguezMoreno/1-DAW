package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class MenuFrase_GuillermoRodriguez {
    
    public static void main(String[] args) {
        
        /*

            * Opción a - Añadir a la frase (añadiendo al final de la frase ya existente)
            * Opción b - Indicar la ultima frase introducida (el programa escribirá la frase que el usuario está creando y analizando, si la frase está vacía indicarlo)

            * Opción c - Indicar el número de palabras que tiene la frase
            * Opción d - Indicar cuantas veces a aparece un carácter en la frase (deberá preguntar por el carácter a buscar, mostrar el número de veces que se repite dicho carácter y sus posiciones en la frase, da igual si está escrito en mayúscula o minúscula)
            * Opción e - Limpiar frase

            * Opción s - Salir


            Después de mostrar el resultado de cada opción el programa indicará que pulse ENTER para continuar y volverá a mostrar el menú de opciones


            Si el usuario introduce una opción incorrecta el programa debe informar de ello y volver a mostrar el menú de opciones.

         */

        Scanner sc = new Scanner (System.in);

        //variables

        char opcion =' ';
        String frase = "";

        //bucle do while para el menu

        do{

            // salida por pantalla del menu

            System.out.println("introduce una opcion");


            System.out.println("Opción a - Añadir a la frase");
            System.out.println("Opción b - Indicar la ultima frase introducida");
            System.out.println("Opción c - Indicar el número de palabras que tiene la frase");
            System.out.println("Opción d - Indicar cuantas veces a aparece un carácter en la frase");
            System.out.println("Opción e - Limpiar frase");
            System.out.println("Opción s - Salir");

            //Scanner de la opcion

            opcion = sc.nextLine().toLowerCase().charAt(0);

            //condiciones de la opcion
            
            switch(opcion){

                case 'a':

                    System.out.println("introduce lo que quieres añadir");

                    frase = frase.concat(sc.nextLine()) + " "; // concateno un espacio para que al introducir palabras salgan separadas

                    break;

                case 'b':

                    if(frase.trim().length() == 0) System.out.println("la frase esta vacia");//control de que la cadena no este vacia

                    else System.out.println(frase);

                    break;

                case 'c':

                    if(frase.trim().length() == 0) System.out.println("la frase esta vacia");//control de que la cadena no este vacia

                    else{
                        
                        System.out.println(frase.split(" ").length); // divido la cadena por espacios y muestro su longitud

                    }
                    break;
                
                case 'd':
                
                    System.out.println("introduce un caracter");

                    char caracter = sc.nextLine().toLowerCase().charAt(0); //escaneo el caracter en minusculas

                    String fraseMinus = frase.toLowerCase(); //vierto la frase en minusculas en otro String

                    int posicionCaracter = 0;
                    int contadorControl = 0; //reinicio de variables
                    int control = 0;
                    String posiciones = "";

                    // bucle para buscar un caracter hasta que no lo encuentre
                    
                    do{

                        control = fraseMinus.indexOf(caracter, posicionCaracter);

                        if (control != -1) { //condicion para que la ultima vuelta del bucle no cuente(no muestre -1 como posicion)
                            
                            posiciones = posiciones + (control + 1) + " ";//acumulo las posiciones en un String y le sumo +1 
                                                                          //para que me muestra las posiciones sin contar la posicion 0
                        }

                        posicionCaracter = control + 1; //actualizacion del indice de busqueda del caracter

                        contadorControl ++; //contador de control por si el caracter no se encuentra

                    }while (control != -1);

                    if (contadorControl < 2) System.out.println("El caracter no se encuentra en la frase");//si el caracter no aparece
                                                                                                             //contador sera 1

                    else{

                        //salida por pantalla si el caracter se encuentra

                        System.out.println("el caracter aparece " + (contadorControl - 1) + " veces"); //resto la ultima busqueda(la que
                                                                                                       //ya no se encuentra el caracter)
                        System.out.println("y sus posiciones son " + posiciones);                      
                    }

                    break;

                case 'e':

                    frase = ""; // limpio la frase

                    break;

                case 's':

                    System.out.println("has salido del Programa"); //salida del programa

                    break;

                default:
                    
                    System.out.println("por favor introduce una opcion correcta");//control de que la opcion es correcta

                    break;
            }

            System.out.println("pulsa ENTER para continuar");
            sc.nextLine();

        }while(opcion != 's');

        sc.close();

        /*
         * solucionar:
         * - al añadir espacios, en la opcion de numero de palabras no salen las correctas
         * - al pulsar enter a la hora de elegir opcion el programa falla
         * - preguntar si al limpiar frase, la opcion b tiene que indicar la frase anterior
         * - en la opcion d si elijo como caracter espacio siempre lo encuentra ya que al concatenar siempre lleva un espacio
         */

    }
}
