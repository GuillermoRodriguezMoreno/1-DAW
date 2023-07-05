package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import modelos.Cliente;
import modelos.ExcepcionProductoSinStock;
import modelos.Linea;
import modelos.Producto;
import modelos.Venta;

public class LeerInformacion {
    
    // Metodos

    
    public static ArrayList<Producto> leerListaProductos(){

        ArrayList<Producto> listaProductos = new ArrayList<>();

        try (BufferedReader bReader = new BufferedReader(new FileReader("src/recursos/productos.csv"))) {

            String linea = "";

            // Leo primera linea
            linea = bReader.readLine();

            while(linea != null){

                // Si no respeta formato
                if(linea.contains("codigo;nombre")){

                    System.out.println("Error en la lectura de un producto -> en la cadena " + linea);

                    // Leo linea
                    linea = bReader.readLine();

                }



                String[] atributos = linea.split(";");

                Producto producto = new Producto();

                try {

                    producto.setCodigo(Integer.valueOf(atributos[0]));
                    producto.setNombre(atributos[1]);
                    producto.setDescripcion(atributos[2]);
                    producto.setPrecio(Double.valueOf(atributos[3]));
                    producto.setStock(Integer.valueOf(atributos[4]));

                    
                } catch (Exception e) {

                    e.printStackTrace();

                }

                try {
                    
                    if(producto.getStock() == 0){

                        throw new ExcepcionProductoSinStock(producto);

                    }

                    else{

                        listaProductos.add(producto);

                    }
                } catch (ExcepcionProductoSinStock ex) {

                    System.out.println(ex);

                }

                listaProductos.add(producto);

                linea = bReader.readLine();
            }


        } catch (Exception e) {
            
            e.printStackTrace();

        }

        // Ya tengo la lista, pero tiene valores repetidos, voy a crear un set para que no esten repetidos

        HashSet<Producto> listaUnica = new HashSet<>(listaProductos);

        // Ya no tengo valores repetidos por lo que vuelvo a crear una lista con los valores del set

        listaProductos = new ArrayList<>(listaUnica);

        return listaProductos;

    }
    

    public static ArrayList<Venta> leerJsonVentas() {

        File ficheroVentas = new File("src/recursos/ventas.json");

		ObjectMapper objectMapper = new ObjectMapper();

		ArrayList<Venta> listaVentas = null;

		try {

            listaVentas = objectMapper.readValue(ficheroVentas, new TypeReference<ArrayList<Venta>>(){});
			
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        // Ya tengo la lista de ventas, ahora me falta hacer el control de las lineas

        // voy a obterer lista productos para poder comparar
        ArrayList<Producto> listaProducto = LeerInformacion.leerListaProductos();

        ArrayList<Linea> listaLineaNueva = new ArrayList<>();

        Linea incorrecta = new Linea();

        boolean existeCodigo = false;

        int codigoProducto = 0;

        // Recorro ventas

        for (Venta venta : listaVentas) {

            listaLineaNueva = venta.getLineas();

            // voy a recorrer lineas

            for (Linea linea: venta.getLineas()) {
                
                // Voy a obtener codigo de productos y ver si existen
                codigoProducto = linea.getCodigoProducto();

                // voy a recorrer producto para ver si existe dicho codigo

                for (Producto producto : listaProducto) {

                    // Si el codigo es encontrado
                    if(codigoProducto == producto.getCodigo()){

                        existeCodigo = true;
                    }
                    
                }

                // una vez se si existe o no borro o no dicha linea

                if(existeCodigo == false){

                    System.out.println("error, el producto con codigo " + codigoProducto + " no existe entre los disponibles");

                    listaLineaNueva.remove(linea);

                }
            }

            // Vuelvo asignar lineas a dicha venta

            venta.setLineas(listaLineaNueva);
            
        }

        

		return listaVentas;

    }

    public static ArrayList<Cliente> leerJsonClientes() {

        File ficheroClientes = new File("src/recursos/clientes.json");

		ObjectMapper objectMapper = new ObjectMapper();

		ArrayList<Cliente> listaClientes = null;

		try {

            listaClientes = objectMapper.readValue(ficheroClientes, new TypeReference<ArrayList<Cliente>>(){});
			
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        // Creo set para no tener valores repetidos

        HashSet<Cliente> listaUnica = new HashSet<>(listaClientes);

        // Vuelvo a crear la lista

        listaClientes = new ArrayList<>(listaUnica);

		return listaClientes;

    }

}
