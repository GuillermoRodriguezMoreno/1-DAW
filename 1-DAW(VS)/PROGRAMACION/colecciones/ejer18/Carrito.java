package colecciones.ejer18;

import java.util.ArrayList;

public class Carrito {
    
    // Atributos

    ArrayList<Elemento> lista;

    // Constructores

    public Carrito(){

        this.lista = new ArrayList<Elemento>();

    }

    // metodos

    @Override
    public String toString(){

        String resultado = "";

        for (Elemento elemento : lista) {
            
            resultado = resultado + elemento.getNombre() + " PVP: " + elemento.getPrecio() + " Unidades: " + elemento.getCantidad() +
            " Total: " + elemento.getPrecio()*elemento.getCantidad() + "\n";

        }

        return resultado;
    }

    public void agrega(Elemento elemento){

        if(this.lista.contains(elemento)){

            int posicion = this.lista.indexOf(elemento);

            this.lista.get(posicion).setCantidad(this.lista.get(posicion).getCantidad() + 1);

        }

        else{

            this.lista.add(elemento);

        }

    }

    public int numeroDeElementos(){

        return this.lista.size();
    }

    public double importeTotal(){

        double suma = 0.0;
        
        for (int i = 0; i < this.lista.size(); i++) {
            
            suma =  suma + (this.lista.get(i).getPrecio()* this.lista.get(i).getCantidad());
        }

        return suma;
    }
}
