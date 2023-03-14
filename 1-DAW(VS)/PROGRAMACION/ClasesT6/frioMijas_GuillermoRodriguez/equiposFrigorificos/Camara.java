package ClasesT6.frioMijas_GuillermoRodriguez.equiposFrigorificos;

public class Camara extends EquipoFrigorifico{
    
    // Atributos

    private float temperaturaMin;
    private float temperaturaMax;
    private float volumen;

    // Constructores

    public Camara(float alto, float ancho, float profundidad, float frigorias, String marca, float temperaturaMin, float temperaturaMax){

        super(alto, ancho, profundidad, frigorias, marca);
        this.temperaturaMin = temperaturaMin;
        this.temperaturaMax = temperaturaMax;

        this.setVolumen(); // volumen segun medidas
    }

    // Metodos

    public float consumo(){

        float consumo = this.frigorias * 5;

        return consumo;
        
    }

    @Override
    public String toString(){

        return "Camara --> " + super.toString() + ", volumen: " + this.getVolumen() + ", T.Min-Max: " + 
        this.getTemperaturaMin() + " - " + this.getTemperaturaMax();
    }


    // Getters y Setters

    public float getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(float temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public float getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(float temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen() {

        // calculo el volumen segun las medidas
        this.volumen = (this.getAlto() * this.getAncho() * this.getProfundidad())/1000000;
    }

    
}
