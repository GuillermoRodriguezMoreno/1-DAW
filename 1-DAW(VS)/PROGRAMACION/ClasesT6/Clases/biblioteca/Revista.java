package ClasesT6.Clases.biblioteca;

import java.time.LocalDate;

public class Revista extends Publicacion{
    
    // Atributos

    private int numero;

    // Constructores

    public Revista(String isbn, String titulo, int fechaPublicacion, int numero){

        super(isbn, titulo, fechaPublicacion);
        this.numero = numero;
    }

    // Metodos


    // Getters y Setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
