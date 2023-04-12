package colecciones.ejer8_9_12;

import java.util.ArrayList;
import java.util.HashMap;

import colecciones.ejer8_9_12.Carta.valorCarta;

public class Uso {
    
    public static void main(String[] args) {

        int puntos = 0;
        
        ArrayList <Carta> baraja = new ArrayList<>();

        HashMap <valorCarta, Integer> puntuaciones = new HashMap<>();
        puntuaciones.put(valorCarta.AS, 11);
        puntuaciones.put(valorCarta.tres, 10);
        puntuaciones.put(valorCarta.Sota, 2);
        puntuaciones.put(valorCarta.Caballo, 3);
        puntuaciones.put(valorCarta.Rey, 4);

        for (int i = 0; i < 5; i++) {

            Carta carta = new Carta();

            baraja.add(carta);

            if(puntuaciones.containsKey(carta.getValor())){

                puntos = puntos + puntuaciones.get(carta.getValor());
            }

            System.out.println(carta);
            
        }

        System.out.println("tienes " + puntos + " puntos");


    }
}
