package examenRecuperacionClasesDam;

import java.time.LocalDate;

import examenRecuperacionClasesDam.vehiculos.Vehiculo;

public class Barco {
    
    // Atributos

    private int capacidadVehiculos;
    private int capacidadPersonas;
    private int totalKgs;
    private String nombre;
    private LocalDate fechaBotadura;
    private Pasajero capitan;

    private Pasajero[] pasajeros;
    private Vehiculo[] vehiculos;

    // Constructor

    public Barco(int capacidadVehiculos, int capacidadPersonas, String nombre, Pasajero capitan){

        this.capacidadVehiculos = capacidadVehiculos;
        this.capacidadPersonas = capacidadPersonas;
        this.nombre = nombre;
        this.capitan = capitan;

        this.pasajeros = new Pasajero[0];
        this.vehiculos = new Vehiculo[0];
    }

    // Metodos

    public void embarcarVehiculo(Vehiculo vehiculo){

        if(comprobarCapacidadVehiculos() == true && comprobarPasajero(vehiculo.getDueño()) == true && 
            comprobarDueñoVehiculos(vehiculo.getDueño()) == false){

            Vehiculo[] nuevo = new Vehiculo[this.vehiculos.length + 1];

            for (int i = 0; i < this.vehiculos.length; i++) {
                
                nuevo[i] = this.vehiculos[i];
            }

            nuevo[nuevo.length - 1] = vehiculo;

            this.vehiculos = nuevo;

        }

        else if(comprobarPasajero(vehiculo.getDueño()) == false){

            System.out.println("primero debe embarcar el dueño");

        }

        else if (comprobarCapacidadVehiculos() == false){

            System.out.println("Capacidad maxima alcanzada");

        }

    }

    public Vehiculo desembarcarVehiculo(){


        Vehiculo[] nuevo = new Vehiculo[this.vehiculos.length - 1];

        for (int i = 0; i < nuevo.length; i++) {
            
            nuevo[i] = this.vehiculos[i];

        }

        Vehiculo desembarcado = this.vehiculos[this.vehiculos.length - 1];

        desambarcarPasajero(desembarcado.getDueño());

        this.vehiculos = nuevo;

        return desembarcado;

    }

    public void embarcarPasajero(Pasajero pasajero){

        if(comprobarPasajero(pasajero) == false && comprobarCapacidadPasajeros() == true){

            Pasajero[] nuevo = new Pasajero[this.pasajeros.length + 1];

            for (int i = 0; i < pasajeros.length; i++) {
                
                nuevo[i] = pasajeros[i];

            }

            nuevo[nuevo.length - 1] = pasajero;

            this.pasajeros = nuevo;

        }

        else if (comprobarCapacidadPasajeros() == false){

            System.out.println("capacidad maxima alcanzada");

        }

        else {

            System.out.println("El pasajero ya se encuentra embarcado");

        }

    }

    public Pasajero desembarcarPasajero(){

        Pasajero[] nuevo = new Pasajero[this.pasajeros.length - 1];

        for (int i = 0; i < nuevo.length; i++) {
            
            nuevo[i] = this.pasajeros[i];

        }

        Pasajero desembarcado = this.pasajeros[this.pasajeros.length - 1];

        this.pasajeros = nuevo;

        return desembarcado;

    }

    public Pasajero desambarcarPasajero(Pasajero pasajero){

        Pasajero[] nuevo = new Pasajero[this.pasajeros.length - 1];
        Pasajero desembarca = new Pasajero("", "", "");
        int posicion = 0;

        if(comprobarPasajero(pasajero) == true){

            for (int i = 0; i < this.pasajeros.length; i++) {
                
                if(pasajeros[i].equals(pasajero)){

                    posicion = i;
                    desembarca = pasajeros[i];

                }

                else{

                    nuevo[i] = pasajeros[i];

                }
            }

            this.pasajeros = nuevo;

        }

        else{

            System.out.println("el pasajero no se encuentra en el barco");

        }

        return desembarca;
    }

    public boolean comprobarPasajero(Pasajero pasajero){

        boolean repetido = false;

        for (int i = 0; i < pasajeros.length; i++) {
            
            if(pasajeros[i].equals(pasajero)){

                repetido = true;

                return repetido;
            }
        }

        return repetido;

    }

    public boolean comprobarCapacidadPasajeros(){

        if(this.capacidadPersonas > pasajeros.length){

            return true;
        }

        else {

            return false;
        }
    }

    public boolean comprobarCapacidadVehiculos(){

        if(this.capacidadVehiculos > this.vehiculos.length){

            return true;
        }

        else {

            return false;
        }
    }

    public boolean comprobarDueñoVehiculos(Pasajero pasajero){

        for (int i = 0; i < vehiculos.length; i++) {
            
            if(vehiculos[i].getDueño().equals(pasajero)){

                System.out.println("el pasajero ya tiene un vehiculo asociado");
                return true;
            }
        }

        return false;
    }

    public String monstrarInformacionBarco(){

        return "Nombre Barco : " + this.nombre + " Capitan: " + this.capitan + " Capacidad pasajeros: " + this.capacidadPersonas
            + " Capacidad vehiculos: " + this.capacidadVehiculos + "\n Pasajeros abordo: \n" + mostrarInformacionPasajeros() + 
            "\n Vehiculos abordo: \n" + mostrarInformacionVehiculos();

    }

    public String mostrarInformacionVehiculos(){

        String resultado = "";

        for (int i = 0; i < vehiculos.length; i++) {
            
            resultado = resultado + vehiculos[i].informacionVehiculo() + " // ";
        }

        return resultado;

    }

    public String mostrarInformacionPasajeros(){

        String resultado = "";

        for (int i = 0; i < pasajeros.length; i++) {
            
            resultado = resultado + pasajeros[i].toString() + " // ";
        }

        return resultado;

    }


    // Guetters y Setters

}
