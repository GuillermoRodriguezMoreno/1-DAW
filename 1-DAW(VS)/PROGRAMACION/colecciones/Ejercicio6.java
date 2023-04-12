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

                if(claves.get(usuarioIntroducido).equals(passIntroducido)){

                    contraseñaCorrecta = true;

                }

                else {

                    intentos ++;

                    System.out.println("incorrecto, te quedan " + (3 - intentos) + " intentos");

                }

            }

            else {

                intentos ++;

                System.out.println("incorrecto, te quedan " + (3 - intentos) + " intentos");

            }

        }while(!contraseñaCorrecta && intentos < 3);

        if(contraseñaCorrecta){

            System.out.println("estas dentro");
        }
    }
}
