package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Conan_GuillermoRodriguez {

    // inicio funciones //

    public static int generarNumeroZombis (){

        //funcion que genera el numero de zombis entre 5 y 10

        int numeroZombi = 0;

        numeroZombi = (int) (Math.random() * (11 - 5) + 5);

        return numeroZombi;
    }

    public static int obtenerAtaque (int ataque){

        //funcion que genera el valor de ataque de un arma dada

        ataque = (int) (Math.random() * (ataque + 1));

        return ataque;
    }

    public static int obtenerDefensa (int defensa){

        //funcion que genera el valor de defensa de un arma dada

        defensa = (int) (Math.random() * (defensa + 1));

        return defensa;
    }
    
    //fin funciones

    public static void main(String[] args) {
        
        //Constantes

        final int VIDA_CONAN = 4;
        //final int VIDA_ZOMBI = 1;

        final int ATAQUE_ESPADA_2_MANOS = 60;
        final int DEFENSA_ESPADA_2_MANOS = 40;

        final int ATAQUE_HACHA = 70;
        final int DEFENSA_HACHA = 30;

        final int ATAQUE_ESPADA_CORTA = 30;
        final int DEFENSA_ESPADA_CORTA = 70;

        final int ATAQUE_ZOMBI = 50;
        final int DEFENSA_ZOMBI = 70;

        //

        Scanner sc = new Scanner(System.in);

        //variables

        char seguirPartida = ' ';

        int vidaActualConan = VIDA_CONAN;


        int ataqueArmaConan = 0;
        int defensaArmaConan = 0;

        int ataqueConanBatalla = 0;
        int defensaConanBatalla = 0;

        String armaSeleccionada = "";

        int ataqueZombi = 0;
        int defensaZombi = 0;

        int numeroZombis = 0;

        int contadorZombis = 1;

        boolean ganaConan = false;
        boolean ganaZombi = false;
        boolean pifia = false;


        //

        //bucle para seguir partida o no

        do{ 

            //Reinicio de variables por si hay otra partida

            vidaActualConan = VIDA_CONAN;
            contadorZombis = 1;


            int arma = 0;

            do{
                 // salida del menu seleccion de arma

                System.out.println("selecciona un arma");
                System.out.println("1 - Espada de dos manos 60 ATQ / 40 DEF");
                System.out.println("2 - Hacha 70 ATQ / 30 DEF");
                System.out.println("3 - Espada corta y escudo 30 ATQ / 70 DEF");


                arma = sc.nextInt();

                switch (arma){  // seleccion de arma

                    case 1:

                        ataqueArmaConan = ATAQUE_ESPADA_2_MANOS;
                        defensaArmaConan = DEFENSA_ESPADA_2_MANOS;
                        armaSeleccionada = "Espada a dos manos";

                        break;

                    case 2:

                        ataqueArmaConan = ATAQUE_HACHA;
                        defensaArmaConan = DEFENSA_HACHA;
                        armaSeleccionada = "Hacha";

                        break;

                    case 3:

                        ataqueArmaConan = ATAQUE_ESPADA_CORTA;
                        defensaArmaConan = DEFENSA_ESPADA_CORTA;
                        armaSeleccionada = "Espada y escudo";

                        break;

                    default:

                        System.out.println("no has elegido un arma correcta");
                }
            
            }while(arma != 1 || arma != 2 || arma != 3); // bucle para que el arma sea correcta

            sc.nextLine(); //limpiar buffer

            System.out.println("Has seleccionado el arma " + armaSeleccionada); //muestra el arma seleccionada

            //obtencion numero de zombis totales

            numeroZombis = generarNumeroZombis();

            System.out.println("Han aparecido " + numeroZombis + " Zombis");

            //bucle batalla contra zombis mientras conan tenga vidas y queden zombis vivos

            while(numeroZombis > 0 && vidaActualConan > 0){

                ganaConan = false;
                ganaZombi = false; //actualizacion de booleans para posterior salida por pantalla
                pifia = false;

                ataqueConanBatalla = obtenerAtaque(ataqueArmaConan); //obtengo ataque
                defensaZombi = obtenerDefensa(DEFENSA_ZOMBI); // obtengo defensa

                if (ataqueConanBatalla >= 0 && ataqueConanBatalla <=5){ //si ocurre pifia

                    pifia = true;

                    vidaActualConan --;

                    ataqueConanBatalla = 0; //actualizo el ataque porque doy por hecho que le toca el turno al zombi despues de una pifia

                }

                if (ataqueConanBatalla > defensaZombi){ // si conan mata a zombi

                    ganaConan = true;

                    numeroZombis --; // decremento numero total zombis

                }
                
                if (defensaZombi >= ataqueConanBatalla) { // si zombi defiende

                    ataqueZombi = obtenerAtaque(ATAQUE_ZOMBI); // genero ataque de zombi
                    defensaConanBatalla = obtenerDefensa(defensaArmaConan); // genero defensa de conan

                    if (ataqueZombi > defensaConanBatalla){ // si zombi gana

                        ganaZombi = true;

                        vidaActualConan --; // decremento vida de conan

                    }

                }

                System.out.println("Turno de conan:"); // siempre muestro por pantalla el turno de conan ya que siempre empieza el

                if (pifia) { // si ha salido una pifia muestro por pantalla todo lo relacionado con pifia
                    
                    System.out.println("Pifia, conan pierde una vida");
                    System.out.println("a conan le quedan " + vidaActualConan);

                    /*
                     *  doy por hecho que al ocurrir una pifia el turno pasa al zombi, pero no se como hacer
                     *  para no repetir la misma salida por pantalla en caso de pifia y en caso de turno del zombi
                     *  por eso este codigo es el mismo que en el caso de turno del zombi
                     */
                    
                    System.out.println("turno de zombie " + contadorZombis + " :");

                    System.out.println("zombi " + contadorZombis + " ataca con " + ataqueZombi + " ATQ");
                    System.out.println("Conan defiende con " + defensaConanBatalla + " DEF");

                    if (ganaZombi){ // si zombi gana 

                        System.out.println("Zombi gana!, a conan le quedan " + vidaActualConan + " vidas");
                    }

                    else{ // si conan defiende

                        System.out.println("Conan ha defendido!");

                    }


                }
                else { // si no ha ocurrido pifia se continua con el turno de conan

                    System.out.println("Conan ataca con " + ataqueConanBatalla + " ATQ");
                    System.out.println("zombi " + contadorZombis + " defiende con " + defensaZombi + " DEF");

                    if (ganaConan){ // si gana conan

                        System.out.println("Conan gana!, zombi " + contadorZombis + " ha muerto");
                        System.out.println("quedan " + numeroZombis + " zombis");

                        contadorZombis ++; // incremento contador aqui para que la salida por pantalla sea correcta

                    }

                    else{ // si zombi defiende es turno de zombi

                        System.out.println("Zombi " + contadorZombis + " Ha defendido");

                        System.out.println("turno de zombie " + contadorZombis + " :");

                        System.out.println("zombi " + contadorZombis + " ataca con " + ataqueZombi + " ATQ");
                        System.out.println("Conan defiende con " + defensaConanBatalla + " DEF");

                        if (ganaZombi){ // si zombi gana

                            System.out.println("Zombi gana!, a conan le quedan " + vidaActualConan + " vidas");
                        }

                        else{ // si conan defiende

                            System.out.println("Conan ha defendido!");

                        }
                    }
                }
            }

            // una vez terminado la battalla se muestra si conan consigue el tesoro o muere

            if (vidaActualConan == 0){ // si conan muere

                System.out.println("Conan ha sucumbido a la horda de zombi muriendo entre terrible sufrimiento");

            }else{ // si conan consigue tesoro

                System.out.println("Conan ha conseguido el tesoro");

            }

            System.out.println("quieres jugar otra vez? s/n"); // opcion de jugar otra partida

            // damos por hecho que el usuario va a introducir s o n, sino habria que hacerle un control

            seguirPartida = sc.nextLine().charAt(0);

        }while ( seguirPartida == 's');

        sc.close();
    }
}

/* SOLUCIONAR:
 * - si se produce pifia y pierde con zombi a la vez, la salida por pantalla de la vida es incorrecta
 * - no repetir codigo en la salida por pantalla de pifia
 * - poner salida por pantalla bonito
 * - Control opciones sea correcto
 */
