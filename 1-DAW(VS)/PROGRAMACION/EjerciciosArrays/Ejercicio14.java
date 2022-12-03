package EjerciciosArrays;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String palabra = "";

        String []palabras = new String[8];
        String []colores = {"verde", "rojo", "azul", "amarillo", "naranja", "rosa", "negro", "blanco", "morado"};
        String []auxColores = new String[8];
        String []auxPalabras = new String[8];

        int contadorColores = 0;

        System.out.println("introduce 8 palabras.");

        //introduzco 8 palabras en el array

        for (int posicionPalabra = 0; posicionPalabra <= 7; posicionPalabra ++){

            palabra = sc.nextLine();

            palabras[posicionPalabra] = palabra;

            // recorro array color

            for (int posicionColor = 0; posicionColor <= 7; posicionColor ++){

                // si la palabra es un color lo almaceno en el array auxiliar de  colores

                if (palabra.equalsIgnoreCase(colores[posicionColor])){

                    contadorColores ++;

                    auxColores[posicionPalabra] = palabra;

                }

            }
            
        }

        for (int indice = 0 ; indice <= 7 ; indice ++){

            palabra = palabras[indice];

            for (int i = 0 ; i <= 7 ; i ++){

                if(!palabra.equalsIgnoreCase(colores[i])){
                
                    auxColores[contadorColores] = palabra;
                }

            }
        }

        for (String palabraOrdenadas : auxColores) {

            System.out.print(palabraOrdenadas + " // ");
            
        }

        sc.close();

    }

}