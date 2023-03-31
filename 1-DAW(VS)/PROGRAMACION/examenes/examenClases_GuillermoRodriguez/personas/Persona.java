package examenClases_GuillermoRodriguez.personas;

public abstract class Persona {
    
    // atributos

    protected String nombre;
    protected String apelllidos;

    // Constructores

    public Persona(String nombre, String apellidos){

        this.nombre = nombre;
        this.apelllidos = apellidos;

    }

    // Metodos

    public abstract String mostrarInformacion();

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelllidos() {
        return apelllidos;
    }

    public void setApelllidos(String apelllidos) {
        this.apelllidos = apelllidos;
    }

    
}
