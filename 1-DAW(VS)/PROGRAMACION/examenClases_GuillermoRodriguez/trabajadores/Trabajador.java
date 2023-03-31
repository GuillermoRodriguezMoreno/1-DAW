package examenClases_GuillermoRodriguez.trabajadores;

import examenClases_GuillermoRodriguez.usuarios.Usuario;

public class Trabajador {

    public enum Oficina {PUEBLO, COSTA, FARO}
    
    // Atributos

    private String nombre;
    private String dni;
    private String titulacion;
    private int añoTitulacion;
    private Oficina oficina;
    private double sueldo;

    // Constructores

    public Trabajador(String nombre, String dni, String titulacion, int año, String oficina){

        this.nombre = nombre;
        this.dni = dni;
        this.titulacion = titulacion;
        this.añoTitulacion = año;

        this.oficina = Oficina.valueOf(oficina);

        this.sueldo = 1000f;
    }

    // Metodos

    @Override
    public boolean equals(Object obj){

        boolean iguales = false;

        Trabajador trabajador = (Trabajador) obj;

        if(this.dni.equals(trabajador.dni)){

            iguales = true;

        }

        return iguales;

    }

    @Override
    public String toString(){

        String resultado = "";

        resultado = this.getNombre() + "(" + this.getDni() + ")";

        return resultado;
    }

    // Getters y Setters

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

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getAñoTitulacion() {
        return añoTitulacion;
    }

    public void setAñoTitulacion(int añoTitulacion) {
        this.añoTitulacion = añoTitulacion;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    

}
