package EjerciciosFechas;

import java.util.Scanner;

public class tarea3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        /*
         * Utilizando el texto siguiente realiza lo siguiente:

        Muchos años después,
        frente al pelotón de fusilamiento, el coronel Aureliano Buendia había de
        recordar aquella tarde remota en que su padre lo llevó a conocer el
        hielo. (Cien años de soledad. G. García Márquez).
        Mostrar la información del libro sabiendo que aparece despues del simbolo '(' : "Libro: Cien años de soledad. G. García Márquez"
        Busca un número random entre 0 y el número total de caracters  y muestralo por pantalla. El caracter en la posicion X es:
        Trocea el texto en palabras y devuelve la palabra que esté en la posición que indique un número aleatorio entre 0 y el número de palabras. -> La palabra en la posición x es: XXXX
        Preguntar :¿Como se llamaba el coronel? y si responde su nombre o su apellido o ambos, sin tener en cuenta las  mayúsculas/minúsculas) indicar que se ha acertado la pregunta, en caso contrario, decir que no es esa la persona
         
        */

        final String texto = "Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendia había derecordar aquella tarde remota en que su padre lo llevó a conocer elhielo. (Cien años de soledad. G. García Márquez)";

        Scanner sc = new Scanner(System.in);

        int posicionParentesis = texto.indexOf(('('));
        
        String informacion = texto.substring(posicionParentesis + 1);

        // mejor usar .substring con indice inicial "(" e indice final ")" y asi
        // solo coge ese trozo de cadena.

        System.out.println(informacion);

        int longTexto = texto.length();
        int posicionRamdom =(int) (Math.random()*(longTexto-1));
        
        System.out.println("la posicion es " + posicionRamdom + " y el caracter es " + texto.charAt(posicionRamdom));

        String trozos[] = texto.split(" ");

        int posicionPalabra = (int) (Math.random() * (trozos.length-1));

        System.out.println(trozos[posicionPalabra]);

        System.out.println("como se llama el coronel?");

        String respuesta = sc.nextLine();

        respuesta.toLowerCase();

        
        
        

        
    }
}
