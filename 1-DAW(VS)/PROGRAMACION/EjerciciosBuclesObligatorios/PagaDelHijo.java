package EjerciciosBuclesObligatorios;

public class PagaDelHijo {
    public static void main(String[] args) {
        
        final float PAGA = 0.05f;
        final float PRECIO_BICI = 2000f;

        float pagaActual = PAGA;

        int semanas = 1;

        while(pagaActual < PRECIO_BICI){

            semanas ++;

            pagaActual = pagaActual + pagaActual * 2;
        }

        System.out.println("tardara " + semanas + " semanas");

    }
}
