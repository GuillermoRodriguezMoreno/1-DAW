package EjerciciosMath;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un numero");

        float numero = sc.nextFloat();

        System.out.println("round(redondea): " + Math.round(numero) + " Ceil (redondea hacia arriba): " + Math.ceil(numero) + " floor (trunca) " + Math.floor(numero));
    }
}
