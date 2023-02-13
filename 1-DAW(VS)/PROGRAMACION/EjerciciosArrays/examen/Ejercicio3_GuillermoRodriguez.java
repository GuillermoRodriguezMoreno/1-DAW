package EjerciciosArrays.examen;

public class Ejercicio3_GuillermoRodriguez {
    
    public static void main(String[] args) {

        // declaro array
        int[][] tabla = new int[5][10];

        rellenarTabla(tabla);

        int sumaFila = 0;

        int sumaColumna = 0;


        // array para almacenar suma de columnas
        int[] sumaColumnas =  new int[10];

        // array para almacenar suma de filas
        int[] sumaFilas = new int[5];

        //recorro filas
        for(int i = 0; i < tabla.length; i++){

            System.out.print("fila " + (i+1) + ": ");

            //recorro columnas
            for(int j = 0; j < tabla[i].length; j++){

                sumaFila = sumaFila + tabla[i][j];

                System.out.print(tabla[i][j] + "  ");

            }

            sumaFilas[i] = sumaFila; // almaceno suma fila

            System.out.print("| ");
            System.out.println(sumaFila);

            sumaFila = 0; // reseteo suma fila
        }

        //recorro filas en busca de 0

        for(int i = 0; i < tabla.length; i++){

            for(int j = 0; j < tabla[i].length; j++){

                //si hay 0 (solo va a funcionar con el primer 0)
                if(tabla[i][j] == 0){

                    //si falta para llegar a 24
                    if(24-sumaFilas[i] >= 0){

                        tabla[i][j] = 24-sumaFilas[i];
                    }
                }
            }
        }

    }

    //funcion rellenar tabla con numero aleatorio entre 0 y 4;

    static void rellenarTabla(int[][] tabla){

        int aleatorio = 0;

        //recorro filas
        for(int i = 0; i < tabla.length; i++){

            //recorro columnas
            for(int j = 0; j < tabla[i].length; j++){

                aleatorio = (int) (Math.random() * 5);

                tabla[i][j] = aleatorio;

            }
        }
    }
}
