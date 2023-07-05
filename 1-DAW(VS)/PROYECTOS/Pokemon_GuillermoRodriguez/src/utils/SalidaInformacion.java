package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SalidaInformacion {
    
    // Metodos

    public static void salidaInformacion(String informacion){

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/recursos/consultasPokemon.txt", false))) {

            bWriter.write(informacion);

        } 
        
        catch (Exception e) {

            e.printStackTrace();

        }
    }
}
