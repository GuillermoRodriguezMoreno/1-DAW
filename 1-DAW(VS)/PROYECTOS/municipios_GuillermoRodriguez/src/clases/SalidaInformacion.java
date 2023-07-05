package clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SalidaInformacion {
    
    // Metodos

    public static void write(String path, String cadena){

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(path, false))) {

            bWriter.write(cadena + "\n");
            
        }
        
        catch(IOException e){

            System.out.println(e.getMessage());
        }
        
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
