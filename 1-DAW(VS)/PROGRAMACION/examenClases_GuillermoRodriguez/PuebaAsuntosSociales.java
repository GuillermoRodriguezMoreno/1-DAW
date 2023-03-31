package examenClases_GuillermoRodriguez;

import java.time.LocalDate;

import examenClases_GuillermoRodriguez.trabajadores.Trabajador;
import examenClases_GuillermoRodriguez.usuarios.Familia;
import examenClases_GuillermoRodriguez.usuarios.Menor;
import examenClases_GuillermoRodriguez.usuarios.Mujer;

public class PuebaAsuntosSociales{
    
        public static void main(String[] args) {
            
            AsuntosSociales asuntosSociales = new AsuntosSociales("Ayun. Mijas", "Calle grande");

            Trabajador trab1 = new Trabajador("Joaquin", "555Z", "titulo1", 2018, "PUEBLO");

            Trabajador trab2 = new Trabajador("MariPaz", "66BZ", "titulo1", 2015, "FARO");

            Trabajador trab3 = new Trabajador("PEPE", "111K", "titulo2", 2017, "PUEBLO");

            Trabajador trab4 = new Trabajador("PEPE", "555Z", "titulo2", 2017, "PUEBLO");

            asuntosSociales.contratarTrabajador(trab1);
            asuntosSociales.contratarTrabajador(trab2);
            asuntosSociales.contratarTrabajador(trab3); 
            asuntosSociales.contratarTrabajador(trab4); //mismo dni no debe de contratarse


            Menor menor1 = new Menor("Andres", "Luque", "123Z", trab1, LocalDate.of(2023, 1, 10), LocalDate.of(2015, 2, 10), "Luis");
            Menor menor2 = new Menor("María", "González", "XYZ456", trab3, LocalDate.of(2023, 2, 1), LocalDate.of(2015, 4, 1), "Pedro");
            Menor menor3 = new Menor("Lucas", "García", "DEF789", trab1, LocalDate.of(2023, 2, 10), LocalDate.of(2015, 5, 12), "Marta");
            Menor menor4 = new Menor("Carolina", "Hernández", "GHI123", trab2, LocalDate.of(2023, 2, 11), LocalDate.of(2015, 6, 20), "Jorge");
            Menor menor5 = new Menor("María", "González", "XYZ456", trab3, LocalDate.of(2023, 2, 13), LocalDate.of(2015, 4, 1), "Pedro");


            Familia fam1 = new Familia("Garcia", "Garcia", "567T", trab1, LocalDate.of(2023, 3, 1), "Ray", 5);
            Familia familia1 = new Familia("Martínez", "Hernández", "123A", trab2, LocalDate.of(2023, 3, 1), "Sofía", 4);
            Familia familia2 = new Familia("González", "Rodríguez", "456B", trab3, LocalDate.of(2023, 3, 3), "Juan", 3);
            Familia familia3 = new Familia("Pérez", "López", "789C", trab1, LocalDate.of(2023, 3, 5), "Ana", 2);
            Familia familia4 = new Familia("Ramírez", "Castillo", "123D", trab2, LocalDate.of(2023, 3, 6), "Miguel", 6);
            Familia familia5 = new Familia("Sánchez", "Martínez", "456E", trab3, LocalDate.of(2023, 3, 8), "Lucía", 4);


            Mujer mujer1 = new Mujer("Patricia", "Lorca", "5657T", trab3, LocalDate.of(2023, 3, 10), false, 4);
            Mujer mujer2 = new Mujer("Laura", "González", "7698W", trab2, LocalDate.of(2023, 3, 15), true, 2);
            Mujer mujer3 = new Mujer("María", "Sánchez", "4578G", trab1, LocalDate.of(2023, 3, 20), false, 3);
            Mujer mujer4 = new Mujer("Sofía", "Ramírez", "2345F", trab3, LocalDate.of(2023, 3, 25), true, 1);


            asuntosSociales.insertarUsuario(menor1);
            asuntosSociales.insertarUsuario(menor2);
            asuntosSociales.insertarUsuario(menor3);
            asuntosSociales.insertarUsuario(menor4);
            asuntosSociales.insertarUsuario(menor5);

            asuntosSociales.insertarUsuario(fam1);
            asuntosSociales.insertarUsuario(familia1);
            asuntosSociales.insertarUsuario(familia2);
            asuntosSociales.insertarUsuario(familia3);
            asuntosSociales.insertarUsuario(familia4);
            asuntosSociales.insertarUsuario(familia5);

            asuntosSociales.insertarUsuario(mujer1);
            asuntosSociales.insertarUsuario(mujer2);
            asuntosSociales.insertarUsuario(mujer3);
            asuntosSociales.insertarUsuario(mujer4);

            System.out.println("---- USUARIOS -----");
            asuntosSociales.mostrarUsuarios();


            System.out.println("---- Trabajadores -----");
            asuntosSociales.muestraTrabajadores();

            System.out.println(" --- Cantidad de usuarios por tipo ----");
            System.out.println(asuntosSociales.listadoUsuarios());

            asuntosSociales.hacerVisita();
            asuntosSociales.hacerVisita();

            System.out.println("---- USUARIOS con 2 visitas-----");
            asuntosSociales.mostrarUsuarios();

            System.out.println("---- Buscamos usuarios-----");
        
            /*
            * Muestra la informacion del usuario con dni 456E
            */
            
            System.out.println(asuntosSociales.obtenerUsuario("456E").muestraInformacion());

            /*
            * Muestra la informacion del usuario con codigo 10 
            */

            System.out.println(asuntosSociales.obtenerUsuario(10).muestraInformacion());

            /*
            * Muestra la informacion del usuario con codigo 101
            */

            System.out.println(asuntosSociales.obtenerUsuario(101));

            asuntosSociales.despedirTrabajador();

            asuntosSociales.muestraInfoUsuario(mujer4);
            asuntosSociales.muestraInfoUsuario(menor1);
            asuntosSociales.muestraInfoUsuario(familia2);
        }

        /*
            SALIDA ESPERADA

        * El trabajador con DNI: 555Z ya está insertado
            El usuario con DNI XYZ456 ya está en el sistema
            ---- USUARIOS -----
            1 Andres Luque (123Z) - Joaquin Ult. Visita: 10/enero/23
            2 María González (XYZ456) - PEPE Ult. Visita: 01/febrero/23
            3 Lucas García (DEF789) - Joaquin Ult. Visita: 10/febrero/23
            4 Carolina Hernández (GHI123) - MariPaz Ult. Visita: 11/febrero/23
            6 Garcia Garcia (567T) - Joaquin Ult. Visita: 01/marzo/23
            7 Martínez Hernández (123A) - MariPaz Ult. Visita: 01/marzo/23
            8 González Rodríguez (456B) - PEPE Ult. Visita: 03/marzo/23
            9 Pérez López (789C) - Joaquin Ult. Visita: 05/marzo/23
            10 Ramírez Castillo (123D) - MariPaz Ult. Visita: 06/marzo/23
            11 Sánchez Martínez (456E) - PEPE Ult. Visita: 08/marzo/23
            12 Patricia Lorca (5657T) - PEPE Ult. Visita: 10/marzo/23
            13 Laura González (7698W) - MariPaz Ult. Visita: 15/marzo/23
            14 María Sánchez (4578G) - Joaquin Ult. Visita: 20/marzo/23
            15 Sofía Ramírez (2345F) - PEPE Ult. Visita: 25/marzo/23
            ---- Trabajadores -----
            Joaquin(555Z) titulo1(2018)  Sueldo total: 1075.0
            MariPaz(66BZ) titulo1(2015)  Sueldo total: 1060.0
            PEPE(111K) titulo2(2017)  Sueldo total: 1075.0
            --- Cantidad de usuarios por tipo ----
            Menores: 4
            Mujeres: 4
            Familias: 6
            Se ha visitado al usuario: 1 Andres Luque (123Z) - Joaquin Ult. Visita: 10/enero/23 Tutor: Luis Fecha Nac.10/enero/23
            Se ha visitado al usuario: 2 María González (XYZ456) - PEPE Ult. Visita: 01/febrero/23 Tutor: Pedro Fecha Nac.01/febrero/23
            ---- USUARIOS con 2 visitas-----
            3 Lucas García (DEF789) - Joaquin Ult. Visita: 10/febrero/23
            4 Carolina Hernández (GHI123) - MariPaz Ult. Visita: 11/febrero/23
            6 Garcia Garcia (567T) - Joaquin Ult. Visita: 01/marzo/23
            7 Martínez Hernández (123A) - MariPaz Ult. Visita: 01/marzo/23
            8 González Rodríguez (456B) - PEPE Ult. Visita: 03/marzo/23
            9 Pérez López (789C) - Joaquin Ult. Visita: 05/marzo/23
            10 Ramírez Castillo (123D) - MariPaz Ult. Visita: 06/marzo/23
            11 Sánchez Martínez (456E) - PEPE Ult. Visita: 08/marzo/23
            12 Patricia Lorca (5657T) - PEPE Ult. Visita: 10/marzo/23
            13 Laura González (7698W) - MariPaz Ult. Visita: 15/marzo/23
            14 María Sánchez (4578G) - Joaquin Ult. Visita: 20/marzo/23
            15 Sofía Ramírez (2345F) - PEPE Ult. Visita: 25/marzo/23
            1 Andres Luque (123Z) - Joaquin Ult. Visita: 29/marzo/23
            2 María González (XYZ456) - PEPE Ult. Visita: 29/marzo/23
            ---- Buscamos usuarios-----


            Se ha despedido el trabajador: Joaquin(555Z) titulo1(2018)
            15 Ramírez (2345F) Mujer- TrabSoc: PEPE
            1 Luque (123Z) Menor- TrabSoc: Joaquin
            8 Rodríguez (456B) Familia- TrabSoc: PEPE

        * 
        */
        
    }
