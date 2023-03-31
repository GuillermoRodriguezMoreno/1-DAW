package examenClases_GuillermoRodriguez.usuarios;

import java.time.LocalDate;

import examenClases_GuillermoRodriguez.trabajadores.Trabajador;

public class Familia extends Usuario{

    // Atributos

    private String cabezaFamilia;
    private int numMiembros;

    // Constructores

    public Familia(String nombre, String apellidos, String dni, Trabajador trabajador, LocalDate ultimaVisita, String cabeza, int miembros) {

        super(nombre, apellidos, dni, trabajador, ultimaVisita);

        this.cabezaFamilia = cabeza;
        this.numMiembros = miembros;
        this.tipo = TipoUsuario.FAMILIA;

    }

    // Metodos

    @Override
    public String muestraInformacion() {
        
        String resultado = "";

        resultado = this.getCodigo() +  " Usuario " + this.getTipo() + " , nombre: " + this.getNombre() + " " + this.getApellidos() + " DNI: " + this.getDni() + 
            " Trabajador asociado: " + this.getTrabajadorAsignado() + " ultima visita: " + this.getUltimaVisita() + " Cabeza Familia: " +
            this.getCabezaFamilia() + " numero de miembros: " + this.getNumMiembros();

        return resultado;
        
    }

    // Getters y Setters

    public String getCabezaFamilia() {
        return cabezaFamilia;
    }

    public void setCabezaFamilia(String cabezaFamilia) {
        this.cabezaFamilia = cabezaFamilia;
    }

    public int getNumMiembros() {
        return numMiembros;
    }

    public void setNumMiembros(int numMiembros) {
        this.numMiembros = numMiembros;
    }
    
    
}
