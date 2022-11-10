package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un numero");

        int termino = sc.nextInt();

        int num1 = 0;
        int num2 = 1;
        int num3 = 0;

        if(termino == 1) System.out.print("0");

        else if (termino == 2) System.out.println("0, 1");

        else{
        
            System.out.print("0, 1 ");

            for (int i = 0; i < termino - 2; i++){

                num3 = num1 + num2;
                num1 = num2;
                num2 = num3;

                System.out.print(", " + num3);

            }
        }

        sc.close();
    }
}
