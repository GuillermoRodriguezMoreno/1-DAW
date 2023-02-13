package ClasesT6.Clases;

public class Gestor {

    // enum

    public enum Puesto{BECARIO, AYUDANTE, SENIOR};

    // Atributos
    
    public String nombre;
    private String telefono;
    double importeMax;
    private Puesto puesto;


    // Constructores

    public Gestor(String nombre, String telefono){

        this.nombre = nombre;
        this.telefono = telefono;
        this.importeMax = 10000;
        this.puesto = Puesto.BECARIO;
    }

    public Gestor(String nombre, String telefono, double importeMax, Puesto puesto){

        this(nombre, telefono);
        this.importeMax = importeMax;
        this.puesto = puesto;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    private void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getImporteMax() {
        return importeMax;
    }

    public void setImporteMax(double importeMax) {

        if(this.puesto  == Puesto.BECARIO && importeMax > 10000){

            this.importeMax = 10000;
            System.out.println("el importe maximo para este gestor es 10000");

        }else if (this.puesto == Puesto.AYUDANTE && importeMax > 50000){

            this.importeMax = 50000;
            System.out.println("el importe maximo de este gestor es 50000");

        }else if(this.puesto == Puesto.SENIOR && importeMax > 200000){

            this.importeMax = 200000;
            System.out.println("el importe maximo de este gestor es 200000");

        }else {

        this.importeMax = importeMax;

        }

    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

}
