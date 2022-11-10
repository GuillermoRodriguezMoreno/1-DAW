package EjerciciosString;

import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un texto");

        String texto = sc.nextLine();

        System.out.println("introduce el caracter a reemplazar");

        String caracter = sc.nextLine();

        System.out.println("introduce el reemplazo");

        String reemplazo = sc.nextLine();

        System.out.println(texto.replace(String.valueOf(caracter), String.valueOf(reemplazo)));

        sc.close();
    }

}
