package modelos;

public class ExcepcionProductoSinStock extends Exception{

    private Producto producto;

    public ExcepcionProductoSinStock(Producto producto){

        this.producto = producto;
    }

    @Override
    public String toString() {
        
        return "Producto sin Stock: " + producto.getNombre() + " con codigo: " + producto.getCodigo();

    }
    
}
