package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Cifrado {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String texto = "";
        int factorCifrado = 0;
        int longitudTexto = 0;
        char caracter = ' ';
        String textoNuevo = "";
        
        System.out.println("Introduce el texto a cifrar");
    
        texto = sc.nextLine();

        texto = texto.toUpperCase();

        do{

            System.out.println("introduce el factor de cifrado");

            factorCifrado = sc.nextInt();

        }while(factorCifrado < 1 && factorCifrado > 9);

        textoNuevo = factorCifrado + "";

        longitudTexto = texto.length();

        for(int i = 0 ; i < longitudTexto ; i++){

            if(caracter == ' '){

                caracter = texto.charAt(i+1);

                textoNuevo = textoNuevo + (char) factorCifrado + (char) (caracter + factorCifrado) + "";

            }else {

                caracter = texto.charAt(i);

                caracter = (char) (caracter + factorCifrado);

                textoNuevo = textoNuevo + caracter;
            }
        }

        System.out.println("El texto es: " + texto);
        System.out.println("el texto cifrado es: " + textoNuevo);

    }
}
