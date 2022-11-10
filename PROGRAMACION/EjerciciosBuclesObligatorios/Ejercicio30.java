package EjerciciosBuclesObligatorios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Ejercicio30 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        boolean controlDia = true;
        boolean controlHora = true;

        int dia = 0;
        int dia2 = 0;
        int hora = 0;
        int hora2 = 0;

        do{

            System.out.println("introduce el primer dia (1 al 7)");

            dia = sc.nextInt();

            if(dia <= 0 && dia > 7) controlDia = false;

            System.out.println("introduce la hora");

            hora = sc. nextInt();

            if (hora < 1 && hora > 24) controlHora = false;

            System.out.println("introduce el segundo dia posterior al primero (1 al 7)");

            if((dia <= 0 && dia > 7)&&(dia2 <= dia)) controlDia = false;

            dia2 = sc.nextInt();

            System.out.println("introduce la hora");

            if (hora < 1 && hora > 24) controlHora = false;

            hora2 = sc. nextInt();

            if (controlDia == false && controlHora == false)System.out.println("introduce los datos correctamente");

        }while (controlDia == false && controlHora == false);

        LocalDateTime fecha = LocalDateTime.of(1, 1, dia, hora, 0, 0);

        LocalDateTime fecha2 = LocalDateTime.of(1, 1, dia2, hora2, 0, 0);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:00  EEEE");

        System.out.println("Entre " + fecha.format(formato) + " y " + fecha2.format(formato) + " hay " + ChronoUnit.HOURS.between(fecha, fecha2) + " horas");

        sc.close();
    }
}
