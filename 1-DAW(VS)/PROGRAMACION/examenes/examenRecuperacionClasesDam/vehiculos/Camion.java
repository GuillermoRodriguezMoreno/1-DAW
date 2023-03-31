package examenRecuperacionClasesDam.vehiculos;

import examenRecuperacionClasesDam.Pasajero;

public class Camion extends Vehiculo{
    
    // Atributos

    private int pesoMax;
    private boolean mercanciaPeligrosa;

    // Constructores

    public Camion (String matricula, Pasajero dueño){

        super(matricula, dueño);
        
    }    

    // Metodos

    @Override
    public String informacionVehiculo(){

        String resultado = "";

        resultado = "Camion, Matricula: " + this.getMatricula() + " Dueño: " + this.getDueño() + 
            " Peso maximo: " + this.getPesoMax() + " Mercancia peligrosa: " + this.isMercanciaPeligrosa();

        return resultado;
    }

    // Getters y Setters

    public int getPesoMax() {
        return pesoMax;
    }
    public void setPesoMax(int pesoMax) {
        this.pesoMax = pesoMax;
    }
    public boolean isMercanciaPeligrosa() {
        return mercanciaPeligrosa;
    }
    public void setMercanciaPeligrosa(boolean mercanciaPeligrosa) {
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

    
}
