package clases;

public class ExcepcionApareamientoImposible extends Exception{

    public ExcepcionApareamientoImposible(){

        super();
        
    }

    public ExcepcionApareamientoImposible(String mensaje){

        super(mensaje);
    }

    @Override
    public String toString(){

        return "Apareamiento imposible, son del mismo sexo";
    }
    
}
