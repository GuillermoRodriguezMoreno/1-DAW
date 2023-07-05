package modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona2 {
    
    // Atributos

    @JsonProperty("firstName")
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;
    private String numero;

    // Constructores

    public Persona2(){


    }

    // Metodos

    @Override
    public String toString() {
        
        return this.nombre + " " + this.apellido + " " + this.genero + " " + this.edad + " " + this.numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    

    
    
}
