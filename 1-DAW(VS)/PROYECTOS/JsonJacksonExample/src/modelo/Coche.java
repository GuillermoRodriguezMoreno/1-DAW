package modelo;

public class Coche {
    
    // Atributos
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private float precio;

    // Constructores

    public Coche(){

    }

    public Coche(String marca, String modelo, int anioFabricacion, float precio){

        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        
        return this.marca + " " + this.modelo + " " + this.anioFabricacion + " " + this.precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
}
