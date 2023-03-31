package colecciones;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JSpinner.NumberEditor;

public class ejemplo1 {
    
    public static void main(String[] args) {
        
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        for (int index = 0; index < 20; index++) {
            
            int aleatorio = (int)((Math.random() * 10) + 1);

            listaNumeros.add(aleatorio);
            
        }

        System.out.println(listaNumeros);

        HashSet<Integer> listaSinRepetir = new HashSet<>(listaNumeros);

        System.out.println("\n--------- Sin repetir -------------\n");

        System.out.println(listaSinRepetir);

        System.out.println("\n--------------- Repetidos --------------\n");

        HashSet<Integer> listaRepetidos = new HashSet<>();
        HashSet<Integer> lista1Aparicion = new HashSet<>();


        for (int i = 0; i < listaNumeros.size(); i++){

            int numeroLeido = listaNumeros.get(i);

            if(!lista1Aparicion.contains(numeroLeido) && !listaRepetidos.contains(numeroLeido)){

                lista1Aparicion.add(numeroLeido);
            }

            else{

                listaRepetidos.add(numeroLeido);
                lista1Aparicion.remove(numeroLeido);
            }
            
        }

        System.out.println("repetidos: " + listaRepetidos);

        System.out.println("\n---------- Aparecen solo 1 vez ----------\n");

        System.out.println("lista 1 aparicion: " + lista1Aparicion);

    }
}


