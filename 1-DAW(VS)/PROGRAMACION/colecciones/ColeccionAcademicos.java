package colecciones;

import java.util.HashMap;

public class ColeccionAcademicos {
    
    public static void main(String[] args) {
        
        Academico a1 = new Academico("pepe", 1923);
        Academico a2 = new Academico("jesus", 1940);
        Academico a3 = new Academico("antonio", 1989);
        Academico a4 = new Academico("luis", 1976);
        Academico a5 = new Academico("jorge", 1999);
        Academico a6 = new Academico("guille", 1978);

        HashMap <Character, Academico> realAcademia = new HashMap<>();


    }

    // Metodos

    static boolean añadir(HashMap realAcademia, Academico a, Character c){

        if(realAcademia.containsKey(c)){

            System.out.println("esa letra ya esta ocupada");
            
            return false;
        }

        else{

            System.out.println("añadido cono exito");
            realAcademia.put(c, a);

            return true;
        }
    }
}
