package EjerciciosCondicionalTarea;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num1 = (int) (Math.random() * 100);

        int num2 = (int) (Math.random() * 100);

        int eleccionOperacion = (int) (Math.random() * 3);

        String operacion = "";

        int resultado = 0;

        switch (eleccionOperacion){

            case 0: 

                operacion = "suma";
                break;

            case 1:

                operacion = "resta";
                break;

            case 2:

                operacion = "multiplicacion";
                break;
        }
        System.out.println("numero 1 es: " + num1 + " y el numero 2 es: " + num2);
        System.out.println("introduce el resultado de la siguiente operacion: " + operacion);
        resultado = sc.nextInt();

        if ((operacion.equals("suma") && (resultado == num1 + num2))
            ||(operacion.equals("resta")&& (resultado == num1 - num2))
            ||(operacion.equals("multiplicacion") && (resultado == num1 * num2)))

            System.out.println("has acertado!");

        else System.out.println("has fallado :(");

        sc.close();
    }
}
