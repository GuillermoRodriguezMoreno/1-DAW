import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelos.Pelicula;
import modelos.Persona;
import modelos.RespuestaPelicula;
import modelos.RespuestaPersona;
import utils.UtilsLecturaTeclado;
import utils.UtilsWS;

public class App {

    // Variables staticas
    static UtilsLecturaTeclado lecturaTeclado = new UtilsLecturaTeclado();

    public static void main(String[] args) throws Exception {

        // Prueba

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel menuP = new JLabel(menu());
        JTextField opcionP = new JTextField(1);

        panel.add(menuP);
        panel.add(opcionP);

        // Salida menu
        //menu();

        // Funcionalidad
        //funcionalidad();

        // Cerrar recursos
        //lecturaTeclado.finalizarLectura();
        
    }


    // Menu

    /**
     * Muestra las opciones del menu
     */
    static String menu(){

        System.out.println("\n|========== Menu ===========|");
        System.out.println("|                           |");
        System.out.println("| 1 - Buscar Película.      |");
        System.out.println("| 2 - Buscar Actor/Director.|");
        System.out.println("| 0 - Salir.                |");
        System.out.println("|                           |");
        System.out.println("|===========================|\n");

        System.out.println("Selecciona una opcion");

        return "\n|========== Menu ===========|\n|                           |\n| 1 - Buscar Película.      |\n| 2 - Buscar Actor/Director.|\n| 0 - Salir.                |\n|                           |\n|===========================|\n";

    }

    // Funcionalidad

    /**
     *  1 - Buscar pelicula
     *  2 - Buscar Persona
     *  0 - Salir
     */
    static void funcionalidad() {

        int opcion = lecturaTeclado.leerInt();

        while (opcion != 0){

            switch(opcion){

                // Buscar pelicula

                case 1:

                    buscarPelicula();

                    break;

                // Buscar actor/director

                case 2:

                    buscarActorDirector();

                    break;

                // Opcion incorrecta

                default:

                    System.out.println("Introduce una opcion correcta");

                    break;

            }

            menu();

            opcion = lecturaTeclado.leerInt();

        }

        System.out.println("\nHas salido del programa");

    }

    // Buscar por pelicula

    /**
     * Busca las 10 peliculas en la API
     */
    private static void buscarPelicula() {

        String informacion = "";

        // Pido titulo pelicula

        System.out.println("introduce el titulo de la pelicula");

        String titulo = "";

        do{

            titulo = lecturaTeclado.leerCadena();

            if(titulo.isBlank()){

                System.out.println("La cadena esta vacia");

            }

        }while(titulo.isBlank());


        // Leo desde WS

        RespuestaPelicula respuesta = UtilsWS.leerPeliculaFromWS(titulo);

        // Obtengo lista peliculas

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>(respuesta.getResults());

        // Si la lista es menor de 10

        if(listaPeliculas.size() <= 10){

            // Recorro lista

            for (int i = 0; i < listaPeliculas.size(); i++) {

                informacion = informacion + (i + 1) + " - " + listaPeliculas.get(i).getTitle() + "\n";
                
            }

        }

        // Si la lista es mayor de 10

        else{

            for (int i = 0; i < 10; i++) {

                informacion = informacion + (i + 1) + " - " + listaPeliculas.get(i).getTitle() + "\n";

            }

        }

        System.out.println(informacion);

        // Pregunto por informacion detallada

        informacionDetallada(listaPeliculas);

    }

    // Buscar por actor/director


    /**
     * Busca las 10 personas en la API
     */
    private static void buscarActorDirector() {

        String informacion = "";

        // Pido nombre persona

        System.out.println("introduce el nombre a buscar");

        String nombre = "";

        do{

            nombre = lecturaTeclado.leerCadena();

            if(nombre.isBlank()){

                System.out.println("La cadena esta vacia");
                
            }

        }while(nombre.isBlank());

        // Leo desde WS

        RespuestaPersona respuesta = UtilsWS.leerPersonaFromWS(nombre);

        // Obtengo lista nombres

        ArrayList<Persona> listaNombres = new ArrayList<>(respuesta.getResults());

        // Si la lista es menor de 10

        if(listaNombres.size() <= 10){

            // Recorro lista

            for (int i = 0; i < listaNombres.size(); i++) {

                informacion = informacion + (i + 1) + " - " + listaNombres.get(i).getName() + "\n";
                
            }

        }

        // Si la lista es mayor de 10

        else{

            for (int i = 0; i < 10; i++) {

                informacion = informacion + (i + 1) + " - " + listaNombres.get(i).getName() + "\n";

            }

        }

        System.out.println(informacion);

        // Pregunto por informacion detallada

        informacionDetallada(listaNombres);

    }

    // Informacion detallada


    /** Muestra la informacion detallada de un elemento concreto */
    static <T> void informacionDetallada(ArrayList<T> lista) {

        // Pido numero

        System.out.println("\nPulse el número de la película/nombre para ver la información completa o pulse 0 para volver al menú principal…");

        int opcion = lecturaTeclado.leerInt();

        // Mientras no salga

        while(opcion != 0){

            // Obtengo indice

            int indice = opcion - 1;

            // Si no encuentra el numero o selecciona uno mayor a 10

            if(lista.get(indice) == null || indice >= 10){

                System.out.println("El numero seleccionado no es correcto, introduce uno correcto");

                opcion = lecturaTeclado.leerInt();
            }

            // Muestro la informacion detallada

            else{

                System.out.println(lista.get(indice).toString());

                System.out.println("\nPulse el número de la película/nombre para ver la información completa o pulse 0 para volver al menú principal…");

                opcion = lecturaTeclado.leerInt();

            }
        }

        System.out.println("\nHas vuelto al menu principal\n");
    }

}
