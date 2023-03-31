package examenClases;

import java.time.LocalDate;

import examenClases.personas.Piloto;
import examenClases.personas.Saltador;

public class Vuelo {
    
    // Atributos

    private LocalDate fecha;
    private Avion avion;
    private Piloto piloto;
    private Saltador[] saltadores;
    private int codigo;

    private static int contador = 0;

    // Constructores

    public Vuelo(Avion avion, Piloto piloto) {

        this.avion = avion;
        this.piloto = piloto;

        this.fecha = LocalDate.now();

        this.codigo = ++ this.contador;
        this.saltadores = new Saltador[0];

    }

    // Metodos

    

    

}
