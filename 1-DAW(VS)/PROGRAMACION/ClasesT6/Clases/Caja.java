package ClasesT6.Clases;

import ClasesT6.Clases.Cliente.Accion;

public class Caja {
    
    private double importe;
    private Cliente[] colaClientes;

    public Caja(){

        this.importe = 1000;
        this.colaClientes = new Cliente[0];
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Cliente[] getColaClientes() {
        return colaClientes;
    }

    public void setColaClientes(Cliente[] colaClientes) {
        this.colaClientes = colaClientes;
    }

    public void cogerTurno(Cliente cliente){

        Cliente[] nuevaCola = new Cliente[this.colaClientes.length + 1];

        for (int i = 0; i < this.colaClientes.length; i++) {
            
            nuevaCola[i] = this.colaClientes[i];
        }

        nuevaCola[nuevaCola.length - 1] = cliente;

        this.colaClientes = nuevaCola;
    }

    public void atender(){

        if(this.colaClientes[0].getAccion().equals(Accion.INGRESAR)){

            this.importe = this.importe + this.colaClientes[0].getImporte();

        }else{

            if(this.importe > this.colaClientes[0].getImporte()){

                this.importe = this.importe - this.colaClientes[0].getImporte();
            }

            else{

                System.out.println("no hay dinero suficiente");
            }

        }

        Cliente[] nuevaCola = new Cliente[this.colaClientes.length - 1];

        for (int i = 0; i < nuevaCola.length; i++) {
            
            nuevaCola[i] = this.colaClientes[i+1];

        }

        this.colaClientes = nuevaCola;
    }

    public void estadoCola(){

        for (int i = 0; i < this.colaClientes.length; i++) {
            
            System.out.print(colaClientes[i] + " - ");
        }

        System.out.println();
    }
}
