package examenRecuperacionClasesDam.vehiculos;

import examenRecuperacionClasesDam.Pasajero;

public abstract class Vehiculo {
    
    // Atributos

    protected String matricula;
    protected Pasajero dueño;

    //  Constructores

    public Vehiculo(String matricula, Pasajero dueño){

        this.matricula = matricula;
        this.dueño = dueño;
        
    }

    // Metodos

    public abstract String informacionVehiculo();

    // Guetters y Setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Pasajero getDueño() {
        return dueño;
    }

    public void setDueño(Pasajero dueño) {
        this.dueño = dueño;
    }

    
}
