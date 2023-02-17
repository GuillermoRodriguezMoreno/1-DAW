package ClasesT6.Clases;

public class Articulo {
    
    // Atributos

    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;

    // Constructor

    public Articulo(String codigo, String descripcion, double precioCompra, double precioVenta, int stock){

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

}
