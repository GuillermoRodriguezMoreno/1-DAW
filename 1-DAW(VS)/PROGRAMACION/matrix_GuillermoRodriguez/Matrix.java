
/* 
 * 
 * 
 * - Pensar como sacar el rango de infeccion de smith en iteracion 2
 * - Pensar como sacar rango de destruccion de neo en iteracion 5
 * 
 * - falta mostrar cuando mueren
 * - falta ordenar por fecha los smith
 * - Falta mostrar informacion de smith y neo
 */


package matrix_GuillermoRodriguez;

import java.util.*;

import matrix_GuillermoRodriguez.personajes.*;

public class Matrix {

    // Variables Staticas
    static ArrayList<PersonajeGenerico> factoriaPersonajes = generarFactoria();
    static ArrayList <Personaje> matrix = inicializarMatrix();
    static ArrayList<Smith> cementerio = new ArrayList<>();

    // Formato
    static String redBg = "\u001B[41m";
    static String greenBg = "\u001B[42m";
    static String blueBg = "\u001B[44m";
    static String yellowBg = "\u001B[43m";
    static String whiteBg = "\u001B[47m";
    static String blackBg = "\u001B[440m";
    static String resetColor = "\u001B[0m";

    
    public static void main(String[] args) {
        
        // Imprimo factoria
        System.out.println(imprimirFactoria());

        // Compruebo tamaño factoria
        System.out.print("Tamaño Factoria: ");
        System.out.println(factoriaPersonajes.size() + "\n");

        // Imprimo mundo Matrix
        System.out.println(imprimirMatrix());

        // Contador iteraciones
        int iteraciones = 0;

        // Bucle de partida, finaliza a la 300 iteraciones o cuando no queden personajesGenericos vivos
        while(iteraciones < 300 && comprobarMundo() == true){

            // Incremento iteraciones
            iteraciones++;

            // Muestro turno actual
            System.out.println("\n" + yellowBg + "------------------- TURNO " + iteraciones + " -----------------" + resetColor + "\n");

            System.out.println(imprimirMatrix() + "\n");

            // Evaluo la supervivencia de los personajes en cada iteracion
            evaluarSupervivencia();

            // cada 2 iteraciones
            if(iteraciones%2 == 0){

                // Smith actua
                accionSmith();
                
            }

            // cada 5 iteraciones
            if(iteraciones%5 == 0){

                // Actua Neo
                accionNeo();

            }

            // Cada 10 iteraciones
            if(iteraciones%10 == 0){

                // Aparecen 5 personajes si es posible
                aparicionPersonajes();

            }

            // Cada 30 iteraciones
            if(iteraciones%30 == 0){

                // Se crea un PersonajeGenerico en la factoria
                crearPersonajeGenerico();

            }

            // Imprimo Matrix
            System.out.println("\n--------------ESTADO FINAL TURNO MATRIX----------------");
            System.out.println("\n" + imprimirMatrix() + "\n");

            //Compruebo tamaño factoria
            System.out.println("\nTamaño Factoria: " + factoriaPersonajes.size() + "\n");

            
        }

        // Imprimo factoria

        System.out.println("Factoria:\n");

        System.out.println(imprimirFactoria());

        // Imprimo cementerio

        System.out.println("Cementerio:\n");

        System.out.println(imprimirCementerio());

        System.out.println("\nMATRIX HA TERMINADO, PULSA 1 PARA VER EL MUNDO DESTRUIDO (Cortesia de ChatGPT) O CUALQUIER OTRA COSA PARA TERMINAR\n");

        Scanner sc = new Scanner(System.in);

        if(sc.nextLine().equals("1")){

            System.out.println();

            finMatrix();

        }

        sc.close();

    }

    // Metodos

    /**
     * Genera una conjunto de 200 personajes genericos aleatorios
     * @return
     */

    static ArrayList<PersonajeGenerico> generarFactoria(){

        ArrayList<PersonajeGenerico> factoria = new ArrayList<>();

        // Mientras el tamaño sea menos de 200
        while(factoria.size() < 200){

            // Añado personajeGenerico aleatorio
            factoria.add(generarPersonajeAleatorio());

        }

        return factoria;

    }

    /**
     * Genera un personaje generico aleatorio
     * @return
     */

    static PersonajeGenerico generarPersonajeAleatorio(){

        String[] ciudades = {"Madrid", "New York", "Pekin", "Leganés", "Londres", "Paris", "Málaga", "Sevilla", "Tokio", "Brasil", "México"};
        String[] nombres = {"Juan", "Pedro", "María", "Ana", "Luis", "Carlos", "Sofía", "Lucía", "Elena", "Miguel", "Guille", "Elias", "Richard", "Nely"};

        // Posiciones aleatorias de los String
        String ciudadAleatoria = ciudades[(int)(Math.random() * ciudades.length)];
        String nombreAleatorio = nombres[(int)(Math.random() * nombres.length)];

        return new PersonajeGenerico(nombreAleatorio, ciudadAleatoria);

    }

    /**
     * Genera un String con la informacion de los personajes
     * del conjunto
     * @param factoria
     * @return
     */

    static String imprimirFactoria(){

        // Ordeno factoria
        Collections.sort(factoriaPersonajes);

        String resultado = "";

        // Creo iterador para recorrer lista
        Iterator<PersonajeGenerico> it = factoriaPersonajes.iterator();
        
        // Mientras haya siguiente
        while(it.hasNext()){

            // Acumulo en el String
            resultado = resultado + it.next().mostrarInformacion() + "\n";

        }

        return resultado;

    }

    /**
     * Crea matrix con tamaño 25 con un Neo y Smith iniciales y el resto
     * de personajesGenericos
     * @return
     */

    static ArrayList<Personaje> inicializarMatrix(){

        // Creo Matrix
        ArrayList<Personaje> matrix = new ArrayList<>();

        // Añado Neo y Smith iniciales
        Neo neoInicial = new Neo("Neo", "Valhalla");
        Smith smithInicial = new Smith("Smith", "Upside Down", true);
        matrix.add(neoInicial);
        matrix.add(smithInicial);


        //Relleno con personajesGenericos
        while(matrix.size() < 25) {
            
            // posicion aleatoria de factoria
            int posicionAleatoria = (int)(Math.random() * factoriaPersonajes.size());

            // Personaje aleatorio de factoria
            PersonajeGenerico aleatorio = factoriaPersonajes.get(posicionAleatoria);

            // Borro personaje de factoria
            factoriaPersonajes.remove(posicionAleatoria);

            // Añado el personaje a matrix
            matrix.add(aleatorio);

        }

        // Desordeno
        Collections.shuffle(matrix);

        return matrix;

    }
    
    /**
     * Imprime el mundo de Matrix
     * @param matrix
     * @return
     */

    static String imprimirMatrix(){

        String resultado = "";

        // Recorro Matrix
        for (Personaje elemento : matrix) {

            // Si es mull
            if(elemento == null){

                resultado = resultado + whiteBg + "[ ]" + resetColor;
            }

            // Si no es null
            else{

                switch(elemento.getClass().getSimpleName()){

                    // Neo
                    case "Neo":
    
                        resultado = resultado + greenBg + "[N]" + resetColor;
    
                        break;
    
                    // Smith
                    case "Smith":
    
                        resultado = resultado + redBg + "[S]" + resetColor;
    
                        break;
    
                    // PersonajeGenerico
                    case "PersonajeGenerico":
    
                        resultado = resultado + blueBg + "[P]" + resetColor;
    
                        break;
    
                }
            }

        }

        return resultado;
    }

    /**
     * evalua la probabilidad de morir de un personajeGenerico
     */

    static void evaluarSupervivencia(){

        // Recorro Matrix
        for (Personaje elemento : matrix) {

            // Si no es null
            if(elemento != null){
            
                // Si el personaje es Generico
                if(elemento.getClass().getSimpleName().equals("PersonajeGenerico")){

                    // Casting
                    PersonajeGenerico personaje = (PersonajeGenerico)elemento;

                    // Si probabilidad de morir es inferior a 30
                    if(personaje.getProbabilidadMorir() < 30){

                        
                        // Imprimo personajeGenerico muerto
                        System.out.print("HA MUERTO --> ");
                        System.out.println(personaje.mostrarInformacion() + " pos" + matrix.indexOf(personaje));

                        // Obtengo indice
                        int posicion = matrix.indexOf(personaje);

                        //Si tengo reemplazos en la factoria
                        if(factoriaPersonajes.size() > 0){

                            // Reemplazo por personaje aleatorio de la factoria

                            // Desordeno
                            Collections.shuffle(factoriaPersonajes);

                            // reemplazo por la primera posicion
                            matrix.set(posicion, factoriaPersonajes.get(0));

                            // Borro la primera posicion
                            factoriaPersonajes.remove(0);
                        }

                        // Si no tengo reemplazos los pongo a null
                        else{

                            matrix.set(posicion, null);

                        }

                    }

                    // sino
                    else {

                        personaje.setProbabilidadMorir(personaje.getProbabilidadMorir() - 10);

                    }
                }
            }
        }

    }

    /**
     * Smith actua e infecta segun su poder
     */

    static void accionSmith(){

        // Obtengo el poder de infeccion
        int poderInfeccion = (int) (Math.random() * Smith.getInfeccionMax() + 1);

        System.out.println("\nSmith intenta infectar con: " + poderInfeccion);

        // Actualizo atributo de todos los Smith
        Smith.setPoderInfeccion(poderInfeccion);

        // Recorro Matrix
        for (int i = 0; i < matrix.size(); i++) {

            Personaje personaje = matrix.get(i);

            // Si no es null
            if(personaje != null){

                // Si es un Smith y puede infectar
                if(personaje.getClass().getSimpleName().equals("Smith")){

                    // Casting
                    Smith smith = (Smith) personaje;

                    // Si puede infectar

                    if(smith.isPuedeInfectar()){

                        // Obtengo su indice
                        int posicionSmith = matrix.indexOf(personaje);

                        // Si tengo hueco a ambos lados
                        if((posicionSmith - poderInfeccion >= 0) && (posicionSmith + poderInfeccion < matrix.size())){

                            // Recorro desde posicion - poder hasta posicion + poder
                            for (int j = posicionSmith - poderInfeccion; j <= posicionSmith + poderInfeccion; j++) {

                                // Si es un personajeGenerico lo infecto
                                if(matrix.get(j) != null){

                                    if(matrix.get(j).getClass().getSimpleName().equals("PersonajeGenerico")){

                                        // Salida por pantalla
                                        System.out.println("\n" + smith.mostrarInformacion() + " pos" + posicionSmith + " infecta a " + matrix.get(j).mostrarInformacion() + " pos" + j);

                                        matrix.set(j, infectar(matrix.get(j)));

                                    }

                                }
                                    
                            }

                        }

                        // Si el poder de infeccion sale de rango por el principio
                        else if((posicionSmith - poderInfeccion < 0)){

                            // Si tengo hueco al final
                            if(posicionSmith + poderInfeccion < matrix.size()){

                                // Recorro desde el principio hasta posicion + poder
                                for (int j = 0; j <= posicionSmith + poderInfeccion; j++) {

                                    // Si es un personajeGenerico lo infecto
                                    if(matrix.get(j) != null && matrix.get(j).getClass().getSimpleName().equals("PersonajeGenerico")){

                                        // Salida por pantalla
                                        System.out.println("\n" + smith.mostrarInformacion() + " pos" + posicionSmith + " infecta a " + matrix.get(j).mostrarInformacion() + " pos" + j);

                                        infectar(matrix.get(j));

                                    }

                                }
                            }

                            // Si no tengo hueco
                            else{

                                // Recorro hasta el final
                                for (int j = 0; j < matrix.size(); j++) {

                                    // Si es un personajeGenerico lo infecto
                                    if(matrix.get(j) != null && matrix.get(j).getClass().getSimpleName().equals("PersonajeGenerico")){

                                        // Salida por pantalla
                                        System.out.println("\n" + smith.mostrarInformacion() + " pos" + posicionSmith + " infecta a " + matrix.get(j).mostrarInformacion() + " pos" + j);

                                        infectar(matrix.get(j));

                                    }

                                }

                            }
                        
                        }

                        // Si el poder de infeccion sale de rango por el final
                        else if((posicionSmith + poderInfeccion) >= (matrix.size())){

                            // Si tengo hueco al principio
                            if(posicionSmith - poderInfeccion >= 0){

                                for (int j = posicionSmith - poderInfeccion; j < matrix.size(); j++) {
                                    
                                    // Si es un personajeGenerico lo infecto
                                    if(matrix.get(j) != null && matrix.get(j).getClass().getSimpleName().equals("PersonajeGenerico")){

                                        // Salida por pantalla
                                        System.out.println("\n" + smith.mostrarInformacion() + " pos" + posicionSmith + " infecta a " + matrix.get(j).mostrarInformacion() + " pos" + j);

                                        infectar(matrix.get(j));

                                    }

                                }

                            }

                            // Si no tengo hueco
                            else{

                                for (int j = 0; j < matrix.size(); j++) {
                                    
                                    // Si es un personajeGenerico lo infecto
                                    if(matrix.get(j) != null && matrix.get(j).getClass().getSimpleName().equals("PersonajeGenerico")){

                                        // Salida por pantalla
                                        System.out.println("\n" + smith.mostrarInformacion() + " pos" + posicionSmith + " infecta a " + matrix.get(j).mostrarInformacion() + " pos" + j);

                                        infectar(matrix.get(j));

                                    }

                                }

                            }

                        }

                    }

                    // Actualizo el atributo puedeInfectar para la siguiente actuacion de Smith
                    smith.setPuedeInfectar(true);

                }

            }

        }

        System.out.println("\n" + imprimirMatrix() + "\n");

    }

    /**
     * convierte un Personaje en Smith
     * @param personaje
     * @return
     */

    static Smith infectar(Personaje personaje){

        Smith nuevoSmith = new Smith(personaje.getId(),"Smith", "Upside Down", false, personaje.getFechaNacimiento());

        return nuevoSmith;
        
    }


    /**
     * devuelve la posicion de Neo dentro de matrix
     * @return
     */

    static int posicionNeo(){

        int posicion = -1;

        // Recorro Matrix
        for (Personaje elemento : matrix) {
            
            // Si el personaje no es null y es neo
            if(elemento != null && elemento.getClass().getSimpleName().equals("Neo")){

                posicion = matrix.indexOf(elemento);
                return posicion;

            }

        }

        return posicion;
    }

    /**
     * devuelve a neo
     * @return
     */

    static Neo devolverNeo(){

        Neo neo = (Neo)matrix.get(posicionNeo());

        return neo;
    }

    /**
     * Neo actua, segun si es el elegido o no y posteriormente
     * se mueve a una posicion aleatoria de Matrix
     */

    static void accionNeo(){

        // Decide si es el elegido al 50% y actua
        if(((int)(Math.random() * 2)) == 1){

            devolverNeo().setElegido(true);

            // Matar Smiths

            // Obtengo poder de destruccion
            int poderDestruccion = (int) ((Math.random() * devolverNeo().getDestruccionMax()) + 1);
            
            System.out.println("\nNeo es el elegido y tiene " + poderDestruccion + " de destruccion\n");

            // Controlo rangos igual que con la infeccion de Smith

            // Si tengo hueco a ambos lados
            if((posicionNeo() - poderDestruccion >= 0) && (poderDestruccion + posicionNeo() < matrix.size())){

                // Recorro desde posicion - poder hasta posicion + poder
                for (int j = posicionNeo() - poderDestruccion; j <= posicionNeo() + poderDestruccion; j++) {

                    // Si es un Smith lo mato
                    if(matrix.get(j) != null){

                        if(matrix.get(j).getClass().getSimpleName().equals("Smith")){

                            // Casting
                            Smith smith = (Smith) matrix.get(j);

                            // Salida Pantalla
                            System.out.println(devolverNeo().mostrarInformacion() + " pos" + posicionNeo() + " ha matado a " + smith.mostrarInformacion() + " pos" + j +  "\n");

                            // Lo añado al cementerio
                            cementerio.add(smith); 
                            matrix.set(j, null);

                        }

                    }
                        
                }

            }

            // Si el poder de infeccion sale de rango por el principio
            else if((posicionNeo() - poderDestruccion < 0)){

                // Si tengo hueco al final
                if(posicionNeo() + poderDestruccion < matrix.size()){

                    // Recorro desde inicio hasta posicion + poder
                    for (int j = 0; j <= posicionNeo() + poderDestruccion; j++) {

                        // Si es un Smith lo mato
                        if(matrix.get(j) != null){

                            if(matrix.get(j).getClass().getSimpleName().equals("Smith")){

                                // Casting
                                Smith smith = (Smith) matrix.get(j);

                                // Salida Pantalla
                                System.out.println(devolverNeo().mostrarInformacion() + " pos" + posicionNeo() + " ha matado a " + smith.mostrarInformacion() + " pos" + j +  "\n");

                                // Lo añado al cementerio
                                cementerio.add(smith);
                                
                                // Lo mato
                                matrix.set(j, null);

                            }

                        }

                    }
                }

                // Si no tengo hueco
                else{

                    // Recorro hasta el final
                    for (int j = 0; j < matrix.size(); j++) {

                        // Si es un Smith lo mato
                        if(matrix.get(j) != null){

                            if(matrix.get(j).getClass().getSimpleName().equals("Smith")){

                                // Casting
                                Smith smith = (Smith) matrix.get(j);

                                // Salida Pantalla
                                System.out.println(devolverNeo().mostrarInformacion() + " pos" + posicionNeo() + " ha matado a " + smith.mostrarInformacion() + " pos" + j +  "\n");

                                // Lo añado al cementerio
                                cementerio.add(smith);
                                
                                // Lo mato
                                matrix.set(j, null);

                            }

                        }

                    }

                }
            
            }

            // Si el poder de infeccion sale de rango por el final
            else if((posicionNeo() + poderDestruccion) >= (matrix.size())){

                // Si tengo hueco al principio
                if(posicionNeo() - poderDestruccion >= 0){

                    // Recorro desde posicion - poder hasta el final
                    for (int j = posicionNeo() - poderDestruccion; j < matrix.size(); j++) {
                        
                        // Si es un Smith lo mato
                        if(matrix.get(j) != null){

                            if(matrix.get(j).getClass().getSimpleName().equals("Smith")){

                                // Casting
                                Smith smith = (Smith) matrix.get(j);

                                // Salida Pantalla
                                System.out.println(devolverNeo().mostrarInformacion() + " pos" + posicionNeo() + " ha matado a " + smith.mostrarInformacion() + " pos" + j +  "\n");

                                // Lo añado al cementerio
                                cementerio.add(smith); 
                                matrix.set(j, null);

                            }

                        }

                    }

                }

                // Si no tengo hueco
                else{

                    for (int j = 0; j < matrix.size(); j++) {
                        
                        // Si es un Smith lo mato
                        if(matrix.get(j) != null){

                            if(matrix.get(j).getClass().getSimpleName().equals("Smith")){

                                // Casting
                                Smith smith = (Smith) matrix.get(j);

                                // Salida Pantalla
                                System.out.println(devolverNeo().mostrarInformacion() + " pos" + posicionNeo() + " ha matado a " + smith.mostrarInformacion() + " pos" + j +  "\n");

                                // Lo añado al cementerio
                                cementerio.add(smith); 
                                matrix.set(j, null);

                            }

                        }

                    }

                }
            }

        }

        else{

            System.out.println("\nNeo esta cansado\n");

        }


        // Cambiar posicion de Neo
        moverNeo();

        System.out.println("\n" + imprimirMatrix() + "\n");


    }

    /**
     * Mueve a Neo a una posicion aleatoria de Matrix,
     * si en la posicion habia un Smith lo mata, sino, 
     * intercambia posiciones
     */

    static void moverNeo(){

        // Posicion aleatoria de Matrix
        int posicionAleatoria = (int) (Math.random() * matrix.size());

        // Salida
        System.out.println("Neo se mueve a la posicion " + posicionAleatoria);

        // Obtengo el personaje en esa posicion y su respectiva posicion
        Personaje personaje = matrix.get(posicionAleatoria);
        int posicionPersonaje = matrix.indexOf(personaje);

        // Obtengo posicion actual de Neo
        int posicionInicialNeo = posicionNeo();

        // Si la posicion aleatoria es un Smith
        if(personaje != null && personaje.getClass().getSimpleName().equals("Smith")){    
            
            // Salida
            System.out.println("Neo ha matado a " + personaje.mostrarInformacion());

            // Machaco el Smith por neo
            matrix.set(posicionPersonaje, matrix.get(posicionInicialNeo));

            // Pongo a null la posicion anterior de Neo
            matrix.set(posicionInicialNeo, null);

        }

        // Si es un PersonajeGenerico
        else if(personaje != null && personaje.getClass().getSimpleName().equals("PersonajeGenerico")){

            // Intercambio posiciones
            Collections.swap(matrix, posicionInicialNeo, posicionPersonaje);

        }

        else{

            Collections.swap(matrix, posicionInicialNeo, posicionPersonaje);

        }
    }

    /**
     * devuelve la lista de posiciones null de matrix
     * @return
     */

    static ArrayList<Integer> posicionesNull(){

        // Creo lista
        ArrayList<Integer> listaPosicionesNull = new ArrayList<>();

        // Recorro Matrix
        for (int i = 0; i < matrix.size(); i++) {
            
            // Si es null añado su posicion
            if(matrix.get(i) == null){

                listaPosicionesNull.add(i);

            }

        }

        return listaPosicionesNull;

    }

    /**
     * Aparece en matrix 5 personajesGenericos o los que sean posibles
     * en Matrix en posiciones aleatorias
     */

    static void aparicionPersonajes(){

        System.out.println("Aparecen personajes si hay hueco!\n");

        // Obtengo lista de posiciones null
        ArrayList<Integer> listaPosicionesNull = posicionesNull();

        // Desordeno lista
        Collections.shuffle(listaPosicionesNull);

        //Desordeno factoria
        Collections.shuffle(factoriaPersonajes);

        // Si la factoria tiene 5 o mas
        if(factoriaPersonajes.size() >= 5){

            // Si la lista de null es 5 o mas
            if(listaPosicionesNull.size() >= 5){

                // Hago un bucle de 5
                for (int i = 0; i < 5; i++) {

                    // Salida por pantalla
                    System.out.println("Aparece un personaje en la posicion " + listaPosicionesNull.get(i));
                    
                    // Sustituyo en Matrix
                    matrix.set(listaPosicionesNull.get(i), factoriaPersonajes.get(i));

                }

            }

            // si la lista es menor de 5
            else{

                // Recorro hasta tamaño lista
                for (int i = 0; i < listaPosicionesNull.size(); i++) {

                    // Salida por pantalla
                    System.out.println("Aparece un personaje en la posicion " + listaPosicionesNull.get(i));
                    
                    // Sustituyo en Matrix
                    matrix.set(listaPosicionesNull.get(i), factoriaPersonajes.get(i));

                }

            }

        }

        // Si la factoria tiene menos de 5
        if(factoriaPersonajes.size() < 5){

            // Recorro hasta tamaño factoria
            for (int i = 0; i < factoriaPersonajes.size(); i++) {

                // Salida por pantalla
                System.out.println("Aparece un personaje en la posicion " + listaPosicionesNull.get(i));
                
                // Sustituyo en Matrix
                matrix.set(listaPosicionesNull.get(i), factoriaPersonajes.get(i));

            }

        }

        // Si la factoria esta vacia
        else if (factoriaPersonajes.isEmpty()){

            System.out.println("No quedan personajes en la factoria");

        }

    }

    /**
     * crea un nuevo personajeGenerico y lo añade a la factoria
     */

    static void crearPersonajeGenerico(){

        factoriaPersonajes.add(generarPersonajeAleatorio());

    }

    /**
     * Comprueba si quedan PersonajesGenericos en matrix
     * @return
     */

    static boolean comprobarMundo(){

        boolean mundoExiste = false;
        boolean hayPersonajes = false;

        // Recorro Matrix
        for (Personaje elemento : matrix) {
            
            // Si es un PersonajeGenerico aun existe el mundo
            if(elemento != null && elemento.getClass().getSimpleName().equals("PersonajeGenerico")){

                hayPersonajes = true;

            }

        }

        if(hayPersonajes || !factoriaPersonajes.isEmpty()){

            mundoExiste = true;

        }

        return mundoExiste;

    }

    static String imprimirCementerio(){

        // Ordeno Cementerio (Mas antiguo primero)
        Collections.sort(cementerio);

        // Invierto
        Collections.reverse(cementerio);

        String resultado = "";

        // Creo iterador para recorrer lista
        Iterator<Smith> it = cementerio.iterator();
        
        // Mientras haya siguiente
        while(it.hasNext()){

            // Acumulo en el String
            resultado = resultado + it.next().mostrarInformacion() + "\n";

        }

        return resultado;
    }

    /**
     * imprime numeros binarios aleatorios durante 3 segundos (cortesia de ChatGPT)
     */

    static void finMatrix(){

        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();

        // Definir la cantidad de columnas y filas que deseas mostrar
        int columnas = 100;
        int filas = 40;

        // Crear una matriz que represente las líneas binarias
        int[][] lines = new int[columnas][filas];
        for (int i = 0; i < columnas; i++) {
            // Generar una longitud aleatoria para la línea actual
            int length = random.nextInt(filas);
            // Llenar la línea actual con números binarios aleatorios
            for (int j = 0; j < length; j++) {
                lines[i][j] = random.nextInt(2);
            }
        }

        // Obtener la marca de tiempo actual en milisegundos
        long startTime = System.currentTimeMillis();

        // Crear un bucle infinito para mostrar la animación continuamente
        while (true) {
            // Borrar la consola para que la animación parezca continua
            System.out.print("\033[H\033[2J");

            // Crear un bucle para mostrar cada fila
            for (int i = 0; i < filas; i++) {
                // Crear un bucle para mostrar cada columna de la fila actual
                for (int j = 0; j < columnas; j++) {
                    // Establecer el fondo en negro o verde dependiendo del número binario
                    if (lines[j][i] == 0) {
                        System.out.print("\u001B[40m");
                    } else {
                        System.out.print("\u001B[42m");
                    }
                    // Mostrar el número binario en la posición actual
                    System.out.print(lines[j][i]);
                }
                // Restablecer el fondo en negro después de imprimir la línea actual
                System.out.print("\u001B[40m");
                // Agregar una pausa para controlar la velocidad de la animación
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // Agregar un salto de línea para pasar a la siguiente fila
                System.out.println();
            }

            // Comprobar si han pasado 3 segundos y salir del bucle si es así
            if (System.currentTimeMillis() - startTime >= 3000) {
                break;
            }
        }
    }

}
