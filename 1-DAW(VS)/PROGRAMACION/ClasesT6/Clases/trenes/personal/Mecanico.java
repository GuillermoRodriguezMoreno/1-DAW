package ClasesT6.Clases.trenes.personal;

public class Mecanico {
    
    public enum Especialidad{FRENOS, HIDRAULICA, ELECTRICIDAD, MOTOR};

        // Atributos

    private String nombre;
    private String tlf;
    private Especialidad especialidad;

    // Constructores

    public Mecanico(){

    }

    public Mecanico(String nombre, String tlf, Especialidad especialidad){

        this.nombre = nombre;
        this.tlf = tlf;
        this.especialidad = especialidad;
        
    }

    // Metodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    
}
