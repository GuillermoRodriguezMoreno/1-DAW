package modelos;

public class Linea {
    
    // Atributos

    private int idLinea;
    private int codigoProducto;
    private int cantidad;

    // Constructor

    public Linea(){


    }

    public Linea (int id, int codigo, int cantidad){

        this.idLinea = id;
        this.codigoProducto = codigo;
        this.cantidad = cantidad;

    }

    // Metodos

    @Override
    public String toString() {
        
        return "idLinea: " + this.idLinea + " ,codProducto: " + this.codigoProducto + " ,Cantidad: " + this.cantidad;
        
    }

    // Getters y Setters

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
