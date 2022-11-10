package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio32_ConString {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un numero entero positivo");

        long num = 0;

        String numeroReves = "";

        do{ //control

            num = sc.nextLong();

        }while (num < 0);

        int suma = 0;

        String numero = String.valueOf(num); // convertir long a String
        
        for (int i = numero.length() - 1 ; i >= 0  ; i--){ // bucle para darle la vuelta al String

            numeroReves = numeroReves.concat(numero.valueOf(numero.charAt(i)));
        }

        num = Long.parseLong(numeroReves); // convertir String a long

        for (int k = numero.length() - 1 ; k >= 0 ; k --){

            if(num%2 == 0) {
                
                System.out.print(numeroReves.charAt(k) + ", ");

                suma = suma + (int)(num%10);

            }
            
            num = num/10;
        }

        System.out.println("son digitos pares");
        System.out.println("la suma es: " + suma);

        sc.close();
    }
}
