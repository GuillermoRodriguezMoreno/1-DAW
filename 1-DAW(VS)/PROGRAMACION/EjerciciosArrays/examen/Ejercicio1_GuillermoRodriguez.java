package EjerciciosArrays.examen;

public class Ejercicio1_GuillermoRodriguez {
    
    public static void main(String[] args) {
        
        // Declaracion array
        int[] array = {4, 6, 8, 4, 2, 3, 6, 9, 11, 6, 5, 9, 10, 13, 8, 3, 6, 5, 2, 1, 6, 6, 8, 4};

        // variables
        int valorMax = 13;

        //copio array
        int[] copiaArray = array.clone();

        // Recorro array
        for(int i = 0; i < array.length; i++){

            // Recorro otra vez el array con el valor de la posicion [i]
            for(int j = 1; j < array.length; j++){

                // si esta repetido incremento el valor maximo y se lo doy a la posicion copiaArray[i]
                if(array[i] == array[j]){

                    valorMax ++;

                    copiaArray[j] = valorMax;

                }

                
            }

            // no consigo hacer recorrer el array y dar los valores correctamente.

            System.out.print(copiaArray[i] + " ");

        }

    }
}
