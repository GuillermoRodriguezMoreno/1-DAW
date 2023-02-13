package ClasesT6.UsoClases;

import ClasesT6.Clases.CuentaCorriente;
import ClasesT6.Clases.Gestor;
import ClasesT6.Clases.Gestor.Puesto;

public class Banco {
    
    public static void main(String[] args) {
        
        CuentaCorriente cc_Andres = new CuentaCorriente("123", "Andres");

        cc_Andres.ingresarDinero(1000);
        cc_Andres.sacarDinero(524);

        System.out.println(cc_Andres.mostrarInfo());
        System.out.println(cc_Andres);

        System.out.println("--------------------------------___");


        String puestoTrabajo = "becario";

        puestoTrabajo = puestoTrabajo.toUpperCase();

        Puesto puesto = Puesto.valueOf(puestoTrabajo);

        Gestor pepe2 = new Gestor("pepe", "123", 0, puesto);

        System.out.println(pepe2.getPuesto());
        
        
    }
}
