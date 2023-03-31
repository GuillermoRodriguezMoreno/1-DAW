package colecciones;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio6 {
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        HashMap <String, String> claves = new HashMap<>();

        claves.put("root", "1234");
        claves.put("admin", "sklfgh");

        boolean contraseñaCorrecta = false;
        int intentos = 0;

        do{

            System.out.println("usuario?");

            String usuarioIntroducido = sc.nextLine();

            System.out.println("Constraseña");

            String passIntroducido = sc.nextLine();

            if(claves.containsKey(usuarioIntroducido)){

                
            }

        }while(!contraseñaCorrecta && intentos < 3);
    }
}
