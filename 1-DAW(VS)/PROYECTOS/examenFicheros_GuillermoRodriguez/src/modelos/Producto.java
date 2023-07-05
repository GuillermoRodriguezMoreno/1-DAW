package modelos;

public class Producto {
    
    // Atributos

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    // Constructor

    public Producto(){

    }

    public Producto(int codigo, String nombre, String descripcion, double precio, int stock){

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;

    }

    // Metodos

    @Override
    public String toString() {
        
        return "(" + this.codigo + ") " + this.nombre + ", descripcion: " + this.descripcion + " precio: " + this.precio +
        " , Stock: " + this.stock;

    }

    @Override
    public boolean equals(Object obj) {
        
        Producto p = (Producto) obj;

        boolean iguales = false;

        if(this.codigo == p.getCodigo()){

            iguales = true;

        }

        return iguales;

    }

    @Override
    public int hashCode() {
        return 0;
    }

    // Getters y Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
}
