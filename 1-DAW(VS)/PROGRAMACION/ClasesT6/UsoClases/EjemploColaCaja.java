package ClasesT6.UsoClases;

import ClasesT6.Clases.Caja;
import ClasesT6.Clases.Cliente;
import ClasesT6.Clases.Cliente.Accion;

public class EjemploColaCaja {
    
    public static void main(String[] args) {
        
        Caja caja = new Caja();
        Cliente cliente1 = new Cliente("Andres", Accion.RETIRAR, 100);
        caja.cogerTurno(cliente1);
        Cliente cliente2 = new Cliente("Javier", Accion.RETIRAR, 540.5);
        caja.cogerTurno(cliente2);
        Cliente cliente3 = new Cliente("Sara", Accion.RETIRAR, 1500);
        caja.cogerTurno(cliente3);
        caja.estadoCola();
        caja.atender();
        System.out.println(caja.getImporte());
        
        Cliente cliente4 = new Cliente("Miguel", Accion.INGRESAR, 2000);
        caja.cogerTurno(cliente4);
        caja.atender();
        System.out.println(caja.getImporte());
        caja.estadoCola();
    }

    
}
