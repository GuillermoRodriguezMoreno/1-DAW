package EjerciciosArrays;

public class prueba {

    public int obtenerAtaque(int ataque) {

        ataque = (int) (Math.random() * (ataque + 1));

        return ataque;
    }
    
    public static void main(String[] args) {

        
        
        for(int i = 0; i <=100 ; i++){
            int a = (int) (Math.random() * ((70 + 1) - 30) + 30);
            System.out.println(a);
        }

    }
}
