package EjerciciosArrays.recuperacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ejercicio2_GuillermoRodriguez {
    
    public static void main(String[] args) {

        // a)

        // genero año y dia aleatorio

        int añoAleatorio = (int) (Math.random() * (2050 - 2023) + 2023);

        int diaAleatorio = (int) (Math.random() * 357 + 1);

        // declaro fecha
        
        LocalDateTime fechaSuma;

        // sumo a la fecha los dias aleatorios

        fechaSuma = LocalDateTime.now().plusDays(diaAleatorio);

        // obtengo los valores de la fecha

        int mes = fechaSuma.getMonthValue();

        int dia = fechaSuma.getDayOfMonth();

        int hora = fechaSuma.getHour();

        int minutos = fechaSuma.getMinute();

        int seg = fechaSuma.getSecond();

        // declaro una nueva fecha

        LocalDateTime fecha = LocalDateTime.of(añoAleatorio, mes, dia, hora, minutos, seg);


        System.out.println("a)");

        // creo el formato

        DateTimeFormatter formatoNuevo = DateTimeFormatter.ofPattern("'Te ha tocado un ' EEEE ' del año ' yyyy ' - a las ' HH:mm ' horas del ' dd ' de ' MMMM");

        System.out.println(fecha.format(formatoNuevo));

        // b)

        LocalDateTime añoNuevo = LocalDateTime.of(añoAleatorio, 1, 1, 0, 0, 0); // creo fecha año nuevo

        int diasPasados = (int) ChronoUnit.DAYS.between(añoNuevo, fecha); // obtengo los dias entre año nuevo y la fecha creada

        System.out.println("b)");

        System.out.println("desde año nuevo han pasado " + diasPasados + " dias");

        // c)

        // salida por pantalla

        System.out.println("c)");

        System.out.println(dia%2 == 0 ? "El dia " + dia + " del mes " + mes + " es par" : "El dia " + dia + " del mes " + mes  + " es impar");
    }
}
