package EjerciciosFechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class fechas1Solucion {
    
    public static void main(String[] args) {
        
        /*
         *  Pedir fecha de naciminento
         * mostrarla por pantalla --> dias - Mes con letras - yy
         * Mostrar la edad
         * cuanto queda para tu cumpleaños ( con chronounit y period)
         * 
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("indica el año");

        int año = sc.nextInt();

        System.out.println("indica el mes");

        int mes = sc.nextInt();

        System.out.println("indica el dia");

        int dia = sc.nextInt();

        LocalDate fecha = LocalDate.of(año, mes, dia);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd, MMMM, yy") ;

        System.out.println(fecha.format(formato));

        // mostrar edad

        System.out.println(ChronoUnit.YEARS.between(fecha, LocalDate.now()) + " años");

        // Tiempo hasta cumpleaños

    }     

}
