package clases;

public class Municipio implements Comparable<Municipio>{
    
    // Atributos

    private String codigoPostal;
    private String nombre;
    private int año;
    private long poblacion;

    // Constructores

    public Municipio(String cp, String nombre, int año, long poblacion){

        this.codigoPostal = cp;
        this.nombre = nombre;
        this.año = año;
        this.poblacion = poblacion;

    }

    // Metodos

    @Override
    public String toString() {
        
        return this.nombre + "(" + this.año + "): " + this.poblacion;
        
    }

    @Override
    public boolean equals(Object o) {

        Municipio municipio = (Municipio) o;

        boolean iguales = false;
    
        if(this.nombre.equals(municipio.getNombre()) && this.año == municipio.getAño()){

            iguales = true;

        }

        return iguales;

    }

    @Override
    public int compareTo(Municipio o) {

        return this.nombre.compareTo(o.getNombre());

    }

    // Getters y Setters

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    
}
