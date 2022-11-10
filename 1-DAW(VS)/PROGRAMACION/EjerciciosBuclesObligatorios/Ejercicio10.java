package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int contador = 0;
        int acumulador = 0;
        int num = 0;

        System.out.println("introce numeros positivos, si desea salir introduzca un numero negativo");

        num = sc.nextInt();

        while (num >= 0){

            contador ++;
            acumulador = acumulador + num;
            
            num = sc.nextInt();
        }
        if (contador == 0) System.out.println("no has introducido ningun numero positivo");

        else{

            float media =  (float)acumulador/(float)contador;

            System.out.println("total de numeros introducidos " + contador);
            System.out.println("total acumulado " + acumulador);
            System.out.println("la media es " + media);
        }
        sc.close();
    }
}
