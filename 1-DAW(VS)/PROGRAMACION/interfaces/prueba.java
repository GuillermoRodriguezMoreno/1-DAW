package interfaces;

import java.util.Random;

public class Matrix {
    public static void main(String[] args) throws InterruptedException {
        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();

        // Definir la cantidad de columnas y filas que deseas mostrar
        int columnas = 100;
        int filas = 40;

        // Crear una matriz que represente las líneas binarias
        int[][] lines = new int[columnas][filas];
        for (int i = 0; i < columnas; i++) {
            // Generar una longitud aleatoria para la línea actual
            int length = random.nextInt(filas);
            // Llenar la línea actual con números binarios aleatorios
            for (int j = 0; j < length; j++) {
                lines[i][j] = random.nextInt(2);
            }
        }

        // Obtener la marca de tiempo actual en milisegundos
        long startTime = System.currentTimeMillis();

        // Crear un bucle infinito para mostrar la animación continuamente
        while (true) {
            // Borrar la consola para que la animación parezca continua
            System.out.print("\033[H\033[2J");

            // Crear un bucle para mostrar cada fila
            for (int i = 0; i < filas; i++) {
                // Crear un bucle para mostrar cada columna de la fila actual
                for (int j = 0; j < columnas; j++) {
                    // Establecer el fondo en negro o verde dependiendo del número binario
                    if (lines[j][i] == 0) {
                        System.out.print("\u001B[40m");
                    } else {
                        System.out.print("\u001B[42m");
                    }
                    // Mostrar el número binario en la posición actual
                    System.out.print(lines[j][i]);
                }
                // Restablecer el fondo en negro después de imprimir la línea actual
                System.out.print("\u001B[40m");
                // Agregar una pausa para controlar la velocidad de la animación
                Thread.sleep(50);
                // Agregar un salto de línea para pasar a la siguiente fila
                System.out.println();
            }

            // Comprobar si han pasado 3 segundos y salir del bucle si es así
            if (System.currentTimeMillis() - startTime >= 3000) {
                break;
            }
        }
    }
}