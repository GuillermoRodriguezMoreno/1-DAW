package EjerciciosFechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class fechas1 {
   
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

        // tiempo hasta tu cumpleaños

        int mesActual = LocalDate.now().getMonthValue();
        int diaActual = LocalDate.now().getDayOfMonth();

        LocalDate fechaResta = LocalDate.of(LocalDate.now().getYear(), fecha.getMonth(), fecha.getDayOfMonth());

        Period resultado = LocalDate.now().until(fechaResta);
        
        if (fecha.getMonthValue() >= mesActual && fecha.getDayOfMonth() >= diaActual){

            System.out.println(resultado);

        }else {
            
            Period resultado2 = LocalDate.now().until(fechaResta.plusYears(1));
            System.out.println(resultado2);

        };






    }
}