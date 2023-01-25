package EjerciciosArrays.Nacho;

import java.util.Scanner;

public class test {

    /*
     *  //Aqui el objeto persona que tienes las caracteristicas que preguntas
     *  //y un id.
     * 
     *  //no se como se hace aun, pero en Go es:
     * 
     *  type person struct {
	 *      personID string // id de la persona: id tipo String
	 *      IsBold   bool   // primera caracteristica: esCalvo tipo boolean
	 *      IsWoman  bool   // segunda caracteristica: esMujer tipo boolean
	 *      IsBlond  bool   // tercera caracteristica: esRubio tipo boolean
     *  }
     */

     /*
      * //Creas la variable persona
      *
      * var personaCorrecta person
      */
    
    public static void main(String[] args) {
        
        System.out.println("Bienvenidos al juego");

        // Creas un int random de 1 hasta el numero de personajes que tienes, en este
        // ejemplo son 3.

        int personaAleatoria = (int) (Math.random() * 4 + 1); // int random de 1 a 3

        // lees la linea numero (personaAleatoria) del archivo txt que incluye los personajes

        // En Go es:
        /*
         * fileInputLine := leerLineaArchivo(personaAleatoria)
         */

        // le das los valores leidos al objeto creado personaCorrecta.

        //En Go es:
        /*
         * personaCorrecta = crearPersona(fileInputLine)
         */

        boolean personaAcertada = false; // creas el boolean que controla el bucle while

        // mientras la persona no se adivine

        Scanner sc = new Scanner(System.in); //inicializar Scanner

        while(personaAcertada == false){

            // Menu de preguntas

            System.out.println("elige una pregunta:");
            System.out.println("1. es calvo/a?");
            System.out.println("2. es rubio/a?");
            System.out.println("3. es una mujer?");

            int preguntaSeleccionada = sc.nextInt(); // int de pregunta seleccionada

            // funcion responder a pregunta y se vuelva el valor a un boolean
            
            boolean esCierto = responderAPregunta(preguntaSeleccionada); // funcion responder a pregunta

            // salida por pantalla si es verdadero o no la pregunta seleccionada

            System.out.println("La respuesta es: " + esCierto);

            // Preguntar si se conoce la persona correcta

            System.out.println("quieres adivinar la persona? Presiona 0 para elegir otra pregunta");

            String respuesta = sc.nextLine();

            // if si quieres hacer otra pregunta o adivinar

            if(respuesta != "0" ){ // si eliges adivinar

                if(respuesta == personaAleatoria.personID){ // si la respuesta es igual al id del objeto persona

                    personaAcertada = true;

                } else{ // si la respues no coincide con el id del objeto persona creado

                    System.out.println("has fallado!");

                }
            }

        }

        System.out.println("Enhorabuena, has acertado!"); // salida por pantalla una vez salido del bucle

    }

    //las carateristicas del objetos no se como se hacen en java asi que los pongo como en Go

    //Funcion responder a pregunta

    static boolean responderAPregunta(String caracteristicaPersona){

        switch(caracteristicaPersona){

            case "1": //"es calvo?"

            return correctPerson.IsBold; // devuelve el booleano de la caracteristica es calvo

            case "2": //es rubio?"

            return correctPerson.IsBlond;

            case "3": //es una mujer?"

            return correctPerson.IsWoman;

            default:

            return false;
        }

        //Funcion crearPersona. devuelve una clase persona

        static persona crearPersona(String lineaFichero){ // le entra un numero de linea del fichero

            String[] caracteristicasPersona = new String[3]; // creas un array con el numero de caracteristicas

            caracteristicasPersona = lineaFichero.split(","); // partes la linea del fichero por "," y le das los valores al array

            // creas el objeto persona aleatoria con los valores del array
            // no se como se hace en java pero en Go es asi

            personaAleatoria = persona{

                IdPersona: caracteristicaPersona[0];

            }

            // si el valor es 1 entonces es true , si es 0 es false

            if caracteristicaPersona[1] == "1"{

                personaAleatoria.esCalvo = true;

            }

            if caracteristicasPersona[2] == "1" {

                personaAleatoria.esRubio = true

            }

            if caracteristicaPersona[3] == "1" {

                personaAleatoria.esMujer = true

            }

            return personaAleatoria; // devulve persona

        }

        // funcion leerLineaArchivo. devuelve un String y le entra un int

        /*
         * esto lo busco ella en internet y es como funciona leer lineas de un archivo
         * simplemente puso en goolge "read file by line in Go" y copio y pego.
         * asi q no se como se podria hacer en java pero seguro q se puede.
         *
         */

        static String leerLineaArchivo(int numeroAleatorio){

            var lines []string

	        readFile, err := os.Open("people.txt")

            if err != nil {

                fmt.Println(err)
            }

            fileScanner := bufio.NewScanner(readFile)

            fileScanner.Split(bufio.ScanLines)

            for fileScanner.Scan() {

                lines = append(lines, fileScanner.Text())

            }

            readFile.Close()
            
            return lines[randomNumber]

        }
    }
}
