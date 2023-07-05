package modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Direccion {

    // Atributos

    private Area area;

    // Constructor

    public Direccion(){

    }

    public Direccion(Area area){

        this.area = area;
        
    }

    // Metodos

    @Override
    public String toString() {

        String resultado  = "Sin datos";

        if(this.area != null){

            resultado = this.area.toString();
            
        }
        
        return resultado;
    }

    // Getters y Setters

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    

}
