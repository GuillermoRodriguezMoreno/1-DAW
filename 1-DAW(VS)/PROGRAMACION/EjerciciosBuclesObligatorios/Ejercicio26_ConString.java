package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio26_ConString {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un numero");

        String num = sc.nextLine();

        System.out.println("introduce un digito");

        String digi = sc.nextLine();

        int posicionInicial = 0;
        int posicion = 0;
        int contador = 0;

        do{ //bucle para que busque el digito hasta que no aparezca mas

            posicion = num.indexOf(digi, posicionInicial); //primera aparicion o si no esta -1

            if (posicion != - 1){ //si encuentra el digito muestra la posicion 

                System.out.print((posicion + 1) + ", ");

                posicionInicial = posicion + 1;

            }

            contador ++; //contador para controlar la salida por pantalla si no se encuentra el contador solo incrementa una vez

        }while (posicion != -1);

        if (contador < 2) System.out.println("el digito no se encuentra en el numero"); // si no se encuentra

        else{

            System.out.println("Son las posiciones en las que se encuentra el digito"); //si se encuentra
        }

        sc.close();
    }
}
