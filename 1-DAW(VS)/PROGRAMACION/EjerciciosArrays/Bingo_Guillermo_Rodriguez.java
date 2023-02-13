
/*
 *  Falta:
 * 
 *  - Control de que numeros de las columnas no se repitan
 *  - Control de numero de blancos
 *  - Arreglar el prinf de string
 */



package EjerciciosArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Bingo_Guillermo_Rodriguez {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        //Declaracion de variables
        
        int[] col0 = new int[3];
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        int[] col4 = new int[3];
        int[] col5 = new int[3];
        int[] col6 = new int[3];
        int[] col7 = new int[3];
        int[] col8 = new int[3];
        
        int[][] carton = {col0, col1, col2, col3, col4, col5, col6, col7, col8};

        //Para usarlo para rellenar con X
        String[][] cartonString = new String[carton.length][carton[0].length];


        
        int[] numerosGenerados = new int[0];


        //variable para controlar si salimos del programa o jugamos otro cartón
        boolean salir = false;

        do 
        {
            //Crear/restaurar carton vacio y vaciado de los numeros generados en eljuego anterior
            carton = restaurarCarton();

            numerosGenerados = restaurarNumerosGenerados();

            //introduzco los numeros de cada columna
            rellenarNumerosCarton(carton);

            // Ordenar Carton
            ordenarCarton(carton);
            
            //Coloco los 12 espacios en blanco, distribuidos en 4 por cada fila al azar en las columnas

            ponerBlancos(carton);

            //pinto el cartón ;
            //pintarCarton(carton, numerosGenerados);

            System.out.println("Este es tu carton:");
            System.out.println();

            imprimirCarton(carton);

            System.out.println();

            //pregunto si quiero sacar otra bola o terminar este juego
            boolean jugar = false;

            System.out.println("1. Sacar una bola");
            System.out.println("2. Terminar partida");

            int opcionJugar = sc.nextInt();
            sc.nextLine(); // Limpiar

            if(opcionJugar == 1){

                jugar = true;

            } else {

                jugar = false;

            }

            while(jugar)
            {

                // Control de numero de bolas sacadas
                int bolasTotales = 0;

                //saco numero aleatorio - no se debe repetir
                int bolaAleatoria = 0;

                boolean bolaRepetida = false;

                // Control
                do{

                    bolaAleatoria = (int) ((Math.random() * 90) + 1);

                    bolaRepetida = comprobarBolaRepetida(numerosGenerados, bolaAleatoria);

                }while(bolaRepetida);

                // Imprimo numero sacado
                System.out.println("ha salido el numero " + bolaAleatoria);

                // Incremento bolasTotales
                bolasTotales++;

                // Atualizo numeroGenerados
                numerosGenerados = actualizarNumerosGenerados(bolasTotales, bolaAleatoria, numerosGenerados);
                Arrays.sort(numerosGenerados); // ordeno lista

                // Imprimo lista de numeros sacados
                System.out.println("Lista de numeros sacados " + Arrays.toString(numerosGenerados));
                System.out.println();

                //Imprimo carton

                //imprimirCarton(carton);

                //Convierto carton a String
                cartonString = convertirString(carton);

                //Actualizo el carton con numeros acertados
                actualizarAciertos(cartonString, numerosGenerados);

                //Imprimo carton con aciertos
                imprimirCarton(cartonString);

                int numeroAciertos = comprobarAciertos(carton, numerosGenerados);


                //Eres ganador??
                if (numeroAciertos >= 15)
                {
                    System.out.println("-----------------------------");
                    System.out.println("--------  BINGO -------------");
                    System.out.println("-----------------------------");

                    jugar = false;

                }else{

                    //pregunto si quiero sacar otra bola o terminar este juego
                    System.out.println("1. sacar una bola");
                    System.out.println("2. Terminar esta partida");

                    opcionJugar = sc.nextInt();
                    sc.nextLine(); // Limpiar

                    if(opcionJugar == 1){

                        jugar = true;
        
                    } else {
        
                        jugar = false;
        
                    }
                }

                

            }

            //Pregunto si quiero jugar otro cartón o salir definitivamente del programa
            System.out.println("Quieres salir del bingo? s/n");

            String opcionSalir = sc.nextLine();

            if(opcionSalir.equalsIgnoreCase("s")){

                salir = true;

            }else {

                salir = false;
            }
            
        } while(!salir);

        System.out.println("Has salido del bingo!");

    }

    // Funciones

    // Limpia el carton

    static int[][] restaurarCarton(){

        int[][] cartonNuevo = new int[9][3];

        return cartonNuevo;
    }

    // Limpia la lista de numeros generados

    static int[] restaurarNumerosGenerados(){

        int[] numerosGenerados = new int[0];

        return numerosGenerados;
    }

    // Rellena los blancos de las columnas

    // Falta Control

    static void ponerBlancos(int[][] carton){

        int posicionAleatoria = 0;

        // Recorro filas
        for (int i = 0; i < carton[0].length; i++) {
            
            // Genero las posiciones de los blancos 4 veces
            for (int nBlancos = 1; nBlancos <= 4; nBlancos++) {
                
                posicionAleatoria = (int) (Math.random() * 9);

                // Recorro columnas
                for (int j = 0; j < carton.length; j++) {
                    
                    if(j == posicionAleatoria){

                        carton[j][i] = -1;

                    } 
                }
            }
        }
    }

    // Rellena el carton con numeros

    // Falta control de que no se repita

    static void rellenarNumerosCarton(int[][] carton){

        for (int i = 0; i < carton.length; i++) {
            
            for (int j = 0; j < carton[i].length; j++) {

                // numero aleatorio con la condicion de las columnas 
                carton[i][j] = (int) ((Math.random() * (10 - 1) + 1) + (i * 10)); 

            }

        }
    }

    // Ordena las columnas del carton

    static void ordenarCarton(int[][] carton){

        for (int i = 0; i < carton[0].length; i++) {
            
            for (int j = 0; j < carton.length; j++) {
                
                Arrays.sort(carton[j]);
            }
        }
    }

    // Devuelve el numero de aciertos

    static int comprobarAciertos(int[][] carton, int[] numerosGenerados){

        int numeroAciertos = 0;

        // Recorrer carton y comparar con numerosGenerados, si coincide aumento numeroAciertos

        // Recorro carton
        for (int i = 0; i < carton.length; i++) {

            for (int j = 0; j < carton[i].length; j++) {

                // Recorro numerosGenerados
                for (int z = 0; z < numerosGenerados.length; z++) {
                    
                    // Si algun numero del carton coincide con los numeros generados aumento aciertos
                    if(carton[i][j] == numerosGenerados[z]){

                        numeroAciertos++;

                    }

                }
                
            }
            
        }

        return numeroAciertos;
    }

    // Imprime el carton

    static void imprimirCarton(int[][] carton){

        for (int i = 0; i < carton[0].length; i++) {
            
            for (int j = 0; j < carton.length; j++) {
                
                System.out.printf("%3d",carton[j][i]);
                System.out.print("  ");
                
            }

            System.out.println("");
        }
    }

    // Imprime carton de String

    static void imprimirCarton(String[][] carton){

        for (int i = 0; i < carton[0].length; i++) {
            
            for (int j = 0; j < carton.length; j++) {
                
                System.out.printf("%3s",carton[j][i]);
                System.out.print("  ");
                
            }

            System.out.println("");
        }

    }

    // Actualiza la lista de numeros sacados

    static int[] actualizarNumerosGenerados(int tamaño, int numero, int[] lista){

        int[] nuevaLista =  new int[lista.length + 1];

        for (int i = 0; i < lista.length; i++) {
            
            nuevaLista[i] = lista[i];

        }

        nuevaLista[lista.length] = numero;

        return nuevaLista;
    }

    // Convierte el carton en Array de String

    static String[][] convertirString(int[][] carton){

        String[][] cartonString = new String[carton.length][carton[0].length];

        for (int i = 0; i < carton.length; i++) {
            
            for (int j = 0; j < carton[i].length; j++) {

                cartonString[i][j] = String.valueOf(carton[i][j]);
                
            }
        }

        return cartonString;
    }

    // modifica el carton de String con los aciertos

    static void actualizarAciertos(String[][] carton, int[] listaNumeros){

        //Recorre carton
        for (int i = 0; i < carton.length; i++) {
            
            for (int j = 0; j < carton[i].length; j++) {
                
                //Recorre lista de numeros
                for (int j2 = 0; j2 < listaNumeros.length; j2++) {
                    
                    if(carton[i][j].equals(String.valueOf(listaNumeros[j2]))){

                        carton[i][j] = "X";
                    }
                }
            }
        }
    }

    // Control de que la bola sacada no sea repetida

    static boolean comprobarBolaRepetida(int[] numeroGenerados, int bola){

        boolean bolaRepetida = false;

        for (int i = 0; i < numeroGenerados.length; i++) {
            
            if(bola == numeroGenerados[i]){

                bolaRepetida = true;
            }
        }

        return bolaRepetida;
    }

}
