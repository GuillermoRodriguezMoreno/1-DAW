package examenRecuperacionClasesDam.vehiculos;

import examenRecuperacionClasesDam.Pasajero;

public class Coche extends Vehiculo{

    public enum Uso {PARTICULAR, PROFESIONAL};
    
    // Atributos

    private int numeroPlaza;
    private Uso tipoUso;

    // Constructores

    public Coche(String matricula, Pasajero dueño){

        super(matricula, dueño);
        
    }    

    // Metodos

    @Override
    public String informacionVehiculo(){

        String resultado = "";

        resultado = "Coche , Dueño: " + this.getDueño() + " Matricula: " + this.getMatricula() + 
            " Numero plazas: " + this.getNumeroPlaza() + " Uso: " + this.tipoUso;

        return resultado;

    }

    // Getters y Setters

    public int getNumeroPlaza() {
        return numeroPlaza;
    }
    public void setNumeroPlaza(int numeroPlaza) {
        this.numeroPlaza = numeroPlaza;
    }
    public Uso getTipoUso() {
        return tipoUso;
    }
    public void setTipoUso(Uso tipoUso) {
        this.tipoUso = tipoUso;
    }

    // Metodos

    

}
