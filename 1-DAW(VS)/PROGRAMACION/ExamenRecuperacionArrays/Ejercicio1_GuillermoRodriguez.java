package ExamenRecuperacionArrays;

import java.util.Scanner;

public class Ejercicio1_GuillermoRodriguez {

    // variables staticas

    static String[] jugadores = {"Pepe", "Juan", "Sara", "Javi"};

    static int[][] tarjetaGolpes = new int[4][9];

    static int[] totalGolpes = new int[4];
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int numeroGolpes = 0;

        imprimirTarjeta();

        // recorro hoyos
        for (int numeroHoyo = 0; numeroHoyo < tarjetaGolpes[0].length; numeroHoyo++) {

            System.out.println("\npresiona una tecla"); 

            sc.nextLine(); // pido entrada

            // recorro jugadores
            for (int i = 0; i < tarjetaGolpes.length; i++) {
                
                numeroGolpes = (int) (Math.random() * 4 + 1); //aleatorio de 1 a 4

                //le doy valor a cada jugador en el hoyo actual
                tarjetaGolpes[i][numeroHoyo] = numeroGolpes;

                System.out.println(jugadores[i] + " - " + numeroGolpes + " golpes dados");
                
            }

            System.out.println(); // salto linea

            //sumo el numero total de golpes y los introduzco en la lista de golpes totales
            sumarGolpes();

            // ordeno la tarjeta
            ordenarTarjeta();

            // imprimo tarjeta
            imprimirTarjeta();

        }

        
    }


    /**
     * imprime la tarjeta de juego
     */
    
    static void imprimirTarjeta(){

        System.out.println(); // salto linea

        //recorro jugadores
        for (int i = 0; i < tarjetaGolpes.length; i++) {

            System.out.print(jugadores[i]);

            //recorro hoyos
            for (int j = 0; j < tarjetaGolpes[i].length; j++) {
                
                System.out.print(" | " + tarjetaGolpes[i][j] + " | ");

            }

            // imprimo la suma total de golpes de segun jugador
            System.out.println("suma total: " + totalGolpes[i]);
        }
    }

    /**
     * suma los golpes totales de cada hoyo
     */

    static void sumarGolpes(){

        int sumaGolpes = 0; // acumulador

        // jugadores
        for (int i = 0; i < tarjetaGolpes.length; i++) {

            sumaGolpes = 0; // reseteo cada vez que cambia de jugador

            // hoyos
            for (int j = 0; j < tarjetaGolpes[i].length; j++) {

                // actualizo acumulador
                sumaGolpes = sumaGolpes + tarjetaGolpes[i][j];
                
            }

            // añado el valor a la lista de golpesTotales
            totalGolpes[i] = sumaGolpes;
        }

    }

    static void ordenarTarjeta(){

        // variables auxiliares
        int auxInt = 0;
        String auxString = "";

        // recorro la lista de golpes totales
        for (int i = 0; i < totalGolpes.length; i++) {

            // vuelvo a recorrer la lista por cada valor empezando en su posicion + 1
            for (int j = i+1; j < totalGolpes.length; j++) {
                
                // si encuentro un valor menor
                if(totalGolpes[i] > totalGolpes[j]){

                    // intercambio de posiciones de lista de golpes totales
                    auxInt = totalGolpes[i];
                    totalGolpes[i] = totalGolpes[j];
                    totalGolpes[j] = auxInt;

                    // el cambio en la lista de golpes totales
                    // implica un cambio en la posicion de la lista de jugadores
                    auxString = jugadores[i];
                    jugadores[i] = jugadores[j];
                    jugadores[j] = auxString;

                }
            }
            
        }
    }
}
