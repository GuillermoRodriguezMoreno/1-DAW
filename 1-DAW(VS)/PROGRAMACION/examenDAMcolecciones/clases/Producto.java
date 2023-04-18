package examenDAMcolecciones.clases;

public class Producto {
    
    // Enum

    public enum Categoria {ELECTRONICA, MODA, HOGAR, DEPORTES};

    // Atributos

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;

    private static int contador;

    // Constructores

    public Producto(String nombre, String descripcion, double precio, Categoria categoria){

        this.contador++;

        this.id = contador;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;

    }

    // Metodos

    // Getters y Setters

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Producto.contador = contador;
    }

    
}
