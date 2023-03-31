package examenClases_GuillermoRodriguez;

public class Avion {
    
    // Atributos

    private String matricula;
    private double potencia;
    private int capacidad;
    private double alturaMax;
    private boolean enPropiedad;
    
    // Constructores

    public Avion(String matricula, double potencia, int capacidad, double alturaMax, boolean enPropiedad){

        this.matricula = matricula;
        this.potencia = potencia;
        this.capacidad = capacidad;
        this.alturaMax = alturaMax;
        this.enPropiedad = enPropiedad;

    }

    public String mostrarInformacion(){

        String resultado = "";

        resultado = this.getMatricula() + " " + this.getPotencia() + " " + this.getCapacidad() + " Altura: " +
            this.getAlturaMax();

        return resultado;
    }


    // Getters y Setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(double alturaMax) {
        this.alturaMax = alturaMax;
    }

    public boolean isEnPropiedad() {
        return enPropiedad;
    }

    public void setEnPropiedad(boolean enPropiedad) {
        this.enPropiedad = enPropiedad;
    }

    
}
