package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class Ejercicio32Bueno {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("introduce un numero entero positivo");

        long num = 0;

        do{ //control

            num = sc.nextLong();

        }while (num < 0);

        int suma = 0;

        String numero = String.valueOf(num); // convertir long a String
        
        for (int i = 0 ; i < numero.length()  ; i++){ //bucle recorre digitos y compara si es par o no

            if(numero.charAt(i)%2 == 0) {
                
                System.out.print(numero.charAt(i) + ", ");

                suma = suma + (int)(Character.getNumericValue(numero.charAt(i))); //convertir char a int

            }

        }

        System.out.println("son digitos pares");
        System.out.println("la suma es: " + suma);

        sc.close();
    }
}
