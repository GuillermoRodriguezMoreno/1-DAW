
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
            System.out.println("\n---------- TURNO " + iteraciones + " -----------\n");

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
            System.out.println();
            System.out.println(imprimirMatrix());

            //Compruebo tamaño factoria
            System.out.println("\nTamaño Factoria: " + factoriaPersonajes.size()); 
        }

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

                resultado = resultado + "[ ]";
            }

            // Si no es null
            else{

                switch(elemento.getClass().getSimpleName()){

                    // Neo
                    case "Neo":
    
                        resultado = resultado + "[N]";
    
                        break;
    
                    // Smith
                    case "Smith":
    
                        resultado = resultado + "[S]";
    
                        break;
    
                    // PersonajeGenerico
                    case "PersonajeGenerico":
    
                        resultado = resultado + "[P]";
    
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
                        System.out.println(personaje.mostrarInformacion());

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

                        // Si el poder de infeccion sale de rango por el principio y hay hueco a la derecha
                        if((poderInfeccion > posicionSmith) && ((posicionSmith + poderInfeccion) < matrix.size())){

                            // Recorro hasta su capacidad de infeccion
                            for (int j = 0; j < poderInfeccion + poderInfeccion; j++) {
                                
                                matrix.set(j, infectar(matrix.get(j)));

                            }

                        }

                        // Si el poder de infeccion sale de rango por el final
                        else if((posicionSmith + poderInfeccion) > (matrix.size()-1)){

                            for (int j = posicionSmith - poderInfeccion; j < poderInfeccion; j++) {
                                
                                matrix.set(j, infectar(matrix.get(j)));

                            }

                        }

                    }

                    // Actualizo el atributo puedeInfectar para la siguiente actuacion de Smith
                    smith.setPuedeInfectar(true);

                }

            }

        }

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

    static int poscionNeo(){

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

        Neo neo = (Neo)matrix.get(poscionNeo());

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

            // Falta matar Smiths
        }

        // Cambiar posicion de Neo
        moverNeo();

    }

    /**
     * Mueve a Neo a una posicion aleatoria de Matrix,
     * si en la posicion habia un Smith lo mata, sino, 
     * intercambia posiciones
     */

    static void moverNeo(){

        // Posicion aleatoria de Matrix
        int posicionAleatoria = (int) (Math.random() * matrix.size());

        // Obtengo el personaje en esa posicion y su respectiva posicion
        Personaje personaje = matrix.get(posicionAleatoria);
        int posicionPersonaje = matrix.indexOf(personaje);

        // Obtengo posicion actual de Neo
        int posicionInicialNeo = poscionNeo();

        // Si la posicion aleatoria es un Smith
        if(personaje != null && personaje.getClass().getSimpleName().equals("Smith")){            

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
        for (Personaje elemento : matrix) {
            
            // Si es null añado su posicion
            if(elemento == null){

                listaPosicionesNull.add(matrix.indexOf(elemento));
            }
        }

        return listaPosicionesNull;

    }

    /**
     * Aparece en matrix 5 personajesGenericos o los que sean posibles
     * en Matrix en posiciones aleatorias
     */

    static void aparicionPersonajes(){

        // Si hay personajes en la factoria
        if(!factoriaPersonajes.isEmpty()){

            // Obtengo lista de posiciones null
            ArrayList<Integer> listaPosicionesNull = posicionesNull();

            // Desordeno factoria
            Collections.shuffle(factoriaPersonajes);

            // Si hay 5 o menos posiciones null y la factoria tiene al menos 5 personajes
            if(listaPosicionesNull.size() <= 5 && factoriaPersonajes.size() >= 5){

                // Recorro posiciones null
                for (int i = 0; i < listaPosicionesNull.size(); i++) {
                    
                    // Añado Personaje de la factoria
                    matrix.add(i, factoriaPersonajes.get(i));

                }

            }

            // Sino
            else{

                // Desordeno lista de null
                Collections.shuffle(listaPosicionesNull);

                // Recorro factoria ya que su tamaño es menor que las posiciones libres
                for (int i = 0; i < factoriaPersonajes.size(); i++) {

                    // Obtengo posicion
                    int poscionNull = listaPosicionesNull.get(i);

                    // Obtengo Personaje de factoria
                    PersonajeGenerico personaje = factoriaPersonajes.get(i);
                    
                    matrix.add(poscionNull, personaje);

                }

            }

        }

        else{

            System.out.println("No quedan Personajes en la factoria");

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

        boolean hayPersonajes = false;

        // Recorro Matrix
        for (Personaje elemento : matrix) {
            
            // Si es un PersonajeGenerico aun existe el mundo
            if(elemento != null && elemento.getClass().getSimpleName().equals("PersonajeGenerico")){

                hayPersonajes = true;
                return hayPersonajes;

            }

        }

        return hayPersonajes;

    }

}
