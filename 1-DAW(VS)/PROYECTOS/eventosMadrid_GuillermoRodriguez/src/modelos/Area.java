package modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Area {

    // Atributos

    @JsonProperty("postal-code")
    private String cp;
    @JsonProperty("street-address")
    private String calle;

    // Constructores

    public Area(){


    }

    public Area(String cp, String calle){

        this.cp = cp;
        this.calle = calle;

    }

    // Metodos

    @Override
    public String toString() {
        
        return "CP: " + this.cp + ", " + this.calle;
        
    }

    // Getters y Setters

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    

}
