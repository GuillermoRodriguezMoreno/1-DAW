package ClasesT6.Clases;

public class FichaDomino {
    
    // Atributos

    private int ladoA;
    private int ladoB;

    // Constructores

    public FichaDomino(int ladoA, int ladoB){

        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    // Metodos

    public int getLadoA() {
        return ladoA;
    }

    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    public void voltea(){

        int valorA = this.getLadoA();
        int valorB = this.getLadoB();

        this.setLadoA(valorB);
        this.setLadoB(valorA);
    }

    public boolean encaja(FichaDomino ficha2){

        boolean encaja = false;

        if(this.getLadoB() == ficha2.getLadoA() || this.getLadoB() == ficha2.getLadoB()){

            encaja = true;
        }

        return encaja;
    }

    @Override
    public String toString(){

        String resultado = "[" + getLadoA() + "|" + getLadoB() + "]";

        return resultado;
    }

    
}
