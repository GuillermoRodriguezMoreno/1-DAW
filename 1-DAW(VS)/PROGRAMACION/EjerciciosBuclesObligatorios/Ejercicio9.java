package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        
        System.out.println("introduce un numero");

        int num = sc.nextInt();

        while(num < 0){

            System.out.println("introduce un numero positivo");
            num = sc.nextInt();
        }

        int num2 = num;

        int contador = 1;

        while(num2 > 1 && num2 > 9){

            contador ++;

            num2 = num2/10;
        }

        System.out.println("el numero " + num + " tiene " + (contador) + " digitos");

        sc.close();
    }
}
