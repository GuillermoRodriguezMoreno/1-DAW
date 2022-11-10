package EjerciciosString;
import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String textoCompleto = "En la casa de Juan estaban Pedro, Luis y Mario, todos jugando al Formite";
        StringBuffer sBuffer = new StringBuffer(textoCompleto);
        System.out.println("quien mas estaba?");

        String texto = sc.nextLine();

        sBuffer.insert((textoCompleto.indexOf("y")), texto);

        System.out.println(sBuffer);
    }
}
