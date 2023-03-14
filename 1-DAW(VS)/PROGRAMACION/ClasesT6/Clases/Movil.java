package ClasesT6.Clases;

public class Movil extends Terminal {

    public enum Tarifa {RATA, MONO, BISONTE}

    // Atributos

    int tiempoTarificado;
    Tarifa tarifa;
    float coste;

    // Constructores

    public Movil(String numero, String tarifa){

        super(numero);
        Tarifa nuevo = Tarifa.valueOf(tarifa.toUpperCase());
        this.tarifa = nuevo;

        switch (nuevo){

            case RATA:

                this.coste = 0.06f;

                break;

            case MONO:

                this.coste = 0.12f;

                break;

            case BISONTE:

                this.coste = 0.30f;

                break;

        }
    }

    // Metodos

    @Override
    public void llama(Terminal terminal, int tiempo){

        this.tiempoConversacion = this.tiempoConversacion + tiempo;
        terminal.tiempoConversacion = terminal.tiempoConversacion + tiempo;

        this.tiempoTarificado = this.tiempoTarificado + tiempo;

    }

    @Override
    public String toString(){

        return mostrarInfo() + " -  tarificados " + (this.coste * (float)((float)this.tiempoTarificado/60)) + " euros";
    }

    
}
