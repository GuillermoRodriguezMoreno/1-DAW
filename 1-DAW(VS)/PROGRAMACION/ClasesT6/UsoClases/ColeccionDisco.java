package ClasesT6.UsoClases;

import java.util.Arrays;
import java.util.Scanner;

import ClasesT6.Clases.Disco;

public class ColeccionDisco {
    
    public static void main(String[] args) {
        
        //Crea el array DINAMICO de discos
        Disco[] coleccionDisco = new Disco[0];

        // Carga varios discos
        //discos[0] = new Disco("GASA41", "Wim Mertens", "Maximazing the Audience", "instrumental", 50);
        //discos[1] = new Disco("FGHQ64", "Metallica", "Black album", "hard rock", 46);
        //discos[2] = new Disco("TYUI89", "Supersubmarina", "Viento de cara", "pop rock", 42);

        Disco d1 = new Disco("GASA41", "Wim Mertens", "Maximazing the Audience", "instrumental", 50);
        Disco d2 = new Disco("FGHQ64", "Metallica", "Black album", "hard rock", 46);
        Disco d3 = new Disco("TYUI89", "Supersubmarina", "Viento de cara", "pop rock", 42);

        // Insertar Discos
        coleccionDisco = añadirDisco(coleccionDisco, d1);

        int opcion;

        Scanner s = new Scanner(System.in);

        String codigoIntroducido;
        String autorIntroducido;
        String tituloIntroducido;
        String generoIntroducido;
        int duracionIntroducida;

        do {

            System.out.println("\nCOLECCIÓN DE DISCOS");
            System.out.println("===================");
            System.out.println("1. Listado");
            System.out.println("2. Nuevo disco");
            System.out.println("3. Modificar");
            System.out.println("4. Borrar");
            System.out.println("5. Salir");
            System.out.print("Introduzca una opción: ");

            opcion = Integer.parseInt(s.nextLine());
        
            switch (opcion) {

            case 1:

                System.out.println("\nLISTADO");
                System.out.println("=======");

                System.out.println("como quieres listar?");
                System.out.println("1- por autor");
                System.out.println("2- completo");
                
                int opcionLista = Integer.parseInt(s.nextLine());

                switch(opcionLista){

                    case 1:

                        System.out.println("introduce el autor");

                        String listaAutor = s.nextLine();

                        listarAutor(coleccionDisco, listaAutor);

                        break;

                    case 2:

                        listarDiscos(coleccionDisco);

                        break;
                }

                

            break;

            case 2:

                System.out.println("\nNUEVO DISCO");
                System.out.println("===========");

                System.out.println("Por favor, introduzca los datos del disco.");  
                System.out.print("Código: ");

                codigoIntroducido = s.nextLine();

                System.out.print("Autor: ");

                autorIntroducido = s.nextLine();

                System.out.print("Título: ");

                tituloIntroducido = s.nextLine();

                System.out.print("Género: ");

                generoIntroducido = s.nextLine();

                System.out.print("Duración: ");

                duracionIntroducida = Integer.parseInt(s.nextLine());

                Disco nuevoDisco = new Disco(codigoIntroducido, autorIntroducido, tituloIntroducido, generoIntroducido, duracionIntroducida);

                coleccionDisco = añadirDisco(coleccionDisco, nuevoDisco);

                break;

            case 3:

                System.out.println("\nMODIFICAR");
                System.out.println("===========");

                System.out.print("Por favor, introduzca el código del disco cuyos datos desea cambiar: ");

                codigoIntroducido = s.nextLine();

                int i = -1;

                do {

                    i++;

                } while (!((coleccionDisco[i].getCodigo()).equals(codigoIntroducido)));

                System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");

                System.out.println("Código: " + coleccionDisco[i].getCodigo());

                System.out.print("Nuevo código: ");

                codigoIntroducido = s.nextLine();

                if (!codigoIntroducido.equals("")) {

                    coleccionDisco[i].setCodigo(codigoIntroducido);

                }

                System.out.println("Autor: " + coleccionDisco[i].getAutor());

                System.out.print("Nuevo autor: ");

                autorIntroducido = s.nextLine();

                if (!autorIntroducido.equals("")) {

                    coleccionDisco[i].setAutor(autorIntroducido);

                }

                System.out.println("Título: " + coleccionDisco[i].getTitulo());

                System.out.print("Nuevo título: ");

                tituloIntroducido = s.nextLine();

                if (!tituloIntroducido.equals("")) {

                    coleccionDisco[i].setTitulo(tituloIntroducido);

                }

                System.out.println("Género: " + coleccionDisco[i].getGenero());

                System.out.print("Nuevo género: ");

                generoIntroducido = s.nextLine();

                if (!generoIntroducido.equals("")) {

                    coleccionDisco[i].setGenero(generoIntroducido);
                }

                System.out.println("Duración: " + coleccionDisco[i].getDuracion());

                System.out.print("Duración: ");

                final String duracionIntroducidaString = s.nextLine();

                if (!duracionIntroducidaString.equals("")) {

                    coleccionDisco[i].setDuracion(Integer.parseInt(duracionIntroducidaString));
                }

            break;

            case 4:

                System.out.println("\nBORRAR");
                System.out.println("======");

                boolean codigoPresente = true;

                do{

                    System.out.print("Por favor, introduzca el código del disco que desea borrar: ");

                    codigoIntroducido = s.nextLine();

                    codigoPresente = comprobarCodigo(coleccionDisco, codigoIntroducido);

                    if (!codigoPresente){

                        System.out.println("El codigo no se encuentra en la lista");
                    }

                }while(!codigoPresente);

                

                coleccionDisco = borrarDisco(coleccionDisco, codigoIntroducido);

                System.out.println("Album borrado.");

            break;

            default:

            } // switch

        } while (opcion != 5);
        
    }

    // Funciones

    // Añadir disco
    static Disco[] añadirDisco(Disco coleccionDisco[], Disco nuevoDisco){

        Disco[] nuevaColeccionDisco = new Disco[coleccionDisco.length + 1];

        for (int i = 0; i < coleccionDisco.length; i++) {

            nuevaColeccionDisco[i] = coleccionDisco[i];
        }

        nuevaColeccionDisco[coleccionDisco.length] = nuevoDisco;

        return nuevaColeccionDisco;
    }

    // Listar Discos
    static void listarDiscos(Disco[] coleccionDisco){

        for(int i = 0; i < coleccionDisco.length; i++){

            System.out.println(coleccionDisco[i]);
        }
    }

    // Comprobar existe Codigo
    static boolean comprobarCodigo(Disco[] coleccionDisco, String codigoIntroducido){

        boolean esta = false;

        for (int i = 0; i < coleccionDisco.length; i++) {
            
            if(coleccionDisco[i].getCodigo().equals(codigoIntroducido)){

                esta = true;
            }
        }

        return esta;
    }

    // Borrar Disco
    static Disco[] borrarDisco(Disco[] coleccionDiscos, String codigoIntroducido){

        Disco[] nuevaColeccionDisco = new Disco[coleccionDiscos.length - 1];

        for (int i = 0; i < nuevaColeccionDisco.length; i++) {
            
            if(coleccionDiscos[i].getCodigo()!= codigoIntroducido){

                nuevaColeccionDisco[i] = coleccionDiscos[i];

            }
        }

        return nuevaColeccionDisco;
    }

    static void listarAutor(Disco[] coleccionDisco, String autor){

        for (int i = 0; i < coleccionDisco.length; i++) {
            
            if(coleccionDisco[i].getAutor().equalsIgnoreCase(autor)){

                System.out.println(coleccionDisco[i]);
            }
        }
    }
}
