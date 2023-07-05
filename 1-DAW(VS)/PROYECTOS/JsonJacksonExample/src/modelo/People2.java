package modelo;

import java.util.ArrayList;

public class People2 {
    
    // Atributos

    private ArrayList<Persona> People2;

    // Constructor

    public People2(){

    }

    // Metodos

    public ArrayList<Persona> getPeople2() {
        return People2;
    }

    @Override
    public String toString() {
        return "People2 [People2=" + People2 + "]";
    }

    public void setPeople2(ArrayList<Persona> listaPersonas) {
        this.People2 = listaPersonas;
    }

    
}
