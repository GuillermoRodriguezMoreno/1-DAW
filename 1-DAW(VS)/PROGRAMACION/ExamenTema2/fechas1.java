package ExamenTema2;

import java.time.LocalDate;
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

        System.out.println("año de nacimiento");

        int añoNac = sc.nextInt();

        System.out.println("mes de nacimiento");

        int mes = sc.nextInt();

        System.out.println("dia de nacimiento");

        int dia = sc.nextInt();

        LocalDate fechaNac = LocalDate.of(añoNac, mes, dia);

        DateTimeFormatter formatoMio = DateTimeFormatter.ofPattern("dd - MMMM - yy");

        System.out.println(fechaNac.format(formatoMio));

        System.out.println("tengo " + ChronoUnit.YEARS.between(fechaNac, LocalDate.now()));

        LocalDate finAno = LocalDate.of(2022,12,31);

        System.out.println("---------------------------------");

        LocalDate fechaActual = LocalDate.now();
        
        Period hastaFinAno = fechaActual.until(finAno);
        System.out.println("Hasta final de año queda: "+ hastaFinAno);
        System.out.println("Quedan " + hastaFinAno.getYears() + " años, " + hastaFinAno.getMonths()+ 
                        " meses y "+ hastaFinAno.getDays() + " días") ;     




    }
}
