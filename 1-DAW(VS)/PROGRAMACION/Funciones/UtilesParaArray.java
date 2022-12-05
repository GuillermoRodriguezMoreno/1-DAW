package Funciones;

public class UtilesParaArray {
    
    public static void main(String[] args) {

        int array[] = generaArrayInt(10, 3, 8);

        for (int i : array) {
            
            System.out.println(i);
        }

        System.out.println("------------- minimo -->" + minimoArrayInt(array));

        System.out.println("------------- maximo -->" + maximoArrayInt(array));

        System.out.println("------------- media -->" + mediaArrayInt(array));

        if(estaEnArrayInt(array, 3) == true) System.out.println("3 esta");

        else System.out.println("no esta");

        System.out.println("la posicion es --> " + poscionEnArrayInt(array, 3));

        
    }

    // Funciones

    // genera array int

    static int[] generaArrayInt(int tamaño, int minimo, int maximo){

        int array[] = new int[tamaño];

        for (int i = 0 ; i < array.length ; i++) {
            
            array[i] = (int) ((Math.random() * (maximo - minimo)) + minimo);

        }

        return array;
    }

    // minimo array int

    static int minimoArrayInt(int array[]){

        int minimo = 10;

        for (int i : array) {
            
            if (i < minimo){

                minimo = i;
            }
        }

        return minimo;
    }

    // maximo array int

    static int maximoArrayInt(int array[]){

        int maximo = 0;

        for (int i : array) {
            
            if(i > maximo){

                maximo = i;
            }
        }

        return maximo;
    }

    // media array int

    static float mediaArrayInt(int array[]){

        float media = 0.0f;

        int suma = 0;

        int total = array.length;

        for (int i : array) {
            
            suma = suma + i;

        }

        media =  ((float)suma/(float)total);

        return media;
    }

    // esta en array int

    static boolean estaEnArrayInt(int array[], int numero){

        boolean esta = false;

        for (int i : array) {

            if (i == numero){

                esta = true;
            }
            
        }

        return esta;
    }

    // posicion en array

    static int poscionEnArrayInt (int array[], int numero){

        int posicion = -1;

        for(int i = 0 ; i < array.length ; i++){

            if(array[i] == numero){

                posicion = i;
            }

        }

        return posicion;
    }

    // voltea array int

    static int[] volteaArrayInt(int array[]){

        int arrayAux[] = new int[];

        return arrayAux;
    }
}
