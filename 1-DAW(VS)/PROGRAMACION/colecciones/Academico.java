package colecciones;

import java.net.http.HttpResponse.PushPromiseHandler;

public class Academico implements Comparable<Academico>{
    
    // atributos

    private String nombre;
    private int añoIngreso;

    public Academico(String nombre, int año){

        this.nombre = nombre;
        this.añoIngreso = año;
    }

    // metodos
    
    @Override
    public int compareTo(Academico a){

        return this.nombre.compareTo(a.nombre);
        
    }


}
