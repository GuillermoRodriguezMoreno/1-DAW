package modelos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaPelicula {
    
    // Atributos

    private int page;
    private List<Pelicula> results;
    private int total_pages;
    private int total_results;



    //Getters y Settes

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public List<Pelicula> getResults() {
        return results;
    }
    public void setResults(List<Pelicula> results) {
        this.results = results;
    }
    public int getTotal_pages() {
        return total_pages;
    }
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
    public int getTotal_results() {
        return total_results;
    }
    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    
}
