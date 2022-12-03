package ExamenTema2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ExamenEj2 {
    public static void main(String[] args) {
        
        int dia = (int) (Math.random() * 32 + 1); //rango de dias 1-7

        int mes = (int) (Math.random() * 13 + 1); //rango de mes 1-31

        int año = (int) (Math.random() * 2031); //

        LocalDate fecha = LocalDate.of(año, mes, dia); // crear fecha

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd, LLLL (EEEE), yyyy"); // crear formato fecha

        System.out.println("es el dia " + fecha.format(formato)); // formatear fecha

        LocalDate fechaHasta = LocalDate.of(año, 12, 31); // crear fecha fin de año

        System.out.println("faltan " + ChronoUnit.DAYS.between(fecha, fechaHasta) + " dias para fin de año"); // restar fechas

    }
}
