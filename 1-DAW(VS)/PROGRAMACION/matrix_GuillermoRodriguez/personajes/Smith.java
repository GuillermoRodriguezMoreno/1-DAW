package matrix_GuillermoRodriguez.personajes;

public class Smith extends Personaje{

    //Atributos

    private static int capacidadMax;
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

    public static int getCapacidadMax() {
        return capacidadMax;
    }

    public static void setCapacidadMax(int capacidadMax) {
        Smith.capacidadMax = capacidadMax;
    }


}
