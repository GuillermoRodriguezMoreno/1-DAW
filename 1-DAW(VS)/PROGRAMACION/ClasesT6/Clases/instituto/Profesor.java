package ClasesT6.Clases.instituto;


abstract class Profesor extends Persona{
    
    // Atributos

    protected double salarioBase;
    protected String materia;
    protected boolean esTutor;

    // constructores

    // Metodos

    public abstract double salario();

    @Override
    public boolean equals(Object profesor){

        Profesor profesor1 = (Profesor) profesor;

        boolean sonIguales = false;

        return false;
    }
}
