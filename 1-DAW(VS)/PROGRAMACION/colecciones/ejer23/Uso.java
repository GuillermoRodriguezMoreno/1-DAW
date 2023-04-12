package colecciones.ejer23;

import java.util.HashMap;

public class Uso {

    private static enum Valor {DAMA, TORRE, ALFIL, CABALLO, PEON};
    
    public static void main(String[] args) {
        
        HashMap<Valor, Integer> puntuaciones = new HashMap<>();

        puntuaciones.put(Valor.DAMA, 9);
        puntuaciones.put(Valor.TORRE, 5);
        puntuaciones.put(Valor.ALFIL, 3);
        puntuaciones.put(Valor.CABALLO, 2);
        puntuaciones.put(Valor.PEON, 1);

        HashMap<Valor, Integer> capturas = new HashMap<>();

        capturas.put(Valor.DAMA, 0);
        capturas.put(Valor.TORRE, 0);
        capturas.put(Valor.ALFIL, 0);
        capturas.put(Valor.CABALLO, 0);
        capturas.put(Valor.PEON, 0);


        int numeroCapturas = (int) (Math.random() * 16);

        int turno = 1;

        int puntos = 0;

        System.out.println("TURNOS " + numeroCapturas);

        while (turno <= numeroCapturas){
            
            int random = (int) (Math.random() * Valor.values().length);

            Valor pieza = Valor.values()[random];

            switch (pieza){

                case DAMA:

                    if(capturas.get(pieza) < 1){

                        turno ++;
                        capturas.put(pieza, capturas.get(pieza) + 1);

                        System.out.println("Capturado un " + pieza);

                        puntos = puntos + 9;

                    }

                    break;

                case TORRE:

                    if(capturas.get(pieza) < 2){

                        turno ++;
                        capturas.put(pieza, capturas.get(pieza) + 1);

                        System.out.println("Capturado un " + pieza);

                        puntos = puntos + 5;

                    }

                    break;

                case ALFIL:

                    if(capturas.get(pieza) < 2){

                        turno ++;
                        capturas.put(pieza, capturas.get(pieza) + 1);

                        System.out.println("Capturado un " + pieza);

                        puntos = puntos + 3;

                    }

                    break;

                case CABALLO:

                    if(capturas.get(pieza) < 2){

                        turno ++;
                        capturas.put(pieza, capturas.get(pieza) + 1);

                        System.out.println("Capturado un " + pieza);

                        puntos = puntos + 2;

                    }

                    break;

                case PEON:

                    if(capturas.get(pieza) < 8){

                        turno ++;
                        capturas.put(pieza, capturas.get(pieza) + 1);

                        System.out.println("Capturado un " + pieza);

                        puntos = puntos + 1;

                    }

                    break;

                default:

            }
            
        }

        System.out.println();
        System.out.println(capturas);
        System.out.println();

        System.out.println("Puntuacion:\n");
        System.out.println("Dama " + capturas.get(Valor.DAMA)*puntuaciones.get(Valor.DAMA) + " puntos");
        System.out.println("Torre " + capturas.get(Valor.TORRE)*puntuaciones.get(Valor.TORRE) + " puntos");
        System.out.println("Alfil " + capturas.get(Valor.ALFIL)*puntuaciones.get(Valor.ALFIL) + " puntos");
        System.out.println("Caballo " + capturas.get(Valor.CABALLO)*puntuaciones.get(Valor.CABALLO) + " puntos");
        System.out.println("Peon " + capturas.get(Valor.PEON)*puntuaciones.get(Valor.PEON) + " puntos");

        System.out.println("\nTotal puntos: " + puntos);
        
    }
}
