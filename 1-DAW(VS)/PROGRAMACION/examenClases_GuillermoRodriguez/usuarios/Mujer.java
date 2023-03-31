package examenClases_GuillermoRodriguez.usuarios;

import java.time.LocalDate;

import examenClases_GuillermoRodriguez.trabajadores.Trabajador;

public class Mujer extends Usuario{

    private boolean casaPropia;
    private int menoresACargo;


    // Constructores

    public Mujer(String nombre, String apellidos, String dni, Trabajador trabajador, LocalDate ultimaVisita, boolean casa, int menores) {

        super(nombre, apellidos, dni, trabajador, ultimaVisita);

        this.casaPropia = casa;
        this.menoresACargo = menores;
        this.tipo = TipoUsuario.MUJER;
        
    }

    // Metodos

    @Override
    public String muestraInformacion() {

        String resultado = "";

        resultado = this.getCodigo() + " Usuario " + this.getTipo() + ", nombre: " + this.getNombre() + " " + this.getApellidos() + " DNI: " + this.getDni() + 
            " Trabajador asociado: " + this.getTrabajadorAsignado() + " ultima visita: " + this.getUltimaVisita() + " casa propia: " + 
            this.isCasaPropia() + " menores a cargo: " + this.getMenoresACargo();

        return resultado;
        
    }

    // Getters y Setters

    public boolean isCasaPropia() {
        return casaPropia;
    }

    public void setCasaPropia(boolean casaPropia) {
        this.casaPropia = casaPropia;
    }

    public int getMenoresACargo() {
        return menoresACargo;
    }

    public void setMenoresACargo(int menoresACargo) {
        this.menoresACargo = menoresACargo;
    }

    
    
}
