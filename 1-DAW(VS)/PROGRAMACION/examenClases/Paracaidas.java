package examenClases;

import examenClases.personas.Instructor;

public class Paracaidas {

    public enum Fabricante {MOLTEM, CAIDALIBRE, ALTUS};

    // Atributos

    private int codigo;
    private int añoFabricacion;
    private Fabricante marca;
    private Instructor instructor;

    private static int contador = 0;

    // Construtor

    public Paracaidas(int añoFabricacion, Fabricante marca, Instructor instructor) {

        this.añoFabricacion = añoFabricacion;
        this.marca = marca;
        this.instructor = instructor;
        this.codigo = ++ this.contador;

    }

    // Gettes y Setters
    
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
