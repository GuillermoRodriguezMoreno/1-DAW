package ClasesT6.Clases;

import java.util.Arrays;

import ClasesT6.Clases.Carta.Palo;

public class Baraja {
    
    // Atributos

    private Carta[] mazo;

    // Constructores

    public Baraja(){

        this.mazo = new Carta[0];

        for (Palo palo : Palo.values()) {
            
            for (int i = 0; i < 13; i++) {
                
                Carta carta = new Carta(palo, i);
                push(carta);
            }
        }

    }

    // Metodos

    public void push(Carta carta){

        Carta[] mazoNuevo = new Carta[this.mazo.length+1];

        for (int i = 0; i < this.mazo.length; i++) {

            mazoNuevo[i] = this.mazo[i];

        }

        mazoNuevo[mazoNuevo.length-1] = carta;

        this.mazo = mazoNuevo;

    }

    public Carta pop(){

        Carta cartaExtraida = null;

        if(this.mazo.length > 0){

            Carta[] mazoNuevo = new Carta[this.mazo.length-1];

            for (int i = 0; i < this.mazo.length-1; i++) {

                mazoNuevo[i] = this.mazo[i];
                
            }

            cartaExtraida = this.mazo[this.mazo.length-1];

            this.mazo = mazoNuevo;

        } else{

            System.out.println("no hay cartas para extraer");
        }

        return cartaExtraida;

    }

    public void barajar(){

        for(int i = 0; i < this.mazo.length; i++){

            Carta cartaAux;

            int aleatorio = (int) (Math.random() * this.mazo.length);

            cartaAux = this.mazo[i];

            this.mazo[i] = this.mazo[aleatorio];

            this.mazo[aleatorio] = cartaAux;
            
        }

    }

    @Override
    public String toString(){

        return Arrays.toString(this.mazo);
    }
}
