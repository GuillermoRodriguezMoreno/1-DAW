package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class PiramideDeLetras {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int altura = 0;
        char letra = 'A';

        do{

            System.out.println("introduce la altura");

            altura = sc.nextInt();

        }while (altura >= 25);

        for(int linea = 1; linea <= altura ; linea++){

            letra = 'A';

            for(int ancho = 1 ; ancho <= linea ; ancho ++){

                System.out.print( (char)(letra++));
            }

            System.out.println(""); //salto linea
        }
    }
}
