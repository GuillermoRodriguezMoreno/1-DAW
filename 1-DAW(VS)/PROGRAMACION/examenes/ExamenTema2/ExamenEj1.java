package ExamenTema2;

import java.util.Scanner;

public class ExamenEj1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String textoCompleto ="El Viajero a través del Tiempo (pues convendrá llamarle así al hablar de él) nos exponía una misteriosa cuestión. Sus ojos grises brillaban lanzando centellas, y su rostro, habitualmente pálido, mostrábase encendido y animado. El fuego ardía fulgurante y el suave resplandor de las lámparas incandescentes, en forma de lirios de plata, se prendía en las burbujas que destellaban y subían dentro de nuestras copas. Nuestros sillones, construidos según sus diseños, nos abrazaban y acariciaban en lugar de someterse a que nos sentásemos sobre ellos; y había allí esa sibarítica atmósfera de sobremesa, cuando los pensamientos vuelan gráciles, libres de las trabas de la exactitud.(La maquina del tiempo, H.G.Wells)";

        int longitudTexto = textoCompleto.length(); // medir longitud texto

        //caracter posicion aleatoria

        int posicionAleatoria = (int) (Math.random() * (longitudTexto - 1)); //posicion aleatoria en rango 0 - (longitud-1)

        char caracterAleatorio = textoCompleto.charAt(posicionAleatoria); //buscar caracter en posicion aleatoria

        System.out.println((caracterAleatorio == ' ') ? "el caracter aleatorio es espacio" : "el caracter aleatorio es " + caracterAleatorio);

        //reemplazar un caracter dado por 'e'

        System.out.println("introduce el caracter que quieres reemplazar");

        char caracterReemplazar = sc.nextLine().charAt(0); //leo el caracter

        String textoReemplazado = textoCompleto.replace(caracterReemplazar, 'e'); //reemplazo los caracteres

        System.out.println(textoReemplazado);

        //Buscar palabra en el texto

        System.out.println("indica la palabra a buscar");

        String palabra = sc.nextLine().toLowerCase(); //convierto la palabra a minusculas

        int posicionPalabra = (textoCompleto.toLowerCase()).indexOf(palabra); //convierto todo el texto a minusculas

        System.out.println((posicionPalabra == -1) ? "la palabra no se encuentra en el texto" : "la palabra si se encuentra en el texto");

        //

        sc.close();
    }
}
