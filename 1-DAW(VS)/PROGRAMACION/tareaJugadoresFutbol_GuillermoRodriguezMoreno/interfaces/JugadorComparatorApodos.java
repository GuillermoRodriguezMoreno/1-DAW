package tareaJugadoresFutbol_GuillermoRodriguezMoreno.interfaces;

import java.util.Comparator;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.Jugador;

public class JugadorComparatorApodos implements Comparator{

    @Override
    public int compare(Object arg0, Object arg1) {
        
        int resultado = 0;

        Jugador j1 = (Jugador) arg0;
        Jugador j2 = (Jugador) arg0;

        if(j1.getApodo().compareTo(j2.getApodo()) > 0){

            resultado = 1;
        }

        else if(j1.getApodo().compareTo(j2.getApodo()) < 0){

            resultado = -1;
        }

        return resultado;
        
    }

    
    
}
