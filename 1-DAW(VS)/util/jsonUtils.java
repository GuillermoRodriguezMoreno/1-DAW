package utils;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import modelos.Pokedex;



public class jsonUtils {

    public static Pokedex leerPokedexFromJsonFile(){

        Pokedex pokedex = null;

        try {
            
            File ficheroPokedex = new File("src/recursos/pokemon.json");

            ObjectMapper objectMapper = new ObjectMapper();

            try {

                pokedex = objectMapper.readValue(ficheroPokedex, Pokedex.class);
            } 
            
            catch (IOException e) {
                
                e.printStackTrace();
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

        return pokedex;

    }

    /**
     * Crea un archivo json con el nombre dado y con el pokemon dado
     * @param nombreArchivo
     * @param pokemon
     */

    public static void listPokemonConvertToJson(String nombreArchivo, Object objeto){

        try {
            
            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

            File file = new File("src/recursos/jsonExtra/" + nombreArchivo + ".json");
            mapper.writeValue(file, objeto);

        } 
        
        catch (Exception e) {

            e.printStackTrace();

        }

    }

}
