package ClasesT6.Clases.instituto;

public class ProfesorTitular extends Profesor{
    
    // Atributos

    private int antiguedad;

    // Constructores

    public ProfesorTitular(String nombre, String tlf, String email, double salarioBase, String materia){

        this.nombre = nombre;
        this.tlf = tlf;
        this.email = email;
        this.salarioBase = salarioBase;
        this.materia = materia;
    }

    // Metodos

    public double salario(){

        double salario = this.salarioBase + (this.antiguedad * 10);

        if(this.esTutor){

            salario = salario + 30;
        }

        return salario;
    }

}
