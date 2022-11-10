package EjerciciosString;

import java.util.Scanner;

public class ejercicio6 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String texto = "En la casa de Juan estaban Pedro, Luis y Mario, todos jugando al Formite";

        System.out.println("quien esta en casa de juan?");

        // MEJOR HACER CON .indexOf()
        
        String respuesta = sc.nextLine();
        respuesta.toLowerCase();
        boolean control = respuesta == "juan" || respuesta == "pedro" || respuesta == "luis" || respuesta == "mario";
        System.out.println(control ? "si esta" : "no esta");
        sc.close();
    }
}
