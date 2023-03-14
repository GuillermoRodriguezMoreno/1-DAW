package ExamenRecuperacionArrays;

import java.util.Scanner;

public class Ejercicio3_GuillermoRodriguez {
    
    public static void main(String[] args) {
        
        //Juego del Lingo
        //String palabra secreta ha buscar es : HUECO
        String palabraSecreata = "HUECO";
        char[] arrayCaracteresSecretos = ConvertirStringAArray(palabraSecreata);
        Scanner sc = new Scanner(System.in);
        String intento = "";
        boolean encontrada = false;
        do
        {
            System.out.println("Intento....");
            intento = sc.nextLine();
            if (!intento.equalsIgnoreCase(palabraSecreata))

            {
                String cadenaPistas = comparacion(arrayCaracteresSecretos, intento);
                System.out.println("Pista: " + cadenaPistas);
            }

            else

            {
                encontrada = true;
                System.out.println("Enhorabuena has encotrado la palabra secreta");
            }

        }while(!encontrada);


    }

    /**
    * Función que devuelve la cadena que se le pasa como parámetro convertida en un array
    de caracteres.
    * @param cadena
    * @return
    */
    public static char[] ConvertirStringAArray(String cadena)
    {

        char[] arrayChar = new char[cadena.length()];

        for (int i = 0; i < cadena.length(); i++) {
            
            arrayChar[i] = cadena.charAt(i);
        }

        return arrayChar;

    }

    /**
    * Funcion que devuelve una cadena de caracteres con la misma longitud que el parámetro
    cadena que se le pasa como parámetro
    * Esta cadena devuelta será de la siguiente forma:
    * '-' Si el caracter que esta en esa posición no está en el array
    * '*' Si el caracter que está en esa posicion esta en algún sitio del array
    * Si el caracter que está en esa posición está en la misma posición del array entonces se
    imprime ese carácter.
    * @param array
    * @param cadena
    * @return
    */
    public static String comparacion(char[] array, String cadena)
    {

        String resultado = "";

        boolean esta = false;

        cadena = cadena.toUpperCase();

        // recorre las posiciones de la cadena
        for (int i = 0; i < cadena.length(); i++) {

            esta = false;

            // si la las posiciones coinciden
            if(cadena.charAt(i) == array[i]){

                resultado = resultado + cadena.charAt(i);
            }

            // si no coinciden
            else{

                // por cada caracter de la cadena recorro el array de caracteres
                for (int j = 0; j < array.length; j++) {

                    esta = false;

                    // si el carcter esta
                    if(cadena.charAt(i) == array[j]){
    
                        esta = true;
                        j = array.length -1;
                    }
                }

                if(esta){

                    resultado = resultado + "*";

                }else{

                    resultado = resultado + "-";
                }

            }
            
        }

        return resultado;
    }
    
}
