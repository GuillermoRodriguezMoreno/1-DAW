package ClasesT6.frioMijas_GuillermoRodriguez.personal;

import ClasesT6.frioMijas_GuillermoRodriguez.Sede;

public class Empleado {
    
    // Atributos

    protected String nombre;
    protected int edad;
    protected String apellidos;
    protected String dni;
    protected float salario;
    protected int codigo;

    protected static int contador = 1;

    protected Sede sede;

    // Constructores

    public Empleado(String nombre, String apellidos, int edad, float sueldo, String dni){

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.salario = sueldo;
        this.dni = dni;

        this.codigo = contador;

        this.contador++;

    }

    // Metodos

    @Override
    public boolean equals(Object object){

        boolean iguales = false;

        Empleado empleado = (Empleado) object;

        if (this.dni.equals(empleado.dni)){

            iguales = true;
        }

        return iguales;
    }

    @Override
    public String toString(){

        String resultado = "";

        resultado = "Nombre: " + this.getNombre() + " " + this.getApellidos() + ", Dni: " + this.getDni() + ", Codigo " + this.getCodigo() + ", Sueldo: " + this.getSalario();

        return resultado;
    }

    // Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
    
}
