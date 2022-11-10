package EjerciciosString;

import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        char caracter = sc.nextLine().charAt(0);
        int caracterNuevo = (int)caracter;
        System.out.println(caracterNuevo);
        // faltaria hacer las comparaciones
        sc.close();

    }
}
