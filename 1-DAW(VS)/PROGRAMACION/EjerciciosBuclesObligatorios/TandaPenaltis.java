package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class TandaPenaltis {

    // Funciones

    // Funcion que seleciona una direccion aleaotoria del CPU

    /* Devuelve un String que contiene la direccion aleatoria */

    public static String seleccionAleatoria(){

        String opcion = "";

        //numero aleatorio de 0 a 2

        int aleatorio = (int) (Math.random() * 3);

        switch(aleatorio){

            case 0:

                opcion = "i";
                break;

            case 1:

                opcion = "c";
                break;

            case 2:

                opcion = "d";
                break;
        }

        return opcion;
    }

    //Funcion que devuelve si se tira fuera el penalti (1 de 5)

    /* devuelve un boolean indicando si se falla o no */

    public static boolean probabilidadFallo(){

        boolean fallo = false;

        // numero aleatorio entre 0 y 4
        
        int probabilidad = (int) (Math.random() * 5);

        if (probabilidad == 1){

            fallo = true;
        }

        return fallo;
    }

    // funcion que compara el disparo y la parada y devuelve el resultado

    /* devuelve un boolean que es el resultado de si se ha metido el penalti o no.
     * Tiene como parametros de entrada la direccion de tiro y la de parada.
     */

    public static boolean resultadoTiro(String tiro, String parada){

        boolean gol = false;

        if(tiro.equalsIgnoreCase(parada)){

            // si las direcciones son iguales no hay gol

            gol = false;
        }

        else{

            // si no son iguales hay gol

                gol = true;
        }

        return gol;
    }

    // Funcion que modifica la salida por pantalla del resultado

    /* Devuelve un String el cual contiene el resultado grafico de la tanda
     * de penaltis.
     * 
     * Tiene como parametros de entrada un String y un boolean (el resultado del penalti).
     */

    public static String salidaResultado(String salidaResultado, boolean gol){

        String salidaFinal = "";

        if (gol == true) {

            /* si ha ocurrido el gol se modifica el String reemplazando el primer "-"
             * por "X"
             */

            salidaFinal = salidaResultado.replaceFirst("-", "X");
        }

        else{

            /* si no ocurre el gol se modifica reemplazando "-" por "O" */

            salidaFinal = salidaResultado.replaceFirst("-", "O");
        }

        return salidaFinal;
    }

        

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Variables

        String nombreJugador = "";
        String nombreCpu = "CPU";
        String resultadoJugador = "-----";
        String resultadoCpu = "-----";

        String opcionTirador = "";
        String opcionPortero = "";

        String ganador = "";

        boolean turnoJugador = false;
        boolean gol = false;
        boolean fallo = false;
        boolean hayGanador = false;

        int contadorPenaltiActual = 0;
        int contadorTotalPenalti = 0;
        int golesJugador = 0;
        int golesCpu = 0;

        System.out.println("indica tu nombre");

        nombreJugador = sc.nextLine();

        // Salida por pantalla inicial

        System.out.println("EMPIEZA LA TANDA DE PENALTIS");

        System.out.println(nombreJugador + resultadoJugador);
        System.out.println(nombreCpu + resultadoCpu);

        // bucle mientras no haya ganador y mientras la tanda de penalti no haya finalizado ( < 10)

        while(hayGanador == false || contadorPenaltiActual < 10){

            //incremento de penaltis totales y de penaltis de la tanda

            contadorTotalPenalti ++;
            contadorPenaltiActual ++;

            // si el numero de penaltis de la tanda supera 10 se reinicia para iniciar una nueva tanda

            if (contadorPenaltiActual > 10) contadorPenaltiActual = 0;

            // si el penalti es impar entonces es el turno del jugador

            if(contadorPenaltiActual%2 != 0){

                turnoJugador = true;

                System.out.println(nombreJugador + " tira (izquierda (i), derecha (d) o centro (c)):");

                // scanner de direccion del tiro del jugador

                opcionTirador = sc.nextLine();

                // Se elige aleatoriamente la direccion del portero

                opcionPortero = seleccionAleatoria();

            }

            // al ser un penalti par es el turno del cpu

            else{

                turnoJugador = false;

                System.out.println(nombreJugador + " Intenta parar (izquierda (i), derecha (d) o centro (c)):");

                // Scanner de la direccion de parada del jugador

                opcionPortero = sc.nextLine();

                // elecion aleatoria de direccion de tiro del cpu

                opcionTirador = seleccionAleatoria();
                
            }

            // comprueba si se ha marcado gol o no

            gol = resultadoTiro(opcionTirador, opcionPortero);

            // se calcula la posibilidad de fallo

            fallo = probabilidadFallo();

            // salida por pantalla y actualizacion de gol si ocurre fallo

            if (fallo == true){

                gol = false;

                System.out.println("Tiro afuera");
            }

            // salida por pantalla si hay gol

            else if (gol == true){

                System.out.println("- GOL -");
            }

            // salida por pantalla si hay parada

            else{

                    System.out.println("- PARADA -");
            }

            // se actualiza los resultados graficos del penalti actual

            if(turnoJugador == true){

                resultadoJugador = salidaResultado(resultadoJugador, gol);

            }

            else{

                resultadoCpu = salidaResultado(resultadoCpu, gol);

            }

            // salida por pantalla de resultados

            System.out.println(nombreJugador + ": " + resultadoJugador);

            System.out.println(nombreCpu + ": " + resultadoCpu);

            // si es el turno del jugador y marca se incrementa sus goles

            if(gol == true && turnoJugador == true){

                golesJugador ++;
            }

            // si es el turno del cpu y marca se incrementa sus goles
                
            if(gol == true && turnoJugador == false){

                golesCpu ++;

            }

            // control de si hay ganador en la tanda actual

            if(golesCpu > golesJugador || golesJugador > golesCpu){

                hayGanador = true;

            }
        }

        // FIN BUCLE

        // control de quien ha ganado

        if (golesCpu > golesJugador) {
            
            ganador = nombreCpu;
        }

        else {
            
            ganador = nombreJugador;
        }

        // salida por pantalla de ganador

        System.out.println("Ha ganado " + ganador);

        System.out.println("Penaltis totales: " + contadorTotalPenalti);

        sc.close();
    }  
}
