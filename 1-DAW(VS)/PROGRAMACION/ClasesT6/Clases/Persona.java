package ClasesT6.Clases;

public class Persona {
    
    //Atributos

    String dni;
    String nombre;
    String apellido;
    int edad;
    int estatura;

    // Constructores

    public Persona(){

        this.nombre = "Desconocido";
    }

    public Persona(String nombre, int edad){

        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, String apellidos, int edad, int estatura, String dni){

        this(nombre, edad);
        this.apellido = apellidos;
        this.estatura = estatura;
        this.dni = dni;
    }

    // Metodos

    void saludar(){

        System.out.println("hola soy " + nombre);

    }

    void cambiarNombre(String nombre){

        this.nombre = nombre;
    }

    static String QueDiaEs(){

        String resultado = "";

        return resultado;
    }
}
