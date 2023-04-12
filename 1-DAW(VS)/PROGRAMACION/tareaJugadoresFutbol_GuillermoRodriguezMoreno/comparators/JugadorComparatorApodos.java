package tareaJugadoresFutbol_GuillermoRodriguezMoreno.comparators;

import java.util.Comparator;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.clases.Jugador;

public class JugadorComparatorApodos implements Comparator<Jugador>{

    @Override
    public int compare(Jugador arg0, Jugador arg1) {
        
        int resultado = 0;

        Jugador j1 =  arg0;
        Jugador j2 = arg1;

        resultado = j1.getApodo().compareTo(j2.getApodo());

        if(resultado == 0){

            resultado = j1.getNombreCompleto().compareTo(j2.getNombreCompleto());
        }

        return resultado;
        
    }
}
