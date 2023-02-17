package EjerciciosArrays.examen;

public class Ejercicio3_GuillermoRodriguezMoreno {
    
    public static void main(String[] args) {
        
        int[][] matriz = new int[5][10];

        rellenarMatriz(matriz);

        imprimirMatriz(matriz);

        int[][] copiaMatriz = matriz.clone();

        sustituirCeros(copiaMatriz);

        System.out.println("--------------------------------------------");

        imprimirMatriz(copiaMatriz);




        
    }

    static void rellenarMatriz(int[][] matriz){

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                
                int aleatorio = (int) (Math.random() * 5);

                matriz[i][j] = aleatorio;
            }
            
        }
    }

    static void imprimirMatriz(int[][] matriz){

        for (int i = 0; i < matriz.length; i++) {

            System.out.print("Fila " + (i+1) + " : ");

            for (int j = 0; j < matriz[i].length; j++) {
                
                int aleatorio = (int) (Math.random() * 5);

                matriz[i][j] = aleatorio;

                System.out.print(matriz[i][j] + "     ");
            }

            System.out.println();
            
        }
    }

    static void sustituirCeros(int[][] matriz){

        int sumaFila = 0;

        int valorRestante = 0;

        int contadorCeros = 0;
        int valorCeros = 0;

        for (int i = 0; i < matriz.length; i++) {

            sumaFila = 0; // reseteo suma
            contadorCeros = 0; // reseteo contador

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

                    valorCeros = valorRestante/contadorCeros; // divido lo que falta entre la cantidad de 0s

                }else { //Si la suma es mayor de 24

                    valorRestante = sumaFila - 24;

                    valorCeros = -(valorRestante/contadorCeros); // le doy valor negativo

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
