package EjerciciosMath;

import java.util.Scanner;

public class ejercicio2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("introduce la base");

        float base = sc.nextFloat();

        System.out.println("introduce el exponente");

        int exponente = sc.nextInt();

        System.out.println("el resultado de la potencia es: " + Math.pow(base, exponente));
    }
}
