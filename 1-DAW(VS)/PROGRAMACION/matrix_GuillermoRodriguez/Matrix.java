
/* Preguntar porque los personajes static se inicializan en null
 * Preguntar como funciona lo de la fecha
 * 
 * - Pensar como sacar el rango de infeccion de smith en iteracion 2
 * - Pensar como sacar rango de destruccion de neo en iteracion 5
 * - falta iteracion 10
 * - falta mostrar cuando mueren
 * - falta ordenar por fecha los smith
 */


package matrix_GuillermoRodriguez;

import java.util.*;

import matrix_GuillermoRodriguez.personajes.*;

public class Matrix {

    // Variables Staticas
    static ArrayList<PersonajeGenerico> factoriaPersonajes = generarFactoria();
    static ArrayList <Personaje> matrix = inicializarMatrix();
    static ArrayList<Smith> cementerio = new ArrayList<>();

    static Neo neoInicial = new Neo("Neo", "Valhalla");
    static Smith smithInicial = new Smith("Smith", "Upside Down");
    
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
        while(iteraciones < 300 && factoriaPersonajes.size() > 0){

            // Incremento iteraciones
            iteraciones++;

            // Muestro turno actual
            System.out.println("\n---------- TURNO " + iteraciones + " -----------\n");

            // Evaluo la supervivencia de los personajes en cada iteracion
            evaluarSupervivencia();

            // cada 2 iteraciones
            if(iteraciones % 2 == 0){

                // Smith actua
                //accionSmith();
            }

            // cada 5 iteraciones
            else if(iteraciones % 5 == 0){

                // Actua Neo
                //accionNeo();

            }

            // Cada 10 iteraciones
            else if(iteraciones % 10 == 0){

                aparicionPersonajes();

            }

            // Cada 30 iteraciones
            else if(iteraciones % 30 == 0){

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

        for (Personaje elemento : matrix) {

            if(elemento == null){

                resultado = resultado + "[ ]";
            }

            else{

                switch(elemento.getClass().getSimpleName()){

                    case "Neo":
    
                        resultado = resultado + "[N]";
    
                        break;
    
                    case "Smith":
    
                        resultado = resultado + "[S]";
    
                        break;
    
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

            // Si es un Smith
            if(personaje.getClass().getSimpleName().equals("Smith")){

                // Obtengo su indice
                int posicionSmith = matrix.indexOf(personaje);

                // Recorro rango de infeccion

                //Primero el rango anterior
                //for (int j = posicionSmith - poderInfeccion; j < array.length; j++) {
                    
                //}

                // Despues rango posterior
            }
        }
    }

    /**
     * convierte un Personaje en Smith
     * @param personaje
     * @return
     */

    static Smith infectar(Personaje personaje){

        Smith nuevoSmith = (Smith) personaje;

        return nuevoSmith;
    }

    /**
     * Neo actua, segun si es el elegido o no y posteriormente
     * se mueve a una posicion aleatoria de Matrix
     */

    static void accionNeo(){

        // Decide si es el elegido al 50% y actua
        if(((int)(Math.random() * 2)) == 1){

            neoInicial.setElegido(true);

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
        int posicionInicialNeo = matrix.indexOf(neoInicial);

        // Si la posicion aleatoria es un Smith
        if(personaje.getClass().getSimpleName().equals("Smith")){            

            // Machaco el Smith por neo
            matrix.set(posicionPersonaje, neoInicial);

            // Pongo a null la posicion anterior de Neo
            matrix.set(posicionInicialNeo, null);

        }

        // Si es un PersonajeGenerico
        else if(personaje.getClass().getSimpleName().equals("PersonajeGenerico")){

            // Intercambio posiciones
            Collections.swap(matrix, posicionInicialNeo, posicionPersonaje);

        }
    }

    static void aparicionPersonajes(){


    }

    /**
     * crea un nuevo personajeGenerico y lo añade a la factoria
     */

    static void crearPersonajeGenerico(){

        factoriaPersonajes.add(generarPersonajeAleatorio());

    }
}
