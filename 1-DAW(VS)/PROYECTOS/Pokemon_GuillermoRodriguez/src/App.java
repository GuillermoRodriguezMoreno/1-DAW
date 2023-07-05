import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import modelos.Pokedex;
import modelos.Pokemon;
import utils.SalidaInformacion;
import utils.jsonUtils;

public class App {

    public static void main(String[] args) throws Exception {

        // Leo Json
        Pokedex pokedex = jsonUtils.leerPokedexFromJsonFile();

        // Inicializo informacion salida
        String informacionSalida = "";

        // Ultimos 5 pokemons

        informacionSalida = informacionSalida + "======== Ultimos 5 pokemons =========\n\n";

        informacionSalida = informacionSalida + formatearLista(pokedex.obtenerUltimosPokemon(5));

        // EXTRA Convertir objeto en json

        jsonUtils.listPokemonConvertToJson("ultimos5", pokedex.obtenerUltimosPokemon(5));

        // Informacion de pikachu

        informacionSalida = informacionSalida + "\n=========== Informacion Pikachu =========\n\n";

        informacionSalida = informacionSalida + pokedex.busquedaPorNombre("Pikachu").toString();

        // EXTRA Convertir objeto en json

        jsonUtils.listPokemonConvertToJson("infoPikachu", pokedex.busquedaPorNombre("Pikachu"));

        // Evolucion Charmander

        informacionSalida = informacionSalida + "\n\n=========== Evolucion Charmander =========\n\n";

        informacionSalida = informacionSalida + Arrays.toString(pokedex.buscarEvolucion("Charmander"));

        // EXTRA Convertir objeto en json

        jsonUtils.listPokemonConvertToJson("evoCharmander", pokedex.buscarEvolucion("Charmander"));

        // Pokemons tipo fuego

        informacionSalida = informacionSalida + "\n\n=========== Pokemons tipo fuego =========\n\n";

        informacionSalida = informacionSalida + formatearLista(pokedex.buscarPorTipo("Fire"));

        // EXTRA Convertir objeto en json

        jsonUtils.listPokemonConvertToJson("tipoFuego", pokedex.buscarPorTipo("Fire"));

        // Pokemons debiles a agua y electrico

        informacionSalida = informacionSalida + "\n=========== Pokemons debiles a agua o electrico =========\n\n";

        // Obtengo la lista y los meto en un Set para que no salgan repetidos
        
        HashSet<Pokemon> setDebilidades = new HashSet<>();

        // Añado cada lista de debilidad al set
        setDebilidades.addAll(pokedex.buscarPorDebilidades("Water"));
        setDebilidades.addAll(pokedex.buscarPorDebilidades("Electric"));

        // Inicializo nueva lista de debilidades la cual esta formada por el Set
        ArrayList<Pokemon> listaDebilidades = new ArrayList<>(setDebilidades);

        // Ordeno
        Collections.sort(listaDebilidades);

        informacionSalida = informacionSalida + formatearLista(listaDebilidades);

        // EXTRA Convertir objeto en json

        jsonUtils.listPokemonConvertToJson("debilAguaOElectrico", listaDebilidades);

        // Pokemon con mas debilidades

        informacionSalida = informacionSalida + "\n=========== Pokemon con mas debilidades =========\n\n";

        informacionSalida = informacionSalida + pokedex.buscarMasDebil().toString();

        // EXTRA Convertir objeto en json

        jsonUtils.listPokemonConvertToJson("masDebil", pokedex.buscarMasDebil());

        // Pokemon mas alto

        informacionSalida = informacionSalida + "\n\n=========== Pokemon mas alto =========\n\n";

        informacionSalida = informacionSalida + pokedex.buscarPokemonMasAlto().toString();

        // EXTRA Convertir objeto en json

        jsonUtils.listPokemonConvertToJson("masAlto", pokedex.buscarMasDebil());

        // Muestro por pantalla para ver que la informacion es correcta
        System.out.println(informacionSalida);

        // Escribo informacion

        SalidaInformacion.salidaInformacion(informacionSalida);


    }

    // Metodos

    static String formatearLista(ArrayList<Pokemon> lista){

        String resultado = "";

        for (Pokemon elemento : lista) {

            resultado = resultado + elemento + "\n";
            
        }

        return resultado;

    }

}
