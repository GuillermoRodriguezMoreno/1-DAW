package examenClases_GuillermoRodriguez.usuarios;

import java.time.LocalDate;

import examenClases_GuillermoRodriguez.trabajadores.Trabajador;

public class Menor extends Usuario{
    
    // Atributos

    private LocalDate fechaNacimiento;
    private String nombreTutor;

    // Constructores

    public Menor(String nombre, String apellidos, String dni, Trabajador trabajador, LocalDate ultimaVisita, LocalDate nacimiento, String tutor){

        super(nombre, apellidos, dni, trabajador, ultimaVisita);

        this.fechaNacimiento = nacimiento;
        this.nombreTutor = tutor;
        this.tipo = TipoUsuario.MENOR;
        
    }

    // Metodos

    @Override
    public String muestraInformacion(){

        String resultado = "";

        resultado = this.getCodigo() + " Usuario " + this.getTipo() + " , nombre: " + this.getNombre() + " " + this.getApellidos() + " DNI: " + this.getDni() + 
            " Trabajador asociado: " + this.getTrabajadorAsignado() + " ultima visita: " + this.getUltimaVisita() + " fecha nacimiento: " +
            this.getFechaNacimiento() + " tutor: " + this.getNombreTutor();

        return resultado;

    }

    // Getters y Setters

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    
}
