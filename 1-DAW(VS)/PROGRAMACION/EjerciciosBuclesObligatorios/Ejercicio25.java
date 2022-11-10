package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio25 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un numero mayor que cero");

        int num, num2;
        num2 = 0;

        do{

            num = sc.nextInt();

        }while(num < 1);

        while(num >= 1){

            num2 = (num2 * 10) + num%10; //modulo de 10 para obtener la ultima cifra, multiplico por 10 para agregar la cifra siguiente

            num = num/10; // recorto una cifra del numero

        }

        System.out.println("el numero introducido es: " + num);
        System.out.println("el numero al reves es: " + num2);

        sc.close();
    }
}
