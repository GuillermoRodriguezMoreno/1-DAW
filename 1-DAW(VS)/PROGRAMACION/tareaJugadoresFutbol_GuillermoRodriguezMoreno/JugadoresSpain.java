package tareaJugadoresFutbol_GuillermoRodriguezMoreno;

import java.util.Arrays;
import java.util.Scanner;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.clases.Jugador;
import tareaJugadoresFutbol_GuillermoRodriguezMoreno.comparators.JugadorComparatorApodos;
import tareaJugadoresFutbol_GuillermoRodriguezMoreno.comparators.JugadorComparatorNumeroFaltas;
import tareaJugadoresFutbol_GuillermoRodriguezMoreno.comparators.JugadorComparatorNumeroGoles;
import tareaJugadoresFutbol_GuillermoRodriguezMoreno.util.UtilesJugadores;

public class JugadoresSpain {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Jugador j1 = new Jugador("Iker Casillas", "Grande",0, 1);
        Jugador j2 = new Jugador("David Villa", "Pulga",7, 2);
        Jugador j3 = new Jugador("Jordi Alba", "Raton", 2, 10);
        Jugador j4 = new Jugador("Carles Puyol", "Pulga", 1,8);
        Jugador j5 = new Jugador("Xavi hernandez", "Mago", 3, 8);
        Jugador j6 = new Jugador("Gerard Pique", "Cabeza", 0, 8);
        Jugador j7 = new Jugador("Pedro Rodriguez", "Pantera", 4, 2);

        Jugador[] equipo = {j1, j2, j3, j4, j5, j6, j7};

        System.out.println(Arrays.toString(equipo));

        // ordenamos por numero de licencia
        System.out.println("--------- Ordenamos por licencia -------------\n");

        Arrays.sort(equipo); 

        System.out.println(Arrays.toString(equipo));

        // ordenamos por apodo
        System.out.println("--------- Ordenamos por apodo -------------\n");

        Arrays.sort(equipo, new JugadorComparatorApodos());

        System.out.println(Arrays.toString(equipo));

        // ordenamos por numero de goles (asc)
        System.out.println("--------- Ordenamos por goles -------------\n");

        Arrays.sort(equipo, new JugadorComparatorNumeroGoles());

        System.out.println(Arrays.toString(equipo));

        // ordenamos por numero de faltas (asc)
        System.out.println("--------- Ordenamos por faltas -------------\n");

        Arrays.sort(equipo, new JugadorComparatorNumeroFaltas());

        System.out.println(Arrays.toString(equipo));

        // comprobacion del extra

        System.out.println("----------- extra ------------\n");

        // Genero equipo aleatorio

        Jugador[] equipoAleatorio = generaEquipoAleatorio();

        System.out.println(Arrays.toString(equipoAleatorio));

        System.out.println("\n--------- comprobacion de insertar ------\n");

        equipoAleatorio = insertarJugador(equipoAleatorio, j7);
        equipoAleatorio = insertarJugador(equipoAleatorio, j2);
        equipoAleatorio = insertarJugador(equipoAleatorio, j7);

        System.out.println(); // salto linea

        Arrays.sort(equipoAleatorio, new JugadorComparatorApodos());

        System.out.println(Arrays.toString(equipoAleatorio));


    }

    // Funciones

    /**
     * Genera un equipo de jugadores aleatorio con el tamaño dado
     * @param equipo
     * @param jugador
     * @return
     */

    static Jugador[] generaEquipoAleatorio(){

        System.out.println("De que tamaño quieres el equipo?\n");

        int tamaño = sc.nextInt();

        System.out.println(); // salto linea

        Jugador[] equipoAleatorio = new Jugador[tamaño];

        boolean control;

        do{

            for (int i = 0; i < equipoAleatorio.length; i++) {

                Jugador jugadorAleatorio = UtilesJugadores.generaJugadorAleatorio();
    
                equipoAleatorio[i] = jugadorAleatorio;
    
            }

            control = equipoCorrecto(equipoAleatorio);

        }while(!control); // mientras haya jugadores repetidos en el equipo

        return equipoAleatorio;
    }

    /**
     * Inserta un jugador si no esta repetido en el array de Jugador
     * @param equipo
     * @param jugador
     * @return
     */

    public static Jugador[] insertarJugador(Jugador[] equipo, Jugador jugador){

        // si el jugador no se encuentra ya en el array
        if(comprobarJugador(equipo, jugador) == false){

            Jugador[] nuevoEquipo = new Jugador[equipo.length + 1];

            for (int i = 0; i < equipo.length; i++) {
                
                nuevoEquipo[i] = equipo[i];

            }

            nuevoEquipo[nuevoEquipo.length - 1] = jugador;

            System.out.println("Añadido con exito");

            return nuevoEquipo;

        }

        // si el jugador ya se encuentra en el array
        else{

            System.out.println("no es posible añadir jugador repetido");

            return equipo;
        }
    }

    /**
     * Comprueba que el jugador no se encuentra en el array
     * @param equipo
     * @param jugador
     * @return
     */

    public static boolean comprobarJugador(Jugador[] equipo, Jugador jugador){

        boolean repetido = false;

        for (int i = 0; i < equipo.length; i++) {

            //si los nombres son iguales
            if(equipo[i].getNombreCompleto().equals(jugador.getNombreCompleto())){

                repetido = true;

                return repetido;
            }
        }

        return repetido;
    }

    /**
     * comprueba que no hay jugadores repetidos en el equipo
     * @param equipo
     * @return
     */

    static boolean equipoCorrecto(Jugador[] equipo){

        boolean ok =  true;

        for (int i = 0; i < equipo.length; i++) {
            
            for (int j = i+1; j < equipo.length; j++) {
                
                if(equipo[i].getNombreCompleto().equals(equipo[j].getNombreCompleto())){

                    ok = false;

                    return ok;
                }
            }
        }

        return ok;
    }

}
