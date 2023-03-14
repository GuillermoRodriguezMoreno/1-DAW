package examenClases_GuillermoRodriguez;

import examenClases_GuillermoRodriguez.personas.Instructor;

public class Paracaidas {

    // Enum

    public enum Fabricante {MOLTEM, CAIDALIBRE, ALTUS};
    
    // Atributos
    private int codigo;
    private int añoFabricacion;
    private Fabricante marca;
    private Instructor instructor;

    private static int contador;

    // Constructores
    
    public Paracaidas(int añoFabricacion, Fabricante marca, Instructor instructor){

        this.añoFabricacion = añoFabricacion;
        this.marca = marca;
        this.instructor = instructor;

        this.contador++;
        this.codigo = contador;
    }

    // Getters y Setters

    public int getCodigo() {
        return codigo;
    }

    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    private void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public Fabricante getMarca() {
        return marca;
    }

    private void setMarca(Fabricante marca) {
        this.marca = marca;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Paracaidas.contador = contador;
    }

    

}
