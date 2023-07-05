import java.util.ArrayList;

import modelos.Cliente;
import modelos.Ferreteria;
import modelos.Producto;
import modelos.Venta;
import util.LeerInformacion;

public class App {

    public static void main(String[] args) throws Exception {


        /* 
        ArrayList<Venta> listaVentas = LeerInformacion.leerJsonVentas();

        System.out.println(listaVentas);

        ArrayList<Cliente> listaClientes = LeerInformacion.leerJsonClientes();

        System.out.println(listaClientes);

        ArrayList<Producto> listaProductos = LeerInformacion.leerListaProductos();

        System.out.println(listaProductos);
        */

        Ferreteria ferreteria = new Ferreteria();

        ferreteria.informeClientes();

        ferreteria.informeVentas();

        ferreteria.informeProductos();


    }
}
