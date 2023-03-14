package ClasesT6.frioMijas_GuillermoRodriguez.equiposFrigorificos;

public abstract class EquipoFrigorifico {

    // Atributos
    
    protected float alto;
    protected float ancho;
    protected float profundidad;
    protected float frigorias;
    protected String marca;

    // Contructores

    public EquipoFrigorifico(float alto, float ancho, float profundidad, float frigorias, String marca){

        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.frigorias = frigorias;
        this.marca = marca;

    }

    // Metodos

    public abstract float consumo();

    @Override
    public String toString(){

        return "Medidas: " + this.getAlto() + " alto X " + this.getAncho() + " ancho X " + this.getProfundidad() + " largo, Frigorias "
            + this.getFrigorias() + ", Marca " + this.getMarca() + ", Consumo: " + consumo();
    }

    // Getters y Setters

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(float profundidad) {
        this.profundidad = profundidad;
    }

    public float getFrigorias() {
        return frigorias;
    }

    public void setFrigorias(float frigorias) {
        this.frigorias = frigorias;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    
}
