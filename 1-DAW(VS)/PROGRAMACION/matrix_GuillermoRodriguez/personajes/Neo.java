package matrix_GuillermoRodriguez.personajes;

import java.time.LocalDateTime;

public class Neo extends Personaje{

    //Atributos

    private boolean elegido;
    private final int DESTRUCCION_MAX = 3;

    //Constructores

    public Neo(String nombre, String ciudad) {
        
        super(nombre, ciudad);
        this.elegido = false;
        this.fechaNacimiento = LocalDateTime.now();

    }

    //Metodos

    @Override
    public String mostrarInformacion() {
        

        return "Neo (" + this.getId() + ") Fecha Nac: " + this.getFechaNacimiento().getNano()  + " Elegido: " + this.isElegido();

    }

    //Getters y Setters

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }

    public int getDestruccionMax() {
        return DESTRUCCION_MAX;
    }

}
