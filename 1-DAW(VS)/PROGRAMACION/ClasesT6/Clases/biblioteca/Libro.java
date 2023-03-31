package ClasesT6.Clases.biblioteca;

import java.time.LocalDate;

public class Libro extends Publicacion implements Prestable{
    
    // Atributos

    private boolean prestado;


    // Constructores

    public Libro(String isbn, String titulo, int fechaPublicacion){

        super(isbn, titulo, fechaPublicacion);
        this.prestado = false;
        
    }

    // Metodos

    @Override
    public void presta(){

        this.setPrestado(true);
    }

    @Override
    public void devuelve(){

        this.setPrestado(false);
    }

    @Override
    public boolean estaPrestado(){

        return this.isPrestado();
    }

    @Override
    public String toString(){

        String resultado = "no prestado";

        if(this.isPrestado()){

            resultado = "prestado";
        }

        return super.toString() + "( " + resultado + " )";
    }

    // Getters y Setters

    public boolean isPrestado() {
        return prestado;
    }


    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    

    
    
}
