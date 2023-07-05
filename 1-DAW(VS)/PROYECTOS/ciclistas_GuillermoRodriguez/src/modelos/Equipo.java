package modelos;

public class Equipo {
    
    // Atributos

    private String codigo;
    private String nombre;
    private String nacionalidad;
    private double presupuesto;

    // Constructor

    public Equipo() {

    }

    public Equipo(String codigo, String nombre, String nacionalidad, double presupuesto){

        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.presupuesto = presupuesto;

    }

    // Metodos

    @Override
    public String toString() {
        
        return "(" + this.codigo + ")" + this.nombre;
    }

    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    
}
