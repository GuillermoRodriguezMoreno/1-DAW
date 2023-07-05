package modelos;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon implements Comparable<Pokemon>{
    
    // Atributos

    private Integer id;
    private String num;
    private String name;
    private String[] type;
    private String height;
    private String weight;
    private String[] weaknesses;
    private Evolution[] prev_evolution;
    private Evolution[] next_evolution;

    // Constructores

    // Metodos

    @Override
    public String toString() {

        String resultado = "";
        
        resultado =  "(" + this.num + ") " + this.name + ", altura: " + this.height + ", tipo: " + Arrays.toString(this.type) + 
        ", debil: " + Arrays.toString(this.weaknesses);

        if(this.getPrev_evolution() != null){

            resultado = resultado + ", preEv: " + Arrays.toString(this.getPrev_evolution());

        }

        if(this.getNext_evolution() != null){

            resultado = resultado + ", Ev: " + Arrays.toString(this.getNext_evolution());

        }

        return resultado;

    }

    @Override
    public int compareTo(Pokemon o) {
        
        return this.id - o.getId();
        
    }
    // Getters y Setters

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getType() {
        return type;
    }
    public void setType(String[] type) {
        this.type = type;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String[] getWeaknesses() {
        return weaknesses;
    }
    public void setWeaknesses(String[] weaknesses) {
        this.weaknesses = weaknesses;
    }
    public Evolution[] getPrev_evolution() {
        return prev_evolution;
    }
    public void setPrev_evolution(Evolution[] prev_evolution) {
        this.prev_evolution = prev_evolution;
    }
    public Evolution[] getNext_evolution() {
        return next_evolution;
    }
    public void setNext_evolution(Evolution[] next_evolution) {
        this.next_evolution = next_evolution;
    }
    
    

}
