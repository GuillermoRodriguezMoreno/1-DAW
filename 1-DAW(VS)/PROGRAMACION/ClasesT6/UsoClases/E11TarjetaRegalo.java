package ClasesT6.UsoClases;

import ClasesT6.Clases.TarjetaRegalo;

public class E11TarjetaRegalo {
    
    public static void main(String[] args) {
        
        TarjetaRegalo t1 = new TarjetaRegalo(100);
        TarjetaRegalo t2 = new TarjetaRegalo(120);

        System.out.println(t1);
        System.out.println(t2);

        t1.gasta(45.90f);
        t2.gasta(5f);
        t2.gasta(200f);
        t1.gasta(3.55f);

        System.out.println(t1);
        System.out.println(t2);

        TarjetaRegalo t3 = t1.fusionaCon(t2);
        
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
