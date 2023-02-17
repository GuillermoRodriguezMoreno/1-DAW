package EjerciciosArrays.examen;

import java.util.Arrays;

public class Ejercicio1_GuillermoRodriguezMoreno {
    
    public static void main(String[] args) {
        
        int[] array = {4, 6, 8, 4, 2, 3, 6, 9, 11, 6, 5, 9, 10, 13, 8, 3, 6, 5, 2, 1, 6, 6, 8, 4};

        int mayorPosibleInicial = 13;

        for (int i = 0; i < array.length; i++) {
            
            // por cada elemento del array vuelvo a recorrer el array sin contar el propio elemento
            for (int j = i+1; j < array.length; j++) {
                
                // si los elementos son iguales
                if(array[i] == array[j]){

                    array[j] = ++mayorPosibleInicial; // pre-incremento  para que primero incremente y luego le de valor
                }
            }
        }

        System.out.println(Arrays.toString(array));
        
    }
}
