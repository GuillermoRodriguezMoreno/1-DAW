package interfaces;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class prueba {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
    System.out.println("El mundo de Matrix ha sido destruido, pulsa enter para ver el resultado");
    sc.nextLine();
    Random random = new Random();
    int intervalo = 10; // Intervalo de tiempo entre cada impresión (en milisegundos)
    String greenTextOnBlackBackground = "\033[42;32m%s\033[0m"; // Código de color para texto verde sobre fondo negro
    String blackBackground = "\u001b[40m"; // Código de color para fondo negro
    String resetColor = "\033[0m"; // Código de color para resetear los colores
    while (true) {
        for (int i = 0; i < 30; i++) {
            if (i == 0) {
                System.out.print(" ");
            } else {
                System.out.print("\033[1A");
            }
            int caracter = random.nextInt(94) + 33;
            String formattedText = String.format(greenTextOnBlackBackground, (char) caracter);
            System.out.print(blackBackground + formattedText + resetColor); // Agrega el código de fondo negro y el código de reseteo de color
            try {
                Thread.sleep(intervalo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
