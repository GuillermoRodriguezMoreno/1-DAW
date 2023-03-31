package examenClases_GuillermoRodriguez.personas;

import examenClases_GuillermoRodriguez.Paracaidas;

public class Saltador extends Cliente{
    
    // Atributos

    private Paracaidas principal;
    private Paracaidas emergencia;

    // Constructores

    public Saltador(String nombre, String apellidos, String tlf, double alturaSalto){

        super(nombre, apellidos, tlf, alturaSalto);
    }

    public Saltador(String nombre, String apellidos, String tlf, double alturaSalto, boolean seguro){

        super(nombre, apellidos, tlf, alturaSalto, seguro);
    }

    public Saltador(String nombre, String apellidos, String tlf, double alturaSalto, Paracaidas principal, Paracaidas Emergencia){

        super(nombre, apellidos, tlf, alturaSalto);
        this.principal = principal;
        this.emergencia = emergencia;
    }

    // Metodos

    // Getters y Setters

    public Paracaidas getPrincipal() {
        return principal;
    }

    public void setPrincipal(Paracaidas principal) {
        this.principal = principal;
    }

    public Paracaidas getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(Paracaidas emergencia) {
        this.emergencia = emergencia;
    }
    
}
