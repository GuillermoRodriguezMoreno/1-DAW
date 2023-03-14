package examenClases_GuillermoRodriguez;

import java.time.LocalDate;

import ClasesT6.Clases.Cliente;
import examenClases_GuillermoRodriguez.personas.Piloto;
import examenClases_GuillermoRodriguez.personas.Saltador;

public class Vuelo {
    
    // Atributos

    private Piloto piloto;
    private Avion avion;
    private Saltador[] saltadores;

    private LocalDate fecha;
    private int codigo;

    private static int contador;

    // constructores

    public Vuelo(Avion avion, Piloto piloto){

        this.piloto = piloto;
        this.avion = avion;
        this.saltadores = new Saltador[0];
        this.fecha = LocalDate.now();

        this.contador++;
        this.codigo = contador;
    }

    // Metodos

    public void addSaltador(Saltador saltador, Paracaidas pa1, Paracaidas pa2){

        /*

        he implementado mal el metodo, no me di cuenta al hacer, he intentado hacer un casting pero no funcion
        la ide era hacer lo mismo que en el metodo equals cuando casteamos object.

        Saltador saltador1 = new Saltador(null, null, null, codigo, pa1, pa2);

        saltador1 =  (saltador) saltador;

        */

        if(comprobarCapacidad() == true && comprobarAltura(saltador) == true && comprobarRepetido(saltador) == false){

            Saltador[] cola = new Saltador[saltadores.length + 1];

            for (int i = 0; i < saltadores.length; i++) {

                cola[i] = saltadores[i];

                cola[i].setPrincipal(pa1);
                cola[i].setEmergencia(pa2);
                
            }

            cola[saltadores.length] = saltador;

            this.saltadores = cola;

            System.out.println("Añadido con exito");

        }

        else{

            System.out.println("no es posible");
        }

    }

    /**
     * comprueba la capacidad del avion
     * @return
     */

    public boolean comprobarCapacidad(){

        boolean esPosible = false;

        if(saltadores.length < this.getAvion().getCapacidad()){

            esPosible = true;
        }

        return esPosible;
    }

    public boolean comprobarAltura(Saltador salt){

        boolean alturaOk = false;

        if(this.getAvion().getAlturaMax() >= salt.getAlturaSalto()){

            alturaOk = true;
        }

        return alturaOk;

    }

    public boolean comprobarRepetido(Saltador salt){

        boolean repetido = false;

        for (int i = 0; i < this.getSaltadores().length; i++) {
            
            if(salt.equals(this.getSaltadores()[i])){

                repetido = true;
            }
        }

        return repetido;
    }

    public void saleSaltador(){

        if(this.getSaltadores().length > 0){

            String turno = "";

            // ultimo en entrar, primero en salir
            Saltador[] cola = new Saltador[saltadores.length - 1];

            for (int i = 0; i < cola.length; i++) { // excluyo la ultima posicion de saltadores
                
                cola[i] = this.getSaltadores()[i];

            }

            turno = "El saltador " + this.getSaltadores()[this.getSaltadores().length-1].getNombre() + " ha saltado";

            System.out.println(turno);

            this.saltadores = cola;

        }

        else{

            System.out.println("Ya han saltado todos");
        }
    }

    /**
     * muestra la lista de saltadores en orden de salto
     * @return
     */

    public String ordenSalto(){

        String resultado = "";

        for (int i = this.getSaltadores().length -1; i >= 0; i--) {
            
            resultado = resultado + " " + this.getSaltadores()[i].getNombre() + " altura: " + this.getSaltadores()[i].getAlturaSalto() + "\n";

        }

        return resultado;
    }

    public String informacionVuelo(){

        String resultado = "";

        resultado = "Codigo: " + this.getCodigo() + "\nPiloto: " + this.getPiloto().mostrarInformacion() + "\navion: " + this.getAvion().mostrarInformacion() +
            "\nFecha vuelo: " + this.getFecha() + "\nSaltadores: " + this.getSaltadores().length + "\n------------\nSaltadores\n"
            + ordenSalto();

        return resultado;
    }

    // Getters y Setters

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Saltador[] getSaltadores() {
        return saltadores;
    }

    public void setSaltadores(Saltador[] saltadores) {
        this.saltadores = saltadores;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Vuelo.contador = contador;
    }

    

}
