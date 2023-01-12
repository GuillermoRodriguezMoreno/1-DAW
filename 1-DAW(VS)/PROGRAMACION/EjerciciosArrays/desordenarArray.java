package EjerciciosArrays;

public class desordenarArray {
    
    public static void main(String[] args) {

        int[] lista = new int[15];

        // rellena array

        for (int i = 0; i < lista.length; i++) {

            lista[i] = i;
            
        }

        // muestra array ordenado

        for (int i : lista) {
            
            System.out.print(i + " ");
        }
        System.out.println();

        // desordeno array

        lista = desordenar(lista);

        // muestro array desordenado

        for (int i : lista) {

            System.out.print(i + " ");
        }
        

    }

    // funcion desordenar array

    static int[] desordenar(int[] array){

        for(int i = 0; i < array.length; i++){

            int posicionAux = 0;

            int aleatorio = (int) (Math.random() * array.length);

            posicionAux = array[i];

            array[i] = array[aleatorio];

            array[aleatorio] = posicionAux;
            
        }

        return array;
    }
}
