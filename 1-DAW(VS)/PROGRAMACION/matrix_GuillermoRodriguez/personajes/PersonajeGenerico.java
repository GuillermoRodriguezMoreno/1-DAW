package matrix_GuillermoRodriguez.personajes;

public class PersonajeGenerico extends Personaje{

   //Atributos

    private int probabilidadMorir;

    //Constructores

    public PersonajeGenerico(String nombre, String ciudad) {

        super(nombre, ciudad);
        this.probabilidadMorir = (int)(Math.random() * 101);

    }

    //Metodos

    @Override
    public String mostrarInformacion() {
        
        String resultado = this.getId() + " --- " + this.getNombre() + " (" + this.getCiudad() + ")" + " Supervivencia " + this.getProbabilidadMorir()
            + "%";

        return resultado;

    }

    //Getters y Setters

    public int getProbabilidadMorir() {
        return probabilidadMorir;
    }

    public void setProbabilidadMorir(int probabilidadMorir) {
        this.probabilidadMorir = probabilidadMorir;
    }
    



}
