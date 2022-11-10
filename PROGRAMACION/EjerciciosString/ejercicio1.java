package EjerciciosString;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un texto");

        String texto = sc.nextLine();

        System.out.println("el texto tiene " + texto.length() + " caracteres");
    
        sc.close();
    }
}