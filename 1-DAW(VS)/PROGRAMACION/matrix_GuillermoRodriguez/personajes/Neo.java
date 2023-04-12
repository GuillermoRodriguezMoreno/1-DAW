package matrix_GuillermoRodriguez.personajes;

public class Neo extends Personaje{

    //Atributos

    private boolean elegido;
    private final int DESTRUCCION_MAX = 3;

    //Constructores

    public Neo(String nombre, String ciudad) {
        
        super(nombre, ciudad);
        this.elegido = false;

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

    public int getDestruccionMax() {
        return DESTRUCCION_MAX;
    }

}
