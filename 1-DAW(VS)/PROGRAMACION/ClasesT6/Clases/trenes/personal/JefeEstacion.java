package ClasesT6.Clases.trenes.personal;

import java.time.LocalDate;

public class JefeEstacion {
    
    // Atributos

    private String nombre;
    private String dni;
    private LocalDate fechaNombramiento;

    // Constructores

    public JefeEstacion(){

    }

    public JefeEstacion(String nombre, String dni){

        this.nombre = nombre;
        this.dni = dni;
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

    public LocalDate getFechaNombramiento() {
        return fechaNombramiento;
    }

    public void setFechaNombramiento(LocalDate fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

    // Modificar fecha cargo

    public void modificarFechaCargo(int año, int mes, int dia){

        LocalDate nuevaFecha = LocalDate.of(año, mes, dia);

        this.setFechaNombramiento(nuevaFecha);
    }
    
    @Override
    public String toString(){

        return getNombre();
    }
}
