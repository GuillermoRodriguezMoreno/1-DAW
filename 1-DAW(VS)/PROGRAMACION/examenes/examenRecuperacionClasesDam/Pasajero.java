package examenRecuperacionClasesDam;

public class Pasajero {
    
    // Atributos

    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private boolean camarote;
    private int codigo;

    private static int contador = 0;

    // Constructor

    public Pasajero(String nombre, String apellidos, String nacionalidad){

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;

        this.codigo = this.contador ++;
    }

    // Metodos

    @Override
    public boolean equals(Object o){

        boolean iguales = false;

        Pasajero p1 = (Pasajero) o;

        if(this.nombre.equals(p1.getNombre()) && this.apellidos.equals(p1.getApellidos()) && this.nacionalidad.equals(p1.getNacionalidad())){

            iguales = true;
        }

        return iguales;
    }

    @Override
    public String toString(){

        String resultado = "";

        resultado = this.nombre + ", " + this.apellidos + " CODIGO: " + this.codigo;

        return resultado;
        
    }

    // Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isCamarote() {
        return camarote;
    }

    public void setCamarote(boolean camarote) {
        this.camarote = camarote;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Pasajero.contador = contador;
    }

    
}
