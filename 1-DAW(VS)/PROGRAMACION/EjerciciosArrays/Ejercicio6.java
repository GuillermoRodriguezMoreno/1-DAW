package EjerciciosArrays;

public class Ejercicio6 {
    public static void main(String[] args) {
        
        int []numeros = new int[15];
        int []numeros2 = new int[15];


        for(int i = 0 ; i <= 14 ; i++){

            numeros[i] = i + 1;

            System.out.print(numeros[i] + " ");
        }
        
        System.out.println("");

        for( int i = 0 ; i <= 14 ; i++){

            if (i == 0) numeros2[i] = numeros[14];

            else numeros2[i] = numeros[i-1];
            
            System.out.print(numeros2[i] + " ");

        }
    }
}
