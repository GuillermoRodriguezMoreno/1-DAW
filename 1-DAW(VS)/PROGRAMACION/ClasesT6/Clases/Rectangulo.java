package ClasesT6.Clases;

public class Rectangulo {
    
    // Atributos

    private int altura;
    private int base;
    static int cuenta;

    // Constructores

    public Rectangulo(int base, int altura){

        this.altura = altura;
        this.base = base;
        this.cuenta = this.cuenta + 1;
    }

    // Metodos

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public static int getCuenta() {
        return cuenta;
    }

    public static void setCuenta(int cuenta) {
        Rectangulo.cuenta = cuenta;
    }

    public String pintarRectangulo(){

        String resultado = "";

        for (int i = 1; i <= this.getAltura(); i++) {

            for (int j = 1; j <= this.getBase(); j++) {

                resultado = resultado + "*";
                
            }

            resultado = resultado + "\n";
            
        }

        return resultado;
    }

    @Override
    public String toString(){

        return pintarRectangulo();
    }
}
