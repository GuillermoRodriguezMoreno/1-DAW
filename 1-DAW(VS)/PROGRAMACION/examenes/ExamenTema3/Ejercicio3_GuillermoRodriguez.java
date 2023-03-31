package ExamenTema3;

import java.util.Scanner;

public class Ejercicio3_GuillermoRodriguez {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // variables

        String opcion;

        String cadenaLeida = "";
        String cadenaABuscar = "";

        boolean cadenaVacia = true;

        // bucle do while para el menu y seleccion de opcion mientras no sea salir

        do{

            System.out.println("Selecciona una opcion:");
            System.out.println("A - Introducir una cadena de caracteres.");
            System.out.println("B - Mostrar la cadena actual");
            System.out.println("C - Encontrar una cadena, numero de apariciones y posiciones");
            System.out.println("D- Recorrer cadena orden inverso");
            System.out.println("E - Invertir cadena");
            System.out.println("F - Salir.");

            opcion = sc.nextLine();

            opcion = opcion.toUpperCase(); // convierto opcion a mayuscula para aceptarla aunque sea en minuscula

            // mostrar si la opcion es correcta

            if (opcion.equals("A")||opcion.equals("B")||opcion.equals("C")||opcion.equals("D")||opcion.equals("E")||opcion.equals("F")){

                System.out.println("La opcion seleccionada es correcta");
            }

            // si la cadena esta vacia

            if (cadenaLeida.isEmpty() == true){

                cadenaVacia = true;
            }

            // si no esta vacia

            else{

                cadenaVacia = false;
            }

            // Switch para realizar la opcion seleccionada

            switch(opcion){

                case "A":

                    // leo cadena

                    System.out.println("introduce la cadena");

                    cadenaLeida = sc.nextLine();

                    break;

                case "B":

                    // control de que la cadena no esta vacia

                    if (cadenaVacia == true){

                        System.out.println("La cadena actualmente esta vacia");
                    }

                    else {

                        // muestro cadena

                        System.out.println("La cadena actual es: " + cadenaLeida);

                    }


                    break;

                case "C":

                    // control cadena vacia

                    if (cadenaVacia == true){

                        System.out.println("La cadena actualmente esta vacia");
                    }

                    else {

                        // leo cadena a buscar

                        System.out.println("Introduce la cadena a buscar");

                        cadenaABuscar = sc.nextLine();

                        // convierto en minuscula fresa leida y frase a buscar

                        cadenaLeida = cadenaLeida.toLowerCase();

                        cadenaABuscar = cadenaABuscar.toLowerCase();

                        // variables

                        int posicionAparicion = 0;
                        int posicionABuscar = 0;
                        int numeroApariciones = 0;

                        // bucle do while hasta que no haya apariciones

                        do{

                            // busco desde posicion 0

                            posicionAparicion = cadenaLeida.indexOf(cadenaABuscar, posicionABuscar);

                            // si no se encuentra

                            if (posicionAparicion == -1){

                                if (numeroApariciones == 0){

                                    System.out.println("La cadena a buscar no se encuentra");

                                }

                                else{

                                    System.out.println("La cadena " + cadenaABuscar + " aparece " + numeroApariciones + " veces");

                                }

                                // actualizo posicion a -1 ya que no se encuentra y entonces sale del bucle

                                posicionABuscar = posicionAparicion;

                            }else{

                                // si se encuentra incremento contador

                                numeroApariciones ++;

                                // muestro posiciones

                                System.out.println("Aparece en la posicion " + posicionAparicion);

                                // actualizo posicion a buscar

                                posicionABuscar = posicionAparicion + 1;
                            }

                        }while(posicionABuscar != -1);
                    }

                    break;

                case "D":

                    if (cadenaVacia == true){

                        System.out.println("La cadena actualmente esta vacia");
                    }

                    else{

                        // parto la cadena por espacios

                        String cadenaPartida[] = cadenaLeida.split(" ");

                        // numero de palabras es igual a la longitud del array

                        int numeroPalabras = cadenaPartida.length;

                        // bucle for decreciente para mostrar las palabras en orden inverso

                        for(int i = numeroPalabras - 1 ; i >= 0 ; i--){

                            // el numero de letras es la longitud de la palabra

                            int numeroLetras = cadenaPartida[i].length();

                            // salida por pantalla

                            System.out.println(i + " - " + cadenaPartida[i] + " ( " +  numeroLetras + " letras )");
                        }

                    }

                    break;

                case "E":

                    if (cadenaVacia == true){

                        System.out.println("La cadena actualmente esta vacia");
                    }

                    else{

                        // parto la cadena por espacios

                        String cadenaPartida2[] = cadenaLeida.split(" ");

                        // numero de palabras es la longitud del array

                        int numeroPalabras2 = cadenaPartida2.length;

                        System.out.print("La frase invertida es: ");

                        // bucle for decreciente para mostrar las palabras en orden inverso

                        for(int i = numeroPalabras2 - 1 ; i >= 0 ; i--){

                            System.out.print(cadenaPartida2[i] + " ");
                        }

                        System.out.println(""); // salto de linea
                    }

                    break;

                case "F":

                    // salir del programa

                    System.out.println("Has seleccionado salir del programa");

                    break;

                default:

                    // si la opcion es incorrecta

                    System.out.println("La opcion es incorrecta, por favor selecciona una correcta");

            }

            // control cadena vacia por si seleccionamos una opcion sin haber introducido cadena

            if (cadenaLeida.isEmpty() == true){

                System.out.println("no has introducido ninguna cadena, por favor vuelva a seleccionar la opcion A e introduce una");
            }


        }while(!opcion.equals("F"));

        sc.close();
    }
}
