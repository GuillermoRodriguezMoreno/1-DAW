package capturaExcepciones;

import capturaExcepciones.utiles.Calculadora;

public class EjemploTryCatch {
    
    public static void main(String[] args) {
        
        Calculadora cal = new Calculadora();

        int resultadoDiv = cal.dividir(10, 2);

        Integer resultadoDiv2 = cal.dividir(10, 0);
        resultadoDiv2 = cal.division2(10, 0);

        try {
            
            
        } catch (Exception e) {
            // TODO: handle exception
        }

        System.out.println(resultadoDiv);
        System.out.println(resultadoDiv2);
    }
}
