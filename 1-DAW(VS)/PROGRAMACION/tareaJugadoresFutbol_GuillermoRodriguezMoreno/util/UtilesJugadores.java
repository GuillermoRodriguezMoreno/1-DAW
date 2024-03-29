package tareaJugadoresFutbol_GuillermoRodriguezMoreno.util;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.clases.Jugador;

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

    /**
     * Comprueba si un jugador tiene 10 o mas faltas
     * @param equipo
     * @param Jugador
     * @return
     */

    public static boolean comprobarFaltas(Jugador jugador){

        boolean masDiez = false;

            
        if(jugador.getNumeroFaltas() >= 10){

            masDiez = true;

        }

        return masDiez;
    }

}
