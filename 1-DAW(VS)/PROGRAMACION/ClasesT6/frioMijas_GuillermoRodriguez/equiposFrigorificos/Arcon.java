package ClasesT6.frioMijas_GuillermoRodriguez.equiposFrigorificos;

public class Arcon extends EquipoFrigorifico{
    
    // Atributos

    private String tipoApertura;

    // Constructores

    public Arcon(float alto, float ancho, float profundidad, float frigorias, String marca, String tipoApertura){

        super(alto, ancho, profundidad, frigorias, marca);
        this.tipoApertura = tipoApertura;

    }

    // Metodos

    public float consumo(){

        float consumo = 0.0f;

        consumo = this.frigorias * 2;

        return consumo;
    }

    @Override
    public String toString(){

        return "Arcon --> " + super.toString() + ", tipo apertura: " + this.getTipoApertura();
    }

    // Getters y Setters

    public String getTipoApertura() {
        return tipoApertura;
    }

    public void setTipoApertura(String tipoApertura) {
        this.tipoApertura = tipoApertura;
    }

}
