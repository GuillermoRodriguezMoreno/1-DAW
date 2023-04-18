package colecciones.equipoFutbol;

public class Jugador {

    // Enum

    public enum Posicion {PORTERO, DEFENSA, CENTROCAMPISTA, DELANTERO}
    
    // Atributos

    private String dni;
    private String nombre;
    private int estatura;
    private Posicion posicion;

    // Constructores

    public Jugador(String dni, String nombre, int estatura, Posicion posicion){

        this.dni = dni;
        this.nombre = nombre;
        this.estatura = estatura;
        this.posicion = posicion;

    }

    // Metodos

    @Override
    public String toString(){

        String colorCode = "\u001B[31m"; // Código de escape ANSI para el color rojo
        String resetCode = "\u001B[0m";

        return colorCode + "(" + this.getDni() + ") " + this.getNombre() + " " + this.getEstatura() + "cm " + this.getPosicion() + resetCode + "\n";

    }

    // Getters y Setters

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Posicion getPosicion() {
        return posicion;
    }
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    public int getEstatura() {
        return estatura;
    }
    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

}
