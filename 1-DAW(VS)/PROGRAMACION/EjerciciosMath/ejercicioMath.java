package EjerciciosMath;

public class ejercicioMath {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        /*
         * 3 jugadores tiran un dado, muestra la tirada de cada
         * uno de ellos y quien ha sacado el numero mayor
         */

         int swap = 0;

         int jugador1 = (int)Math.floor(Math.random()*(6-1+1)+1);
         int jugador2 = (int)Math.floor(Math.random()*(6-1+1)+1);
         int jugador3 = (int)Math.floor(Math.random()*(6-1+1)+1);
         
        System.out.println(jugador1 + " " + jugador2 + " " + jugador3);

         swap = Math.max(jugador2, jugador3);

         System.out.println(Math.max(jugador1, swap));


    }
}
