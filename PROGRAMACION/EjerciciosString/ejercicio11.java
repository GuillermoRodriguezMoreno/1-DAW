package EjerciciosString;
import java.util.Scanner;

public class ejercicio11 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String texto  = "Debes comprobar que se ha introducido un dígito, que no estamos buscando en una posición más grande que la longitud de la cadena y si estoy mostrando un espacio entonces mostrar la cadena";

        System.out.println("introduce el digito");

        String textoLeido = sc.nextLine();
        char caracter = textoLeido.charAt(0);
        int tam = texto.length();
        int x = Character.getNumericValue(caracter);

        if (Character.isDigit(caracter) && x < tam && textoLeido.length() < 2){

            System.out.println(texto.charAt(x));

        }else if (Character.isSpaceChar(caracter)){

            System.out.println("ESPACIO");
            }
            
            else System.out.println("caracter incorrecto");        
        System.out.println(x);
    }
}
