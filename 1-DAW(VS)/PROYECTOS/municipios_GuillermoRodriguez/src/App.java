import java.util.ArrayList;

import clases.LeerInformacion;
import clases.Municipio;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Municipio> listaMunicipios = LeerInformacion.leerFicheroMunicipio();

        System.out.println(listaMunicipios.toString());
    }
}
