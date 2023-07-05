package modelo;

import java.util.ArrayList;

public class People {
    
    // Atributos

    private ArrayList<Persona> people;

    // Constructor

    public People(){

    }

    // Metodos

    public ArrayList<Persona> getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return "People [people=" + people + "]";
    }

    public void setPeople(ArrayList<Persona> listaPersonas) {
        this.people = listaPersonas;
    }

    
}
