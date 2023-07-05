package modelos;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import util.LeerInformacion;
import util.SalidaInformacion;

public class Ferreteria {

    // static

    DecimalFormat df = new DecimalFormat("0.00");
    
    // Atributos

    private ArrayList<Cliente> listaCliente;
    private ArrayList<Producto> listaProducto;
    private ArrayList<Venta> listaVentas;

    // Constructor

    public Ferreteria(){

        this.listaCliente = LeerInformacion.leerJsonClientes();
        this.listaProducto = LeerInformacion.leerListaProductos();
        this.listaVentas = LeerInformacion.leerJsonVentas();

    }

    // Metodos

    public void informeClientes(){

        String informacion = "====== Informe Clientes =====\n";

        // Recorro clientes

        for (Cliente cliente : this.listaCliente) {

            informacion = informacion + cliente.toString() + "\n Importe total = " + df.format(obtenerImporteCliente(cliente)) + "\n";

        }



        SalidaInformacion.crearFichero("facturacionClientes", informacion);

    }

    public void informeProductos(){

        String informacion = "======= Productos Vendidos =========\n";

        HashMap<Integer, Integer> mapaProdcutos = obtenerUnidadesVendidas();

        int unidadesVendidas = 0;

        // Recorro productos

        for (Producto producto : this.listaProducto) {

            unidadesVendidas = 0;

            // Recorro mapa

            for (Integer codProd : mapaProdcutos.keySet()) {


                if(producto.getCodigo() == codProd){

                    unidadesVendidas = mapaProdcutos.get(codProd);

                }
            }

            informacion = informacion + producto.toString() + " Unidades totales vendidas: " + unidadesVendidas + "\n";
            
        }

        SalidaInformacion.crearFichero("ProductosVendidos", informacion);

    }

    public void informeVentas(){

        String informacion = "========= Facturacion Total ========\n";

        double facturacionTotal = 0.0;

        // Recorro clientes y obtengo su importe total y sumo

        for (Cliente cliente : this.listaCliente) {

            facturacionTotal = facturacionTotal + obtenerImporteCliente(cliente);
            
        }

        informacion = informacion + df.format(facturacionTotal);

        SalidaInformacion.crearFichero("FacturacionTotal", informacion);

    }

    public double obtenerImporteCliente(Cliente cliente){

        int codProducto = 0;
        int cantidad = 0;
        double importeTotal = 0.0;

        // Recorro ventas

        for (Venta venta : this.listaVentas) {

            // Si encuentro cliente
            if(venta.getCodigoCliente() == cliente.getCodigo()){

                // Recorro lineas
                for (Linea linea : venta.getLineas()) {

                    codProducto = linea.getCodigoProducto();
                    cantidad = linea.getCantidad();

                    // Recorro productos
                    for (Producto producto : this.listaProducto) {

                        if(codProducto == producto.getCodigo()){

                            importeTotal = importeTotal + producto.getPrecio() * cantidad;

                        }
                        
                    }
                    
                }
            }
            
        }

        return importeTotal;

    }

    public HashMap<Integer, Integer> obtenerUnidadesVendidas(){

        HashMap<Integer, Integer> productoCantidad = new HashMap<>();

        // Recorro ventas

        for (Venta venta : this.listaVentas) {

            // Recorro Lineas

            for (Linea linea : venta.getLineas()) {


                productoCantidad.put(linea.getCodigoProducto(), linea.getCantidad());

            }
            
        }

        return productoCantidad;

    }

}
