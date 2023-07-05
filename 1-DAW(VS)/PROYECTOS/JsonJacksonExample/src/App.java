import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.Coche;
import modelo.Employee;
import modelo.People;
import modelo.Persona;
import utils.jsonUtils;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, JSon!");

        /*

        //Leer Json que contiene 1 objeto y convertirlo en objeto 
        jsonUtils.LeerEmpleadoFromJsonFile("src/recursos/employee.txt");

        System.out.println("==============================================");



        //Leer Json que contiene 1 array de objetos y convertirlo en un list<objeto> 
        List<Employee> listaEmpleados = jsonUtils.LeerListEmpleadoFromJsonFile("src/recursos/employeeArray.txt");
        System.out.println("====== ARRAY EMPLEADOS ========================");

        for (Employee employee : listaEmpleados) {
            System.out.println(employee);
        }

        System.out.println("==============================================");

        //Convertir objeto a Json
        jsonUtils.convertToJson();
         */

        /* 
        Coche coche1 = jsonUtils.LeerCocheFromJsonFile("src/recursos/coche.json");

        System.out.println(coche1);

        List<Coche> listaCoches = jsonUtils.LeerListCocheFromJsonFile("src/recursos/cochesArray.json");

        System.out.println(listaCoches.toString());

        listaCoches.add(coche1);

        jsonUtils.crearFicheroCoches(listaCoches);

        */

        People listaGente = jsonUtils.LeerPeopleFromJsonFile("src/recursos/personas.json");

        People listaGente24 = new People();

        listaGente24.setPeople(new ArrayList<>());

        System.out.println(listaGente.toString());

        for (Persona elemento : listaGente.getPeople()) {


            if(elemento.getAge() == 24){

                listaGente24.getPeople().add(elemento);
            }
        }

        System.out.println(listaGente24.toString());

        jsonUtils.crearFicheroPeople(listaGente24);

        System.out.println("=========== mapa ================");

        HashMap<String, Persona> mapa = new HashMap<>();

        mapa.put("1", listaGente.getPeople().get(0));
        mapa.put("2", listaGente.getPeople().get(1));




        jsonUtils.crearFicheroMapa(mapa);

        HashMap<String, Persona> mapa2 = jsonUtils.LeerMapaFromJsonFile("src/recursos/nuevoMapa.json");

        
    }
}
