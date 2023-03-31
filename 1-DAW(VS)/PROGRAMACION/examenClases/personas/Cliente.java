package examenClases.personas;

public class Cliente extends Persona{
    
    // Atributos

    protected String tlf;
    protected int alturaSalto;
    protected boolean seguroVida;

    // Constructores

    public Cliente(String nombre, String apellidos, String tlf, int alturaSalto){

        super(nombre, apellidos);
        this.tlf = tlf;
        this.alturaSalto = alturaSalto;

    }

    public Cliente(String nombre, String apellidos, String tlf, int alturaSalto, boolean seguro){

        this(nombre,apellidos,tlf, alturaSalto);
        this.seguroVida = seguro;

    }

    // Metodos

    @Override
    public String informacion() {
        
        return this.nombre + ", " + this.apellidos + " Tlf: " + this.tlf +  " Altura: " + this.alturaSalto + " Seguro: " + this.seguroVida;

    }

    @Override
    public boolean equals(Object o){

        boolean iguales = false;
        Cliente cliente = (Cliente) o;

        if(this.nombre.equals(cliente.nombre) && this.apellidos.equals(cliente.apellidos)
            && this.tlf.equals(cliente.tlf)){

                iguales = true;

            }

        return iguales;

    }

    
}
