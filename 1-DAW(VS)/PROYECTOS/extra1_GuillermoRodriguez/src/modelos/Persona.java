package modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Persona {
    
    // Atributos

    private int gender;
    private String known_for_department;
    private String name;
    private String original_name;
    private int popularity;
    private List<Pelicula> known_for;

    // Metodos

    @Override
    public String toString() {

        String resultado = "";

        String genero;

        if(this.gender == 2){

            genero = "Masculino";

        }

        else{

            genero = "Femenino";

        }

        // Tratamiento null

        if(this.original_name == null)

            this.original_name = "Sin datos";

        resultado =  "Nombre: " + this.name + "\nNombre original: " + original_name + "\nGenero: " + genero + "\nOcupacion: " + known_for_department + 
                "\nPopularidad: " + popularity + "\nConocido por: ";

        for (Pelicula pelicula : known_for) {
            
            resultado = resultado + pelicula.getTitle() + ", ";

        }

        return resultado;

    }

    // Getters y Setters

    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public String getKnown_for_department() {
        return known_for_department;
    }
    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOriginal_name() {
        return original_name;
    }
    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }
    public int getPopularity() {
        return popularity;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    public List<Pelicula> getKnown_for() {
        return known_for;
    }
    public void setKnown_for(List<Pelicula> known_for) {
        this.known_for = known_for;
    }

    

}
