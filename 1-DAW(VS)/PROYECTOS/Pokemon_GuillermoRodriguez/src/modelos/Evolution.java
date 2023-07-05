package modelos;

public class Evolution {

    // Atributos

    private String num;
    private String name;

    // Constructores

    // Metodos

    @Override
    public String toString() {
        
        return "(" + this.num + ") " + this.name;
    }

    //Getters y Setters

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
    
}
