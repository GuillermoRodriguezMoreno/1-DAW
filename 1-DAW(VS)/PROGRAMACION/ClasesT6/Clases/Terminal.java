package ClasesT6.Clases;

public class Terminal {

    // Atributos
    
    protected String numero;
    protected int tiempoConversacion;

    // Contructores

    public Terminal(String numero){

        this.numero = numero;

    }

    // Metodos

    public void llama(Terminal terminal, int tiempo){

        this.tiempoConversacion = this.tiempoConversacion + tiempo;
        terminal.tiempoConversacion = terminal.tiempoConversacion + tiempo;

    }

    public String mostrarInfo(){

        String resultado = "Nº " + this.numero + " - " + this.tiempoConversacion + "s de conversacion";

        return resultado;
    }

    @Override

    public String toString(){

        return mostrarInfo();
    }
}
