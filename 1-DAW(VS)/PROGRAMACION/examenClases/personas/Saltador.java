package examenClases.personas;

import examenClases.Paracaidas;

public class Saltador extends Cliente{

    // Atributos

    private Paracaidas paracaidasPrincipal;
    private Paracaidas paracaidasEmergencia;
    
    // Constructores

    public Saltador(String nombre, String apellidos, String tlf, int alturaSalto) {

        super(nombre, apellidos, tlf, alturaSalto);

    }

    public Saltador(String nombre, String apellidos, String tlf, int alturaSalto, boolean seguro) {

        super(nombre, apellidos, tlf, alturaSalto, seguro);

    }

    // Metodos

    // Getters y Setters
    
    public Paracaidas getParacaidasPrincipal() {
        return paracaidasPrincipal;
    }

    public void setParacaidasPrincipal(Paracaidas paracaidasPrincipal) {
        this.paracaidasPrincipal = paracaidasPrincipal;
    }

    public Paracaidas getParacaidasEmergencia() {
        return paracaidasEmergencia;
    }

    public void setParacaidasEmergencia(Paracaidas paracaidasEmergencia) {
        this.paracaidasEmergencia = paracaidasEmergencia;
    }
    
}
