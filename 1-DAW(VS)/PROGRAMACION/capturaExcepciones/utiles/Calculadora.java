package capturaExcepciones.utiles;

public class Calculadora {
    
    //Metodos

    public int sumar(int a , int b){

        return a + b;
    }

    public int multiplicar(int a, int b){

        return a * b;

    }

    public Integer dividir(int a, int b){

        Integer resultado = null;

        try {
            
            resultado = a/b;

        } 
        
        catch (ArithmeticException e) {

            e.printStackTrace();
        }

        return resultado;
    }

    public Integer division2(int a, int b) throws ArithmeticException{

        Integer resultado = a/b;




        return resultado;
    }
}
