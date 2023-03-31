package ExamenTema2;

import java.util.Scanner;

public class ExamenEj3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("tienes trabajo fijo? s/n"); //responder s = si, responder n = no

        char trabajoFijo = (sc.nextLine()).toLowerCase().charAt(0); //lee caracter s o n

        System.out.println("Tienes cuenta? s/n"); //responder s = si, responder n = no

        char cuenta = (sc.nextLine()).toLowerCase().charAt(0); //lee caracter s o n

        System.out.println("que porcentaje de la hipoteca tienes ahorrado?");

        int porcentaje = sc.nextInt();

        if (((trabajoFijo == 's')&&(cuenta == 's'))||(porcentaje >= 50)){ //posibilidad para trabajo fijo y cuenta en el banco O porcentaje mas 50% (nos dan hipoteca)

            System.out.println("estupendo aqui tienes la hipoteca");

        }else if ((trabajoFijo == 'n')&&(cuenta == 's')&&(porcentaje > 20)){ //posibilidad para no tener trabajo pero si mas del 20% (nos dan hipoteca)

            System.out.println("estupendo aqui tienes la hipoteca");

        }else System.out.println("lo siento no podemos darte la hipoteca"); //cualquiera otra posibilidad la cual no nos da la hipoteca


        sc.close();
    }
}
