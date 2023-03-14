package ClasesT6.frioMijas_GuillermoRodriguez;

import ClasesT6.frioMijas_GuillermoRodriguez.equiposFrigorificos.*;
import ClasesT6.frioMijas_GuillermoRodriguez.personal.*;

/*
 * Falta:
 * 
 *  - Ajustar el volumen de los equipos
 *  - Penultimo apartado
 *  - Preguntas al profesor
 */

public class FrioMijas {

    public static void main(String[] args) {
        
        JefeSede jefe1 = new JefeSede("Jefazo", "Garcia", 45, 2500, "45000001X" );
        JefeSede jefe2 = new JefeSede("Jefe_malaga", "Lopez", 34, 2100, "77000002P" );

        Sede sede1 = new Sede("Madrid", "Calle ancha", "80881", jefe1);
        
        Sede sede2 = new Sede("Malaga", "Calle Larios", "29001");
        sede2.setJefe(jefe2);

        Empleado empleado1 = new Empleado("Daniel", "ape1", 35, 1000, "88000008W" );
        Empleado empleado2 = new Empleado("Juan", "ape2", 35, 1200, "21000008E" );
        Empleado empleado3 = new Empleado("Maria", "ape3", 55, 1700, "99000008R" );
        Empleado empleado4 = new Empleado("Pepe", "ape4", 45, 900, "66000008Y" );
        Empleado empleado5 = new Empleado("Pedro", "ape5", 30, 2000, "54000008T" );
        Empleado empleado6 = new Empleado("Daniel", "ape6", 24, 1000, "12000008P" );
        Empleado empleado7 = new Empleado("Pilar", "ape7", 24, 1000, "12000008P" );

        System.out.println("\n------------ Muestra empleados --------------------\n");

        System.out.println(empleado1);
        System.out.println(empleado2);

        System.out.println("\n------------ Añade empleados --------------------\n");

        sede1.addEmpleado(empleado1);
        sede1.addEmpleado(empleado2);

        sede2.addEmpleado(empleado3);
        sede2.addEmpleado(empleado4);
        sede2.addEmpleado(empleado5);
        sede2.addEmpleado(empleado6);
        sede2.addEmpleado(empleado7);

        System.out.println("\n------------ Cambio contraseñas --------------------\n");


        //Cambiamos contraseñas
        System.out.println(jefe1);
        jefe1.generarPassword(5);
        System.out.println("Nueva contraseña para jefe1");
        System.out.println(jefe1);

        System.out.println(jefe2);
        jefe2.generarPassword();
        System.out.println("Nueva contraseña para jefe2");
        System.out.println(jefe2);

        System.out.println("\n------------ Muestro Sedes --------------------\n");

        //Mostrar la información completa de cada una de las sedes + jefe + empleados
        System.out.println(sede1);
        
        System.out.println(sede2);

        /*
         * HACER *
         * Mostrar si la contraseña de los jefes es no Fuerte
         */

        System.out.println("\n-------Mostrar si la contraseña de los jefes es no Fuerte------------\n");

        jefe1.esFuerte();

        jefe2.esFuerte();

        /*
          * HACER
          * Generar contraseña de 10 elementos que sea fuerte para cada uno de los jefes
          */

        System.out.println("\n-------Generar contraseña de 10 elementos que sea fuerte para cada uno de los jefes----------\n");

        System.out.println(jefe1);
        jefe1.generarPassFuerte();
        System.out.println("Nueva contraseña para jefe1");
        System.out.println(jefe1);
        System.out.println();
        System.out.println(jefe2);
        jefe2.generarPassFuerte();
        System.out.println("Nueva contraseña para jefe2");
        System.out.println(jefe2);
        System.out.println();

        jefe1.esFuerte();

        jefe2.esFuerte();
        
        /*
         * HACER *
         * Empleados de la sede2 con sueldo entre 500 y 1500 
         */

        System.out.println("\n----------Empleados de la sede2 con sueldo entre 500 y 1500---------\n");

        for (int i = 0; i < sede2.getTrabajadores().length; i++) {
          
          if(sede2.getTrabajadores()[i].getSalario() >= 500 && sede2.getTrabajadores()[i].getSalario()<= 1500){

            System.out.println(sede2.getTrabajadores()[i]);
            
          }
        }

        /*
         * HACER *
         * Crea 5 equipos frigorificos diferentes y asignalos a la 2º sede y muéstralos a continuación   
         */

        System.out.println("\n----------Crea 5 equipos frigorificos diferentes y asignalos a la 2º sede y muéstralos a continuación---------\n");

        Arcon arcon1 = new Arcon(120, 200, 150, 50, "LG", "manual");
        Arcon arcon2 = new Arcon(70, 100, 80, 70, "BOSCH", "auto");
        Camara camara1 =  new Camara(300, 500, 600, 245, "CangreBurguer", -1, 4);
        Frigorifico frigo1 = new Frigorifico(200, 70, 100, 100, "EcoFriendly");
        Minibar mini1 = new Minibar(80, 50, 40, 30, "JaggerBomb", 2);

        sede2.addEquipo(arcon1);
        sede2.addEquipo(arcon2);
        sede2.addEquipo(camara1);
        sede2.addEquipo(frigo1);
        sede2.addEquipo(mini1);

        sede2.mostrarEquipos();

    }
    
}
