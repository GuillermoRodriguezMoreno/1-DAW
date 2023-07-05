package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import modelos.Ciclista;
import modelos.Equipo;

public class LeerInformacion {
    
    // Metodos

    public static ArrayList<Equipo> leerListaEquipo(){

        ArrayList<Equipo> listaEquipos = new ArrayList<>();

        try (BufferedReader bReader = new BufferedReader(new FileReader("src/recursos/equipos.csv"))) {

            String linea = "";

            // Salto primera linea
            linea = bReader.readLine();

            // Leo segunda linea
            linea = bReader.readLine();

            while(linea != null){

                String[] atributos = linea.split(",");

                Equipo equipo = new Equipo();

                try {

                    equipo.setCodigo(atributos[0]);
                    equipo.setNombre(atributos[1]);
                    equipo.setNacionalidad(atributos[2]);
                    equipo.setPresupuesto(Double.valueOf(atributos[3]));
                    
                } catch (Exception e) {

                    e.printStackTrace();

                }

                listaEquipos.add(equipo);

                linea = bReader.readLine();
            }


        } catch (Exception e) {
            
            e.printStackTrace();

        }

        return listaEquipos;

    }

    public static ArrayList<Ciclista> leerJsonCiclistas() {

        File ficheroCiclistas = new File("src/recursos/ciclistas.json");

		ObjectMapper objectMapper = new ObjectMapper();

		ArrayList<Ciclista> listaCiclistas = null;

		try {

            listaCiclistas = objectMapper.readValue(ficheroCiclistas, new TypeReference<ArrayList<Ciclista>>(){});
			
        } catch (IOException e) {
            
            e.printStackTrace();
        }

		return listaCiclistas;

    }

    public static HashMap<Integer, Integer> leerEtapa(String fichero){

        HashMap<Integer, Integer> etapa = null;

        try {
            
            File ficheroEtapa = new File("src/recursos/" + fichero);

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                
                etapa = objectMapper.readValue(ficheroEtapa, new TypeReference<HashMap<Integer, Integer>>(){});

            } 
            
            catch (Exception e) {

                e.printStackTrace();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return etapa;

    }

}
