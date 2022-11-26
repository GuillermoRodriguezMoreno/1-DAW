package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class CifradoPlus {

    public static String cifrar (String texto, int factorCifrado) {

        int longitudTexto = texto.length();
    
        char caracter = ' ';
    
        String textoNuevo = "";
    
            for(int i = 0 ; i < longitudTexto ; i++){
    
                caracter = texto.charAt(i);
    
                if(caracter != ' '){
    
                    caracter = (char) (caracter + factorCifrado);
    
                    textoNuevo = textoNuevo + factorCifrado + caracter;
    
                }
            }
    
        return textoNuevo;    
    }

    public static String descifrar (String texto){

        String textoDescifrado = "";
        int factorCifrado = 0;
        char caracter = ' ';
        char factor = ' ';
        String cadenaFactor = "";

        factor = texto.charAt(0);

        factorCifrado = Character.getNumericValue(factor);
        
        cadenaFactor = cadenaFactor + factor;

        texto = texto.replaceAll(cadenaFactor, "");

        for(int posiciones = 0; posiciones < textoDescifrado.length(); posiciones ++){

            caracter = (char)(texto.charAt(0) - factorCifrado);

            textoDescifrado = textoDescifrado + caracter;
        }

        return textoDescifrado;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        String texto = "";
        String textoNuevo = "";
        int factorCifrado = 0;
        String textoADescifrar = "";
        String textoDescifrado = "";

        do{

            System.out.println("introduce una de las opciones:");
            System.out.println(" 1 - Cifrar texto");
            System.out.println("2 - Descifrar texto");
            System.out.println("3 - Salir");

            opcion = sc.nextInt();

            switch (opcion){

                case 1:

                    System.out.println("introduce el texto a cifrar");

                    texto = sc.nextLine();

                    System.out.println("introduce el factor de cifrado");

                    factorCifrado = sc.nextInt();

                    textoNuevo = cifrar(texto, factorCifrado);

                    System.out.println("el texto cifrado es: " + textoNuevo);

                    break;

                case 2:

                    System.out.println("introduce un texto a descifrar");

                    textoADescifrar = sc.nextLine();

                    textoDescifrado = descifrar(textoADescifrar);

                    System.out.println("el texto descifrado es: " + textoDescifrado);

                    break;

                case 3:

                    System.out.println("Has salido");

                    break;

                default:

                    System.out.println("introduce una opcion correcta");

            }

        }while(opcion != 3);

    }
}
