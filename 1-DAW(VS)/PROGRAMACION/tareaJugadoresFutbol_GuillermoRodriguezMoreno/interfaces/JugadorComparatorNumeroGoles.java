package tareaJugadoresFutbol_GuillermoRodriguezMoreno.interfaces;

import java.util.Comparator;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.Jugador;

public class JugadorComparatorNumeroGoles implements Comparator{

    @Override
    public int compare(Object arg0, Object arg1) {

        Jugador j1 = (Jugador) arg0;
        Jugador j2 = (Jugador) arg1;

        return j1.getNumeroGoles() - j2.getNumeroGoles();
        
    }
    
}
