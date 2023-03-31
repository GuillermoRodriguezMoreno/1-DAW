package tareaJugadoresFutbol_GuillermoRodriguezMoreno.clases;

import tareaJugadoresFutbol_GuillermoRodriguezMoreno.interfaces.Jugar_I;

public class Jugador implements Comparable, Jugar_I{
    
    // Atributos

    private String nombreCompleto;
    private String apodo;
    private int numeroLicencia; // unico, auto-generado y empieza en 1000
    private int numeroGoles;
    private int numeroFaltas;

    private static int contador = 1000;

    // Constructores

    public Jugador(String nombre, String apodo){

        this.nombreCompleto = nombre;
        this.apodo = apodo;

        this.contador ++;
        
        this.numeroLicencia = contador;
    }

    public Jugador(String nombre, String apodo, int numeroGoles, int numeroFaltas){

        this(nombre, apodo);
        this.numeroGoles = numeroGoles;
        this.numeroFaltas = numeroFaltas;

    }

    // Metodos

    @Override
    public String toString(){

        String resultado = "";

        resultado = this.getNombreCompleto() + "(" + this.getApodo() + ") Licencia: " + this.getNumeroLicencia() + " - Goles: " + this.getNumeroGoles() + " - Faltas: " + this.getNumeroFaltas() + "\n";

        return resultado;
    }

    @Override
    public boolean equals(Object o){

        boolean sonIguales = false;

        Jugador j = (Jugador) o;

        if(this.getNumeroLicencia() == j.getNumeroLicencia()){

            sonIguales = true;
        }

        return sonIguales;
    }

    @Override
    public int compareTo(Object o) {

        int resultado = 0;

        Jugador j = (Jugador) o;

        if(this.numeroLicencia > j.numeroLicencia){

            resultado = 1;
        }

        else if(this.numeroLicencia < j.numeroLicencia){

            resultado = -1;
        }

        return resultado;

    }

    @Override
    public void hacerGol() {

        this.numeroGoles++;
    }

    @Override
    public void cometerFalta() {

        this.numeroFaltas++;
    }

    // Getters y Setters

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public int getNumeroGoles() {
        return numeroGoles;
    }

    public void setNumeroGoles(int numeroGoles) {
        this.numeroGoles = numeroGoles;
    }

    public int getNumeroFaltas() {
        return numeroFaltas;
    }

    public void setNumeroFaltas(int numeroFaltas) {
        this.numeroFaltas = numeroFaltas;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Jugador.contador = contador;
    }

}
