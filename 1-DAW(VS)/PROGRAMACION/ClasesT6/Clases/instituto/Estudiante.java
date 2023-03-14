package ClasesT6.Clases.instituto;

public class Estudiante extends Persona{

    private String numCarnetEstudiante;
    private float notaMedia;

    // Constructores

    public Estudiante(String nombre, String tlf, String email, String carnetEstudiante){

        super(nombre, tlf, email);
        this.numCarnetEstudiante = carnetEstudiante;
    }
    
}
