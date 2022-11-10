package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio33 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce la altura mayor a 3");

        int altura;

        do{ //control altura mayor a 3

            altura = sc.nextInt();
        
        }while(altura <= 3);

        for (int i = 1 ; i <= altura ; i ++){ // recorre lineas

            if (i == altura) System.out.print(" "); //pinta espacios si no es la ultima linea

            else System.out.print("*"); //pinta asterisco si es la ultima linea

            for (int j = 1 ; j <= altura - 2 ; j ++){ 

                if (i == altura) System.out.print("*"); //pinta asterisco si es la ultima linea

                else System.out.print(" "); //pinta espacios si no es la ultima linea

            }

            //pinta ultimo asterisco o nada segun sea la ultima linea o no

            if (i == altura) System.out.println("");

            else System.out.println("*");

        }

        sc.close();
    }
}
