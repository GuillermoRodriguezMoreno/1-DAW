package EjerciciosCondicionalTarea;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        
        final float descuento = 0.25f;

        Scanner sc = new Scanner(System.in);

        System.out.println("cual es el aforo del local?");

        int aforo = sc.nextInt();
        
        System.out.println("cual es el precio de la entrada?");

        float precio = sc.nextFloat();

        System.out.println("cual es el numero de entradas vendidas?");

        int numEntradas = sc.nextInt();

        float porcentajeEntradas = (float)numEntradas/aforo;

        float total = precio * numEntradas;

        if (porcentajeEntradas <= 0.2){
            
            System.out.println("concierto cancelado por falta de asistencia");

        }else {
            
            if (porcentajeEntradas > 0.2 && porcentajeEntradas <= 0.5){

            total = total * (1 - descuento);
            }

            System.out.println("el precio total es " + total + " euros");      
        
        }
        sc.close();
    }
}
