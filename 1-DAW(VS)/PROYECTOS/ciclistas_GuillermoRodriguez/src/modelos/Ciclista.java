package modelos;

public class Ciclista {
    
    // Atributos

    protected String nombre;
    protected String codigoEquipo;
    protected float peso;
    protected String pais;

    // Constructor
    public Ciclista() {


    }

    public Ciclista(String nombre, String codigoEquipo, float peso, String pais){

        this.nombre = nombre;
        this.codigoEquipo = codigoEquipo;
        this.peso = peso;
        this.pais = pais;

    }

    // Metodos

    @Override
    public String toString() {
        
        return this.nombre + "(" + this.getCodigoEquipo() + ") " + this.peso + " " + this.pais;
        
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigoEquipo() {
        return codigoEquipo;
    }
    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }



    
}
