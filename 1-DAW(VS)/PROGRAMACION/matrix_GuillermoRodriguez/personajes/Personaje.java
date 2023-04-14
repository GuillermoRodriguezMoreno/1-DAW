package matrix_GuillermoRodriguez.personajes;

import java.time.LocalDateTime;

public abstract class Personaje {
    
    //Atributos

    protected int id;
    protected String nombre;
    protected String ciudad;
    protected LocalDateTime fechaNacimiento;
    protected int edad;
    static int contadorPersonajes;

    //Constructores

    public Personaje(String nombre, String ciudad){

        this.id = Personaje.contadorPersonajes;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechaNacimiento = LocalDateTime.now();
        this.edad = (int)(Math.random() * 120);

        Personaje.contadorPersonajes++;

    }

    //Metodos

    public abstract String mostrarInformacion();

    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
