package modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pelicula {
    
    // Atributos

    private String original_language;
    private String original_tittle;
    private String overview;
    private String release_date;
    private String title;

    // Costructores


    // Metodos

    @Override
    public String toString() {

        // Tratamiento null

        if(this.original_tittle == null)

            this.original_tittle = "Sin datos";

        if(this.original_language == null)

            this.original_language = "Sin datos";

        if(this.overview == null)

            this.overview = "Sin datos";

        return "Titulo: " + title + "\nTitulo original: " + original_tittle + "\nIdioma original: " + original_language
            + "\nFecha de salida: " + release_date + "\nDescripcion: " + overview;
            
    }

    // Getters y Setters

    public String getOriginal_language() {
        return original_language;
    }
    
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public String getOriginal_tittle() {
        return original_tittle;
    }
    public void setOriginal_tittle(String original_tittle) {
        this.original_tittle = original_tittle;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
