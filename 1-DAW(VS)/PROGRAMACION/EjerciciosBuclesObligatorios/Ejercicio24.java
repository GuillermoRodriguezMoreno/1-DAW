package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio24 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce la altura de la piramide");

        int altura = sc.nextInt();
        int caracter = 1;

        for (int i = 1 ; i <= altura ; i ++){ //recorre lineas

            for (int j = 1 ; j < (altura - i) + 1 ; j++){ //pinta espacios

                System.out.print(" ");
            }

            for (int z = 1 ; z <= i ; z ++){ //pinta mitad de piramide con el incremento de numeros

                System.out.print(caracter);
                
                caracter++;
            }

            caracter = 1; // resetear contador

            for( int k = 1 ; k < i ; k++){ // bucle que pinta la segunda mitad de la piramide

                System.out.print(i - k);
            }
            
            System.out.println(""); // salto de linea
        }

        sc.close();
    }
}
