package modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Evento {
    
    // Atributos

    private String id;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("free")
    private boolean gratuito;
    @JsonProperty("price")
    private String precio;
    @JsonProperty("address")
    private Direccion direccion;

    // Constructor

    public Evento(){

    }

    public Evento (String id, String titulo, int gratuito, String precio, Direccion direccion){

        this.id = id;
        this.titulo = titulo;

        if(gratuito == 1){

            this.gratuito = true;

        }

        else{

            this.gratuito = false;

        }

        this.precio = precio;
        this.direccion = direccion;

        
    }

    // Metodos

    @Override
    public String toString() {

        String resultado = "Sin datos";

        if(this.direccion != null){

            resultado = "(" + this.getId() + ") Titulo: " + this.getTitulo() + ", Precio: " + this.getPrecio() + ", Gratis: " + this.isGratuito() + ", Direccion: " + this.direccion;
        }
        else{

            resultado = "(" + this.getId() + ") Titulo: " + this.getTitulo() + ", Precio: " + this.getPrecio() + ", Gratis: " + this.isGratuito() + ", Direccion: Sin Datos";
        }
        
        return resultado;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        
        this.gratuito = gratuito;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {

        if(precio.equals("")) precio = "0";

        this.precio = precio;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    

}
