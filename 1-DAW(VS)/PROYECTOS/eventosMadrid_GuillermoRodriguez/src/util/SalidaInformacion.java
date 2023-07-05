package util;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SalidaInformacion {
    
    // Metodos

    public static void crearInforme(String nombre, String informacion){

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/recursos/" + nombre + ".txt"))) {

            bWriter.write(informacion);
            
        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
