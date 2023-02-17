package ClasesT6.Clases;

public class Carta {
    
    // Atributos

    enum Palo{OROS, BASTOS, COPAS, ESPADAS};

    private int numero;
    private Palo palo;

    // Constructores

    public Carta(){

    }

    public Carta(Palo palo, int numero){

        this.palo = palo;
        this.numero = numero;
    }

    // metodos


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public boolean esMenor(Carta carta){

        boolean esMenor = false;

        if(this.numero < carta.getNumero()){

            esMenor = true;
        }

        return esMenor;
    }

    @Override
    public String toString(){

        String resultado = "";

        resultado = this.numero + " de " + this.palo;

        return resultado;
    }

    
}
