package ClasesT6.Clases;

public class TarjetaRegalo {
    
    // Atributos

    private float saldo;
    private int codigo;

    // Contructores

    public TarjetaRegalo(float saldo){

        this.saldo = saldo;
        this.codigo = (int) (Math.random()* 100000 + 1);
    }


    // metodos


    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return codigo;
    }

    public void setNumero(int numero) {
        this.codigo = numero;
    }

    public void gasta(float cantidad){

        if(this.getSaldo() < cantidad){

            System.out.println("No tienes suficiente saldo");

        }else{

            this.setSaldo(getSaldo() - cantidad);

        }

    }

    public TarjetaRegalo fusionaCon(TarjetaRegalo tarjeta2){

        float nuevoSaldo = this.getSaldo() + tarjeta2.getSaldo();

        TarjetaRegalo nuevaTarjeta = new TarjetaRegalo(nuevoSaldo);

        return nuevaTarjeta;
    }

    @Override

    public String toString(){

        String resultado = "Tarjeta Nº " + this.getNumero() + " - " + "Saldo disponible " + this.getSaldo();

        return resultado;
    }

    
}
