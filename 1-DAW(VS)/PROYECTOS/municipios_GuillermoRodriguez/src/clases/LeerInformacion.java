package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LeerInformacion {
    
    // Metodos

    /**
     * devuelve una lista con todos los municipios con poblacion en todos los años
     * @return
     */

    public static ArrayList<Municipio> leerFicheroMunicipio(){

        // Creo lista
        ArrayList<Municipio> listaMunicipios = new ArrayList<>();

        // try-resource
        try (BufferedReader bReader = new BufferedReader(new FileReader("src/recursos/PoblacionMunicipiosMalaga.csv"))) {

            // Omito primera linea
            bReader.readLine();
            // Leo linea
            String linea = bReader.readLine();

            // Mientras linea no sea null
            while(linea != null){

                // Si la linea contiene Total y no contiene Malaga
                if(linea.contains("Total") && !linea.contains("Málaga")){

                    // Reemplazo . por cadena vacia para poder guardar la poblacion
                    linea = linea.replace(".", "");

                    // Parto linea en trozos por ;
                    String[] trozosLinea = linea.split(";");

                    // Si el trozo relacionado con poblacion esta vacio
                    if(!trozosLinea[3].equals("\"\"")){

                        // Creo municipio con los atributos de los trozos
                        Municipio nuevoMunicipio = construirMunicipio(trozosLinea);

                        // Añado municipio a la lista
                        listaMunicipios.add(nuevoMunicipio);

                    }

                }

                linea = bReader.readLine();
                
            }


        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

        return listaMunicipios;

    }

    /**
     * Crea un Municipio con las columnas del archivo
     * @param trozos
     * @return
     */

    static Municipio construirMunicipio(String[] trozos){

        Municipio municipio = null;

        // Hay que tratar el primer trozo ya que tiene nombre y cp junto
        String[] nuevo = trozos[0].split(" ", 2); // solo corta en 2 trozos

        try {
            
            // Asigno atributos
            String cp = nuevo[0];
            String nombre = nuevo[1];
            int año = Integer.valueOf(trozos[2]);
            long poblacion = Long.valueOf(trozos[3]);

            municipio = new Municipio(cp, nombre, año, poblacion);

        } catch (Exception e) {
                
            System.out.println("fallo en linea: " + Arrays.toString(trozos));

        }

        return municipio;

    }

    public static ArrayList<Municipio> leerFicheroMunicipio(Integer año){

        if(año == null){


        }

        return null;
    }

}
