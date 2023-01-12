package EjerciciosArrays;

import javax.swing.text.AbstractDocument.LeafElement;

// falta insertarEnPosicion y InsertarOrdenado

public class UtilesArrayGUILLERMO {

    //borra los valores del array. Deque quedar un array vacio int[]
    
    static int[] limpiar(){

        int[]nuevo = new int[0];

        return nuevo;
    }

    //llena el array con el numero de elementos  indicados, el nvalor de estos números será 0   

    static int[] rellenar(int[]array, int numeroElementos){

        int[]nuevo = new int[numeroElementos];

        for(int i = 0; i < nuevo.length; i++){

            nuevo[i] = 0;
        }

        return nuevo;
    }

    //llena el array con el numero de elementos indicados con el valor indicado

    static int[] rellenar(int[]array, int numeroElementos, int valor){

        int[]nuevo = new int[numeroElementos];

        for(int i = 0; i < nuevo.length; i ++){

            nuevo[i] = valor;

        }

        return nuevo;

    }

    static int[] insertarAlFinal(int[]array, int elemento){

        int[]nuevo = new int[array.length + 1];

        for(int i = 0; i < nuevo.length; i++){

            if(i > array.length -1){

                nuevo[i] = elemento;

            }else{

                nuevo[i] = array[i];

            }

        }

        return nuevo;

    }

    static int[] insertarAlPrincipio(int[]array, int elemento){

        int[]nuevo = new int[array.length + 1];

        for(int i = 0; i < nuevo.length; i++){

            if(i == 0){

                nuevo[i] = elemento;

            }else {

                nuevo[i] = array[i-1];

            }

        }

        return nuevo;

    }

    static int[] insertarEnPosicion(int[]array, int elemento, int posicion){

        int[] nuevo = new int[array.length + 1];

        // comprobar si la posicion esta dentro de nuevo (falta hacer)

        for(int i = 0; i < posicion; i++){

            nuevo[i] = array[i];

        }

        // Inserto el nuevo elemento

        nuevo[posicion] = elemento;

        // Inserto la parte izquierda del array (de 0 a posicion-1)

        for(int i = posicion; i < array.length; i++){

            nuevo[i+1] = array[i];

        }

        return nuevo;

    }

    static int[] insertarOrdenado(int[]array, int elemento){

        int[]nuevo;

        // Encontrar la posicion de insercion

        int posicionInsercion = 0;

        boolean noEncontradoPosicion = true;

        for(int i = 0; i < array.length; i++){

            if(elemento < array[i] && noEncontradoPosicion){

                posicionInsercion = i;
                noEncontradoPosicion = false;
            }

        }

        if(noEncontradoPosicion){

            posicionInsercion = array.length;

        }

        // insertar en posicion

        nuevo = insertarEnPosicion(array, elemento, posicionInsercion);

        return nuevo;

    }

    static int[] eliminarUltimo(int[]array){

        int[] nuevo = new int[array.length - 1];

        for(int i = 0; i < array.length - 1; i++){

            nuevo[i] = array[i];

        }

        return nuevo;

    }

    static int[] eliminarPrimero(int[]array){

        int[] nuevo = new int[array.length - 1];

        for(int i = 0; i < nuevo.length; i++){

            nuevo[i] = array[i+1];

        }

        return nuevo;

    }

    static int[] eliminar(int[]array, int elemento){

        int apariciones = 0;

        // busco el numero de veces que aparece el elemento en el array

        for(int i = 0; i < array.length; i++){

            if(array[i] == elemento){

                apariciones ++;

            }

        }

        int[] nuevo = new int[array.length - apariciones];

        for(int i = 0; i < array.length; i++){

            if(array[i] != elemento){


            }
        }


    }

    static int[] ordenar(int[]array){

        

    }

    static int[] desordenar(int[]array){


    }

    static int[] invertir(int[]array){
        
        int[]nuevo = new int[array.length];

        for(int i = array.length - 1; i == 0; i --){

            nuevo[nuevo.length - i - 1] = array[i];

        }

        return nuevo;

    }

    static void imprimir(int[]array){

        System.out.println(array.toString());

    }

    //devuelve true si el array está ordendo, false en  caso contrario

    static boolean estaOrdenado(int[]array){

        boolean ordenado = false;

        return ordenado;
    }

    //devuelve -1 si el elemento NO está en el array y en caso de estar DEVUELVE la posición en la que está 

    static int buscar(int[]array, int elemento){

        int esta = 0;

        return esta;
    }

    // devuelve el array  resultante de partir el array original entre la posicionInical y la  posicionFinal (incluido solo el primero)

    static int[] partirPor(int[]array, int posicionInicial, int posicionFinal){

        int[]arrayPartido = new int[];

        return arrayPartido;
    }

    static boolean sonIguales(int[]array1, int[]array2){

        boolean iguales = false;

        return iguales;
    }

    static boolean elementosIguales(int[]array1, int[]array2, int posicionAComparar){

        boolean iguales = false;

        return iguales;
    }
}
