package ClasesT6.Clases;

public class CuentaCorriente {
    
    // Atributos

    String dni;
    String nombreTitular;
    double saldo;

    Gestor gestor;

    // Constructores

    public CuentaCorriente(String dni, String nombreTitular){

        this.dni = dni;
        this.nombreTitular = nombreTitular;
        this.saldo = 0.0;
    }

    public CuentaCorriente(String dni, double saldo){

        this.dni = dni;
        this.saldo = saldo;
    }

    public CuentaCorriente(String dni, String nombreTitular, double saldo){

        this(dni, nombreTitular);

        this.saldo = saldo;
    }




    // Metodos

    public void sacarDinero(double cantidad){

        if(this.saldo - cantidad < 0){

            System.out.println("no tienes dinero suficiente");

        }else{

            this.saldo -= cantidad;
        }
    }

    public void ingresarDinero(double cantidad){

        if(cantidad >= 0){

            this.saldo += cantidad;
        }
    }

    public String mostrarInfo(){

        String resultado = this.nombreTitular  + "(" + this.dni + ") : " + this.saldo;

        return resultado;
    }

    @Override // para sobreescribir una funcion ya definida.
    public String toString(){

        return mostrarInfo();
    }

    // Getter y Setters de Gestor

    public Gestor getGestor() {
        return gestor;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }

    
}
