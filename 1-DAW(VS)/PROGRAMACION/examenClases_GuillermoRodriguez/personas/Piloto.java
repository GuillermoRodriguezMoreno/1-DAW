package examenClases_GuillermoRodriguez.personas;

public class Piloto extends Persona{

    // Atributos

    private int añoTitulo;

    // Constructores

    public Piloto(String nombre, String apellidos, int añoTitulo){

        super(nombre, apellidos);
        this.añoTitulo = añoTitulo;
    }

    // Metodos

    public String mostrarInformacion(){

        return this.getNombre() + " " + this.getApelllidos() + " Año titulo: " + this.getAñoTitulo(); 
    
    }

    // Getters y Setters

    public int getAñoTitulo() {
        return añoTitulo;
    }

    public void setAñoTitulo(int añoTitulo) {
        this.añoTitulo = añoTitulo;
    }

    
    
}
