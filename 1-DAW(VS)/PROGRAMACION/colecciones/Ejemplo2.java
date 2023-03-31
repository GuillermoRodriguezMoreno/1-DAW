package colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejemplo2 {
    
    public static void main(String[] args) {
        
        ArrayList <Integer> listaNumeros = new ArrayList<>();

        for (int index = 0; index < 99; index++) {
            
            int aleatorio = (int)((Math.random()*9)+1);

            listaNumeros.add(aleatorio);
        }

        System.out.println(listaNumeros);

        while(listaNumeros.contains(5)){

            for (int i = 0; i < listaNumeros.size(); i++) {
            
                if(listaNumeros.get(i) == 5){
    
                    listaNumeros.remove(i);
                }
            }
        }

        System.out.println(listaNumeros);

        Iterator <Integer>nuevaLista = listaNumeros.iterator();

        while(nuevaLista.hasNext()){

            if(nuevaLista.next() == 4){

                nuevaLista.remove();
            }
        }

        //listaNumeros = ;
    }
}
