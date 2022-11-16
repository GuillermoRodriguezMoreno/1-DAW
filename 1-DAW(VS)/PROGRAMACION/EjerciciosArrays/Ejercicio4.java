package EjerciciosArrays;

public class Ejercicio4 {
    public static void main(String[] args) {
        
        int []numero = new int [99];
        long []cuadrado = new long[99];
        long []cubo = new long [99];

        for(int i = 0 ; i <= 99 ; i++){

            numero[i] = (int) (Math.random() * 101);
            System.out.print(numero[i] + "  ");
            cuadrado[i] = (long) (Math.pow(numero[i], 2));
            System.out.print(cuadrado[i] + "  ");
            cubo[i] = (long) (Math.pow(numero[i], 3));
            System.out.println(cubo[i] + "  ");

        }
    }
}
