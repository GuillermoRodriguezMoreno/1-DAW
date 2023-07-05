import java.util.ArrayList;
import java.util.HashMap;

import modelos.Carrera;
import modelos.Ciclista;
import utils.LeerInformacion;
import utils.SalidaInformacion;

public class App {

    public static void main(String[] args) throws Exception {

        // Lista de ciclistas obtenida al leer fichero ciclistas.Json
        ArrayList<Ciclista> listaCiclistas = LeerInformacion.leerJsonCiclistas();

        // Etapa obtenia al leer json etapa

        HashMap<Integer, Integer> etapa1 = LeerInformacion.leerEtapa("etapa1.json");
        HashMap<Integer, Integer> etapa2 = LeerInformacion.leerEtapa("etapa2.json");
        HashMap<Integer, Integer> etapa3 = LeerInformacion.leerEtapa("etapa3.json");

        // Instancio carrera

        Carrera vueltaMalaga = new Carrera(listaCiclistas, "Vuelta a Málaga");

        // Inserto etapas

        vueltaMalaga.insertarTiemposEtapa(etapa1);
        vueltaMalaga.insertarTiemposEtapa(etapa2);
        vueltaMalaga.insertarTiemposEtapa(etapa3);

        // Genero informe

        SalidaInformacion.crearInformeCarrera(vueltaMalaga);

    }
}
