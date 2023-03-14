package ExamenRecuperacionArrays;

import java.util.Scanner;

public class Ejercicio2_GuillermoRodriguez {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int[] lista = new int[20];
        int posicion = 0;

        rellenarLista(lista);
        imprimirLista(lista);

        

        do{

            System.out.println("indica una posicion");
            posicion = sc.nextInt();

            if(posicion < 0 || posicion > 19){

                System.out.println("posicion incorrecta");
            }

        }while(posicion < 0 || posicion > 19);

        sc.close();

        // a la hora de hacer los calculos doy por hecho que las posiciones van desde la 0 a la 19

        System.out.println("Suma de todos los elementos a la izquierda = " + sumaIzquierda(lista, posicion));

        System.out.println("A - suma de todos los elementos a la derecha = " + sumaDerecha(lista, posicion));

        elementosIzq(lista, posicion);

        elementosDer(lista, posicion);

    }

    /**
     * rellena lista de array con numeros entre -20 y 20 no repetidos
     * @param lista
     */
    
    static void rellenarLista(int[] lista){

        int aleatorio = 0;

        boolean repetido = false;
        
        do{

            // relleno lista

            for (int i = 0; i < lista.length; i++) {

                // numero aleatorio entre -20 y 20
                aleatorio = (int) ((Math.random()* 42) - 21);

                lista[i] = aleatorio;
            }

            // compruebo que no este repetido

            // por cada elemento de la lista
            for (int i = 0; i < lista.length; i++) {

                repetido = false; // reseteo
                
                //compruebo que no se encuentre en la lista
                for (int j = i + 1; j < lista.length; j++) {

                    if(lista[i] == lista[j]){

                        repetido = true;
                    }
                    
                }
            }

        }while(repetido);


    }

    /**
     * imprime la lista
     * @param lista
     */

    static void imprimirLista(int[] lista){

        System.out.println("Lista: ");

        for (int i = 0; i < lista.length; i++) {
            
            System.out.print(lista[i] + ", ");
        }

        System.out.println();
    }

    /**
     * suma los elementos hacia la derecha desde una posicion dada
     * @param lista
     * @param posicion
     * @return
     */

    static int sumaDerecha(int[] lista, int posicion){

        int sumaDerecha = 0;

        // for desde posicion + 1 hasta el final
        for (int i = posicion + 1; i < lista.length; i++) {
            
            sumaDerecha = sumaDerecha + lista[i];
        }

        return sumaDerecha;
    }

    static int sumaIzquierda(int[] lista, int posicion){

        int sumaIzquierda = 0;

        // for desde inicio hasta la posicion
        for (int i = 0; i < posicion; i++) {
            
            sumaIzquierda = sumaIzquierda + lista[i];

        }

        return sumaIzquierda;
    }

    /**
     * calcula total de mayores y menores a la izq desde una posicion dada
     * @param lista
     * @param posicion
     */

    static void elementosIzq(int[] lista, int posicion){

        int totalMayores = 0;
        int totalMenores = 0;

        for (int i = 0; i < posicion; i++) {
            
            if(lista[i] > lista[posicion]){

                totalMayores++;
            }

            else if(lista[i] < lista[posicion]){

                totalMenores++;
            }

        }

        System.out.println("Mayores a la izq = " + totalMayores + " , menores a la izq = " + totalMenores);
    }

    /**
     * calcula total mayores y menores a la derecha de una posicion dada
     * @param lista
     * @param posicion
     */

    static void elementosDer(int[] lista, int posicion){

        int totalMayores = 0;
        int totalMenores = 0;

        for (int i = posicion + 1; i < lista.length; i++) {
            
            if(lista[i] > lista[posicion]){

                totalMayores++;
            }

            else if(lista[i] < lista[posicion]){

                totalMenores++;
            }

        }

        System.out.println("Mayores a la Der = " + totalMayores + " , menores a la Der = " + totalMenores);
    }

}
