package modelos;

public class Corredor extends Ciclista implements Comparable<Corredor>{

    // Atributos

    private int dorsal;
    private int tiempo;

    // Constructor

    public Corredor(String nombre, String codigoEquipo, float peso, String pais) {

        super(nombre, codigoEquipo, peso, pais);
        
    }

    public Corredor(Ciclista ciclista, int dorsal){

        super(ciclista.getNombre(), ciclista.getCodigoEquipo(), ciclista.getPeso(), ciclista.getPais());
        this.dorsal = dorsal;
        this.tiempo = 0;

    }

    // Metodos

    @Override
    public boolean equals(Object obj) {

        Corredor c2 = (Corredor) obj;

        boolean iguales = false;
        
        if(this.nombre.equals(c2.getNombre()) && this.codigoEquipo.equals(c2.getCodigoEquipo()) && this.dorsal == c2.getDorsal()){

            iguales = true;

        }

        return iguales;
        
    }

    @Override
    public int compareTo(Corredor o) {
        
        return this.tiempo - o.getTiempo();

    }

    
    
    // Getters y Setters

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
}
