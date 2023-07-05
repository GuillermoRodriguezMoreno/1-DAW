package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


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

                    // Informo de que el campo esta vacio

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
            int poblacion = Integer.valueOf(trozos[3]);

            municipio = new Municipio(cp, nombre, año, poblacion);

        } catch (Exception e) {
                
            System.out.println("fallo en linea: " + Arrays.toString(trozos));

        }

        return municipio;

    }

    /**
     * Devuelve una lista con los municipios de un año dado, si dicho año es null
     * devuelve la lista de todos los años. Si para el año dado no hay datos,
     * devuelve una lista vacia
     * @param año
     * @return
     */
    public static ArrayList<Municipio> leerFicheroMunicipio(Integer año){

        // Lista completa
        ArrayList<Municipio> listaCompleta = leerFicheroMunicipio();
        ArrayList<Municipio> listaPorAño = new ArrayList<>();

        // Si no es null
        if(año != null){

            // Busco la lista de ese año
            for (Municipio element : listaCompleta) {
                
                // Selecciono municipios que coincidan con el año
                if(element.getAño() == año){

                    // Añado los municipios
                    listaPorAño.add(element);

                }
            }

            // Si no existe datos de dicho año
            if(listaPorAño.size() < 1){

                System.out.println("No hay datos de poblacion en ese año");
            }

            // Devuelvo la lista vacia
            return listaPorAño;

        }

        // Si es null devuelvo la lista completa
        return listaCompleta;
    }

    /**
     * Busca en la lista un municipio por año y nombre, si no se encuentra devuelve null
     * @param lista
     * @param nombre
     * @param año
     * @return
     */
    public static Municipio buscarMunicipio(ArrayList<Municipio> lista, String nombre, Integer año){

        // Ordeno lista
        Collections.sort(lista);

        // Busco
        int posicion = Collections.binarySearch(lista, new Municipio("", nombre, año, 0));

        // Si no se encuentra
        if(posicion < 0){

            System.out.println("El municipio no se encuentra en la lista");
            return null;
        }

        // Si se encuentra
        return lista.get(posicion);

    }

    /**
     * Devuelve un mapa con los nombres de los municipios y su respectivo incremento
     * de poblacion entre dos años dados
     * @param lista
     * @param año1
     * @param año2
     * @return
     */

    public static HashMap<String, Integer> incrementoPoblacion(ArrayList<Municipio> lista, int año1, int año2){

        HashMap<String, Integer> mapa = new HashMap<>();

        ArrayList<Municipio> listaAño1 = leerFicheroMunicipio(año1);
        ArrayList<Municipio> listaAño2 = leerFicheroMunicipio(año2);

        for (int i = 0; i < listaAño1.size(); i++) {
        
            mapa.put(listaAño1.get(i).getNombre(), (listaAño2.get(i).getPoblacion() - listaAño1.get(i).getPoblacion()));

        }

        return mapa;
        
    }

    /**
     * Devuelve el municipio menos poblado de una lista de municipios
     * @param lista
     * @return
     */

    public static Municipio obtenerMenosPoblado(ArrayList<Municipio> lista){

        Municipio menosPoblado = null;
        int min = Integer.MAX_VALUE;

        for (Municipio elemento : lista) {
            
            if(elemento.getPoblacion() < min){

                min = elemento.getPoblacion();
                menosPoblado = elemento;

            }

        }

        return menosPoblado;

    }

}
