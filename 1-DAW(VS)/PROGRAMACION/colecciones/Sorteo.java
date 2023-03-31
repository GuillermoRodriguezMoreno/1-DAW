package colecciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sorteo <T extends Comparable<T>>{
    
    HashSet<T> conjunto;

    public Sorteo(){

    }

    public boolean add(T e){

        return this.conjunto.add(e);
    }

    public Set<T> premiados(int numeroPremios){

        ArrayList <T>conjuntoOrdenado = new ArrayList<>(this.conjunto);

        Collections.sort(conjuntoOrdenado);
        Collections.shuffle(conjuntoOrdenado);

        Set <T> premiados = new HashSet<>();

        for (int i = 0; i < numeroPremios; i++) {

            premiados.add(conjuntoOrdenado.get(i));
        }

        return premiados;
    }


}
