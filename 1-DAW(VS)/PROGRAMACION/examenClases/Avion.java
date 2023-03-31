package examenClases;

import examenClases.personas.Saltador;

public class Avion {
    
    // Atributos

    private String matricula;
    private int potencia;
    private int capacidadSaltadores;
    private int alturaMax;
    private boolean enAlquiler;

    // Constructores

    public Avion(String matricula, int potencia, int capacidadSaltadores, int alturaMax, boolean enAlquiler) {
        this.matricula = matricula;
        this.potencia = potencia;
        this.capacidadSaltadores = capacidadSaltadores;
        this.alturaMax = alturaMax;
        this.enAlquiler = enAlquiler;
    }

    // Metodos



    // Getters y Setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCapacidadSaltadores() {
        return capacidadSaltadores;
    }

    public void setCapacidadSaltadores(int capacidadSaltadores) {
        this.capacidadSaltadores = capacidadSaltadores;
    }

    public int getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(int alturaMax) {
        this.alturaMax = alturaMax;
    }

    public boolean isEnAlquiler() {
        return enAlquiler;
    }

    public void setEnAlquiler(boolean enAlquiler) {
        this.enAlquiler = enAlquiler;
    }
    
}
