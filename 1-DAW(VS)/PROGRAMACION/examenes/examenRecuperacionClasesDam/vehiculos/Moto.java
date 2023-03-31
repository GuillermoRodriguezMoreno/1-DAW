package examenRecuperacionClasesDam.vehiculos;

import examenRecuperacionClasesDam.Pasajero;

public class Moto extends Vehiculo{
    
    // Atributos

    private int cilindrada;
    private boolean necesitaCarnet;

    // Constructores

    public Moto(String matricula, Pasajero dueño){

        super(matricula, dueño);
        
    }    
    // Metodos

    public String informacionVehiculo(){

        String resultado = "";

        resultado = "Moto, Matricula: " + this.getMatricula() + " Dueño: " + this.getDueño() +
            " Cilindrada: " + this.getCilindrada() + " Necesita carnet: " + this.isNecesitaCarnet();

        return resultado;
    }

    // Getters y Setters

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean isNecesitaCarnet() {
        return necesitaCarnet;
    }

    public void setNecesitaCarnet(boolean necesitaCarnet) {
        this.necesitaCarnet = necesitaCarnet;
    }

    
}
