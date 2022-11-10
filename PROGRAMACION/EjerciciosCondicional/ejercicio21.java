package EjerciciosCondicional;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ejercicio21 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("#.00"); //formatear la nota a dos decimales

        System.out.println("introduce la nota 1");

        float nota1 = sc.nextFloat();

        System.out.println("introduce la nota 2");

        float nota2 = sc.nextFloat();

        sc.nextLine(); //limpiar buffer

        float media = (nota1 + nota2)/2;

        if (media >= 5) System.out.println("estas aprobado con una nota de " + formato.format(media));

        else{

            System.out.println("cual ha sido el resultado de la recuperacion? apto / no apto");

            String recuperacion = sc.nextLine();

            if(recuperacion.equals("apto")){
                
                System.out.println("tu nota es un 5");

            }else 
            
                System.out.println("has suspendido, tu nota es " + formato.format(media));
        }

        sc.close();
    }
}
