package ClasesT6.UsoClases;

import java.util.Scanner;

import ClasesT6.Clases.Zona;

public class E7ExpoCoche {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Zona salaPrincipal = new Zona(1000);
        Zona compraVenta = new Zona(200);
        Zona vip = new Zona(25);

        boolean salir = false;
        int opcion = 0;

        int opcionZona = 0;

        int numeroEntradas = 0;



        do{

            System.out.println("Selecciona una opcion:");
            System.out.println("1. Mostrar numero de entradas libres");
            System.out.println("2. Vender entradas");
            System.out.println("3. Salir");

            opcion = sc.nextInt();

            switch(opcion){

                case 1:

                    System.out.println("Para que zona?");
                    System.out.println("1. Sala principal");
                    System.out.println("2. Compra-Venta");
                    System.out.println("3. VIP");

                    opcionZona = sc.nextInt();

                    switch(opcionZona){

                        case 1:

                            System.out.println(salaPrincipal.getEntradasPorVender() + " entradas libres");

                            break;

                        case 2:

                            System.out.println(compraVenta.getEntradasPorVender() + " entradas libres");

                            break;

                        case 3:

                            System.out.println(vip.getEntradasPorVender() + " entradas libres");

                            break;
                    }

                    break;

                case 2:

                    System.out.println("Para que zona?");
                    System.out.println("1. Sala principal");
                    System.out.println("2. Compra-Venta");
                    System.out.println("3. VIP");

                    opcionZona = sc.nextInt();

                    System.out.println("Cuantas entradas quieres?");

                    numeroEntradas = sc.nextInt();

                    switch(opcionZona){

                        case 1:

                           

                            salaPrincipal.vender(numeroEntradas);


                            break;

                        case 2:

                            
                            compraVenta.vender(numeroEntradas);

                            
                            break;

                        case 3:

                            

                            vip.vender(numeroEntradas);

            
                            break;

                        default:

                            System.out.println("opcion erronea");
                    }

                    break;
                
                case 3:

                    salir = true;

                    break;

                default:

                    System.out.println("opcion incorrecta");

                    break;
            }

        }while(!salir);

        System.out.println("has salido");
    }
}
