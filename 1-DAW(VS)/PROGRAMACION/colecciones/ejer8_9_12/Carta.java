package colecciones.ejer8_9_12;

public class Carta implements Comparable <Carta>{
    
    public enum valorCarta {AS , dos, tres, cuatro, cinco, seis , siete , Sota , Caballo ,Rey};
    public enum Palo {COPAS, OROS, BASTOS, ESPADAS};

    // Atributos

    private valorCarta valor;
    private Palo palo;

    // Constructores

    public Carta(){

        //construye una carta al azar
        valorCarta[] v = valorCarta.values();
        this.valor = v[(int)(Math.random()*v.length)];

        Palo[] p = Palo.values();
        this.palo = p[(int)(Math.random()*p.length)];
    }

    // Metodos

    @Override
    public String toString() {
        return this.valor + " " + this.palo;
    }

    @Override
    public boolean equals(Object obj) {
        Carta carta = (Carta)obj;
        return  this.palo.equals(carta.palo) && this.valor.equals(carta.valor);
    }

    @Override
    public int compareTo(Carta o) {
    
        if (this.palo.compareTo(o.palo) == 0)
        {
            //si son del mismo palo miro su valor
            return this.valor.compareTo(o.valor);
        }
        else 
        {
            //si no son del mismo palo ordena por el palo,
            //al ser un enumerado mantiene su orden
            return this.palo.compareTo(o.palo);
        }

    }

    public valorCarta getValor() {
        return valor;
    }

    public void setValor(valorCarta valor) {
        this.valor = valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    

}
