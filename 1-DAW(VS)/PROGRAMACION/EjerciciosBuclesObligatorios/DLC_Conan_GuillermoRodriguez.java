
/* 
 * Este es un DLC del juego de Conan en el cual añado algunas caracteristicas extras, las cuales detallo a continuacion.
 *  
 * EL CODIGO ESTA BASTANTE SUCIO Y ES MUY MUY REDUNDANTE, declaro demasiadas variables que podria ahorrarmelas reutilizando otras.
 * he intentado usar funciones pero aun no tengo mucha practica con ellas. Ademas he ido añadiendo codigo mientras encontraba errores,
 * ensuciando aun mas el código
 * 
 * He hecho varias pruebas y mas o menos funciona. pero claro no he barajado todas las opciones y seguramente alguna vaya mal.
 * Seguro que lo que queria hacer se podria hacer de manera mas limpia y funcional, pero empece hacerlo asi y mas o menos
 * funcionaba y no queria tocarlo demasiado, ya no sabia donde tenia la cabeza!, me ha costado su tiempo.
 * 
 * Me falta añadir control de lectura por teclado sea un caracter correcto.
 * Me falta añadir que pelea fue mas larga.
 * 
 * 
 *  // DOCUMENTACION //
 * 
 *  El juego es exactamente igual que el de Conan pero con estos EXTRAS:
 * 
 * - Cambio el arma Espada a dos manos por el arma Baston
 * 
 * - Añado habilidades pasivas al arma:
 * 
 *      - Hacha posibilidad de fatality si ataque es 60 o mayor
 *      - Bastón ganas 2 monedas por cada enemigo derrotado
 *      - Espada y escudo la defensa minima es siempre 30
 * 
 * - Añado Habilidad activa a Conan la cual solo puede usar si tiene  el medidor cargado. el tipo de habilidad depende de su arma
 * 
 *      - Habilidad hacha muere el enemigo instantaneamente.
 *      - Habilidad de Baston cura una vida a Conan.
 *      - Habilidad Espada y escudo te protege durante el turno de ataque del enemigo
 * 
 *  - Añado botin a los enemigos, los cuales al derrotarlos sueltan de 0 a 3 monedas.
 * 
 *  - Añado la posibilidad de un 25% de que se genere una tienda al derrotar un enemigo. en la tienda puedes items:
 * 
 *      - Pocion de salud 20 monedas: Recupera la salud de Conan completamente.
 *      - Pocion de habilidad 15 monedas: Carga completamente la habilidad activa de Conan.
 *      - Arma aleatoria 10 monedas: sin contar la que porta Conan, pudiendo cambiar el arma actual por la de la tienda.
 * 
 *  - Añado la posibilidad de usar el item en cada turno de Conan
 * 
 * - Añado dos tipos de hordas de enemigos, solo uno de ellos aparacen en una partida.
 *  Cada enemigo tiene una habilidad pasiva y estadisticas distintas
 * 
 *      - Enemigo BuscadorTexto: Tamaño de horda 5 - 10. habilidad: si el numero total es menor a seis obtienen un extra de ATQ
 *      - NumeroAlReves: Tanaño de horda 8 - 13. Habilidad: En su turno tienen un 20% de probabilidad de robarte el item 
 *      
 * - Añado una pelea contra jefe (tiene "GRAFICOS"), existen dos tipos, cada uno con distintas estadisticas y habilidades pasivas. Durante esta 
 *   pelea esta la posibilidad de que en cada turno de Conan este pueda usar su habilidad o su item. Pifia no puede ocurrir en 
 *   esta pelea y el arma de Conan cambia, pudiendo usar las 3 habilidades de arma. Los tipos de jefes son:
 * 
 *      - Piramide: Tiene un 20% de orobabilidad de dormir a Conan, por lo que no ataca en el siguiente turno.
 *      - Piramide Hueca: Tiene un 10% de probabilidad de matar a Conan instantaneamente
 * 
 * - Añado una segunda fase a la pela con el Jefe, en la cual tiene las dos habilidades anteriores juntas.
 * 
 * - Añado estadisticas de la partida como muertes de enemigos totales, etc...
 * 
 * Finalmente me gustaria retocar la salida por pantalla, añadiendo color al texto para destacar cuando Conan recibe daño,
 * se cura, mata a un enemigo, etc... tambien me gustaria añadir una barra de vida y de habilidad, representar las monedas, etc...
 * todo usando unicamente caracteres.
 * 
 * // Observaciones
 * 
 *  - toda la rama de hacha creo que funciona
 * 
*/

// EL MAIN EMPIEZA EN LA LINEA 662 -------------------------------------------

package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class DLC_Conan_GuillermoRodriguez {

    //----------------- FUNCIONES ---------------------------------------------

    // Mostrar menu

    public static void mostrarMenu(){

        System.out.println("Bienvenidos al DLC Conan VS Piramides!");
        System.out.println("En esta aventura acompañaras a conan en su lucha contra las piramides y sus hordas de enemigos");
        System.out.println("Si consigues llegar al final te espera una suculenta recompensa! animo!");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("Primero de nada, es peligroso andar solo, toma esto...");
        System.out.println("Una pequeña hada te da a elegir entre varias armas");
        System.out.println("1 - Hacha 70 ATQ 30 DEF Habilidad: Muerte instantanea // Habilidad pasiva: Posibilidad de Fatality");
        System.out.println("2 - Baston 40 ATQ 60 DEF Habilidad: Cura una vida // Habilidad pasiva: Mayor posibilidad de monedas");
        System.out.println("3 - Espada y escudo 30 ATQ Habilidad: Proteccion durante un turno // habilidad pasiva: Posibilidad de Defensa");
        
    }

    // genero el valor de ataque o defensa

    public static int obtenerValor(int valor) {

        valor = (int) (Math.random() * (valor + 1));

        return valor;
    }

    //Mostrar arma elegida

    public static void mostrarArma(int arma){

        switch (arma){

            case 1 :

                System.out.println("Has elegido el Hacha, eres un poco sadico!");

                break;

            case 2 :

                System.out.println("Has elegido el Baston, una persona sabia!");

                break;

            case 3 :

                System.out.println("Has elegido la Espada y el Escudo, eres un cobardica!");

                break;

        }
    }

    //ataque de eleccion de arma

    public static int ataqueArma(int arma){

        int ataque = 0;

        switch (arma){

            case 1 :

                ataque = 70;

                break;

            case 2 :

                ataque = 40;

                break;

            case 3 :

                ataque = 30;

                break;

        }

        return ataque;
    }

    // Defensa de eleccion de arma

    public static int defensaArma(int arma){

        int defensa = 0;

        switch (arma){

            case 1 :

                defensa = 30;

                break;

            case 2 :

                defensa = 60;

                break;

            case 3 :

                defensa = 70;

                break;

        }

        return defensa;
    }

    // Generacion aleatoria de enemigos

    public static boolean generarTipoEnemigo(){

        /*
         * Como solo hay dos tipos de enemigos, hago la eleccion de uno de ellos
         * mediante un boolean, si no es un tipo, es otro.
         */

        int tipoEnemigo = (int) (Math.random() * 2);

        boolean numerosAlreves = false;

        switch (tipoEnemigo){

            case 0 :

                numerosAlreves = true;

                break;

            case 1 :

                numerosAlreves = false;

                break;

        }

        return numerosAlreves;
    }

    // Generar numero total de enemigos

    public static int generarNumeroEnemigos(boolean tipoEnemigo){

        /*
         * segun el boolean del tipo de enemigo generado anteriormente
         * genero un numero total de enemigos
         */

        int numeroEnemigos = 0;
        
        if (tipoEnemigo == true){

            numeroEnemigos = (int) ((Math.random() *  (14 - 8)) + 8 );

        }else {

            numeroEnemigos = (int) ((Math.random() *  (11 - 5)) + 5 );
        }

        return numeroEnemigos;
    }


    //generar de 0 a 3 monedas aleatoriamente

    public static int generarMonedas() {

        int monedas = (int) (Math.random() * 4);

        return monedas;
    }

    // Generar tienda

    public static boolean generarTienda() {

        boolean aparicionTienda =  false;

        int probabilidad = (int) (Math.random() * 5);

        if (probabilidad == 2) aparicionTienda = true;

        return aparicionTienda;
    }

    // Generar arma aleatoria

    public static int generarArmaAleatoria(int idArma){

        int idArmaNueva = 0;

        switch (idArma){

            case 1 :

                idArmaNueva = (int) (Math.random() * 2);

                switch(idArmaNueva){

                    case 0:

                        idArmaNueva = 2;
                        break;

                    default:

                        idArmaNueva = 3;
                        break;
                }

                break;

            case 2 :

                idArmaNueva = (int) (Math.random() * 2);

                switch(idArmaNueva){

                    case 0:

                        idArmaNueva = 1;
                        break;

                    default:

                        idArmaNueva = 3;
                        break;
                }

                break;

            case 3 :

                idArmaNueva = (int) (Math.random() * 2);

                switch(idArmaNueva){

                    case 0:

                        idArmaNueva = 1;
                        break;

                    default:

                        idArmaNueva = 2;
                        break;
                }

                break;

        }

        return idArmaNueva;
    }

    // almacenar nombre arma

    public static String nombreArma(int arma){

        String nombreArma = "";

        switch(arma){

            case 1: nombreArma = "Hacha";
                break;
            
            case 2: nombreArma = "Baston";
                break;

            case 3: nombreArma = "Espada y Escudo";
                break;

            case 4: nombreArma = "Tenedor";
        }

        return nombreArma;
    }

    // Comprar Item

    public static int comprarItem(int item) {

        int monedas = 0;

        switch(item){

            case 1: monedas = 20;
                break;

            case 2: monedas = 10;
                break;

            case 3: monedas = 15;
                break;
        }

        return monedas;
    }

    // Almacenar nombre de item

    public static String nombreItem(int item){

        String nombreItem = "";

        switch(item){

            case 1: nombreItem = "Pocion de Salud Completa";
                break;
            
            case 2: nombreItem = "Pocion de Habilidad";
                break;

        }

        return nombreItem;
    }

    // robar con probabilidad de 20%

    public static boolean robar() {

        boolean robo = false;

        int prob = (int) (Math.random() * 5);

        if (prob == 2) robo = true;

        return robo;
    }

    // Mostrar estadisticas

    public static void mostrarEstadisticas(int vida, int arma, int item, int habilidad){

        System.out.println("------------------------------------------------");
        System.out.println("informacion de Conan:");
        System.out.println("Vida actual ---> " + vida);
        System.out.println("Arma actual ---> " + nombreArma(arma));
        System.out.println("Inventario ---> " + nombreItem(item));
        System.out.println("Habilidad --> " + habilidad);
        System.out.println("------------------------------------------------");

    }

    // Mostrar piramide

    public static void mostrarPiramide(int tipo){

        int altura = 8;

        if (tipo == 0){

            for (int i = 1 ; i <= altura ; i++){

                for (int j = 1 ; j <= altura - i ; j++){ //bucle espacios piramide1

                    System.out.print(" ");
                }
                for (int k = 1 ; k <= i + (i-1) ; k++){ //bucle asteriscos piramide1

                    System.out.print("*");

                }

                System.out.println("");
            }

        } else {

            for(int i = 1 ; i <= altura ; i ++){ //bucle lineas

                for(int j = 0 ; j <= altura - i ; j ++ ){ //bucle espacios
    
                    System.out.print(" ");
                }
    
                if (i == 1)System.out.println("*"); // pintar caracter con salto de linea
    
                else if(i > 1 && i < altura){
    
                    System.out.print("*");
    
                    for(int k = 0 ; k < (i * 2) - 3 ; k ++){ // bucle para hueco piramide
    
                        System.out.print(" ");
    
                    }
    
                    System.out.println("*"); // pintar caracter con salto de linea
    
                }
    
                else if (i == altura){ //control pintar base piramide
    
                    for(int z = 0 ; z < (altura * 2) - 1 ; z ++){ // pintar base piramide
    
                        System.out.print("*");
                    }
                }
            }

        }

    }

    // Mostrar piramide doble

    public static void mostrarPiramideDoble(){

        int altura1 = (int) (Math.random() * (8 - 3) + 3);

        int altura2 = (int) (Math.random() * (8 - 3) + 3);

        int alturaMax = Math.max(altura1, altura2);
        int diferenciaAltura = Math.abs(altura1-altura2);

        for (int linea = 1 ; linea <= alturaMax ; linea++ ){ //recorre lineas
            
            if (altura1 < altura2){ //la piramide 1 es mas pequeña

                if (linea <= (diferenciaAltura)){ // pinta espacios en las lineas que no utiliza piramide1

                    for (int i = 1 ; i <= (altura1 * 2)  ; i++){ // no se le resta -1 por el asterisco de separacion de bases

                        System.out.print(" ");
                    }

                    for (int j = 1 ; j <= altura2 - linea ; j++){ //pinta los espacios de la piramide2 de las lineas de la diferencia de altura

                        System.out.print(" ");
                    }

                    for ( int k = 1 ; k <= linea + (linea-1) ; k++){

                        System.out.print("*");

                    }

                }else{

                    for (int j = 1 ; j <=  altura1 - linea + diferenciaAltura; j++){ //bucle espacios piramide1

                        System.out.print(" ");
                    }

                    for (int k = 1 ; k <= linea - diferenciaAltura ; k++){ //bucle asteriscos 1/2 piramide1

                        System.out.print("*");
                    }

                    for (int z = 1 ; z <= linea - diferenciaAltura - 1 ; z++){ // bucle asteriscos 1/2 piramide1

                        System.out.print("*");
                    }

                    System.out.print(" "); // espacio de separacion entre base de piramides

                    for(int y = 1 ; y <= altura1 - (linea - diferenciaAltura) ; y++){ //bucles espacios post piramide hasta anchura piramide1

                        System.out.print(" ");
                    }

                    for (int j = 1 ; j <=  altura1 - linea + diferenciaAltura; j++){ //bucle espacios piramide2 resto de lineas

                        System.out.print(" ");
                    }

                    for ( int k = 1 ; k <= linea + (linea-1) ; k++){ // bucle asteriscos piramide2 resto de lineas

                        System.out.print("*");

                    }
                }

            System.out.println(""); // salto linea
            
            }else{ // caso en que la piramide2 sea menor que piramide1

                for (int i = 1 ; i <= altura1 - linea ; i++){ //pinta espacios piramide1

                    System.out.print(" ");
                }

                for (int j = 1 ; j <= linea + (linea-1) ; j++){ //pinta asteriscos piramide1

                    System.out.print("*");
                }

                System.out.print(" "); // separacion de base

                if (linea > diferenciaAltura){ // si la linea es igual a la altura de la piramide2

                    for (int i = 1 ; i <= altura2 - (linea - diferenciaAltura) ; i++){ //pinta espacios post piramide1

                        System.out.print(" ");
                    }

                    for (int i = 1 ; i <= altura2 - (linea - diferenciaAltura) ; i++){ //pinta espacios piramide2

                        System.out.print(" ");
                    }

                    for (int j = 1 ; j <= (linea - diferenciaAltura) + ((linea - diferenciaAltura) - 1) ; j++){ //pinta asteriscos piramide2

                        System.out.print("*");

                    }

                }

                System.out.println("");

            }
        }
    
    }

    // eleccion de accion contra boss

    public static void mostrarOpcionesCombate() {

        System.out.println("Elige que quieres hacer antes de atacar! :");
        System.out.println("1 - USAR ITEM");
        System.out.println("2 - USAR HABILIDAD");
        System.out.println("3 - NADA!");
        
    }

    // Mostrar habilidades del arma final

    public static void mostrarHabilidadesArma(){

        System.out.println("Que habilidad quires usar?");
        System.out.println("1 - CURAR");
        System.out.println("2 - PROTECCION");
        System.out.println("3 - EXTRA DE ATAQUE");

    }

    // instakill boss con probabilidad 10%

    public static boolean instakillBoss() {

        boolean instakillBoss = false;

        int prob = (int) (Math.random() * 10);

        if (prob == 2) instakillBoss = true;

        return instakillBoss;
    }

    // Mostrar estadisticas del juego

    public static void mostrarEstadisticasJuego(int a, int b, int c, int d, int e, int f) {

        System.out.println("Numero de Duelos totales --> " + a);
        System.out.println("Numero de muertes de Conan --> " + b);
        System.out.println("Numero de muertes de Enemigos --> " + c);
        System.out.println("Numero de Hordas superadas --> " + d);
        System.out.println("Numero de muerte de Bosses --> " + e);
        System.out.println("Numero de partidas jugadas --> " + f);

    }

    /* ------------------------- FIN FUNCIONES ------------------------------ */

    // --------------------- INICIO MAIN ---------------------------------


    public static void main(String[] args) {

        // Constantes

        final int VIDA_CONAN = 4;

        // Queria usar estas constantes en las funciones :()

        final int ATQ_HACHA = 70;
        final int DEF_HACHA = 30;

        final int ATQ_BASTON = 40;
        final int DEF_BASTON = 60;

        final int ATQ_ESPADA = 30;
        final int DEF_ESPADA = 70;

        final int ATQ_TENEDOR = 70;
        final int DEF_TENEDOR = 70;

        final int ATQ_NUM_AL_REVES = 30;
        final int DEF_NUM_AL_REVES = 40;

        final int ATQ_BUSCADOR_TEXTO = 50;
        final int DEF_BUSCADOR_TEXTO = 70;

        final int PRECIO_POCION_SALUD = 20;
        final int PRECIO_POCION_HABILIDAD = 10;
        final int PRECIO_ARMA = 15;

        final int PUNTOS_HABILIDAD = 20;

        final int VIDA_BOSS = 2;

        final int ATQ_PIRAMIDE = 70;
        final int DEF_PIRAMIDE = 80;

        final int ATQ_PIRAMIDE_HUECA = 80;
        final int DEF_PIRAMIDE_HUECA = 70;

        final int ATQ_PIRAMIDE_DOBLE = 85;
        final int DEF_PIRAMIDE_DOBLE = 85;

        
        Scanner sc = new Scanner(System.in);

        // variables

        int idArma = 0;
        int idArmaTienda = 0;

        int vidaActualConan = VIDA_CONAN;
        int ataqueConan = 0;
        int defensaConan = 0;

        boolean tipoEnemigo = true;
        String nombreEnemigo = "";
        int numeroEnemigos = 0;
        int contadorEnemigo = 1;
        int ataqueEnemigo = 0;
        int defensaEnemigo = 0;

        boolean tenerItem = false;
        int idItem = 0;
        char usarItem = ' ';

        boolean tenerHabilidad = false;
        int contadorHabilidad = 0;
        char usarHabilidad = ' ';

        int monedasSoltadas = 0;
        int monedasTotales = 0;

        boolean aparicionTienda = false;
        char comprarItem = ' ';

        boolean fatality = false;
        boolean instakill = false;
        boolean proteccion = false;

        char seguirPartida = ' ';

        // SISTEMA COMBATE CON BOSS

        int tipoBoss = 0;
        int vidaBoss = VIDA_BOSS;

        int opcionCombate = 0;

        boolean item = false;
        boolean habilidad = false;

        int habilidadDeArma = 0;

        boolean buffAtq = false;
        boolean dormir = false;
        boolean instakillBoss = false;

        boolean conanUsaInstakill = false;

        // contadores

        int contadorDueloInicial = 0;
        int contadorDuelo = 0;
        int contadorPartida = 0;
        int contadorMuertesConan = 0;
        int contadorMuertesBosses = 0;
        int contadorMuertesEnemigos = 0;
        int contadorHordasSuperadas = 0;




        do{

            contadorPartida ++;

            // reset

            contadorEnemigo = 1; 
            contadorHabilidad = 0;
            proteccion = false;
            

            mostrarMenu(); // Muestro menu

            idArma = sc.nextInt(); // Escaner de arma

            sc.nextLine(); // Limpiar buffer

            mostrarArma(idArma); // Muestro arma elegida

            System.out.println("Ahora que has elegido arma, es hora de comenzar tu aventura...");

            sc.nextLine(); // pausa

            /* GENERACION ENEMIGOS */

            tipoEnemigo = generarTipoEnemigo(); // Genero un tipo de enemigo segun un booleano

            numeroEnemigos = generarNumeroEnemigos(tipoEnemigo); // Genero el numero total de enemigos segun el tipo

            /* FIN GENERACION ENEMIGOS */

            vidaActualConan = VIDA_CONAN; // Vuelvo a iniciar variable para actualizarla despues de cada partida
            contadorDueloInicial = 0;

            /* BATALLA CONTRA ENEMIGOS */

            do{ 

                contadorDuelo ++; // Incremento contador de duelo
                contadorDueloInicial ++;

                fatality = false; // reset
                proteccion = false;
                if (conanUsaInstakill) instakill = false;

                // No se como hacer este control antes del bucle

                if (tipoEnemigo == true){ // Genero estadisticas de ATQ y DEF segun el tipo de enemigo

                    nombreEnemigo = "NumerosAlReves";
                    ataqueEnemigo = obtenerValor(ATQ_NUM_AL_REVES);
                    defensaEnemigo = obtenerValor(DEF_NUM_AL_REVES);

                }else{  // Genero estadisticas de ATQ y DEF segun el tipo de enemigo

                    nombreEnemigo = "BuscadorDeTexto";
                    ataqueEnemigo = obtenerValor(ATQ_BUSCADOR_TEXTO);
                    defensaEnemigo = obtenerValor(DEF_BUSCADOR_TEXTO);

                }

                if (contadorDueloInicial == 1){ // Si es el primer duelo, muestro por pantalla el inicio de la batalla

                    System.out.println("Oh no!, Ha aparecido una horda furiosa de " + numeroEnemigos + " " + nombreEnemigo);
                    System.out.println("Preparate para la batalla!");
                }

                sc.nextLine(); // pausa

                /* COMIENZO DEL SISTEMA DE CONBATE */

                System.out.println("Es tu turno Conan!");


                /* TENER UN ITEM */

                if(tenerItem == true){ // Si tienes un item en tu inventario

                    mostrarEstadisticas(vidaActualConan, idArma, idItem, contadorHabilidad); // Muestro informacion del personaje

                    if (idItem == 3){ // si es un arma

                        System.out.println("Tienes un arma en tu inventario, " + nombreArma(idArmaTienda) + " , quieres cambiarla por la actual? s/n");

                    } else { // si es una pocion

                        System.out.println("Tienes un item (" + nombreItem(idItem) + ") en tu inventario, quieres usarlo? s/n");

                    }

                    //Pregunto si quieres usar item

                    usarItem = sc.nextLine().charAt(0);

                    if (usarItem == 's'){ // Si se usa el item

                        tenerItem = false; // Ya no tienes item

                        switch (idItem){ // Usar el item segun cual sea

                            case 1: // Pocion salud

                                vidaActualConan = VIDA_CONAN; // Restaura restaura completamente la salud

                                System.out.println("Has usado una Pocion de Salud!, tu vida actual es " + vidaActualConan);

                                break;

                            case 2: // Pocion Habilidad

                                tenerHabilidad = true; // Carga la habilidad de arma completamente

                                System.out.println("Has usado una Pocion de Habilidad!, tu habilidad esta completamente cargada! ");

                                break;

                            case 3: // Cambiar arma

                                idArma = idArmaTienda; // Actualizo arma de conan

                                break;

                        }

                    }

                }

                sc.nextLine(); // pausa

                /* FIN TENER UN ITEM */

                /* GENERAR ESTADISTICAS DE CONAN */ 

                // Genero estadisticas ahora por si el item o la habilidad las modifica
                
                // Compruebo habilidad pasiva escudo

                ataqueConan = obtenerValor(ataqueArma(idArma));

                if (idArma == 3){

                    defensaConan = (int) (Math.random() * ((DEF_ESPADA + 1) - 30) + 30);
                
                }else defensaConan = obtenerValor(defensaArma(idArma));

                /* FIN GENERAR ESTADISCICAS */

                /* TENER HABILIDAD CARGADA */

                if (contadorHabilidad >= 100){ //control de si tengo habilidad cargada

                    tenerHabilidad = true;

                }

                if (tenerHabilidad == true){ // Si tengo habilidad cargada

                    System.out.println("Tienes la Habilidad de arma cargada! quieres usarla? s/n"); //Preguntar si usar habilidad

                    usarHabilidad = sc.nextLine().charAt(0);

                    sc.nextLine(); // Limpiar buffer

                    if (usarHabilidad == 's'){ // Usar habilidad

                        tenerHabilidad = false; // Reseteo tener habilidad

                        contadorHabilidad = 0; // Reseteo contador habilidad

                        switch (idArma){ // Efectos usar habilidad segun tipo arma

                            case 1: // Hacha -> Instakill ese turno

                                instakill = true; // Para hacer instakill le doy un valor muy alto al ATQ de conan, seguro que hay otra forma de hacerlo
                                conanUsaInstakill = true;

                                System.out.println("Has usado la habilidad INSTAKILL del arma Hacha!, mataras a tu enemigo instantaneamente");

                                break;
                            
                            case 2: // Baston -> Cura una vida

                                vidaActualConan ++;

                                System.out.println("Has usado la habilidad CURA del arma baston!, tu vida actual es: " + vidaActualConan);

                                break;

                            case 3: // Espada y Escudo -> Proteccion ese turno

                                proteccion = true;
                                
                                System.out.println("Has usado la habilidad PROTECCION del arma Espada y Escudo!, te protegerás completamente del ataque del enemigo");

                                break;
                        }


                    }

                }

                sc.nextLine(); // pausa

                /* FIN TENER HABILIDAD CARGADA */

                /* MOSTRAR ESTADISTICAS */

                // compruebo fatality y def pasiva del escudo despues de tienda para darle un poco de incertidumbre ;)

                if (idArma == 1 && ataqueConan >= 60){ // si arma es hacha y ataque es 60 o mas

                    fatality = true;

                    System.out.println("Conan ataca con " + ataqueConan + " ATQ, OCURRE UN FATALITY!");

                    sc.nextLine(); // pausa

                } else {

                    System.out.println("Conan ataca con " + ataqueConan + " ATQ");

                    sc.nextLine(); // pausa

                    System.out.println("Enemigo " + nombreEnemigo + " " + contadorEnemigo + " defiende con " + defensaEnemigo + " DEF");

                }

                sc.nextLine(); // pausa

                /* FIN MOSTRAR ESTADISTICAS */

                /* INICIO COMBATE */

                // si ocurre pifia

                if (ataqueConan <= 5 && fatality == false && instakill == false){

                    vidaActualConan --;

                    System.out.println("Conan es un manco y ha sufrido una PIFIA, por lo cual se autolesiona perdiendo una vida");
                    System.out.println("Conan tiene " + vidaActualConan + " vidas");

                    sc.nextLine(); // pausa

                }


                // Si conan gana o ocurre fatality o instakill

                else if ((ataqueConan > defensaEnemigo || fatality == true || instakill == true) && vidaActualConan > 0){

                    /*
                     * else if porque puede ser que aun ocurriendo la pifia conan gane
                     * pero doy por hehco que cuando ocurre pifia se le pasa el
                     * turno al enemigo
                     */

                    contadorMuertesEnemigos ++;

                    numeroEnemigos --; // Decremento numero de enemigos

                    contadorEnemigo ++; // Incremento contador de enemigos al matar a uno de ellos

                    contadorHabilidad += 20; // Incremento contador de habilidad al ganar el combate

                    monedasSoltadas = generarMonedas(); // Genero monedas al ganar combate

                    monedasTotales += monedasSoltadas; // Acumulador de monedas
                    
                    System.out.println("Conan ha machacado al enemigo y ha ganado " + PUNTOS_HABILIDAD + " puntos de habilidad!");
                    System.out.println("Puntos de Habilidad actual: " + contadorHabilidad);

                    sc.nextLine(); // pausa

                    System.out.println("El enemigo ha soltado " + monedasSoltadas + " monedas!");

                    sc.nextLine(); // pausa

                    // Si tengo el arma Baston hago efecto de su habilidad pasiva

                    if (idArma == 2){

                        monedasSoltadas = + 2;

                        monedasTotales = + monedasSoltadas;

                        System.out.println("Por tener el baston te llevas 2 monedas extra!");
                    }

                    sc.nextLine(); // pausa

                    System.out.println("Quedan " + numeroEnemigos + " enemigos"); // muestro enemigos restantes

                    /* APARICION DE TIENDA CON PROB 20% */

                    aparicionTienda = generarTienda();

                    if (aparicionTienda == true){ // Si tienda aparece

                        System.out.println("SE HA GENERADO UNA TIENDA!");

                        sc.nextLine(); // pausa

                        mostrarEstadisticas(vidaActualConan, idArma, idItem, contadorHabilidad);

                        sc.nextLine(); // pausa

                        idArmaTienda = generarArmaAleatoria(idArma); // Genero arma aleatoria de la tienda sin contar la actual

                        // Muestro tienda

                        System.out.println("Tienes suerte!, ha aparecido un comerciante extraño!");
                        System.out.println("El comerciante muestra sus artilugios de manera misteriosa");
                        System.out.println("1 - Pocion de Salud Completa, precio " + PRECIO_POCION_SALUD + " monedas");
                        System.out.println("2 - Pocion de Habilidad, precio " + PRECIO_POCION_HABILIDAD + " monedas");
                        System.out.println("3 - Arma " + nombreArma(idArmaTienda) + ", precio " + PRECIO_ARMA);
                        System.out.println("Miras en tus bolsillos y encuentras " + monedasTotales + " monedas");
                        System.out.println("Quieres comprar algo? s/n");

                        // Pregunto si quieres comprar

                        comprarItem = sc.nextLine().charAt(0);

                        if (comprarItem == 's'){ // Si compras

                            System.out.println("indica que item quieres comprar");

                            idItem = sc.nextInt(); 

                            sc.nextLine(); // Limpiar buffer

                            tenerItem = true; // Item comprado

                            monedasTotales -= comprarItem(idItem); // Actualizacion de monedas

                            System.out.println("Enhora buena, has hecho al comerciante feliz!");
                            System.out.println("Te quedan " + monedasTotales + " monedas");

                            sc.nextLine(); // pausa

                        }

                    }

                    /* FIN TIENDA */

                }

                // FIN TURNO CONAN

                // Si enemigo defiende

                if (ataqueConan <= defensaEnemigo && vidaActualConan > 0 && instakill == false){

                    // Turno del enemigo

                    System.out.println("El enemigo " + nombreEnemigo + " " + contadorEnemigo + " ha defendido!");

                    sc.nextLine(); // pausa

                    System.out.println("Turno del enemigo " + nombreEnemigo + " " + contadorEnemigo + "!");

                    sc.nextLine(); // pausa

                    // Activacion de habilidad de enemigos si se dan las condiciones

                    if (tipoEnemigo == false && numeroEnemigos <= 5){

                        System.out.println("El enemigo " + nombreEnemigo + " " + contadorEnemigo + " ha activado su habilidad especial BUFF");
                        System.out.println("Su ATQ ha incrementado en 20!");

                        sc.nextLine(); // pausa

                        ataqueEnemigo += 20;

                    } else if (tipoEnemigo == true){

                        if (robar() == true) {

                            tenerItem = false;

                            System.out.println("El enemigo te ha robado el item con su habilidad especial! (si tienes)");

                            sc.nextLine(); // pausa

                        }

                    }

                    System.out.println(nombreEnemigo + " " + contadorEnemigo + " ataca con " + ataqueEnemigo + " ATQ");

                    sc.nextLine(); // pausa

                    System.out.println("Conan defiende con " + defensaConan + " DEF");

                    sc.nextLine(); // pausa

                    // Si conan defiende o usa proteccion

                    if (ataqueEnemigo <= defensaConan || proteccion == true && vidaActualConan > 0){

                        System.out.println("Conan ha defendido!");

                        sc.nextLine(); // pausa
                    }

                    // Si enemigo gana

                    if (ataqueEnemigo > defensaConan && vidaActualConan > 0){

                        vidaActualConan --; // Decremento vida actual de Conan

                        System.out.println(nombreEnemigo + " " + contadorEnemigo + " ha ganado!");

                        sc.nextLine(); // pausa

                        System.out.println("Conan pierde una vida, Conan tiene " + vidaActualConan + " vidas");

                        sc.nextLine(); // pausa

                    }

                }

                    // Si Conan defiende, vuelve al inicio del bucle y vuelve a tener el turno

                /* FIN COMBATE */

            }while(vidaActualConan > 0 && numeroEnemigos > 0);

            /* FIN BATALLA CONTRA ENEMIGOS */

            contadorHordasSuperadas ++;

            // si conan MUERE se acaba la partida

            if (vidaActualConan == 0){

                contadorMuertesConan ++;

                System.out.println("Conan ha muerto entre terrible sufrimiento");

                sc.nextLine(); // pausa

            // Si conan vive le espera otro reto

            }else{

                tipoBoss = (int) (Math.random() * 2); // Defino el tipo de boss

                vidaBoss = VIDA_BOSS; // Actualizacion de variable por si hay otra partida

                System.out.println("Conan ha acabado con la horda de enemigos!...");
                System.out.println("De repente el cielo comienza a oscurecerse...");

                sc.nextLine(); // pausa

                System.out.println("");

                mostrarPiramide(tipoBoss); // Muestro por pantalla al BOSS, tipo o -> completa, tipo 1 -> hueca

                sc.nextLine(); // pausa

                System.out.println("");
                sc.nextLine(); // pausa
                System.out.println("oh no! ha aparecido mi archienemigo, UNA PIRAMIDE!");
                System.out.println("Conan se prepara para su batalla final!");

                sc.nextLine(); // pausa

                mostrarEstadisticas(vidaActualConan, idArma, idItem, contadorHabilidad); // Muestro la informacion del personaje antes de la batalla

                sc.nextLine(); // pausa

                System.out.println("Conan siente algo en su interior y de repente!... Su arma se convierte en un Tenedor completamente equilibrado!");
                //elimino la posibilidad de pifia en el combate final
                System.out.println("Conan expresa felizmente: Oh! gracias a esta arma ya no tendre que preocuparme por autolesionarme!");
                
                sc.nextLine(); // pausa
                
                System.out.println("Comienza la batalla final!");

                sc.nextLine(); // pausa

                if (tenerItem == true && idItem == 3) idItem = 1; // Convierto el item arma a una pocion de salud

                idArma = 4; // actualizo tipo de arma

                /* INICIO SISTEMA DE COMBATE */

                while(vidaActualConan > 0 && vidaBoss > 1){

                    contadorDuelo ++;

                    // reset variables

                    proteccion = false;
                    buffAtq = false;
                    instakillBoss = false;

                    // TURNO DE CONAN


                    System.out.println("Turno de Conan!");

                    sc.nextLine(); // pausa

                    mostrarOpcionesCombate();

                    opcionCombate = sc.nextInt(); // Leer que hacer

                    sc.nextLine(); // limpiar buffer

                    switch (opcionCombate){ // Activo booleanos segun opcion elegida para entender el codigo mejor posteriormente

                        case 1:

                            item = true;

                            System.out.println("Has elegido usar el item!");

                            sc.nextLine(); // pausa

                            break;

                        case 2:

                            habilidad = true;

                            System.out.println("Has elegido usar tu habilidad!");

                            sc.nextLine(); // pausa
                    }

                    // si eliges usar item

                    if (item == true){

                        if (tenerItem == true) {

                            tenerItem = false; // Ya no tienes item

                            switch (idItem){ // Usar el item segun cual sea

                                case 1: // Pocion salud

                                    vidaActualConan = VIDA_CONAN; // Restaura completamente la salud

                                    System.out.println("Has usado una Pocion de Salud!, tu vida actual es " + vidaActualConan);
                                    

                                    break;

                                case 2: // Pocion Habilidad

                                    tenerHabilidad = true; // Carga la habilidad de arma completamente

                                    System.out.println("Has usado una Pocion de Habilidad!, tu habilidad esta completamente cargada! ");

                                    break;
                            }

                        }

                        else{

                            System.out.println("No tienes item idiota!");
                        }
                    }

                        sc.nextLine(); // pausa

                    sc.nextLine(); // pausa

                    // Si eliges usar habilidad

                    if (habilidad == true){

                        if (tenerHabilidad == true) {

                            tenerHabilidad = false; // reset

                            mostrarHabilidadesArma();

                            habilidadDeArma = sc.nextInt();

                            if (habilidadDeArma == 1){

                                System.out.println("Has elegido curarte!");

                                sc.nextLine(); // pausa

                                vidaActualConan ++;

                            }else if (habilidadDeArma == 2) {

                                System.out.println("Has elegido protegerte!");

                                sc.nextLine(); // pausa

                                proteccion = true;

                            }else if (habilidadDeArma == 3) {

                                System.out.println("Has elegido un Buff de ATQ");

                                sc.nextLine(); // pausa

                                buffAtq = true;
                            }
                        }

                        else{

                            System.out.println("no tienes la habilidad cargada pelele!");
                        }

                    }

                    sc.nextLine(); // pausa

                    // INICIO ATAQUE

                    System.out.println("Comienza el ATAQUE!");

                    sc.nextLine(); // pausa

                    //genero estadisticas


                    ataqueConan = obtenerValor(ATQ_TENEDOR);
                    defensaConan = obtenerValor(DEF_TENEDOR);

                    if (buffAtq == true) ataqueConan += 20; // actualizo ataque si tengo el extra de ataque

                    if (tipoBoss == 0){ // segun tipo de boss tiene distintas estadisticas

                        defensaEnemigo = obtenerValor(DEF_PIRAMIDE);

                        ataqueEnemigo = obtenerValor(ATQ_PIRAMIDE);

                        nombreEnemigo = "PIRAMIDE";

                    } else {
                        
                        defensaEnemigo = obtenerValor(DEF_PIRAMIDE_HUECA);

                        ataqueEnemigo = obtenerValor(ATQ_PIRAMIDE_HUECA);

                        instakill = instakillBoss();

                        nombreEnemigo = "PIRAMIDE HUECA";

                    }

                    if (dormir == true) {

                        System.out.println("ZZZzzzzzz");
                        System.out.println("Conan esta dormido....");

                        sc.nextLine(); // pausa
                    }

                    else{

                        System.out.println("Conan ataca con " + ataqueConan + " de ATQ");

                        sc.nextLine(); // pausa

                        System.out.println(nombreEnemigo + " defiende con " + defensaEnemigo + " de DEF");

                        sc.nextLine(); // pausa

                    }

                    // Si conan gana

                    if (ataqueConan > defensaEnemigo && dormir == false){

                        vidaBoss --;

                        System.out.println("Conan ha dañado seriamente al enemigo!");

                        sc.nextLine(); // pausa
                    }

                    // Si enemigo defiende

                    else if (ataqueConan <= defensaEnemigo){

                        if (dormir == false){

                            System.out.println(nombreEnemigo + " ha conseguido defender!");

                            sc.nextLine(); // pausa

                        }

                        //Turno enemigo

                        if (tipoBoss == 0) dormir = robar();// posibilidad de dormir

                        System.out.println("Turno de " + nombreEnemigo);

                        sc.nextLine(); // pausa

                        if(dormir == true) {

                            System.out.println("La Habilidad Especial de " + nombreEnemigo + " ha dormido a Conan, en el siguiete turno estara dormido y no atacará!...");
                        
                            sc.nextLine(); // pausa

                        }

                        System.out.println(nombreEnemigo + " ataca con " + ataqueEnemigo + " ATQ");

                        sc.nextLine(); // pausa

                        if(instakillBoss == true){

                            System.out.println("Ha ocurrido un instakill!");

                            sc.nextLine(); // pausa
                        }

                        // Si he elegido protegerme

                        if (proteccion == true) {
                            
                            System.out.println("Conan ha defendido con PROTECCION");

                            sc.nextLine(); // pausa
                        }

                        else {

                            if (instakill == true){

                                vidaActualConan = 0;

                                System.out.println(nombreEnemigo + "Ha conseguido un golpe certero y ha acabado completamente con Conan...");
                            
                                sc.nextLine(); // pausa
                            }

                            else {

                                System.out.println("Conan defiende con " + defensaConan + " de DEF");

                                sc.nextLine(); // pausa

                                // si enemigo gana

                                if (ataqueEnemigo > defensaConan && proteccion == false){

                                    System.out.println(nombreEnemigo + " ha herido a conan!");

                                    sc.nextLine(); // pausa

                                    vidaActualConan --;

                                    System.out.println("Ha Conan le quedan " + vidaActualConan + " vidas");

                                    sc.nextLine(); // pausa

                                // si conan defiende    

                                }else if (ataqueEnemigo <= defensaConan){

                                    System.out.println("Conan ha conseguido defender!");

                                    sc.nextLine(); // pausa
                                }

                            }

                        }
                    
                    }

                }

                // Fin primera fase boss

                if( vidaActualConan == 0) {

                    contadorMuertesConan ++;
                    
                    System.out.println("ha pesar de todos sus esfuerzos conan ha sucumbido a la oscuridad");

                    sc.nextLine(); // pausa

                }

                // segunda fase Boss


                else{

                    System.out.println("Conan sale triunfante de la batalla, mirando el cadaver de su enemigo con desprecio");
                    sc.nextLine(); // pausa
                    System.out.println("...");
                    sc.nextLine(); // pausa
                    System.out.println("De repente se escucha sonidos aterradores...");
                    sc.nextLine(); // pausa

                    System.out.println("");
                    mostrarPiramideDoble();
                    System.out.println("");

                    sc.nextLine(); // pausa
                    System.out.println(" JA JA JA creias que me habias vencido? aun te queda tarea por hacer!");
                    sc.nextLine(); // pausa
                    System.out.println("Conan: Oh no! otra vez no... esto parece Dark Souls...");
                    sc.nextLine(); // pausa
                    System.out.println("Conan se prepara para su batalla final, esta vez de verdad");
                    sc.nextLine(); // pausa
                    System.out.println("Conan esta exhausto por lo que para esta batalla solo cuenta con su destreza con el arma");
                    sc.nextLine(); // pausa
                    System.out.println("Conan tiene " + vidaActualConan + " vidas, es todo un milagro...");
                    sc.nextLine(); // pausa

                    System.out.println("Turno de Conan!");
                    sc.nextLine(); // pausa

                    nombreEnemigo = "PIRAMIDE DOBLE ATERRADORA";

                    ataqueConan = obtenerValor(ATQ_TENEDOR);
                    defensaEnemigo = obtenerValor(DEF_PIRAMIDE_DOBLE);

                    System.out.println("Conan ataca con " + ataqueConan + " de ATQ");
                    sc.nextLine(); // pausa
                    System.out.println(nombreEnemigo + " defiende con " + defensaEnemigo + " de DEF");
                    sc.nextLine(); // pausa

                    while(vidaActualConan > 0 && vidaBoss > 0){

                        contadorDuelo ++;

                        // Si conan gana y no esta dormido

                        if (ataqueConan > defensaEnemigo && dormir == false){

                            vidaBoss --;

                            System.out.println("Conan ha dañado seriamente al enemigo!");
                            sc.nextLine(); // pausa

                        }

                        // si enemigo defiende

                        else if (ataqueConan <= defensaEnemigo || dormir == true){

                            if (dormir == true){  // si conan esta dormido
                                
                                System.out.println("ZZZZzzzzzz");
                                System.out.println("Conan esta dormido...");
                                sc.nextLine(); // pausa
                            }

                            else  System.out.println(nombreEnemigo + " ha conseguido defender!");
                            sc.nextLine(); // pausa

                            //Turno enemigo

                            System.out.println("Turno de " + nombreEnemigo);
                            sc.nextLine(); // pausa

                            // Genero estadisticas y habilidades boss
                            
                            ataqueEnemigo = obtenerValor(ATQ_PIRAMIDE_DOBLE);
                            defensaConan = obtenerValor(DEF_TENEDOR);
                            dormir = robar();
                            instakillBoss = instakillBoss();

                            if (instakill == true){ // si boss instakill a Conan

                                vidaActualConan = 0;
                                System.out.println("Ha ocurrido una INSTAKILL");
                                sc.nextLine(); // pausa
                                System.out.println(nombreEnemigo + " ha conseguido un golpe certero y ha acabado completamente con Conan...");
                                sc.nextLine(); // pausa
                            }

                            else {
                                
                                if(dormir == true){ // Si boss duerme a conan

                                System.out.println("La Habilidad Especial de " + nombreEnemigo +" ha conseguido dormir a Conan!, por lo que en el siguiente turno no atacará!");
                                sc.nextLine(); // pausa
                            }

                            System.out.println(nombreEnemigo + " ataca con " + ataqueEnemigo + " ATQ");
                            sc.nextLine(); // pausa
                            System.out.println("Conan defiende con " + defensaConan + " de DEF");
                            sc.nextLine(); // pausa

                                // si enemigo gana

                                if (ataqueEnemigo > defensaConan && proteccion == false){

                                    System.out.println(nombreEnemigo + " ha herido a conan!");
                                    sc.nextLine(); // pausa

                                    vidaActualConan --;

                                    System.out.println("Ha Conan le quedan " + vidaActualConan + " vidas");
                                    sc.nextLine(); // pausa

                                // si conan defiende    

                                }else if (ataqueEnemigo <= defensaConan){

                                    System.out.println("Conan ha conseguido defender!");
                                    sc.nextLine(); // pausa
                                }

                            }   

                        }

                    }

                }

                // final batalla boss

                // resultado batalla final

                if( vidaActualConan == 0) {
                    
                    System.out.println("ha pesar de todos sus esfuerzos conan ha sucumbido a la oscuridad");
                    sc.nextLine(); // pausa
                }

                else{

                    contadorMuertesBosses ++;
                    contadorMuertesEnemigos ++;

                    System.out.println("Conan PORFIN ha derrotado a su enemigo!");
                    sc.nextLine(); // pausa
                    System.out.println("despues de todo el sufrimiento pasado en incontables batallas...");
                    sc.nextLine(); // pausa
                    System.out.println("Conan se dirige triunfante a la sala del tesoro!...");
                    sc.nextLine(); // pausa
                    System.out.println("En la sala del tesoro Conan se encuentra con una preciosa princesa custodiada por una turtuga...");
                    sc.nextLine(); // pausa
                    System.out.println("Conan se libra facilmente de la tortuga y junto a la princesa se dirigen a la salida del Castillo");
                    sc.nextLine(); // pausa
                    System.out.println("Conan y la princesa se casan, son felices y comen perdices!");
                    sc.nextLine(); // pausa
                    System.out.println("FIN");
                }

            }

            sc.nextLine(); // pausa

            System.out.println("-------------- Estadisticas Totales De La Partida --------------");

            mostrarEstadisticasJuego(contadorDuelo, contadorMuertesConan, contadorMuertesEnemigos, contadorHordasSuperadas, contadorMuertesBosses, contadorPartida);

            System.out.println("-------------------------------------------------------------");

            System.out.println("");

            System.out.println("quieres echar otra partida?");

            seguirPartida = sc.nextLine().charAt(0);


        }while(seguirPartida == 's');

        sc.nextLine(); // pausa

        System.out.println("--------- Etadisticas Totales Del Juego --------------");

        mostrarEstadisticasJuego(contadorDuelo, contadorMuertesConan, contadorMuertesEnemigos, contadorHordasSuperadas, contadorMuertesBosses, contadorPartida);

        sc.close();
    }
}
