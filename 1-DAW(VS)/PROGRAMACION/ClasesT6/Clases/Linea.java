package ClasesT6.Clases;

public class Linea {
    
    // Atributos

    private Punto a;
    private Punto b;

    // Contructores

    public Linea(Punto a, Punto b){

        this.a = a;
        this.b = b;
    }

    // Metodos

    public Punto getA() {
        return a;
    }

    public void setA(Punto a) {
        this.a = a;
    }

    public Punto getB() {
        return b;
    }

    public void setB(Punto b) {
        this.b = b;
    }

    @Override
    public String toString(){

        String resultado = "Linea formada por los puntos " + "(" + this.getA().getX() + " , " + this.getA().getY() + ")" + " y " + "(" + this.getB().getX() + " , " + this.getB().getY() + ")";

        return resultado;
    }

    
}
