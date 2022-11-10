package EjerciciosCondicional;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ejemplo1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        /*
         switch con dias de la semana
         */

       

        int mes = sc.nextInt();

        switch (mes){

            case 1:

              
            case 3:

             

            case 5:

            
            case 7:

        

            case 10:

            
            case 12:

                System.out.println("31 dias");
                break;

            
            case 4:
            case 6:
            case 9:
            case 11:
            
            System.out.println("30 dias");
            break;


            default:

                System.out.println("error");
        }


    }
}
