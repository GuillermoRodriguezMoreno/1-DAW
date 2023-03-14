package ClasesT6.Clases;

public class Hora {
    
    public int hora;
    public int minuto;

    public Hora(int hora, int minuto){

        this.hora = hora;
        this.minuto = minuto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    boolean setMinuto(int valor){

        boolean correcto = false;

        if(valor < 60 && valor >= 0){

            correcto = true;
        }

        return correcto;

    }


    public boolean setHora(int valor){

        boolean correcto = false;

        if(valor < 24 && valor >= 0){

            correcto = true;
        }

        return correcto;

    }

    public void inc(){

        if(this.minuto > 60){

            this.minuto = 0;
            this.hora++;

        }else{

            this.minuto++;
        }

    }

    public String toString(){

        return getHora() + ":" + getMinuto();
    }

    

    
}
