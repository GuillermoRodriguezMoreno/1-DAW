package ExamenTema2.recuperacion;

import java.util.Scanner;

public class Ejercicio1_GuillermoRodriguez {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // variables

        String texto = "La libertad, Sancho, es uno de los más preciosos dones que a los hombres dieron los cielos; con ella no pueden igualarse los tesoros que encierra la tierra ni el mar encubre; por la libertad así como por la honra se puede y debe aventurar la vida, y, por el contrario, el cautiverio es el mayor mal que puede venir a los hombres(Don Quijote – Miguel de Cervantes)";

        int longitudTexto = texto.length();

        // posicion aleatoria desde 0 hasta longitud del texto - 1

        int posicionAleatoria = (int) (Math.random() * longitudTexto);

        // caracter de la posicion aleatoria

        char caracterAleatorio = texto.charAt(posicionAleatoria);

        // a)

        System.out.println("a)");

        System.out.println( caracterAleatorio == ' ' ? "Espacio" : "el caracter aleatorio es " + caracterAleatorio);

        // b)

        System.out.println("b)");

        System.out.println("introduce el caracter a eliminar");

        char caracterAEliminar = sc.nextLine().charAt(0);

        caracterAEliminar = Character.toLowerCase(caracterAEliminar); // convierto el caracter a minuscula

        texto = texto.toLowerCase(); // convierto el texto a minuscula

        String textoReemplazado; 

        textoReemplazado = texto.replaceAll(String.valueOf(caracterAEliminar), ""); // convierto caracter a string y lo reemplazo por cadena vacia

        System.out.println("El texto con el caracter reemplazado es: ");
        System.out.println(textoReemplazado);

        // c)

        int posicionInicial = 0;
        int posicionFinal = 0;

        posicionInicial = texto.indexOf("("); // busco el inicio de parentesis
        posicionFinal = texto.indexOf(")"); // busco el final de parentesis

        String informacionLibro = texto.substring((posicionInicial + 1), posicionFinal); // corto la cadena con substring y las posiciones de los parentesis

        System.out.println("c)");

        System.out.println("la informacion del libro es " + informacionLibro);

        sc.close();
    }
}
