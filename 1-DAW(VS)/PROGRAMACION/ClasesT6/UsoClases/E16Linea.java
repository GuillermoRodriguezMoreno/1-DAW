package ClasesT6.UsoClases;

import ClasesT6.Clases.Linea;
import ClasesT6.Clases.Punto;

public class E16Linea {
    
    public static void main(String[] args) {
        
        Punto p1 = new Punto(4.21f, 7.3f);
        Punto p2 = new Punto(-2f, 1.66f);
        Linea l = new Linea(p1, p2);
        System.out.println(l);
    }
}
