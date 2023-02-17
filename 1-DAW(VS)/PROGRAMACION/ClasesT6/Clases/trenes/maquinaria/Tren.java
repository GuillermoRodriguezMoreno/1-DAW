package ClasesT6.Clases.trenes.maquinaria;

import ClasesT6.Clases.trenes.personal.Maquinista;

public class Tren {
    
    // Atributos

    private Locomotora locomotora;
    private Vagon[] vagones;
    private Maquinista maquinista;
    private int contadorVagones;

    // Constructores

    public Tren(){

    }

    public Tren(Locomotora locomotora, Maquinista maquinista){

        this.locomotora = locomotora;
        this.maquinista = maquinista;
        this.contadorVagones = 0;
        this.vagones = new Vagon[contadorVagones];
        
    }

    // Metodos

    public Locomotora getLocomotora() {
        return locomotora;
    }

    public void setLocomotora(Locomotora locomotora) {
        this.locomotora = locomotora;
    }

    public Vagon[] getVagones() {
        return vagones;
    }

    public void setVagones(Vagon[] vagones) {
        this.vagones = vagones;
    }

    public Maquinista getMaquinista() {
        return maquinista;
    }

    public void setMaquinista(Maquinista maquinista) {
        this.maquinista = maquinista;
    }

    // Engancha vagon

    public void enganchaVagon(int cargaMax, int cargaActual, String material){

        // si la carga actual supera la maxima
        if(cargaActual > cargaMax){

            System.out.println("VAGON NO ENGANCHADO, este vagon supera la carga maxima");

        }else{
            
            //si ya tiene enganchado 5 vagones
            if(this.contadorVagones >= 5){

                System.out.println("TREN LLENO NO SE PUEDE ENGANCHAR OTRO VAGON");

            }else{

                // Creo el nuevo vagon
                Vagon vagon = new Vagon(cargaMax, cargaActual, material);

                this.contadorVagones ++; // sumo contador de vagones

                Vagon[] aux = new Vagon[contadorVagones]; // creo un array auxiliar de vagones para volcarle los valores anteriores

                aux = this.vagones.clone(); // le doy los valores anteriores del array vagones al auxiliar

                this.vagones = new Vagon[this.contadorVagones]; // creo el array vagones con el tamaño actualizado

                for (int i = 0; i < aux.length; i++) {

                    this.vagones[i] = aux[i]; // vuelco los valores del array auxiliar al nuevo array de vagones
                }

                this.vagones[vagones.length - 1] = vagon; // le doy a la ultima posicion del array de vagones el nuevo vagon

                System.out.println("VAGON ENGANCHADO CON EXITO");

            }
        }
    }

    @Override
    public String toString(){

        String resultado = "";

        int cargaTotal = 0;

        resultado = "Locomotora: " + locomotora.getMatricula() + "(" + locomotora.getPotencia() + "Cv)";

        if(vagones.length > 0){

            for (int i = 0; i < vagones.length; i++) {

                resultado = resultado + " - [ V" + (i+1) + " - " + vagones[i].getCargaActual() + "Kgs de " + vagones[i].getCargaMax() + " "
                + vagones[i].getTipoMercancia() + " ]";

                cargaTotal = cargaTotal + vagones[i].getCargaActual();
                
            }
        }

        resultado = resultado + " - " + maquinista.getNombre() + "(" + maquinista.getRango() + ")";

        return resultado;
    }
    
}
