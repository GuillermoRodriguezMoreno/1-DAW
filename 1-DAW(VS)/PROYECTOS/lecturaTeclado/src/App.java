import clase.utiles.LecturaTeclado;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        LecturaTeclado sc = new LecturaTeclado();

        System.out.println("leer cadena");
        System.out.println(sc.leerCadena());
        System.out.println("leer int");
        System.out.println(sc.leerInt());
        System.out.println("leer float");
        System.out.println(sc.leerFloat());
        System.out.println("leer double");
        System.out.println(sc.leerDouble());

        sc.finalizarLectura();

        sc.leerDouble();
        
    }
}
