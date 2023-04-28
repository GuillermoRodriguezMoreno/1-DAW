package Funciones;
/*  
 *  NO COMPILA
 *  No consigo entender la funcion canasta(turno)
 */



/* comentarios propios:

 * funcion canasta (turno), se le pasa el turno para saber que porcentaje usar
 * 1- saber que tipo de tiro va a ocurrir mediante funcion int tipoTiro = tipoTiro(turno)
 * 2- boolen hayCanasta = canasta(turno, tipoTiro) devolvera 0 si falla, 2 si mete de 2 y 3 si mete de 3
 * 3- if (hayCanasta){ int resultado = tipoTiro}
 * 
 * la funcion canata(turno, tipoTiro) llamara a la ultima funcion canasta(%tiro)
 * 
 * seria canasta(turno) -> canasta(turno, tipoTiro) -> canasta(%tiro)
 */


/* apuntes:
 * 
 * canasta(String equipo, int tipoTiro){
 * 
 *  boolean canasta = false;
 * 
 *  if (turno == e1 && tipoTiro == 2){
 * 
 *      int aleatorio = aleatorio(100);
 *      
 *      canasta = (aleatorio < equipo1.acierto2)
 * }
 * 
 *      hacer 4 elseif con las posibilidades equipo1 tiro 2, equipo1 tiro3, equipo2 tiro2, equipo2 tiro3
 *}
 */

public class PartidoBaloncesto {
    
    //Variables de los equipos

    final static int E1_ACIERTO_2 = 70;
    final static int E2_ACIERTO_2= 75;

    final static int E1_ACIERTO_3 = 45;
    final static int E2_ACIERTO_3 = 35;

    final static int E1_JUEGA_DE_2 = 60;
    final static int E2_JUEGA_DE_2 = 70;

    final static int E1_REBOTE_DEF = 60;
    final static int E1_REBOTE_ATA = 30;

    final static int E2_REBOTE_DEF = 70;
    final static int E2_REBOTE_ATA = 40;

    public static void main(String[] args) {
        
        int puntosE1 = 0;
        int puntosE2 = 0;

        System.out.println("Empieza la simulación del partido de baloncesto");

        //salto Inicial

        //String turno  = salto();

        System.out.println("Ataca el equipo: " + turno);

        //Un partido de baloncesto hay unas 150 posesiones de media.

        for(int posesion = 0; posesion < 150; posesion++){

            int valorAtaque = canasta(turno);
            
            //Si hay canasta entonces el turno es del equipo que estaba defendiendo

            if (valorAtaque>0){

                if (turno.equals("E1")){

                    puntosE1 = actualizarPuntos(puntosE1, valorAtaque);

                }

                else {
                
                    puntosE2 = actualizarPuntos(puntosE2, valorAtaque);

                }

                System.out.println("Canasta de " + turno + " - de " + valorAtaque + " puntos");

                imprimirResultado(puntosE1, puntosE2);

                turno = siguienteTurno(turno);

                System.out.println("Ataca el equipo: " + turno);

            }

            else {

                //no hay canasta, se  produce un rebote

                turno = rebote(turno);

                System.out.println("Rebote del equipo: " + turno);

            }

            //si hay empate doy 40 posesiones mas

            if (posesion== 149 && puntosE1 == puntosE2){

                System.out.println("EMPATE --- Hay Prorroga");

                posesion= 100;

            }

        }

        System.out.println("-------------------------");

        System.out.println("FIN de partido");

        imprimirResultado(puntosE1, puntosE2);

        System.out.println(" **** GANA EL EQUIPO: " + (puntosE1>puntosE2 ? "E1": "E2"));

    }



        //Funciones que necesito programar
        /*
        XX - salto() --> devuelve E1 si el salto lo gana E1 y E2 si el salto lo gana E2
        canasta(equipo) --> devuelve el valor de la canasta realizada (0, 2 o 3) 
        XX - actualizarPuntos(equipo, valor)  
        XX - canasta(turno, tipoTiro) ---> dado un turno y el tipo de tiro devuelve true si hay canasta y false si no     
        XX - canasta(porcentaje) ---> indica si hay canasta según el porcentaje -- Hay canasta si el aleatorio generado es mayor a 50;
        XX - tipoTiro(turno) --> devuelve el tipo de tiro que va a realizar el equipo que tiene el turno(tiro2 o tiro3)
        XX - tipoTiro(int porcentaje2) -> devuelve el tipo de tiro que se produce según el porcentaje indicado  (se genera un numero entre 0 y 100 y según el valor de X_JUEGA_DE_2 elegir que tipo de tiro hace)
        XX - rebote(String equipoAtaque) ---> devuelve E1 si el rebote lo gana E1 y E2 si el rebote lo gana E2
        XX - rebote(int reboteAtaque, int reboteDefensa) ---> indica true si el rebote es de ataque y false si el rebote es de defensa
             El rebote del equipo atacante es de 0 a maximo y el rebote del equipo que defiende es de 30 al maximo. El que saque más será el ganador del rebote
        XX - aleatorio(maximo)--> devuelve un numero aleatorio entre 0 y maximo
        XX - aleatorio(minimo, maximo) ---> devuelve un número entre mínimo y máximo
        XX - imprimirResultado(int valor1, int valor2) ---> imprime el resultado actual del partido.
        */
    
        
        /**
         * Devuelve 0,2 o 3 dependiendo si el equipo que ataca consigue canasta o no y según el tipo
         * @param equipoAtaca
         * @return
         */

        static int canasta(String equipoAtaca){

            int resultado = 0;

            int tipoTiro = tipoTiro(equipoAtaca);

            return resultado;

        }

        // devuelve si se encesta canasta segun el tipo de tiro

        // Hecho XxX

        static boolean canasta(String equipo, int tipoTiro){

            boolean canasta = false;

            if (equipo.equals("E1")){

                if(tipoTiro == 2){

                    canasta = canasta(70);

                }else{

                    canasta = canasta(45);

                }


            }else{

                if(tipoTiro == 2){

                    canasta = canasta(75);

                }else{

                    canasta(35);

                }

            }

            return canasta;
        }


        /**
         * Devuelve 2 si intenta tirar de 2 y 3 si intenta tirar de 3
         * Se genera un numero aleatorio de 0 a 100 y si es mayor al porcentajeTiro2 entonces el tiro es de 3
         * @param porcentajeTiro2
         * @return
         */

        // Hecho XxX

        static int tipoTiro(int porcentajeTiro2){

            int tiro = 0;

            int prob = aleatorio(100);

            if (prob > porcentajeTiro2){

                tiro = 3;

            } else {

                tiro = 2;
            }

            System.out.println("    Tira de " + tiro);

            return tiro;
        }

        // Hecho XxX

        static int tipoTiro(String turno){

            int tipoTiro = 0;

            if (turno.equals("e1")){

                tipoTiro = tipoTiro(E1_JUEGA_DE_2);

            }else{

                tipoTiro = tipoTiro(E2_JUEGA_DE_2);

            }

            return tipoTiro;

        }

        /**
         * Devuelve true si hay canasta y false en caso contrario
         * @param porcentajeAcierto
         * @return
         */

        // Hecho XxX

        static boolean canasta(int porcentajeAcierto){

            boolean canasta = false;

            canasta = (aleatorio(porcentajeAcierto) > 50);

            return canasta;
        }

        /**
         * Devuelve el equipo que gana el sato inicial, utilizando dos numeros aleatorios entre o y 100
         * Utiliza la funcion rebote
         * @return
         */

        /*
        * He usado una probabilidad de 0 a 100 para que ambos equipos esten en igualdad de condiciones
        */

        // Hecho XxX

        // static String salto(){   

        //     String resultado = "E1";

        //     int probE1 = aleatorio(100);
            
        //     int probE2 = aleatorio(100);

        //     if (probE1 > probE2){

        //         resultado = "E1";
        //     }

        //     //else (probE2 >= probE1){

        //         resultado = "E2";
        //     }

        //     return resultado;
        // }

        /**
         * Devuelve un mumero entero aleatorio entre 0 y maximo
         * @param maximo
         * @return
         */

         // Hecho XxX

        static int aleatorio(int maximo){

            int resultado = (int) (Math.random() * (maximo + 1));

            return resultado;
        }

        /**
         * Devuelve un numero entero aleatorio entre minimo y maximo
         * @param maximo
         * @param minimo
         * @return
         */

         // Hecho XxX

        static int aleatorio(int minimo, int maximo){

            int resultado = (int) (Math.random() * (maximo - minimo) + minimo);

            return resultado;
        }

        /**
         * Devuelve el equipo que consigue obtener el rebote de un tiro.
         * @param equipoAtaca
         * @return
         */

        // Hecho XxX

        static String rebote(String equipoAtaca){

            String rebotePara = "E1";

            boolean rebote;

            if (equipoAtaca.equals("E1")){

                rebote = rebote(30, 70);

                if(rebote == false){

                    rebotePara = "E2";
                }

            } else {

                rebote = rebote(40, 60);

                if(rebote == true){

                    rebotePara = "E2";
                }
            }

            return rebotePara;
        }


        /**
         * Devuelve true si el rebote se lo lleva el equipo atacante y false si se lo lleva el equipo defensor
         * El rebote del equipo atacante es de 0 a maximo y el rebote del equipo que defiende es de 30 al maximo. 
         * El que saque más será el ganador del rebote
         * @param porcentajeAtaque
         * @param porcentajeDefensa
         * @return
         */

        // Hecho XxX

        static boolean rebote(int porcentajeAtaque, int porcentajeDefensa){

            boolean ganaRebote = false;

            int probAtaque = aleatorio(porcentajeAtaque, 0);

            int probDefensa = aleatorio(porcentajeDefensa, 30);
            
            if (probAtaque >= porcentajeDefensa){

                ganaRebote = true;

            }
            
            return ganaRebote;
        }

        /**
         * Devuelve el equipo contrario al que se le pasa por parametros
         * @param equipo
         * @return
         */

        // Hecho XxX

        static String siguienteTurno(String equipo){

            String resultado = "E1";

            if (equipo.equals("E1")){

                resultado = "E2";
            }
            
            return resultado;

        }

        // Hecho XxX

        static int actualizarPuntos(int puntosTotalesEquipo, int puntosCanasta){

            int puntosTotales = puntosTotalesEquipo + puntosCanasta;

            return puntosTotales;

        }

        // Imprime ganador del partido

        // Hecho XxX

        static void imprimirResultado(int puntosEquipo1, int puntosEquipo2){

            String ganador = "El ganador es el equipo1";

            System.out.println("Puntos equipo1: " + puntosEquipo1);
            System.out.println("Puntos equipo2: " + puntosEquipo2);

            if(puntosEquipo1 < puntosEquipo2){

                ganador = "El ganador es el equipo2";
            }

            System.out.println(ganador);

        }

}
