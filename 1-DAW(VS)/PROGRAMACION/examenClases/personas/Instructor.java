package examenClases.personas;

public class Instructor extends Persona{
    
    // Atributos

    private double sueldo;

    // Construtores

    public Instructor(String nombre, String apellidos) {

        super(nombre, apellidos);
    }

    // Metodos

    @Override
    public String informacion() {

        return this.nombre + ", " + this.apellidos + " Sueldo: " + this.sueldo;

    }

    // Getters y Setters

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
}
