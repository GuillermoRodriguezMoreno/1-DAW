package ExamenTema3;

import java.util.Scanner;

public class Ejercicio1_GuillermoRodriguez {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // constantes

        final double PLATO1 = 5;
        final double PLATO2 = 4;
        final double PLATO3 = 4.5;
        final double PLATO4 = 6;
        final double PLATO5 = 8;
        final double PLATO6 = 9;
        final double PLATO7 = 5;
        final double PLATO8 = 1.5;
        final double PLATO9 = 1.25;
        final double PLATO10 = 2;

        // variables

        int cantidad1 = 0;
        int cantidad2 = 0;
        int cantidad3 = 0;
        int cantidad4 = 0;
        int cantidad5 = 0;
        int cantidad6 = 0;
        int cantidad7 = 0;
        int cantidad8 = 0;
        int cantidad9 = 0;
        int cantidad10 = 0;

        int opcion = 0;

        double precioTotal = 0f;

        do{

            System.out.println(" *** RESTAURANTE VEGA DE MIJAS ****");
            System.out.println(" ----------------------------------");
            System.out.println("Primeros platos");
            System.out.println(" 1. Salmorejo (5€)");
            System.out.println(" 2. Sopa picadillo (4€)");
            System.out.println(" 3. Ensalada de atún (4.5€)");
            System.out.println("Segundos platos");
            System.out.println(" 4. Paella (6€)");
            System.out.println(" 5. Salmón (8€)");
            System.out.println(" 6. Codillo al horno (9€)");
            System.out.println(" 7. Lentejas (5€)");
            System.out.println("Postres");
            System.out.println(" 8. Fruta (1.5€)");
            System.out.println(" 9. Café (1.25€)");
            System.out.println("10. Helado (2€)");
            System.out.println();
            System.out.println();
            System.out.println("0. SALIR (Imprimir Ticket + FIN) ");
            System.out.println("Selecciona la opción deseada por el cliente...");

            opcion = sc.nextInt(); 

            sc.nextLine(); // limpiar buffer

            switch (opcion){

                case 1:

                    System.out.println("cuanta cantidad?");

                    cantidad1 = sc.nextInt();

                    //control de cantidad positiva

                    if (cantidad1 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        precioTotal = precioTotal + cantidad1 * PLATO1;

                        System.out.println("salmorejo x" + cantidad1);

                    }

                    break;

                case 2:

                    System.out.println("cuanta cantidad?");

                    cantidad2 = sc.nextInt();

                    if (cantidad2 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        precioTotal = precioTotal + cantidad2 * PLATO2;

                        System.out.println("sopa de picadillo x" + cantidad1);

                    }

                break;

                case 3:

                    System.out.println("cuanta cantidad?");

                    cantidad3 = sc.nextInt();

                    if (cantidad3 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        precioTotal = precioTotal + cantidad3 * PLATO3;

                        System.out.println("Ensalada de atun x" + cantidad1);

                    }

                    break;

                case 4:

                    System.out.println("cuanta cantidad?");

                    cantidad4 = sc.nextInt();

                    if (cantidad4 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        if(cantidad4 > 2){

                            // descuento si son mas de dos platos iguales

                            precioTotal = precioTotal + (cantidad4 * PLATO4) - (1 * cantidad4);
                        }

                        else{

                            precioTotal = precioTotal + cantidad4 * PLATO4;



                        }

                        System.out.println("Paella x" + cantidad1);


                    }

                    break;

                case 5:

                    System.out.println("cuanta cantidad?");

                    cantidad5 = sc.nextInt();

                    if (cantidad5 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        if(cantidad5 > 2){

                            precioTotal = precioTotal + (cantidad5 * PLATO5) - (1 * cantidad5);
                        }

                        else{

                            precioTotal = precioTotal + cantidad5 * PLATO5;



                        }

                        System.out.println("salmon x" + cantidad1);

                    }

                break;

                case 6:

                    System.out.println("cuanta cantidad?");

                    cantidad6 = sc.nextInt();

                    if (cantidad6 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        if(cantidad6 > 2){

                            precioTotal = precioTotal + (cantidad6 * PLATO6) - (1 * cantidad6);
                        }

                        else{

                            precioTotal = precioTotal + cantidad6 * PLATO6;



                        }

                        System.out.println("codillo al horno x" + cantidad1);

                    }

                    break;

                case 7:

                    System.out.println("cuanta cantidad?");

                    cantidad7 = sc.nextInt();

                    if (cantidad7 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        if(cantidad7 > 2){

                            precioTotal = precioTotal + (cantidad7 * PLATO7) - (1 * cantidad7);
                        }

                        else{

                            precioTotal = precioTotal + cantidad7 * PLATO7;

                        }

                        System.out.println("lentejas x" + cantidad1);

                    }

                    break;

                case 8:

                    System.out.println("cuanta cantidad?");

                    cantidad8 = sc.nextInt();

                    if (cantidad8 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        precioTotal = precioTotal + cantidad8 * PLATO8;

                        System.out.println("fruta x" + cantidad1);

                    }

                    break;

                case 9:

                    System.out.println("cuanta cantidad?");

                    cantidad9 = sc.nextInt();

                    if (cantidad9 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        precioTotal = precioTotal + cantidad9 * PLATO9;

                        System.out.println("cafe x" + cantidad1);

                    }

                    break;

                case 10:

                    System.out.println("cuanta cantidad?");

                    cantidad10 = sc.nextInt();

                    if (cantidad10 < 0){

                        System.out.println(" por favor introduce una opcion correcta");
                    }

                    else{

                        precioTotal = precioTotal + cantidad10 * PLATO10;

                        System.out.println("helado x" + cantidad1);

                    }

                    break;

                case 0:

                    System.out.println("has seleccionado salir");

                    break;

                default:

                    System.out.println("opcion incorrecta");
            }

            sc.nextLine(); // limpiar buffer



        }while(opcion!= 0);

        // descuentos por precio total

        if(precioTotal >= 20 && precioTotal <= 30) precioTotal = precioTotal - 2;
        if(precioTotal >= 31 && precioTotal <= 50) precioTotal = precioTotal - 3;
        if(precioTotal > 50) precioTotal = precioTotal - 5;

        System.out.println("El precio total es " + precioTotal);

        sc.close();
    }
}
