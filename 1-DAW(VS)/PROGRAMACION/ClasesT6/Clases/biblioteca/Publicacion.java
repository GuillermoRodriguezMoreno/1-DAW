package ClasesT6.Clases.biblioteca;

import java.sql.Date;
import java.time.LocalDate;

public class Publicacion {
    
    // Atributos

    protected String isbn;
    protected String titulo;
    protected int fechaPublicacion;

    // Constructores

    public Publicacion(String isbn, String titulo, int fechaPublicacion){

        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;

    }


    // Metodos

    @Override
    public String toString(){

        String resultado = "";

        resultado = "ISBN: " + this.getIsbn() + ", titulo: " + this.getTitulo() + ", año publicacion: " + this.getFechaPublicacion();

        return resultado;
    }

    // Getters y Setters

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
}
