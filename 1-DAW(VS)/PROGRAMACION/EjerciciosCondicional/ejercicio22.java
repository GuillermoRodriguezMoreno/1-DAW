package EjerciciosCondicional;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ejercicio22 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        

        System.out.println("introduce dia");
        String dia = sc.nextLine();
        System.out.println("introduce hora");;
        String horaCompleta = sc.nextLine();
        StringTokenizer st = new StringTokenizer(horaCompleta, ":");
        String hora = st.nextToken();
        String min = st.nextToken();  

        
        //String min = sc.next();
        System.out.println(hora + "///" + min);
    }
}
