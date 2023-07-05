package modelos;

import java.util.ArrayList;
import java.util.Collections;

public class Pokedex {
    
    // Atributos

    private ArrayList<Pokemon> pokemon;

    // Constructores

    // Metodos

    @Override
    public String toString() {

        String resultado = "";
        
        for (Pokemon elemento : pokemon) {
            
            resultado = resultado + elemento +"\n";

        }

        return resultado;

    }

    /**
     * Muestra los n ultimos pokemons pasados por parametro
     * @param num numero a mostrar de ultimos pokemons
     * @return
     */
    public ArrayList<Pokemon> obtenerUltimosPokemon(int num){

        // Copio lista pokemons
        ArrayList<Pokemon> reversePokedex = new ArrayList<>(this.pokemon);

        // declaro lista con ultimos pokemons vacia
        ArrayList<Pokemon> listaUltimos = new ArrayList<>();

        // invierto lista pokemons
        Collections.reverse(reversePokedex);

        // Recorro hasta numero dado
        for (int index = 0; index < num; index++) {
            
            // Añado los pokemons a la lista
            listaUltimos.add(reversePokedex.get(index));

        }

        Collections.sort(listaUltimos);

        return listaUltimos;

    }

    /**
     * Busca en la pokedex y devuelve el pokemon con dicho nombre
     * @param nombre
     * @return
     */

    public Pokemon busquedaPorNombre(String nombre){

        // Declaro nuevo pokemon a null
        Pokemon nuevo = null;

        // Recorro pokedex
        for (Pokemon elemento : this.pokemon) {
            
            // Si encuentra el nombre
            if(elemento.getName().equals(nombre)){

                // Obtengo el pokemon
                nuevo = elemento;

            }

        }

        return nuevo;

    }

    /**
     * Busca por nombre un pokemon y devuelve su evolucion/es
     * @param nombre
     * @return
     */
    public Evolution[] buscarEvolucion(String nombre){

        // Obtengo pokemon por nombre
        Pokemon pokemon = busquedaPorNombre(nombre);

        // Devuelvo el array de evoluciones
        return pokemon.getNext_evolution();

    }

    /**
     * Busca en la pokedex los pokemon de un tipo dado
     * @param tipo
     * @return
     */
    public ArrayList<Pokemon> buscarPorTipo(String tipo){

        // Nueva lista
        ArrayList<Pokemon> listaTipo = new ArrayList<>();

        // Recorro Pokedex
        for (Pokemon elemento : this.pokemon) {
            
            // Recorro tipos de cada pokemon
            for (String type : elemento.getType()) {

                // Si contiene el tipo lo añado
                if(type.equals(tipo)){

                    listaTipo.add(elemento);

                }
                
            }

        }

        return listaTipo;

    }

    public ArrayList<Pokemon> buscarPorDebilidades(String debilidad){

        // Nueva lista
        ArrayList<Pokemon> listaDebilidades = new ArrayList<>();

        // Recorro Pokedex
        for (Pokemon elemento : this.pokemon) {
            
            // Recorro debilidades de cada pokemon
            for (String weakness : elemento.getWeaknesses()) {

                // Si contiene el tipo lo añado
                if(weakness.equals(debilidad)){

                    listaDebilidades.add(elemento);

                }
                
            }

        }

        return listaDebilidades;

    }

    public Pokemon buscarMasDebil(){

        Pokemon nuevo = null;

        // inicializo numero de debilidades a -1
        int masDebil = -1;

        // Recorro pokedex
        for (Pokemon elemento : pokemon) {
            
            // Si el numero de debilidades es mayor
            if(elemento.getWeaknesses().length > masDebil){

                // obtengo pokemon
                nuevo = elemento;

                // Actualizo numero de debildiades maximas
                masDebil = elemento.getWeaknesses().length;

            }

        }

        return nuevo;

    }

    /**
     * Busca en la pokedex el pokemon mas alto
     * @return
     */
    public Pokemon buscarPokemonMasAlto(){

        Pokemon nuevo = null;
        Double alturaMax = 0.0;
        Double alturaActual = 0.0;

        // Recorro pokedex
        for (Pokemon elemento : pokemon) {
            
            // Altura actual = valor[0] del string partido por " ";
            alturaActual = Double.valueOf(elemento.getHeight().split(" ")[0]); 

            // Si la altura actual es mayor a la max
            if(alturaActual > alturaMax){

                nuevo = elemento;

                // Actualizo altura max
                alturaMax = alturaActual;

            }

        }

        return nuevo;

    }

    // Getters y Setters

    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
    
}
