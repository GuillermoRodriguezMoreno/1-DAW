package EjerciciosString;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("introduce un texto");

        String texto = sc.nextLine();

        System.out.println("introduce una posicion");

        int posicion = sc.nextInt();

        String parteIzq = texto.substring(0, posicion);  

        String parteDer = texto.substring(posicion);  
         
        System.out.println(parteIzq + "/" + parteDer);

        sc.close();
    }
}
