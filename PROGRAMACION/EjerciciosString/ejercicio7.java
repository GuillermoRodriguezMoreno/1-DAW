package EjerciciosString;

import java.util.Scanner;

public class ejercicio7 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        char caracter = sc.nextLine().charAt(0);

        if (Character.isDigit(caracter)) System.out.println("es digito");
        else if (Character.isSpaceChar(caracter)) System.out.println("es en blanco");
        else Character.isUpperCase(caracter) ;System.out.println("es mayuscula");
        

        sc.close();
        
    
    }}
