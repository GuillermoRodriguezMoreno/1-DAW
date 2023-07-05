package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaEventos {
    
    @JsonProperty("@graph")
    private List<Evento> lista;

    // Contructor

    public ListaEventos(){


    }

    public ListaEventos(List<Evento> lista){

        this.lista = lista;

    }

    // Metodos

    /**
     * Devuelve una lista de eventos gratuitos
     * @return
     */
    public List<Evento> listadoEventosGratuitos(){

        List<Evento> listaEventosGratuitos = new ArrayList<>();

        for (Evento evento : this.lista) {

            if(evento.isGratuito()){

                listaEventosGratuitos.add(evento);

            }
            
        }

        return listaEventosGratuitos;

    }

    /**
     * Devuelve una lista con los eventos gratuitos de un codigo postal dado
     * @param cp
     * @return
     */
    public List<Evento> listaEventosGratuitos(String cp){

        List<Evento> listaEventosGratuitos = new ArrayList<>();

        String cpEvento = "";

        Direccion direccion = null;

        for (Evento evento : this.listadoEventosGratuitos()) {

            try {
                
                direccion = evento.getDireccion();

                // Algunos registros no tienen direccion por lo que hay que evitar el nullPointer
                if(direccion == null){

                    cpEvento = "Sin Código Postal";

                }

                else if (direccion.getArea() == null){

                    cpEvento = "Sin Código Postal";

                }

                else{

                    cpEvento = direccion.getArea().getCp();

                }

                if(cpEvento.equals(cp)){

                    listaEventosGratuitos.add(evento);
                }

            }

            catch(Exception e){

                e.printStackTrace();
            }

        }

        return listaEventosGratuitos;

    }

    public HashMap<String, Integer> eventosTotales(){

        Integer contador = 0;
        HashMap<String, Integer> eventos = new HashMap<>();

        // voy hacer una lista con los codigos postales

        List<String> listaCp = new ArrayList<>();

        // Recorro lista de eventos y añado codigos postales

        String cpEvento = "";
        Direccion direccion = null;

        for (Evento evento : this.lista) {

            try {
                
                direccion = evento.getDireccion();

                // Algunos registros no tienen direccion por lo que hay que evitar el nullPointer
                if(direccion == null){

                    cpEvento = "Sin Código Postal";

                }

                else if (direccion.getArea() == null){

                    cpEvento = "Sin Código Postal";

                }

                else{

                    cpEvento = direccion.getArea().getCp();

                }
                
                listaCp.add(cpEvento);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        // Vuelvo a reccorer lista de eventos para obtener el codigo postal y obtener sus ocurrencias

        for (Evento evento : this.lista) {

            try {
                
                contador = 0;
            
                direccion = evento.getDireccion();

                if(direccion == null){

                    cpEvento = "Sin Código Postal";

                }

                else if (direccion.getArea() == null){

                    cpEvento = "Sin Código Postal";

                }

                else{

                    cpEvento = direccion.getArea().getCp();

                }

                contador = Collections.frequency(listaCp, cpEvento);

                // Añado al mapa
                eventos.put(cpEvento, contador);

            } 
            
            catch (Exception e) {
                
                e.printStackTrace();

            }

        }

        return eventos;

    }
    
    public int eventosTotalesMapa(HashMap<String, Integer> mapa){

        int acumulador = 0;

        for (String key : mapa.keySet()) {

            acumulador = acumulador + mapa.get(key);
            
        }

        return acumulador;

    }


    // Getters y Setters

    public List<Evento> getLista() {
        return lista;
    }

    public void setLista(List<Evento> listaEventos) {
        this.lista = listaEventos;
    }

    

}
