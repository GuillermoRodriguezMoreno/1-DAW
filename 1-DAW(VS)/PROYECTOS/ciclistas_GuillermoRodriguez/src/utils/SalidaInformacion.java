package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;

import modelos.Carrera;

public class SalidaInformacion {
    

    // Metodos

    public static void crearInformeCarrera(Carrera carrera){
        
        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("src/recursos/" + carrera.getNombre() + ".txt"))) {

            // Nombre carrera

            String informacion = "====== Nombre Carrera =======\n" + carrera.getNombre() + "\n";

            // Ciclistas Participantes

            informacion = informacion + "======= Ciclistas Participantes ========\n" + carrera.listaParticipantes() + "\n";

            // Clasificacion final

            informacion = informacion + "====== Clasificacion Final =======\n" + carrera.clasificacionCompleta() + "\n";

            // Podium

            informacion = informacion + "======= Podium =======\n" + carrera.podium() + "\n";

            // Clasificacion por equipos

            informacion = informacion + "========= Clasificacion por equipos =========\n" + carrera.clasificacionPorEquipos() + "\n";

            // Posicion corredor especifico

            informacion = informacion + "======= Posicion Wilco Kerderman (BOHA) =========\n" + carrera.posicionCorredor(carrera.buscarCorredorPorDorsal(22));
            
            bWriter.write(informacion);

        } 
        
        catch (Exception e) {

            e.printStackTrace();

        }
    }
}
