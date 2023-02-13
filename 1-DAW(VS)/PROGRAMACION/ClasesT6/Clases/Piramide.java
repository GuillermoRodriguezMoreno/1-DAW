package ClasesT6.Clases;

public class Piramide {
    
    // Atributos

    private int altura;
    static int cuenta;

    // Constructores

    public Piramide(int altura){

        this.altura = altura;
        this.cuenta = this.cuenta + 1;
    }

    // Metodos

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public static int getCuenta() {
        return cuenta;
    }

    public static void setCuenta(int cuenta) {
        Piramide.cuenta = cuenta;
    }

    public String pintarPiramide(){

        String resultado = "";

        for (int linea = 1; linea <= this.getAltura(); linea++) {

            for (int j = 1 ; j <= this.getAltura() - linea ; j++){ //bucle espacios piramide1

                resultado = resultado + " ";
                
            }

            for (int k = 1 ; k <= linea + (linea-1) ; k++){ //bucle asteriscos piramide1

                resultado = resultado + "*";

            }

            resultado = resultado + "\n";
            
        }

        return resultado;
    }

    @Override
    public String toString(){

        return pintarPiramide();
        
    }
    
    
}
