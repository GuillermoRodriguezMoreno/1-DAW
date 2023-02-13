package EjerciciosArrays;

import java.util.Arrays;

public class Ejercicio13 {
    
    public static void main(String[] args) {
        
        String[] pais = {"es", "ru", "ja", "aus"};

        int[][] alturas = new int[4][10];

        int media, max, min;

        rellenarAlturas(alturas);

        System.out.println(Arrays.deepToString(alturas));



        
    }

    static void rellenarAlturas(int alturas[][]){

        for(int i = 0; i < alturas.length; i++){

            for(int j = 0 ; j < alturas[i].length; j++){

                alturas[i][j] = (int) ((Math.random() * (211-140)) + 140);

            }
        }
    }
}
