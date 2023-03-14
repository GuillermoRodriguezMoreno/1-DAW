package ClasesT6.UsoClases;

import java.util.Scanner;

import ClasesT6.Clases.instituto.*;

public class Instituto {
    
    public static void main(String[] args) {
        

        Persona[] instituto = new Persona[0];

        Scanner sc = new Scanner(System.in);

        String opcion = "";

        do{

            System.out.println("añade personas");

            opcion = sc.nextLine();

        }while (opcion.equals(x));


    }

    static Persona[] añadirPersona(Persona persona, Persona[] instituto){

        Persona[] nuevo = new Persona[instituto.length + 1];

        for (int i = 0; i < instituto.length; i++) {

            nuevo[i] = instituto[i];
        }

        nuevo[nuevo.length-1] = persona;

        return nuevo;
    }
}
