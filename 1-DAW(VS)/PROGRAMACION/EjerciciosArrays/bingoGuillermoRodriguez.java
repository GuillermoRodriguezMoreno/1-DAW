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
        
        rellenarNumerosCarton(carton);

        imprimirCarton(carton);

    }

    static void ponerBlancos(int[][] carton){

        int blancosColocados = 0;

        while(blancosColocados <= 12){


        }
    }

    static void rellenarNumerosCarton(int[][] carton){

        boolean repetido = false;

        for (int i = 0; i < carton.length; i++) {
            
            for (int j = 0; j < carton[i].length; j++) {

                int aleatorio = (int) (((Math.random() * 10 - 1) + 1) + (i * 10)); // numero aleatorio con la condicion de las columnas

                carton[i][j] = aleatorio;

                }
            }
        }
    

    static int pintarCarton(int[][] carton, int[] numerosGenerados){

        int numeroAciertos = 0;
        return numeroAciertos;
    }

    static void imprimirCarton(int[][] carton){

        for (int i = 0; i < carton.length; i++) {
            
            for (int j = 0; j < carton[i].length; j++) {
                
                System.out.println(carton[i][j] + " ");
                
            }
        }
    }
}


