package colecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        
        int tamaño = (int) ((Math.random() * (21 - 10)) + 10);

        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < tamaño; i++) {
            
            int aleatorio = (int) (Math.random() * 101);

            lista.add(aleatorio);
        }

        System.out.println("Tamaño: " + lista.size());

        System.out.println(lista.toString());

        int max = Collections.max(lista);

        int min = Collections.min(lista);

        int suma = 0;

        for (Integer elemento : lista) {
            
            suma = suma + elemento;
        }

        float media = (float) suma / lista.size();

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);
    }
}
