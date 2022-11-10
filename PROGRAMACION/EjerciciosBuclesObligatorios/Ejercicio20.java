package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio20 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int altura = 0;

        do {
            
            System.out.println("introduce la altura de la piramide (3 o mayor)");

            altura = sc.nextInt();

        }while(altura < 3);

        sc.nextLine(); // clean buffer

        System.out.println("introduce el caracter para pintar");

        char caracter = sc.nextLine().charAt(0);



        for(int i = 1 ; i <= altura ; i ++){ //bucle lineas

            for(int j = 0 ; j <= altura - i ; j ++ ){ //bucle espacios

                System.out.print(" ");
            }

            if (i == 1)System.out.println(caracter); // pintar caracter con salto de linea

            else if(i > 1 && i < altura){

                System.out.print(caracter);

                for(int k = 0 ; k < (i * 2) - 3 ; k ++){ // bucle para hueco piramide

                    System.out.print(" ");

                }

                System.out.println(caracter); // pintar caracter con salto de linea

            }

            else if (i == altura){ //control pintar base piramide

                for(int z = 0 ; z < (altura * 2) - 1 ; z ++){ // pintar base piramide

                    System.out.print(caracter);
                }
            }
        }

        sc.close();
    }
}
