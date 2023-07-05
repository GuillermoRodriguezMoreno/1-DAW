package utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import modelos.RespuestaPelicula;
import modelos.RespuestaPersona;

public class UtilsWS {

    // Leer pelicula
    
    public static RespuestaPelicula leerPeliculaFromWS(String titulo){
        
        RespuestaPelicula respuesta = null;

        try {

            String query = "\"" + titulo + "\"";

            URL url = new URL("https://api.themoviedb.org/3/search/movie?api_key=f90902a089f156ef97dd133d9e092ad3&include_adult=false&language=en-US&page=1&query=" + query );

            URLConnection connection = url.openConnection();

            InputStream stream =  new BufferedInputStream(connection.getInputStream());

            ObjectMapper mapper = new ObjectMapper();

            respuesta = mapper.readValue(stream, RespuestaPelicula.class);


        } catch (Exception e) {

            System.out.println("Error al leer Peliculas desde el WS");
            
        }


        return respuesta;
    }

    // Leer persona

    public static RespuestaPersona leerPersonaFromWS(String titulo){
        
        RespuestaPersona respuesta = null;

        try {

            String query = "\"" + titulo + "\"";

            URL url = new URL("https://api.themoviedb.org/3/search/person?api_key=f90902a089f156ef97dd133d9e092ad3&include_adult=false&language=en-US&page=1&query=" + query );

            URLConnection connection = url.openConnection();

            InputStream stream =  new BufferedInputStream(connection.getInputStream());

            ObjectMapper mapper = new ObjectMapper();

            respuesta = mapper.readValue(stream, RespuestaPersona.class);


        } catch (Exception e) {

            System.out.println("Error al leer Personas desde el WS");
            
        }


        return respuesta;
    }

}

