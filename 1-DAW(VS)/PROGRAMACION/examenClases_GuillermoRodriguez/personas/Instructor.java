package examenClases_GuillermoRodriguez.personas;

public class Instructor extends Persona{
    
    // Atributos

    private double sueldo;

    // Constructores

    public Instructor(String nomnbre, String apellidos){

        super(nomnbre, apellidos);
    }

    public Instructor(String nombre, String apellidos, double sueldo){

        super(nombre, apellidos);
        this.sueldo = sueldo;
    }

    // Metodos

    public String mostrarInformacion(){

        return this.getNombre() + " " + this.getApelllidos() + " " + this.getSueldo() + "e";

    }

    // Getters y Setters

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    
}
