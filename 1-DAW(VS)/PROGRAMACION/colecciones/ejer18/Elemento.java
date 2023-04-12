package colecciones.ejer18;

public class Elemento {
    
    //Atributos

    private String nombre;
    private double precio;
    private int cantidad;

    // Constructores

    public Elemento(String nombre, double precio, int cantidad){

        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object obj){

        Elemento e = (Elemento) obj;

        if(this.nombre.equals(e.getNombre())){

            return true;
        }

        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
