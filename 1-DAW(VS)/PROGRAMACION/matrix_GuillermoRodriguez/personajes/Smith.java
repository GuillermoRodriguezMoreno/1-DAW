package matrix_GuillermoRodriguez.personajes;

public class Smith extends Personaje{

    //Atributos

    private static final int INFECCION_MAX = 3;
    private static int poderInfeccion;

    //Constructores

    public Smith(String nombre, String ciudad) {

        super(nombre, ciudad);

    }
    
    //Metodos

    @Override
    public String mostrarInformacion() {
        
        return "";
    }

    //Getters y Setters

    public static int getPoderInfeccion() {
        return poderInfeccion;
    }

    public static void setPoderInfeccion(int poderInfeccion) {
        Smith.poderInfeccion = poderInfeccion;
    }

    public static int getInfeccionMax() {
        return INFECCION_MAX;
    }

}
