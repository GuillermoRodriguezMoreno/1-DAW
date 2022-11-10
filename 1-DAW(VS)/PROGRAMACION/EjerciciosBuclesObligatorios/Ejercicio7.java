package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce una combinacion de 4 cifras");

        int combinacion = sc.nextInt();

        int codigo = 1234;
        int contador = 1;

        while(contador < 4 && combinacion != codigo){
            
            System.out.println("combinacion erronea, te quedan " + (4-contador) + " intentos");
            System.out.println("intentalo de nuevo");

            combinacion = sc.nextInt();
            contador ++;
        }
        if (combinacion == codigo) System.out.println("caja abierta");
        else System.out.println("fallo, has acabado todo los intentos");
        
        sc.close();
    }
}
