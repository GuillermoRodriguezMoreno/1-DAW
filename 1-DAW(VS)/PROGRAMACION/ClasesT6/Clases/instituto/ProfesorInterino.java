package ClasesT6.Clases.instituto;

public class ProfesorInterino extends Profesor{

    // Atributos

    // Constructores

    public ProfesorInterino(String nombre, String tlf, String email, double salarioBase, String materia){

        this.nombre = nombre;
        this.tlf = tlf;
        this.email = email;
        this.salarioBase = salarioBase;
        this.materia = materia;
    }

    // Metodos

    public double salario(){

        double salario = this.salarioBase;

        if(this.esTutor){

            salario = salario + 25;
        }

        return salario;
    }

    public String getNombre(){

        return this.nombre;
    }
    
}
