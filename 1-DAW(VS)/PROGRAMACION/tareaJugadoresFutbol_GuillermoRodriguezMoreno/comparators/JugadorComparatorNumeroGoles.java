package tareaJugadoresFutbol_GuillermoRodriguezMoreno.comparators;

import java.util.Comparator;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.clases.Jugador;

public class JugadorComparatorNumeroGoles implements Comparator<Jugador>{

    @Override
    public int compare(Jugador arg0, Jugador arg1) {

        Jugador j1 =  arg0;
        Jugador j2 =  arg1;

        int resultado = 0;

        if(j1.getNumeroGoles() > j2.getNumeroGoles()){

            resultado = 1;
        }

        else if(j1.getNumeroGoles() < j2.getNumeroGoles()){

            resultado = -1;
        }

        else{

            resultado = j1.getNombreCompleto().compareTo(j2.getNombreCompleto());
        }
        
        return resultado;
    }
    
}
