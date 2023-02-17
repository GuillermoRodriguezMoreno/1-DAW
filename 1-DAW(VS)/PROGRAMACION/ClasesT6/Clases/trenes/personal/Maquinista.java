package ClasesT6.Clases.trenes.personal;

public class Maquinista {
    
    // Atributos

    private String nombre;
    private String dni;
    private double sueldo;
    private String rango;

    // Constructores

    public Maquinista(){


    }

    public Maquinista(String nombre, String dni, double sueldo){

        this.nombre = nombre;
        this.dni = dni;
        this.sueldo = sueldo;
        this.rango = "ayudante";
    }

    public Maquinista(String nombre, String dni, double sueldo, String rango){

        this(nombre, dni, sueldo);
        this.rango = rango;
    }

    // Metodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    
}
