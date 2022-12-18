package Funciones.funcionesRecursivas;

public class ejercicio3 {
    
    public static void main(String[] args) {

        piramide(4);
        

    }

    static void piramide (int altura){

        if (altura > 1){

            pintarFila(altura);
            System.out.println();
            piramide(altura-1);

        }

        else{

            System.out.println("*");

        }
        
    }

    static void pintarFila(int num){

        if (num == 0){

            System.out.print("");

        } else {

            System.out.print("*");
            pintarFila(num-1);
        }
    }

    static String array (String []lista){

        String resultado = "";

        return resultado;
    }
}
