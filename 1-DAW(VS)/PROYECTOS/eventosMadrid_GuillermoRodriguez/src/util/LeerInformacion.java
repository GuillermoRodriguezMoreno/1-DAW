package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import modelos.Area;
import modelos.Direccion;
import modelos.Evento;
import modelos.ListaEventos;

public class LeerInformacion {
    
    // Metodos

    public static ListaEventos leerFichero(){

        List<Evento> listaEventos = new ArrayList<>();

        try (BufferedReader bReader = new BufferedReader(new FileReader("src/recursos/206974-0-agenda-eventos-culturales-100.csv"))) {

            // Salto primera linea

            bReader.readLine();

            String linea = bReader.readLine();

            Evento evento = null;

            while(linea != null){

                String[] trozos = linea.split(";");

                for (int i = 0; i < trozos.length; i++) {
                    
                    trozos[i] = trozos[i].replaceAll("\"", "");
                }

                evento = construirEvento(trozos);

                listaEventos.add(evento);

                linea = bReader.readLine();

            }
            
        } 
        
        catch (Exception e) {

            e.printStackTrace();

        }

        ListaEventos listaCompleta = new ListaEventos();

        listaCompleta.setLista(listaEventos);

        return listaCompleta;

    }

    private static Evento construirEvento(String[] trozos) {

        Evento evento = new Evento();

        try {
            
            evento.setId(trozos[0]);
            evento.setTitulo(trozos[1]);
            evento.setPrecio(trozos[2]);

            if(trozos[3].equals("1")){

                evento.setGratuito(true);
            }

            else{

                evento.setGratuito(false);
            }

            Direccion direccion = new Direccion();

            Area area = new Area();

            if(trozos[trozos.length - 7].equals("")){

                area.setCp("Sin datos");

            }

            else{

                area.setCp(trozos[trozos.length - 7]);

            }

            area.setCalle(trozos[trozos.length - 12] + " " + trozos[trozos.length - 11]);

            direccion.setArea(area);

            evento.setDireccion(direccion);

        } 
        
        catch (Exception e) {
        
            e.printStackTrace();

            System.out.println("\n linea erronea");
        }

        return evento;
    }

    public static ListaEventos leerJson(){
        
        File ficheroJson = new File("src/recursos/206974-0-agenda-eventos-culturales-100.json");
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        ListaEventos listaEventos = null;

        try {

            listaEventos = objectMapper.readValue(ficheroJson, ListaEventos.class);
        } 
        
        catch (IOException e) {
            
            e.printStackTrace();
        }
        
        return listaEventos;
        
    }
}
