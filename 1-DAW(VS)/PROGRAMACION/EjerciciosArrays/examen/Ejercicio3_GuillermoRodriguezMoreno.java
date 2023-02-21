/*
 * Me falta que los valores sustituidos sean los correctos
 * para que la suma de fila sea justo 24
 * 
 */



package EjerciciosArrays.examen;

public class Ejercicio3_GuillermoRodriguezMoreno {
    
    public static void main(String[] args) {
        
        int[][] matriz = new int[5][10];

        rellenarMatriz(matriz);

        System.out.println("\n" + "---------------------- Matriz original ----------------------" + "\n");

        imprimirMatriz(matriz);

        int[][] copiaMatriz = matriz.clone();

        sustituirCeros(copiaMatriz);

        System.out.println("\n\n" + "---------------------- Matriz sustituida ----------------------" + "\n");

        imprimirMatriz(copiaMatriz);




        
    }

    /**
     * rellena la matriz con numeros aleatorios entre 0 y 4
     * @param matriz
     */

    static void rellenarMatriz(int[][] matriz){

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                
                int aleatorio = (int) (Math.random() * 5);

                matriz[i][j] = aleatorio;
            }
            
        }
    }
    
    /**
     * imprime la matriz sin las sumas
     * @param matriz
     */

    static void imprimirMatriz(int[][] matriz){

        int sumaFila = 0;
        int sumaCol = 0;

        for (int i = 0; i < matriz.length; i++) {

            sumaFila = 0;

            System.out.print("Fila " + (i+1) + " : ");

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.printf("%4d", matriz[i][j]);

                sumaFila = sumaFila + matriz[i][j];

            }

            System.out.println(" | " + sumaFila);
            
        }

        System.out.println("-----------------------------------------------------------------");
        System.out.print("         ");

        // segundo for para obtener la suma de las columnas
        for (int i = 0; i < matriz[0].length; i++) {

            sumaCol = 0;

            for (int j = 0; j < matriz.length; j++) {

                sumaCol = sumaCol + matriz[j][i];

            }

            System.out.printf("%4d", sumaCol);
            
        }

        System.out.println();// salto linea

    }

    /**
     * sustituye los 0 para que la fila sume 24
     * @param matriz
     */

    static void sustituirCeros(int[][] matriz){

        int sumaFila = 0;

        int valorRestante = 0;

        int contadorCeros = 0;
        int valorCeros = 0;

        for (int i = 0; i < matriz.length; i++) {

            sumaFila = 0; // reseteo suma
            contadorCeros = 0; // reseteo contador
            valorCeros = 0;

            // para obtener la suma de las columnas en cada fila
            for (int j = 0; j < matriz[i].length; j++) {

                if(matriz[i][j] == 0){

                    contadorCeros++;
                }
                
                sumaFila = sumaFila + matriz[i][j];
            }

            // si la suma es distinta a 24
            if(sumaFila != 24 && contadorCeros > 0){

                //Si la suma es menor de 24
                if(sumaFila < 24){

                    valorRestante = 24 - sumaFila; // obtengo lo que falta para 24

                    valorCeros = (int) (valorRestante/contadorCeros); // divido lo que falta entre la cantidad de 0s

                }else { //Si la suma es mayor de 24

                    valorRestante = sumaFila - 24;

                    valorCeros = - (int)(valorRestante/contadorCeros); // le doy valor negativo

                }
    
                // para sustituir los 0 una vez ya conocida la suma total y el valor de los 0
                for (int j = 0; j < matriz[i].length; j++) {

                    if(matriz[i][j] == 0){

                        matriz[i][j] = valorCeros;
                    }
                }

            }       
        }
    }
}
