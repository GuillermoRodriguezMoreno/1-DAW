package examenClases.personas;

public abstract class Persona {
    
    // Atributos

    protected String nombre;
    protected String apellidos;

    // Constructores

    public Persona(String nombre, String apellidos){

        this.nombre = nombre;
        this.apellidos = apellidos;

    }

    // Metodos

    public abstract String informacion();

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    

}
