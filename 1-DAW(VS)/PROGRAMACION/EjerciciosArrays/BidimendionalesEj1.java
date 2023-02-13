package EjerciciosArrays;

public class BidimendionalesEj1 {
    
    public static void main(String[] args) {
        
        int[][] tabla = new int[5][5];

        for(int i = 0; i < 5; i++){

            for(int z = 0; z < 5; z++){

                tabla[i][z] = 10*i + z;

                System.out.print(" | " + tabla[i][z]+ " | ");   
            
            }

            System.out.println("\n----------------------------------------");

        }

        System.out.println(tabla.toString());
    }
}
