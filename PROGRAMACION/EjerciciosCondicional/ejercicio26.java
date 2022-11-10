package EjerciciosCondicional;

import java.util.Scanner;

public class ejercicio26 {
    public static void main(String[] args) {

        final int PRECIO = 8;
        final int PRECIO_MIERCOLES = 5;
        final int PRECIO_PAREJA = 11;
        final float DESCUENTO = 0.10f;
        
        Scanner sc = new Scanner(System.in);

        System.out.println("cuantas personas?");

        int numPersonas = sc.nextInt();
        float precioTotal = 0.0f;
        int precioIndividual = 0;

        sc.nextLine(); //limpiar buffer

        System.out.println("dia de la semana?");

        String diaSemana = sc.nextLine();

        System.out.println("tienes tarjeta campa? s/n");

        char tarjeta = (sc.nextLine()).charAt(0);
        
        switch (diaSemana){
            
            case "miercoles":

                precioTotal = numPersonas * PRECIO_MIERCOLES;
                precioIndividual = PRECIO_MIERCOLES;
                break;

            case "jueves":

                numPersonas = (numPersonas/2);
                precioTotal = (numPersonas * PRECIO_PAREJA) +   ((numPersonas%2) * PRECIO);
                precioIndividual = PRECIO;
                break;

            default:

                precioTotal = numPersonas * PRECIO;
                precioIndividual = PRECIO;
                break;
        }
        if (tarjeta == 's') precioTotal = precioTotal - (precioTotal * DESCUENTO);

        System.out.println("numero de entradas: " + numPersonas);
        System.out.println("dia de la semana: " + diaSemana);
        System.out.println("tarjeta campa?: " + tarjeta);
        System.out.println("aqui tienes tus entradas");
        System.out.println("----------------------------");
        if (diaSemana.equals("jueves") && numPersonas%2 == 0){

            System.out.println("entradas pareja: " + numPersonas/2);
            System.out.println("precio por entrada de pareja: " + PRECIO_PAREJA);


        }else{

        System.out.println("entradas individuales: " + numPersonas);
        System.out.println("precio por entrada individual " + PRECIO_MIERCOLES);
        
    }
    System.out.println("total: " + precioTotal);
    System.out.println("descuento: " + precioTotal);
    System.out.println("a pagar: " + precioTotal);
        
}   }
