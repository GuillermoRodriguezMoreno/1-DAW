package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio18 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int num1, num2;

        do{

            System.out.println("introduce un numero");

            num1 = sc.nextInt();

            System.out.println("introduce el otro numero distinto");

            num2 = sc.nextInt();

            if (num1 == num2) System.out.println("deben ser distintos");

        } while (num1 == num2);

        int numMasSiete = 0;

        int numMin = Math.min(num1, num2);
        int numMax = Math.max(num1, num2);

        numMasSiete = numMin;

        while(numMasSiete <= numMax){


            System.out.println(numMasSiete);

            numMasSiete = numMasSiete + 7;

        }
        sc.close();
    }
}
