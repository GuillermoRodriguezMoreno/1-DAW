package clases;

public class Alumno implements Comparable<Alumno>{
    
    // Atributos

    private String sexo;
    private int edad;
    private float estatura;
    private int puntuacion1;
    private int puntuacion2;
    private boolean aprobado;

    // Construtores

    public Alumno(String sexo, int edad, float estatura, int puntuacion1, int puntuacion2, boolean aprobado){

        this.sexo = sexo;
        this.edad = edad;
        this.estatura = estatura;
        this.puntuacion1 = puntuacion1;
        this.puntuacion2 = puntuacion2;
        this.aprobado = aprobado;

    }

    // Metodos

    @Override
    public String toString(){

        String resultado = "";

        resultado = "Sexo: " + this.getSexo() + ", edad: " + this.getEdad() + ", estatura: " + this.getEstatura() + ", puntuacion1: " 
            + this.puntuacion1 + ", puntuacion2: " + this.getPuntuacion2() + ", aprobado: " + this.isAprobado();

        return resultado;

    }

    @Override
    public int compareTo(Alumno o) {
        
        int resultado = 0;

        if(this.edad > o.getEdad()){

            resultado = 1;

        }

        if(this.edad < o.getEdad()){

            resultado = -1;
            
        }

        return resultado;

    }

    // Getters y Setters

    public Alumno() {
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public int getPuntuacion1() {
        return puntuacion1;
    }

    public void setPuntuacion1(int puntuacion1) {
        this.puntuacion1 = puntuacion1;
    }

    public int getPuntuacion2() {
        return puntuacion2;
    }

    public void setPuntuacion2(int puntuacion2) {
        this.puntuacion2 = puntuacion2;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    
}
