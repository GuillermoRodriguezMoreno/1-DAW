package EjerciciosCondicional;

import java.util.Scanner;

public class ejercicio28 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("eleccion jugador1?");

        String jugador1 = sc.nextLine();

        System.out.println("eleccion jugador2");

        String jugador2 = "";

        int eleccion2 = (int)(Math.random() * 3);

        switch (eleccion2){

            case 0: jugador2 = "papel";
            break;

            case 2: jugador2 = "piedra";
            break;

            case 1: jugador2 = "tijeras";
            break;
        }

        System.out.println(jugador2);

        String ganador = "";

        if (jugador1.equals(jugador2)) System.out.println("empate");

        else{

            switch (jugador1){

                case "papel":

                    if (jugador2.equals("piedra")) ganador = "jugador1";
                    else if (jugador2.equals("tijeras")) ganador = "jugador2";
                    break;

                case "tijeras":

                    if (jugador2.equals("piedra")) ganador = "jugador2";
                    else if (jugador2.equals("papel")) ganador = "jugador1";
                    break;

                case "piedra":

                    if (jugador2.equals("tijeras")) ganador = "jugador1";
                    else if (jugador2.equals("papel")) ganador = "jugador2";
                    break;
            }

        }System.out.println(ganador);
        sc.close();
}
}