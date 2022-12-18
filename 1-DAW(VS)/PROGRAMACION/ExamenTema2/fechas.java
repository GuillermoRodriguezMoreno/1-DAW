package ExamenTema2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class fechas {
    public static void main(String[] args) {
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy 'dia' EEEE");

        System.out.println(LocalDate.now().format(formato));
    }
}
