package ClasesT6.Clases;

public class SintonizadorFM {
    
    // Atributos

    private double frecuencia;

    // Constructores

    public SintonizadorFM(){

        this.frecuencia = 80.0;
    }

    public SintonizadorFM(double frecuencia){

        if(frecuencia > 108){

            this.frecuencia = 108.0;

        }else if(frecuencia < 80.0){

            this.frecuencia = 80.0;
        }
        
        else{

            this.setFrecuencia(frecuencia);
        }

        
    }

    // Getters and Setters

    public double getFrecuencia() {

        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {

        if(frecuencia > 108.0){

            this.frecuencia = 80.0;

        }else if (frecuencia < 80.0){

            this.frecuencia = 108.0;

        } else{

            this.frecuencia = frecuencia;

        }

    }

    // Metodos

    public void up(){

        setFrecuencia(this.frecuencia + 0.5);
    }

    public void down(){

        setFrecuencia(this.frecuencia - 0.5);
    }

    public void display(){

        System.out.println(getFrecuencia());
    }

    


}
