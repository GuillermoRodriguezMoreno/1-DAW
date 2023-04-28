import logCutre.Log;
import logCutre.Log.Tipo;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");

        Log.nuevaEntradaLog("prueba", Tipo.INFORMACION);
    }
}
