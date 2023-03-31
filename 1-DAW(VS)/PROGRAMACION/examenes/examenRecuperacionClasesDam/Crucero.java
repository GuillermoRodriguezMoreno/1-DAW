package examenRecuperacionClasesDam;

import examenRecuperacionClasesDam.vehiculos.Camion;
import examenRecuperacionClasesDam.vehiculos.Coche;
import examenRecuperacionClasesDam.vehiculos.Moto;

public class Crucero {
    
    public static void main(String[] args) {

        Pasajero p1 = new Pasajero("pepe", "gonzalez", "españa");
        Pasajero p2 = new Pasajero("fran", "perez", "finlandia");
        Pasajero p3 = new Pasajero("paco", "lopez", "marruecos");
        Pasajero p4 = new Pasajero("adrian", "hernandez", "portugal");
        Pasajero p5 = new Pasajero("pedro", "ruiz", "grecia");
        Pasajero p6 = new Pasajero("pepe", "gonzalez", "españa");
        
        Camion c1 = new Camion("1A", p3);
        Moto m1 = new Moto("2A", p1);
        Coche coche1 = new Coche("3A", p2);

        Barco comodoro = new Barco(2, 10, "comodoro", p5);

        comodoro.embarcarPasajero(p1);
        comodoro.embarcarPasajero(p2);
        comodoro.embarcarPasajero(p3);
        comodoro.embarcarVehiculo(coche1);
        comodoro.embarcarVehiculo(c1);

        System.out.println("--------------------");

        comodoro.embarcarPasajero(p6);
        comodoro.embarcarVehiculo(m1);

        System.out.println(comodoro.monstrarInformacionBarco());

        //System.out.println(comodoro.monstrarInformacionBarco());

    }
}
