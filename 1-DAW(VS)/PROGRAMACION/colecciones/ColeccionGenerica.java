package colecciones;

import java.util.Arrays;


public class ColeccionGenerica <T>{

    private T[] lista;

    // Constructores
    public ColeccionGenerica(T[] lista){

        this.lista = lista;
    }
    
    // Metodos

    public void insertarAlPrincio(T e){

        T[] nuevalista = Arrays.copyOf(lista, lista.length + 1);

        for (int i = 0; i < lista.length; i++) {
            
            nuevalista[i+1] = lista[i];
        }

        nuevalista[0] = e;

        this.lista = nuevalista;
    }

    public void insertarAlFinal(T e){

        T[] nuevalista = Arrays.copyOf(lista, lista.length + 1);

        nuevalista[lista.length] = e;

        this.lista = nuevalista;

    }

    
}
