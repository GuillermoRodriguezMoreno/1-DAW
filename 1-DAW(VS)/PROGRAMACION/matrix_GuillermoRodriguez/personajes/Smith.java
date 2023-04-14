package matrix_GuillermoRodriguez.personajes;

import java.time.LocalDateTime;

public class Smith extends Personaje implements Comparable<Smith>{

    //Atributos

    private static final int INFECCION_MAX = 3;
    private static int poderInfeccion;
    private boolean puedeInfectar;

    //Constructores

    public Smith(String nombre, String ciudad, boolean puedeInfectar) {

        super(nombre, ciudad);
        this.puedeInfectar = puedeInfectar;

    }

    public Smith(int id, String nombre, String ciudad, boolean puedeInfectar, LocalDateTime nacimiento){

        super(nombre, ciudad);
        this.id = id;
        this.puedeInfectar = puedeInfectar;
        this.fechaNacimiento = nacimiento;
    }
    
    //Metodos

    @Override
    public String mostrarInformacion() {
        
        return "";
    }

    @Override
    public int compareTo(Smith o) {
        
        return this.fechaNacimiento.compareTo(o.getFechaNacimiento());
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

    public boolean isPuedeInfectar() {
        return puedeInfectar;
    }

    public void setPuedeInfectar(boolean puedeInfectar) {
        this.puedeInfectar = puedeInfectar;
    }
    
}
