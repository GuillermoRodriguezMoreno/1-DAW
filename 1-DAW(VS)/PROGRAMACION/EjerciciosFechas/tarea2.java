package EjerciciosFechas;

import java.util.Scanner;

public class tarea2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("indica el nombre del jugador atacante");

        String jugadorAtacante = sc.nextLine();

        System.out.println("indica el nombre del jugador defensor");

        String jugadorDefensor = sc.nextLine();

        System.out.println("indica el % de acierto de 2");

        double porcentajeAciertoDos = sc.nextDouble();

        System.out.println("indica el % de acierto de 3");

        double porcentajeAciertoTres = sc.nextDouble();

        System.out.println("numero de veces de defensas (entre 0 y 10)");

        int defensas = sc.nextInt();

        System.out.println("atacante tira de 2 o de 3");

        int tiro = sc.nextInt();

        double probCanasta = 0.0;
        double probDefensa = Math.random() * defensas * 10;

        if (tiro < 3){

            probCanasta = Math.random() * porcentajeAciertoDos;

        }else probCanasta = Math.random() * porcentajeAciertoTres;

        if (probCanasta > probDefensa){

            System.out.println("el jugador " + jugadorAtacante + " ha encestado de "
            + tiro + " sobre el jugador " + jugadorDefensor + "(" + probCanasta + " > " + 
            probDefensa + ")");

        }else{

            System.out.println("el jugador " + jugadorAtacante + " No ha encestado contra el jugador "
            + jugadorDefensor + "(" + probCanasta + " < " + 
            probDefensa + ")");

        }
        /* 
        // FORMA 1 (BRUTA)  
        boolean meteDe2 = (Math.random()*porcentajeAciertoDos) > (Math.random() * defensas * 10);
        boolean meteDe3 = (Math.random()*porcentajeAciertoTres) > (Math.random() * defensas * 10);
        sc.close();
        
        // FORMA 2 (ELEGANTE)
        int porcentajeAtaque = (tiro == 2) ? porcentajeAciertoDos : porcentajeAciertoTres;
        */
    }
}
