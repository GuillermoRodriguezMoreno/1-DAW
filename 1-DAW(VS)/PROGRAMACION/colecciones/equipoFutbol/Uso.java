package colecciones.equipoFutbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import colecciones.equipoFutbol.Jugador.Posicion;

public class Uso {

    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        Map <Integer, Jugador> plantilla = new HashMap<>();

        // Introducir 6 Jugadores

        Jugador j1 = new Jugador("1", "Pedro Martin", 178, Posicion.PORTERO);
        Jugador j2 = new Jugador("2", "Adrian Rodriguez", 175, Posicion.PORTERO);
        Jugador j3 = new Jugador("3", "Juan Laporta", 180, Posicion.DEFENSA);
        Jugador j4 = new Jugador("4", "Pablo Herrera", 185, Posicion.DEFENSA);
        Jugador j5 = new Jugador("5", "Jorge Masvidal", 172, Posicion.DELANTERO);
        Jugador j6 = new Jugador("6", "Marlon Pajares", 176, Posicion.DELANTERO);

        plantilla.put(1, j1);
        plantilla.put(13, j2);
        plantilla.put(4, j3);
        plantilla.put(3, j4);
        plantilla.put(10, j5);
        plantilla.put(11, j6);

        mostrar(plantilla);

        System.out.println("--------- Porteros ---------");

        mostrar(plantilla, "portero");

        System.out.println("---------- Delanteros --------------");

        System.out.println("Selecciona el dorsal del delantero que quieres editar");

        mostrar(plantilla, "delantero");

        int editar = sc.nextInt();
        sc.nextLine(); // limpiar

        editarJugador(plantilla, editar);

        System.out.println("---------- plantilla actualizada -----------");

        mostrar(plantilla);

        System.out.println("introduce el dorsal al que quieres añadir el nuevo jugador");

        int nuevoDorsal = sc.nextInt();
        sc.nextLine(); // limpiar

        altaJugador(plantilla, nuevoDorsal);

        System.out.println();
        System.out.println("---------- plantilla actualizada -----------");


        mostrar(plantilla);

        System.out.println("---------- Defensas --------");

        mostrar(plantilla, "defensa");

        eliminarJugador(plantilla, 3);
        eliminarJugador(plantilla, 4);

        System.out.println("---------- plantilla actualizada -----------");

        mostrar(plantilla);
    }

    // Metodos

    static void altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal){

        System.out.println("dni del jugador");

        String dni = sc.nextLine();

        System.out.println("nombre del jugador");

        String nombre = sc.nextLine();

        System.out.println("estura del jugador");

        int estatura = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        System.out.println("posicion del jugador");

        String posicion = sc.nextLine();

        Jugador nuevo = new Jugador(dni, nombre, estatura, Posicion.valueOf(posicion.toUpperCase()));

        plantilla.put(dorsal, nuevo);

    }

    static void altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador){

        plantilla.put(dorsal, jugador);

    }

    static Jugador eliminarJugador(Map<Integer, Jugador> plantilla, Integer dorsal){

        if(plantilla.containsKey(dorsal)){

            Jugador eliminado = plantilla.get(dorsal);

            plantilla.remove(dorsal);

            return eliminado;

        }

        else{

            System.out.println("Dorsal no encontrado");

        }

        return null;

        
    }

    static void mostrar(Map<Integer, Jugador> plantilla){

        String resultado = "";

        for (Integer elemento : plantilla.keySet()) {

            resultado = resultado + "Dorsal " + elemento + " Jugador: " + plantilla.get(elemento).toString();
            
        }

        System.out.println(resultado);

    }

    static void mostrar(Map<Integer, Jugador> plantilla, String posicion){

        String resultado = "";

        for (Integer elemento : plantilla.keySet()) {
            
            if(plantilla.get(elemento).getPosicion() == Posicion.valueOf(posicion.toUpperCase())){

                resultado = resultado + "Dorsal " + elemento + " Jugador: " + plantilla.get(elemento).toString();
            }

        }

        System.out.println(resultado);

    }

    static boolean editarJugador(Map<Integer, Jugador> plantilla, Integer dorsal){

        boolean existe = false;

        if(plantilla.containsKey(dorsal)){

            Jugador editar = plantilla.get(dorsal);

            System.out.println("que dato quieres modificar?");

            String modificar = sc.nextLine();

            modificar.toLowerCase();

            switch (modificar){

                case "nombre":

                    System.out.println("introduce el nuevo nombre");

                    editar.setNombre(sc.nextLine());

                    break;

                case "estatura":

                    System.out.println("introduce la nueva estatura");

                    editar.setEstatura(sc.nextInt());
                    sc.nextLine(); // limpiar

                    break;

                case "posicion":

                    System.out.println("introduce la nueva posicion");

                    editar.setPosicion(Posicion.valueOf(sc.nextLine().toUpperCase()));

                    break;

                default:

                    System.out.println("dato incorrecto");

                    break;

            }

            existe = true;

            return existe;

        }

        else{

            System.out.println("dorsal no encontrado");
        }

        return existe;

    }
}
