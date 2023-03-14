package ClasesT6.frioMijas_GuillermoRodriguez.equiposFrigorificos;

public class Minibar extends EquipoFrigorifico{
    
    // Atributos

    private int numeroBaldas;

    // Constructores

    public Minibar(float alto, float ancho, float profundidad, float frigorias, String marca, int numeroBaldas){

        super(alto, ancho, profundidad, frigorias, marca);
        this.numeroBaldas = numeroBaldas;

    }

    // Metodos

    public float consumo(){

        float consumo = 0.0f;

        consumo = this.getFrigorias() * 2;

        return consumo;
    }

    @Override
    public String toString(){

        return "Minibar --> " + super.toString() + ", Nº Baldas: " + this.getNumeroBaldas();
    }

    // Getters y Setters

    public int getNumeroBaldas() {
        return numeroBaldas;
    }

    public void setNumeroBaldas(int numeroBaldas) {
        this.numeroBaldas = numeroBaldas;
    }

    


}
