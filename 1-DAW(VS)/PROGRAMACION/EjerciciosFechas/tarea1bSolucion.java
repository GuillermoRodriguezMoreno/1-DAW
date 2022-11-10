package EjerciciosFechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class tarea1bSolucion {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int dia = 25;
        int mes = 10;
        int anio = 2022;
        int hora = 12;
        int minutos = 45;

        LocalDateTime fechaExamen = LocalDateTime.of(anio, mes, dia, hora, minutos);
        
        // usar comillas simples en el patron para introducir caracteres o propio formato
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("'El examen sera el' EEEE ',' dd ' 'de' LLLL 'del' yy");
        System.out.println(fechaExamen.format(formato));

        long horasQueFaltan = ChronoUnit.HOURS.between(LocalDateTime.now(), fechaExamen);
        System.out.println("Faltan " + horasQueFaltan);
    }
}
