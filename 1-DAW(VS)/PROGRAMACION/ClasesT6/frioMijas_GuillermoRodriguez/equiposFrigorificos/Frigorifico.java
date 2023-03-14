package ClasesT6.frioMijas_GuillermoRodriguez.equiposFrigorificos;

public class Frigorifico extends EquipoFrigorifico{
    
    // Atributos

    private float volumen;
    
    // Constructores

    public Frigorifico(float alto, float ancho, float profundidad, float frigorias, String marca){

        super(alto, ancho, profundidad, frigorias, marca);

        this.setVolumen();
    }

    // Metodos

    public float consumo(){

        float consumo = this.getFrigorias() * 3;

        return consumo;        
    }

    @Override
    public String toString(){

        return "Frigorifico --> " + super.toString() + ", volumen: " + this.getVolumen();
    }

    // Getters y Setters

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen() {

        this.volumen = (this.getAlto() * this.getAncho() * this.getProfundidad())/1000000;
    }

    
}
