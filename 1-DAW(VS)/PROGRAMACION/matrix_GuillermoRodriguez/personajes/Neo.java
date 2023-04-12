package matrix_GuillermoRodriguez.personajes;

import java.time.LocalDateTime;

public class Neo extends Personaje{

    //Atributos

    private boolean elegido;

    //Constructores

    public Neo(String nombre, String ciudad) {
        
        super(nombre, ciudad);

    }

    //Metodos

    @Override
    public String mostrarInformacion() {
        

        return "";
    }

    //Getters y Setters

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }
    
}
