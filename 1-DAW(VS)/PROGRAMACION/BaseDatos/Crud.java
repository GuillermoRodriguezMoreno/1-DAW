package BaseDatos;

import java.util.Scanner;

import java.sql.*;

public class Crud {

    static Scanner sc = new Scanner(System.in); 
    
    public static void main(String[] args) {

        System.setProperty("jdbc.drivers", "com.mysql.cj.jdbc.Driver"); 
        String url = "jdbc:mysql://localhost:3306/people"; 
        String user = "admin"; 
        String pass = "admin"; 

        try{

            Connection connection = DriverManager.getConnection(url ,user, pass);
            System.out.println("Conexión a la base de datos OK.");
            boolean fin_bucle = false;

            do { 

                mostrarMenu();

                int opcion = sc.nextInt();
                sc.nextLine(); //Limpiar buffer
                
                switch (opcion) {

                    case 1: 
                    
                        consultar_Cliente(connection);

                        break;

                    case 2: 
                    
                        dar_de_alta_Cliente(connection);

                        break;

                    case 3: 
                    
                        dar_de_baja_Cliente(connection);

                        break;

                    case 4: 
                    
                        modificar_Cliente(connection);

                        break;

                    case 0: 
                    
                        fin_bucle = true;

                        break;

                    default: 
                    
                        System.out.println("Indique una opción entre [0 - 4]");

                }

            } while (!fin_bucle);

            connection.close();

            System.out.println("Connection closed.");

        } catch (SQLException sqle){

            System.out.println(sqle.getMessage()); 

        }

    }

    // Metodos

    static void mostrarMenu(){

        System.out.println("\nSelecciona una opcion:");
        System.out.println("1 - Consultar un Cliente mediante dni.");
        System.out.println("2 - Dar de alta a un Cliente.");
        System.out.println("3 - Dar de baja a un Cliente.");
        System.out.println("4 - Modificar datos de un Cliente.");
        System.out.println("0 - Salir del programa.\n");
    }

    static void consultar_Cliente(Connection conexion){
            
        System.out.println("introduce el dni del cliente");

        String dniEntrada = sc.nextLine();

        String query = "SELECT * FROM people WHERE dni = '" + dniEntrada + "';";
        
        try{

            Statement stmt = conexion.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String telefono = rs.getString("telefono");
            System.out.println("nombre -> " + nombre);
            System.out.println("apellidos -> " + apellidos);
            System.out.println("telefono -> " + telefono);

        }
        
        catch (SQLException sqle){

            System.out.println(sqle.getMessage() + " " + sqle.getErrorCode()); 

        }

    }

    static void dar_de_alta_Cliente(Connection conexion){

        String dni, nombre, apellido, telefono, consulta;

        System.out.println("Inserta el dni del nuevo Cliente");

        dni = "'" + sc.nextLine() + "'";

        System.out.println("Inserta el nombre");

        nombre = "'" + sc.nextLine() + "'";

        System.out.println("Inserta el apellido");

        apellido = "'" + sc.nextLine() + "'";

        System.out.println("Inserta el telefono");

        telefono = "'" + sc.nextLine() + "'";

        consulta = "insert into people values (" + dni + ", " + nombre + ", " + apellido + ", " + telefono + ");";

        try{

            Statement stmt = conexion.createStatement();

            stmt.executeUpdate(consulta);

        }

        catch(SQLException sqle){

            System.out.println(sqle.getMessage() + " " + sqle.getErrorCode()); 

        }

    }

    static void dar_de_baja_Cliente(Connection conexion){

        String dni, consulta;

        System.out.println("Inserta el dni del Cliente que quieres eliminar");

        dni = "'" + sc.nextLine() + "'";

        consulta = "delete from people where dni=" + dni + ";";

            
        try {

            Statement stmt = conexion.createStatement();

            stmt.executeUpdate(consulta);

        }

        catch (SQLException sqle) {

            System.out.println(sqle.getMessage() + " " + sqle.getErrorCode()); 
        }
    }

    static void modificar_Cliente(Connection conexion){

        String dni, nombre, apellido, telefono, consulta;

        consulta = "update people set ";

        System.out.println("Selecciona el dni del Cliente");

        dni = "'" + sc.nextLine() + "'";

        System.out.println("Selecciona el dato que quieres modificar:");
        System.out.println("1 - Nombre");
        System.out.println("2 - Apellidos");
        System.out.println("3 - Telefono");

        int opcion = sc.nextInt();
        sc.nextLine();

        switch(opcion){

            case 1:

                System.out.println("Introduce el nuevo nombre");

                nombre = "'" + sc.nextLine() + "'";

                consulta = consulta + "nombre=" + nombre;

                break;

            case 2:

                System.out.println("Introduce el nuevo apellido");

                apellido = "'" + sc.nextLine() + "'";

                consulta = consulta + "apellidos=" + apellido;

                break;

            case 3:

                System.out.println("Introduce el nuevo telefono");

                telefono = "'" + sc.nextLine() + "'";

                consulta = consulta + "telefono=" + telefono;

                break;

            default:

                System.out.println("opcion incorrecta");
        }

        consulta = consulta + " where dni=" + dni + ";";

        try{

            Statement stmt = conexion.createStatement();

            stmt.executeUpdate(consulta);

        } 
        
        catch (SQLException sqle) {

            System.out.println(sqle.getMessage() + " " + sqle.getErrorCode());

        }
    }
    
}