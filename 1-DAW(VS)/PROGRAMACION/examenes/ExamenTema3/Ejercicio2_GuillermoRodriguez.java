package ExamenTema3;

import java.util.Scanner;

public class Ejercicio2_GuillermoRodriguez {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // variables

        int altura = 0;

        String cadena = "";

        System.out.println("Introduce la altura");

        altura = sc.nextInt();

        sc.nextLine(); // limpiar buffer

        System.out.println("Introduce la cadena");

        cadena = sc.nextLine();

        // añado x a la cadena leida

        cadena = "XX" + cadena + "XX";

        // primer bloque

        for (int lineaPrimerBloque = 1 ; lineaPrimerBloque <= altura ; lineaPrimerBloque ++){

            // si la linea es par

            if (lineaPrimerBloque%2 == 0){

                // ancho tiene longitud de la cadena

                for(int ancho = 1 ; ancho <= (cadena.length()) ; ancho ++){

                    System.out.print("H");
                    
                    }

            // si la linea no es par

            }else{

                for(int ancho = 1 ; ancho <= (cadena.length()) ; ancho ++){

                System.out.print("A");

                }
            }

            System.out.println(""); // salto de linea

        }

        // imprimo cadena

        System.out.println(cadena);

        // seguno bloque

        for (int lineaSegundoBloque = 1 ; lineaSegundoBloque <= altura ; lineaSegundoBloque ++){

            // si la linea es par

            if (lineaSegundoBloque%2 == 0){

                for(int ancho = 1 ; ancho <= (cadena.length()) ; ancho ++){

                    System.out.print("H");
                    
                    }

            // si la linea no es par

            }else{

                for(int ancho = 1 ; ancho <= (cadena.length()) ; ancho ++){

                System.out.print("A");

                }
            }

            System.out.println(""); // salto de linea

        }

        sc.close();
    }
}
