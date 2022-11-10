package EjerciciosMath;

public class ejercicio7 {
    public static void main(String[] args) {
        
        int tirada1 = (int) (Math.random()*6 + 1);
        int tirada2 = (int) (Math.random()*6 + 1);
        int tirada3 = (int) (Math.random()*6 + 1);

        System.out.println("jugador1 " + tirada1 + " jugador2 " + tirada2 + " jugador3 " + tirada3);

        int max = Math.max(tirada2, tirada3);
        max = Math.max(tirada1, max);
        
        int min = Math.min(tirada1, tirada2);
        min = Math.min(min, tirada3);

        System.out.println("el max es " + max + ", el min es " + min);
        

    }
}
