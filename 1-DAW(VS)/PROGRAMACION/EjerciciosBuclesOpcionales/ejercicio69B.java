package EjerciciosBuclesOpcionales;

import java.util.Scanner;

public class ejercicio69B {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce la altura, 3 o mayor");

        int altura = sc.nextInt();

        for (int i = 1 ; i <= altura ; i++){ //bucles lineas

            for (int k = 1 ; k <= altura - i ; k ++){ //bucles espacios blanco

                System.out.print(" ");
            }

            for (int j = 1 ; j <= 4 + (i*2) ; j++){ //bucle dentro piramide

                if (i%2 != 0) System.out.print("*"); // si es impar pinta solo asteriscos

                else{

                    if((j <= i) || (j > i + 4)) System.out.print("*"); // pinta asteriscos o espacios en blanco

                    else System.out.print(" ");
                }      
            }

            System.out.println(""); // salto de linea
        }
        sc.close();
    }
}