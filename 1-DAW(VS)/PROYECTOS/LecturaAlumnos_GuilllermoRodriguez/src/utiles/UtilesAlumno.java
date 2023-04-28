package utiles;

import java.util.ArrayList;
import java.util.Collections;

import clases.Alumno;

public class UtilesAlumno {
    
    // Metodos

    /**
     * separo la linea por atributos
     * @param linea
     * @return Array de String de los atributos
     */

    public static String[] obtenerAtributos(String linea){

        // Troceo la linea por espacios
        String[] lineaTroceada = linea.split(" ");

        // Recorro trozos
        for (int i = 0; i < lineaTroceada.length; i++) {
            
            // Limpio espacios en blanco
            lineaTroceada[i] = lineaTroceada[i].strip();

            // Cambio comas por punto
            lineaTroceada[i] = lineaTroceada[i].replace(',', '.');

        }

        return lineaTroceada;

    }
    
    /**
     * Sette los atributos dados a un alumno
     * @param atributos
     * @return Alumno con los atributos dados
     */

    public static Alumno settearAlumno(String[] atributos){

        // Variables

        String sexo = "";
        int edad = 0;
        float estatura = 0.0f;
        int puntuacion1 = 0;
        int puntuacion2 = 0;
        boolean aprobado = false;

        try {
            
            sexo = atributos[0];
            edad = Integer.valueOf(atributos[1]);
            estatura = Float.valueOf(atributos[2]);
            puntuacion1 = Integer.valueOf(atributos[3]);
            puntuacion2 = Integer.valueOf(atributos[4]);

            // Si el alumno esta aprobado actualizo valor aprobado
            if(atributos[5].toLowerCase().equals("aprobado")){

                aprobado = true;

            }

            try{

                // Construccion alumno
                Alumno nuevoAlumno = new Alumno(sexo, edad, estatura, puntuacion1, puntuacion2, aprobado);

                return nuevoAlumno;

            }
            
            catch (Exception e) {

                e.getMessage();
                System.out.println("no se pudo construir Alumno con esos valores de atributos");

            }

            return null;

        }
        
        catch (NumberFormatException e){

            e.getMessage();
            System.out.println("No se pudo pasar a valor numerico un atributo");

        }
        
        catch (Exception e) {

            e.getMessage();

        }

        return null;

    }

    /**
     * Muestra la lista de alumnos ordenada por edad
     * @param clase
     */

    public static void ordenarPorEdad(ArrayList<Alumno> clase){

        try {
            
            // Ordeno
            Collections.sort(clase);

            System.out.println("LISTA ORDENADADA POR EDAD:");

            // Recorro
            for (Alumno alumno : clase) {
                
                System.out.println(alumno);

            }

        } 
        
        catch (Exception e) {
            
            e.getMessage();

        }

        

    }

    /**
     * muestra la media de edad de los alumnos
     * @param clase
     */

    public static void mostrarMedia(ArrayList<Alumno> clase){

        // variables
        float media = 0.0f;
        float total = 0.0f;

        // Recorro
        for (Alumno alumno : clase) {
            
            total = total + alumno.getEdad();

        }

        try {
            
            media = total / (float) (clase.size());

            System.out.println("La media de edad es: " + media);

        }
        catch (ArithmeticException e){

            e.getMessage();
            System.out.println("No se puede dividir por 0");

        }
        
        catch (Exception e) {
            
            e.getMessage();

        }
        
    }

    /**
     * muestra el numero total de alumnos
     * @param clase
     */

    public static void mostrarTotalAlumnos(ArrayList<Alumno> clase){

        System.out.println("El total de alumnos es: " + clase.size());

    }

    /**
     * muestra el numero total de alumnos suspensos
     * @param clase
     */

    public static void mostrarNumeroSuspensos(ArrayList<Alumno> clase){

        // Variables
        int numSuspensos = 0;

        // Recorro
        for (Alumno alumno : clase) {
            
            if(!alumno.isAprobado()){

                numSuspensos++;

            }

        }

        System.out.println("El numero de alumnos suspensos es: " + numSuspensos);

    }

    /**
     * Muestra el numero de alumnos que son mujer
     * @param clase
     */

    public static void mostrarNumeroMujeres(ArrayList<Alumno> clase){

        // Variables
        int numMujeres = 0;

        // Recorro
        for (Alumno alumno : clase) {
            
            if(alumno.getSexo().toUpperCase().equals("MUJER")){

                numMujeres++;

            }

        }

        System.out.println("El numero de mujeres es: " + numMujeres);

    }

    /**
     * Muestra el total de alumnos mujer suspensas
     * @param clase
     */

    public static void mostrarNumeroMujeresSuspensas(ArrayList<Alumno> clase){

        // Variables
        int numMujeresSuspensas = 0;

        // Recorro
        for (Alumno alumno : clase) {
            
            if(alumno.getSexo().toUpperCase().equals("MUJER") && !alumno.isAprobado()){

                numMujeresSuspensas++;

            }

        }

        System.out.println("El numero de mujeres suspensas es: " + numMujeresSuspensas);

    }

}
