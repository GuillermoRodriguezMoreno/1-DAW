package clases;

public class Gato {
    
    // Atributos

    private String nombre;
    private String raza;
    private String sexo;

    // Constructores

    public Gato(){

    }

    public Gato(String nombre, String raza, String sexo){

        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;

    }

    // Metodos

    @Override
    public String toString(){

        return this.nombre + " " + this.sexo;
    }

    public Gato apareaCon(Gato gato2){

        try {
            

            if(this.sexo.equals(gato2.sexo)){


                throw new ExcepcionApareamientoImposible(this.nombre + " no puede aparearse con " + gato2.nombre);
                
            }

            else{

                return new Gato(this.nombre + " JR", this.raza, "no Binario");
            }
            
        } catch (ExcepcionApareamientoImposible e) {
            
            System.out.println(e.getMessage());
        }

        return null;

    }
}
