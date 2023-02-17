package ClasesT6.Clases.trenes.maquinaria;

import ClasesT6.Clases.trenes.personal.Mecanico;

public class Locomotora {
    
    // Atributos

    private String matricula;
    private int potencia;
    private int año;
    private Mecanico mecanicoAsignado;

    // Constructores

    public Locomotora(){

    }

    public Locomotora(String matricula, int potencia){

        this.matricula = matricula;
        this.potencia = potencia;
    }

    public Locomotora(String matricula, int potencia, int fecha){

        this(matricula, potencia);
        this.año = fecha;
    }

    // Metodos

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Mecanico getMecanicoAsignado() {
        return mecanicoAsignado;
    }

    public void setMecanicoAsignado(Mecanico mecanicoAsignado) {
        this.mecanicoAsignado = mecanicoAsignado;
    }

    
}
