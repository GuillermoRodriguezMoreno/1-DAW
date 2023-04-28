import java.io.*;
import java.util.*;

import clases.Alumno;
import utiles.UtilesAlumno;

public class App {

    public static void main(String[] args) throws Exception {

        // Creo objetos lectura con sus respectivos try-catch-resources

        String fichero = "src/recursos/ficheroAlumnos.txt";

        try (BufferedReader bReader = new BufferedReader(new 
            FileReader(fichero))){

            String linea = "";

            int contador = 0;

            ArrayList<Alumno> clase = new ArrayList<>();

            // Leo linea
            linea = bReader.readLine();

            // Mientras linea no se null
            while(linea != null){

                // si no es la primera linea
                if(contador > 0){

                    // Obtengo los atributos de cada linea
                    String[] atributos = UtilesAlumno.obtenerAtributos(linea);

                    // Setteo alumno por cada linea
                    Alumno nuevoAlumno = UtilesAlumno.settearAlumno(atributos);


                    // Añado alumno a la clase
                    clase.add(nuevoAlumno);

                }
                
                // Actualizo contador
                contador++;

                // Actualizo linea
                linea = bReader.readLine();

            }

            System.out.println();
            UtilesAlumno.ordenarPorEdad(clase);
            System.out.println();
            UtilesAlumno.mostrarMedia(clase);
            System.out.println();
            UtilesAlumno.mostrarTotalAlumnos(clase);
            System.out.println();
            UtilesAlumno.mostrarNumeroSuspensos(clase);
            System.out.println();
            UtilesAlumno.mostrarNumeroMujeres(clase);
            System.out.println();
            UtilesAlumno.mostrarNumeroMujeresSuspensas(clase);
            
        }
        
        catch(FileNotFoundException e){

            System.out.println(e.getMessage());

        }
        
        catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
    }

}
