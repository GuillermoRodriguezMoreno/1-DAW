package util;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SalidaInformacion {
    
    // Metodos

    public static void crearFichero(String nombreFichero, String informacion){

        try (BufferedWriter bWriter = new BufferedWriter( new FileWriter("src/recursos/" + nombreFichero + ".txt", false))) {


            bWriter.write(informacion);

        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
