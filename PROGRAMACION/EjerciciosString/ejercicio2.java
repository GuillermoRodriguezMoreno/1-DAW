package EjerciciosString;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un texto");

        String texto = sc.nextLine();

        System.out.println("introduce un numero");

        int posicion = sc.nextInt();

        boolean control = posicion < texto.length();

        char caracterBuscado = control ? texto.charAt(posicion) : ' ';

        System.out.println(caracterBuscado);
        

        sc.close();
    }
}