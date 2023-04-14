package interfaces;

import java.util.Random;
import java.util.Scanner;

public class prueba {
    
    public static void main(String[] args) {
        
        imprimirMatrix();
    }

    public static void imprimirMatrix() {

        Scanner sc = new Scanner(System.in);

        System.out.println("El mundo de Matrix ha sido destruido, pulsa enter para ver el resultado");
        sc.nextLine();
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        Random random = new Random();
        int intervalo = 75; // Intervalo de tiempo entre cada impresión (en milisegundos)
    
        while (true) {
            for (int i = 0; i < 30; i++) {
                if (i == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print("\033[1A"); // Mueve el cursor una línea hacia arriba
                }
                int caracter = random.nextInt(94) + 33; // Genera un carácter aleatorio entre los códigos ASCII 33 y 126
                System.out.print((char) caracter); // Imprime el carácter correspondiente al código ASCII generado
                try {
                    Thread.sleep(intervalo); // Espera un tiempo antes de imprimir el siguiente carácter
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(2000); // Espera un tiempo antes de volver a imprimir la secuencia de caracteres
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
