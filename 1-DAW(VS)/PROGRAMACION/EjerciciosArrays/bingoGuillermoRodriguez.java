package EjerciciosArrays;

import java.util.Scanner;

public class bingoGuillermoRodriguez {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Declaracion variables
        
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];

        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8}; // array [9][3]

        int[] numerosGenerados = new int[0]; // lista numeros sacados array[0]
        
        boolean salir = true; //variable para controlar si salimos del programa o jugamos otro cartón

        do{

            // Crear/Restaurar carton vacio y vaciado de numeros generados en el juego anterior

            carton = limpiarCarton();

            numerosGenerados = limpiarListaNumeros();

            // Colocar 12 espacios en blanco, distribuidos en 4 por cada fila al azar en las columnas

            ponerBlancos(carton);

            // Introduzco los numeros de cada columna

            rellenarNumerosCarton(carton);

            // Pregunto si quiero sacar otra bola o terminar este juego

            boolean jugar = false;

            while(jugar){

                // Saco numero aleatorio NO SE DEBE REPETIR

                // Pinto el carton con numeros sacados

                int numeroAciertos = pintarCarton(carton, numerosGenerados);

                // Eres ganador?

                if(numeroAciertos >= 15){

                    System.out.println("-----------------------------");
                    System.out.println("--------  BINGO -------------");
                    System.out.println("-----------------------------");

                }

                // Pregunto si quiero sacar otra bola o terminar este juego

            }

            // Pregunto si quiero jugar otro carton  o salir definitivamente del programa

        }while(!salir);

    }

    // Limpiar carton

    static int[][] limpiarCarton(){

        int[][] nuevoCarton = new int[9][3];

        return nuevoCarton;

    }
    
    // Limpiar lista de numeros generdos

    static int[] limpiarListaNumeros(){

        int[] numerosGenerados = new int[0];

        return numerosGenerados;

    }

    // Poner espacios en blancos

    static void ponerBlancos(int[][]carton){

        for(int fila = 0; fila < 3; fila ++){

            for(int i = 1; i <= 4; i++){

                boolean repetido = false;

                while(repetido == false){

                int aleatorio = (int) Math.random();

                    for(int posicionEnfila = 0; posicionEnfila < carton.length; posicionEnfila ++){

                        if(carton[fila][posicionEnfila] == -1){

                            repetido = true;

                        }else{


                        }
                    }
                }
            }

        }
    }
}


