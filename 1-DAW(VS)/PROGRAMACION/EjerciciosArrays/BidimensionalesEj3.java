package EjerciciosArrays;

public class BidimensionalesEj3 {
    
    public static void main(String[] args) {
        
        int[][] tabla = new int[4][5];

        for(int i = 0; i < tabla.length; i++){

            for(int j = 0; j < tabla[i].length; j++){

                tabla[i][j] = j;

                System.out.print(tabla[i][j]);

            }

            System.out.println("\n------------------");
        } 
    }
}
