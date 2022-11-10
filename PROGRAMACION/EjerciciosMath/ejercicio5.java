package EjerciciosMath;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce el numero de segundos");

        int segundos = sc.nextInt();
        float minutos = segundos/60f;

        System.out.println("minuto " + (int)(Math.ceil(minutos)));
        System.out.println(minutos);
    }
}
