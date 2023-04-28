package logCutre;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    // enum
    
    public enum Tipo {ERROR, INFORMACION};

    // Atributos

    private static String nombreFichero = "Log.txt";

    // Metodos
    
    public static void nuevaEntradaLog(String mensaje, Tipo tipo){

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/" + nombreFichero, true))) {

            String mensajeTotal = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"))
            + " - " + tipo + " : " + mensaje;

            bWriter.write(mensajeTotal);
            bWriter.newLine();
            
        } 
        
        catch (Exception e) {

            System.out.println("ERROR: " + e);

        }

    }


}
