package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio23 {
    public static void main(String[] args) {

        final int NUM_MAX = 10000;
        
        Scanner sc = new Scanner(System.in);

        int contador = 0;
        long total = 0;
        int num = 0;
        boolean control = false;

        System.out.println("introduce numeros hasta que su suma no supere 10000");

        do{ // control para que el numer introducido no sea mayor o igual a 10000 

            num = sc.nextInt();

            if(num >= 10000){

                System.out.println("introduce un numero menor de 10000");

                control = false;

            }else {
                
                control = true;
                contador ++;

            }

        }while (control == false);

        total = total + num;
        
        while(total <= NUM_MAX){ //bucle para sumar los numeros introducidos

            do{ // mismo control anterior

                num = sc.nextInt();
    
                if(num >= 10000){
    
                    System.out.println("introduce un numero menor de 10000");
    
                    control = false;

    
                }else { // OK para realizar operaciones
                    
                    control = true;
                    total = total + num;
                    contador ++;
                }

            }while (control == false);

        }
        

        float media = ((float)total/(float)contador);

        System.out.println("has superado los " + NUM_MAX);
        System.out.println("total acumulado " + total);
        System.out.println("total numeros introducidos " + contador);
        System.out.println("la media es " + media);

        sc.close();
    }
}
