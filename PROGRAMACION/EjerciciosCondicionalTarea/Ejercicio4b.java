package EjerciciosCondicionalTarea;

import java.util.Scanner;

public class Ejercicio4b {
    public static void main(String[] args) {
        
        final float GAS = 1.75f;
        final int KM = 550;
        final int GASTO_CIEN = 8;
        final int PRECIO_AVION = 95;
        final int SUPLEMENTO = 20;
        final int PRECIO_TREN = 80;
        final float DES_TREN_4 = 0.25f;
        final float DES_TREN_3 = 0.10f;
        
        Scanner sc = new Scanner(System.in);

        float precioPersona = 0.0f;
        float precioTotal = 0.0f;

        float descuentoTren = 0.0f;

        boolean coche = false;
        boolean avionEquipaje = false;
        boolean avion = false;
        boolean tren = false;
        boolean controlPersonas = false;
        boolean controlTransporte = false;
        boolean controlEquipaje = false;

        System.out.println("como vais a viajar, en coche, avion o tren?");

        String transporte = sc.nextLine();

        if (transporte.equals("coche") || transporte.equals("avion") || transporte.equals("tren")){

            controlTransporte = true;

        }else controlTransporte = false;

        System.out.println("cuantas personas: 2, 3 o 4?");

        int numPersonas = sc.nextInt();

        sc.nextLine(); //limpiar buffer

        if (numPersonas == 2 || numPersonas == 3 || numPersonas == 4){

            controlPersonas = true;

        }else controlPersonas = false;

        if (controlTransporte == false && controlPersonas == true) System.out.println("precio 0, error en medio de transporte");
        
        else if (controlPersonas == false && controlTransporte == true) System.out.println("precio 0, error en numero de personas");

        else if (controlPersonas == false && controlTransporte == false) System.out.println("precio 0, error en numero de personas y en medio de transporte");

        else{

            if (transporte.equals("coche")){

                precioTotal =((((float)(KM * GASTO_CIEN))/100) * GAS);
    
                coche = true;
    
            }else if (transporte.equals("avion")){
    
                avion = true;
    
                System.out.println("llevais equipaje? s/n");
    
                char equipaje = sc.nextLine().charAt(0);
                
                if (equipaje == 's') {
    
                    avionEquipaje = true;

                    controlEquipaje = true;
    
                    precioTotal = (PRECIO_AVION + SUPLEMENTO) * numPersonas;
                
                }else if (equipaje == 'n') {
                
                precioTotal = PRECIO_AVION * numPersonas;

                controlEquipaje = true;

                }else controlEquipaje = false;
    
            }else if (transporte.equals("tren")){
    
                    tren = true;
    
                if (numPersonas == 4){
    
                    descuentoTren = (PRECIO_TREN * numPersonas) * DES_TREN_4;
                    precioTotal = (PRECIO_TREN * numPersonas) - descuentoTren;
    
                }else if (numPersonas == 3){
    
                    descuentoTren = (PRECIO_TREN * numPersonas) * DES_TREN_3;
                    precioTotal = (PRECIO_TREN * numPersonas) - descuentoTren;
    
                }else {
                    
                    precioTotal = (PRECIO_TREN * numPersonas);
                }
    
            }
    
            precioPersona = precioTotal / numPersonas;

            if (controlEquipaje == false) System.out.println("opcion de equipaje erronea");

            else{

                System.out.println("Vais a viajar " + numPersonas + " personas");
                System.out.println("viajais en " + transporte);
                System.out.println("Precio por persona " + precioPersona);

                if (coche){

                    System.out.println("Precio gasolina total = " + precioTotal + " euros");

                }else if (avion){

                    if (avionEquipaje){

                        System.out.println("precio por equipaje " + SUPLEMENTO * numPersonas + " euros");

                    }

                    System.out.println("precio billetes " + precioTotal + "euros");

                }else if (tren){

                    System.out.println("Precio total billete tren " + precioTotal + " euros");

                    if (numPersonas == 3 || numPersonas == 4){

                        System.out.println("descuento total por ser " + numPersonas + " personas: " + descuentoTren);

                    }
                }
            }
        }
        sc.close();
    }
}
