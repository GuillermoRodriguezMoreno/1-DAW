package examenDAMcolecciones.clases;

import java.util.HashMap;

import examenDAMcolecciones.clases.Producto.Categoria;

public class DescuentoPorCategoria {
    
    // Atributos

    private HashMap<Categoria, Integer> descuento;

    // Constructores
    
    public DescuentoPorCategoria(){

        this.descuento = new HashMap<>();

    }

    // Metodos

    public boolean insertar(Categoria categoria, int descuento){

        boolean existe = false;

        if(this.descuento.containsKey(categoria)){

            this.descuento.put(categoria, descuento);

            existe = true;

        }

        return existe;

    }

    public boolean modificar(Categoria categoria, int descuento){

        boolean 
    }
}
