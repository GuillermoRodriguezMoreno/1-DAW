import java.util.HashMap;
import java.util.List;

import modelos.ListaEventos;
import util.LeerInformacion;
import util.SalidaInformacion;

public class App {

    public static void main(String[] args) throws Exception {

        // Leo ambos ficheros

        ListaEventos listaEventos = LeerInformacion.leerJson();

        ListaEventos listaEventos2 = LeerInformacion.leerFichero();

        //========== Formateo del informe del fichero CSV ===================

        // Lista de eventos gratis

        String informacionCsv = "=X=X=X=X=X=X=X=X=X=X= FICHERO CSV =X=X=X=X=X=X=X=X=X=\n\n ";
        informacionCsv = informacionCsv + "============ LISTA EVENTOS GRATIS ===========\n\n Total: ";
        informacionCsv = informacionCsv + listaEventos2.listadoEventosGratuitos().size() + "\n\n";
        informacionCsv = informacionCsv + formatearLista(listaEventos2.listadoEventosGratuitos());

        // Lista de eventos gratis de un codigo postal en concreto

        informacionCsv = informacionCsv + "\n============= EVENTOS GRATIS CP 28049 ===============\n\n Total: ";
        informacionCsv = informacionCsv + listaEventos2.listaEventosGratuitos("28049").size() + "\n\n";
        informacionCsv = informacionCsv + formatearLista(listaEventos2.listaEventosGratuitos("28049"));

        // Lista eventos totales por codigo postal

        informacionCsv = informacionCsv + "\n============ LISTA EVENTOS TOTALES ===========\n\n Total: ";
        informacionCsv =informacionCsv + listaEventos2.eventosTotalesMapa(listaEventos2.eventosTotales()) + "\n\n";
        informacionCsv = informacionCsv + formatearMapa(listaEventos2.eventosTotales());

        // Crear fichero

        SalidaInformacion.crearInforme("informacionCsv", informacionCsv);

        //========== Formateo del informe del fichero Json =================== 

        // Lista eventos gratis

        String informacionJson = "=X=X=X=X=X=X=X=X=X=X= FICHERO JSON =X=X=X=X=X=X=X=X=X=\n\n";
        informacionJson = informacionJson + "============ LISTA EVENTOS GRATIS ===========\n\n Total: ";
        informacionJson = informacionJson + listaEventos.listadoEventosGratuitos().size() + "\n\n";
        informacionJson = informacionJson + formatearLista(listaEventos.listadoEventosGratuitos());

        // Lista de eventos gratis de un codigo postal en concreto

        informacionJson = informacionJson + "\n============= EVENTOS GRATIS CP 28049 ===============\n\n Total: ";
        informacionJson = informacionJson + listaEventos.listaEventosGratuitos("28049").size() + "\n\n";
        informacionJson = informacionJson + formatearLista(listaEventos.listaEventosGratuitos("28049"));

        // Lista eventos totales por codigo postal

        informacionJson = informacionJson + "\n============ LISTA EVENTOS TOTALES ===========\n\n Total: ";
        informacionJson =informacionJson + listaEventos.eventosTotalesMapa(listaEventos.eventosTotales()) + "\n\n";
        informacionJson = informacionJson + formatearMapa(listaEventos.eventosTotales());

        // Crear fichero

        SalidaInformacion.crearInforme("informacionJson", informacionJson);

        


    }

    // Metodos

    static <T> String formatearLista(List<T> lista){
        
        String informacion = "";

        for (T t : lista) {
            
            informacion = informacion + t.toString() + "\n";

        }

        return informacion;
    }

    static <T> String formatearMapa(HashMap<String, Integer> hashMap){

        String informacion = "";

        for (String key : hashMap.keySet()) {

            informacion = informacion + "CP: " + key + " - Eventos: " + hashMap.get(key) + "\n";
            
        }

        return informacion;

    }

    
}
