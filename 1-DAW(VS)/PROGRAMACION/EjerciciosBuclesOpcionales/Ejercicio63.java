package EjerciciosBuclesOpcionales;

import java.util.Scanner;

public class Ejercicio63 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce la altura 1");

        int altura1 = sc.nextInt();

        System.out.println("introduce la altura 2");

        int altura2 = sc.nextInt();

        int alturaMax = Math.max(altura1, altura2);
        int diferenciaAltura = Math.abs(altura1-altura2);

        for (int linea = 1 ; linea <= alturaMax ; linea++ ){ //recorre lineas
            
            if (altura1 < altura2){ //la piramide 1 es mas pequeña

                if (linea <= (diferenciaAltura)){ // pinta espacios en las lineas que no utiliza piramide1

                    for (int i = 1 ; i <= (altura1 * 2)  ; i++){ // no se le resta -1 por el asterisco de separacion de bases

                        System.out.print(" ");
                    }

                    for (int j = 1 ; j <= altura2 - linea ; j++){ //pinta los espacios de la piramide2 de las lineas de la diferencia de altura

                        System.out.print(" ");
                    }

                    for ( int k = 1 ; k <= linea + (linea-1) ; k++){

                        System.out.print("*");

                    }

                }else{

                    for (int j = 1 ; j <=  altura1 - linea + diferenciaAltura; j++){ //bucle espacios piramide1

                        System.out.print(" ");
                    }

                    for (int k = 1 ; k <= linea - diferenciaAltura ; k++){ //bucle asteriscos 1/2 piramide1

                        System.out.print("*");
                    }

                    for (int z = 1 ; z <= linea - diferenciaAltura - 1 ; z++){ // bucle asteriscos 1/2 piramide1

                        System.out.print("*");
                    }

                    System.out.print(" "); // espacio de separacion entre base de piramides

                    for(int y = 1 ; y <= altura1 - (linea - diferenciaAltura) ; y++){ //bucles espacios post piramide hasta anchura piramide1

                        System.out.print(" ");
                    }

                    for (int j = 1 ; j <=  altura1 - linea + diferenciaAltura; j++){ //bucle espacios piramide2 resto de lineas

                        System.out.print(" ");
                    }

                    for ( int k = 1 ; k <= linea + (linea-1) ; k++){ // bucle asteriscos piramide2 resto de lineas

                        System.out.print("*");

                    }
                }

            System.out.println(""); // salto linea
            
            }else{ // caso en que la piramide2 sea menor que piramide1

                for (int i = 1 ; i <= altura1 - linea ; i++){ //pinta espacios piramide1

                    System.out.print(" ");
                }

                for (int j = 1 ; j <= linea + (linea-1) ; j++){ //pinta asteriscos piramide1

                    System.out.print("*");
                }

                System.out.print(" "); // separacion de base

                if (linea > diferenciaAltura){ // si la linea es igual a la altura de la piramide2

                    for (int i = 1 ; i <= altura2 - (linea - diferenciaAltura) ; i++){ //pinta espacios post piramide1

                        System.out.print(" ");
                    }

                    for (int i = 1 ; i <= altura2 - (linea - diferenciaAltura) ; i++){ //pinta espacios piramide2

                        System.out.print(" ");
                    }

                    for (int j = 1 ; j <= (linea - diferenciaAltura) + ((linea - diferenciaAltura) - 1) ; j++){ //pinta asteriscos piramide2

                        System.out.print("*");

                    }

                }

                System.out.println("");

            }
        }
        sc.close();

             /* bucle cualquier piramide

                for (int j = 1 ; j <= altura1 - linea ; j++){ //bucle espacios piramide1

                    System.out.print(" ");
                }
                for (int k = 1 ; k <= linea + (linea-1) ; k++){ //bucle asteriscos piramide1

                    System.out.print("*");
                }
            */  
    }
}
