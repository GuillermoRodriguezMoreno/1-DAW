package examenClases_GuillermoRodriguez.usuarios;

import java.time.LocalDate;

import examenClases_GuillermoRodriguez.trabajadores.Trabajador;

public abstract class Usuario {

    public enum TipoUsuario{MENOR, FAMILIA, MUJER}
    
    // Atributos

    protected TipoUsuario tipo;
    protected String nombre;
    protected String apellidos;
    protected String dni;
    protected Trabajador trabajadorAsignado;
    protected LocalDate ultimaVisita;
    protected int codigo;

    protected static int contador = 0;

    // Constructores

    public Usuario(String nombre, String apellidos, String dni, Trabajador trabajador, LocalDate ultimaVisita){

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.trabajadorAsignado = trabajador;
        this.ultimaVisita = ultimaVisita;

        this.codigo = ++ this.contador;

    }

    // Metodos

    public abstract String muestraInformacion();

    @Override
    public boolean equals(Object obj){

        boolean iguales = false;

        Usuario usuario = (Usuario) obj;

        if(this.dni.equals(usuario.dni)){

            iguales = true;

        }

        return iguales;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Trabajador getTrabajadorAsignado() {
        return trabajadorAsignado;
    }

    public void setTrabajadorAsignado(Trabajador trabajadorAsignado) {
        this.trabajadorAsignado = trabajadorAsignado;
    }

    public LocalDate getUltimaVisita() {
        return ultimaVisita;
    }

    public void setUltimaVisita(LocalDate ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    
    
}
