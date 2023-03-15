package tareaJugadoresFutbol_GuillermoRodriguezMoreno.util;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.Jugador;

public class UtilesJugadores {
    
    // Metodos

    /**
     * Genera un jugador con nombre y mote aleatorio
     * @return
     */

    public static Jugador generaJugadorAleatorio(){

        Jugador jugadorAleatorio = new Jugador(generarNombreAleatorio(), generarMoteAleatorio());

        return jugadorAleatorio;

    }

    /**
     * Inserta un jugador si no esta repetido en el array de Jugador
     * @param equipo
     * @param jugador
     * @return
     */

    public static Jugador[] insertarJugador(Jugador[] equipo, Jugador jugador){

        // si el jugador no se encuentra ya en el array
        if(comprobarJugador(equipo, jugador) == true){

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

        boolean ok = true;

        for (int i = 0; i < equipo.length; i++) {

            //si los nombres son iguales
            if(equipo[i].getNombreCompleto().equals(jugador.getNombreCompleto())){

                ok = false;
            }
        }

        return ok;
    }

    /**
     * Genera un nombre completo aleatorio
     * @return
     */

    public static String generarNombreAleatorio(){

        String nombre = "";

        String[] nombres = {"Juan", "Pedro", "María", "Ana", "Luis", "Carlos", "Sofía", "Lucía", "Elena", "Miguel"};
        String[] apellidos = {"García", "Fernández", "Martínez", "González", "Pérez", "López", "Ruiz", "Sánchez", "Hernández", "Jiménez"};

        int random1 = (int) (Math.random() * nombres.length);
        int random2 = (int) (Math.random() * apellidos.length);

        nombre = nombres[random1] + " " + apellidos[random2];

        return nombre;
    }

    /**
     * Genera un mote aleatorio
     * @return
     */

    public static String generarMoteAleatorio(){

        String mote = "";

        String[] apodo1 = {"Grande", "Pulga", "Raton", "Mago", "La roca", "Titan", "Cabeza", "Jardinero", "Carnicero", "Muñeco", "Burro", "Pantera"};
        String[] apodo2 = {"de Oro", "de los mares", "de Mijas", "de Titanio", "loca", "Blanco", "Negro"};

        int random1 = (int) (Math.random() * apodo1.length);
        int random2 = (int) (Math.random() * apodo2.length);

        mote = apodo1[random1] + " " + apodo2[random2];

        return mote;
    }
}
