import java.util.ArrayList;
import java.util.Collections;

import clases.LeerInformacion;
import clases.Municipio;
import clases.SalidaInformacion;

public class App {
    public static void main(String[] args) throws Exception {

        String informacionCompleta = "";

        // Obtengo la lista de municipios completa
        ArrayList<Municipio> listaMunicipios = LeerInformacion.leerFicheroMunicipio(null);

        // Ordeno lista
        Collections.sort(listaMunicipios);

        // Muestro lista
        System.out.println("\n---------------- LISTA MUNICIPIOS ---------------\n");
        System.out.println(cadenaListaMucipios(listaMunicipios));

        informacionCompleta = informacionCompleta + "\n" + cadenaListaMucipios(listaMunicipios);

        // Mijas en 2022
        Municipio mijas = LeerInformacion.buscarMunicipio(listaMunicipios, "Mijas", 2022);
        System.out.println("---------------- MIJAS 2022 ---------------\n");
        System.out.println(mijas);

        informacionCompleta = informacionCompleta + "\n" + "------ MIJAS 2022 ------" + "\n" + mijas.toString() + "\n";

        // Incremento poblacion Fuengirola
        System.out.println("\n---------------- FUENGIROLA 2016-2022 ---------------\n");

        int incrementoFueng = LeerInformacion.incrementoPoblacion(listaMunicipios, 2016, 2022).get("Fuengirola");

        System.out.println("Incremento poblacion de FUENGIROLA 2016-2022: " + incrementoFueng);

        informacionCompleta = informacionCompleta + "\n" + "------ INCREMENTO POBLACION FUENGIROLA 2016-2022 ------" + "\n" 
            + String.valueOf(incrementoFueng) + "\n";

        // Incremento poblacion Mijas
        System.out.println("\n---------------- MIJAS 2016-2022 ---------------\n");

        int incrementoMijas = LeerInformacion.incrementoPoblacion(listaMunicipios, 2016, 2022).get("Mijas");

        System.out.println("Incremento poblacion de MIJAS 2016-2022: " + incrementoMijas);

        informacionCompleta = informacionCompleta + "\n" + "------ INCREMENTO POBLACION MIJAS 2016-2022 ------" + "\n" 
        + String.valueOf(incrementoMijas) + "\n";

        // Municipio menos poblado en 2021
        System.out.println("\n---------------- Municipio menos poblado en 2021 ---------------\n");

        ArrayList<Municipio> lista2021 = LeerInformacion.leerFicheroMunicipio(2021);

        Municipio menosPoblado = LeerInformacion.obtenerMenosPoblado(lista2021);

        System.out.println(menosPoblado);

        informacionCompleta = informacionCompleta + "\n" + "------ MUNICIPIO MENOS POBLADO 2021 ------" + "\n" 
        + menosPoblado.toString() + "\n";

        // Salida de la informacion
        SalidaInformacion.write("src/recursos/salida.txt", informacionCompleta);

    }

    static String cadenaListaMucipios(ArrayList<Municipio> lista){

        String cadena = "";

        for (Municipio municipio : lista) {
            
            cadena = cadena + municipio.toString() + "\n";

        }

        return cadena;
    }
}
