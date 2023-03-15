package tareaJugadoresFutbol_GuillermoRodriguezMoreno;

import java.util.Arrays;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.interfaces.JugadorComparatorNumeroFaltas;
import tareaJugadoresFutbol_GuillermoRodriguezMoreno.interfaces.JugadorComparatorNumeroGoles;
import tareaJugadoresFutbol_GuillermoRodriguezMoreno.util.UtilesJugadores;

public class JugadoresSpain {
    
    public static void main(String[] args) {
        
        Jugador j1 = new Jugador("Iker Casillas", "Grande",0, 1);
        Jugador j2 = new Jugador("David Villa", "Pulga",7, 2);
        Jugador j3 = new Jugador("Jordi Alba", "Raton", 2, 10);
        Jugador j4 = new Jugador("Carles Puyol", "Peluca", 1,8);
        Jugador j5 = new Jugador("Xavi hernandez", "Mago", 3, 4);
        Jugador j6 = new Jugador("Gerard Pique", "Cabeza", 0, 8);
        Jugador j7 = new Jugador("Pedro Rodriguez", "Pantera", 4, 2);

        Jugador[] equipo = {j1, j2, j3, j4, j5, j6, j7};

        System.out.println(Arrays.toString(equipo));

        // ordenamos por numero de licencia
        Arrays.sort(equipo); 

        System.out.println(Arrays.toString(equipo));

        // ordenamos por numero de goles (asc)
        Arrays.sort(equipo, new JugadorComparatorNumeroGoles());

        System.out.println(Arrays.toString(equipo));

        // ordenamos por numero de faltas (asc)
        Arrays.sort(equipo, new JugadorComparatorNumeroFaltas());

        System.out.println(Arrays.toString(equipo));

        // comprobacion del extra

        System.out.println("----------- extra ------------");

        // comprobar que jugadorAleatorio se generan correctamente

        Jugador[] equipo2 = new Jugador[0];

        for (int i = 0; i < 50; i++) {

            Jugador j = UtilesJugadores.generaJugadorAleatorio();
            
            equipo2 = UtilesJugadores.insertarJugador(equipo2, j);
        }

        // comprobar que insertar funciona correctamente

        System.out.println(Arrays.toString(equipo2));

        System.out.println(equipo2.length);


    }
}
