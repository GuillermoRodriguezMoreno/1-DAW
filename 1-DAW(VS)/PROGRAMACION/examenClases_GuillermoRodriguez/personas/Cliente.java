package examenClases_GuillermoRodriguez.personas;

public class Cliente extends Persona{
    
    // Atributos

    protected String tlf;
    protected double alturaSalto;
    protected boolean seguro;

    // Constructores

    public Cliente(String nombre, String apellidos, String tlf, double alturaSalto){

        super(nombre, apellidos);
        this.tlf = tlf;
        this.alturaSalto = alturaSalto;
        this.seguro = false;
    }

    public Cliente(String nombre, String apellidos, String tlf, double alturaSalto, boolean seguro){

        this(nombre, apellidos, tlf, alturaSalto);
        this.seguro = seguro;

    }

    // Metodos

    public String mostrarInformacion(){

        return this.getNombre() + " " + this.getApelllidos() + " " +  this.getTlf() + " " + this.getAlturaSalto() +
        "m " + this.getSeguro();
    }

    @Override
    public boolean equals(Object obj){

        boolean iguales = false;

        Cliente cliente = (Cliente) obj;

        if(this.getNombre() == cliente.getNombre() && this.getApelllidos() == cliente.getApelllidos() && this.getTlf() == cliente.getTlf()){

            iguales = true;
        }

        return iguales;
    }

    // Getters y Setters

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public double getAlturaSalto() {
        return alturaSalto;
    }

    public void setAlturaSalto(double alturaSalto) {
        this.alturaSalto = alturaSalto;
    }

    public boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }


    
}
