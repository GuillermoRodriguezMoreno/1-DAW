package EjerciciosMath;

import java.util.Scanner;

public class ejercicio1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce el numero");
        
        float numero = sc.nextFloat();

        System.out.println(Math.abs(numero));

        sc.close();
    }
}
