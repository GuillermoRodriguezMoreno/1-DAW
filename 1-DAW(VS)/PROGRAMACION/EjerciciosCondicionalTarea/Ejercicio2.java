package EjerciciosCondicionalTarea;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("cuanta cantidad de comida dispones?");

        float comidaDiaria = sc.nextFloat();

        System.out.println("cuantos animales tienes?");

        int numAnimales = sc.nextInt();

        System.out.println("cuantos kilos de comida come un animal?");

        float kilosPorAnimal = sc.nextFloat();

        float comidaConsumida = (float) (numAnimales * kilosPorAnimal);
        
        if (comidaConsumida <= comidaDiaria) System.out.println("tienes comida suficiente");

        else{

            System.out.println("le corresponde " + (comidaDiaria/numAnimales) + " kg por animal");
            System.out.println("necesitas " + (comidaConsumida - comidaDiaria) + " kilos mas de comida");
        }

        sc.close();
    }   
}
