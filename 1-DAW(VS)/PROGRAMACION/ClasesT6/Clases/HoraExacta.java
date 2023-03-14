package ClasesT6.Clases;

public class HoraExacta extends Hora{
    
    int hora;
    int minuto;
    int segundo;

    public HoraExacta(int hora, int minuto, int segundo){

        super(hora, minuto);
        this.segundo = segundo;
    }

    

    public int getSegundo() {
        return segundo;
    }



    public boolean setSegundo(int valor){

        boolean correcto = false;

        if(valor < 60 && valor >= 0){

            this.segundo = valor;
            correcto = true;

        }

        return correcto;
    }

    
    

    
    void equals(HoraExacta hora){

        if(this.getHora() == hora.getHora() && this.getMinuto() == hora.getMinuto() && this.getSegundo() == hora.getSegundo()){

            System.out.println("las horas son iguales");

        }else{

            System.out.println("las horas no son iguales");
        }
    }

    @Override
    public String toString(){

        return this.getHora() + ":" + this.getMinuto() + ":" + this.getSegundo();
    }

    @Override
    public boolean equals(Object object){

        boolean sonIguales = false;

        Hora hora = (Hora) object;

        // se haria comparaciones para saber si las horas son iguales

        return sonIguales;
    }
}
