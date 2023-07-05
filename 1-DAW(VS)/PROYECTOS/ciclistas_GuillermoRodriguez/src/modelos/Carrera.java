package modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import utils.LeerInformacion;

public class Carrera {
    
    // Atributos

    private ArrayList<Equipo> listaEquipos;
    private ArrayList<Corredor> listaCorredores;
    private String nombre;

    // Constructor

    public Carrera(List<Ciclista> ciclistas, String nombre){

        // Setteo nombre
        this.nombre = nombre;

        // Inicializo dorsal
        int dorsal = 0;

        // Inicializo set de equipos
        HashSet<String> equipos = new HashSet<>();

        // Lista corredores
        ArrayList<Corredor> listaCorredores = new ArrayList<>();

        // Recorro lista de ciclistas
        for (Ciclista elemento : ciclistas) {

            dorsal++;
            
            // Declaro nuevo corredor con los datos de ciclista y dorsal incremental
            Corredor nuevoCorredor = new Corredor(elemento, dorsal);

            // Añado corredor a la carrera
            listaCorredores.add(nuevoCorredor);

            // Añado equipo a el set
            equipos.add(elemento.getCodigoEquipo());

        }

        this.listaCorredores = listaCorredores;

        // Construir lista de equipos
        construirListaEquipos(equipos);

    }

    // Metodos

    /**
     * Settea la lista de equipos que participan en una carrera
     * @param equipos
     */
    private void construirListaEquipos(HashSet<String> equipos) {

        HashSet<Equipo> listaEquipos = new HashSet<>();

        // Obtengo lista completa de equipos
        ArrayList<Equipo> listaEquiposCompleta = LeerInformacion.leerListaEquipo();

        // Recorro lista de equipo que participan
        for (String equipo : equipos) {
            
            // por cada equipo que participa compruebo si coincide con la alguno de la lista completa para completar los datos
            for (Equipo elemento : listaEquiposCompleta) {

                // Si se encuentra equipo
                if(equipo.equals(elemento.getCodigo())){

                    // lo añado al set para no obtener valores repetidos
                    listaEquipos.add(elemento);

                }
                
            }
        }

        // Convierto en lista
        ArrayList<Equipo> listaFinal = new ArrayList<>(listaEquipos);

        // Setteo lista
        this.setListaEquipos(listaFinal);

    }

    /**
     * inserta el tiempo que ha hecho cada corredor en una etapa dada
     * @param etapa
     */
    public void insertarTiemposEtapa(HashMap<Integer, Integer> etapa){

        int tiempo = 0;
        int tiempoActual = 0;

        boolean encontrado = false;

        // Recorro corredores
        for (Corredor corredor : this.listaCorredores) {

            encontrado = false;

            tiempoActual = corredor.getTiempo();

            // Recorro dorsales
            for (Integer dorsal : etapa.keySet()) {

                // Si lo encuentro
                if(corredor.getDorsal() == dorsal){

                    // Setteo tiempo
                    tiempo = etapa.get(dorsal);

                    corredor.setTiempo(tiempoActual + tiempo);

                    encontrado = true;
                }
                
            }

            // Si no encuentro
            if(encontrado == false){

                // Obtengo maximo de etapa
                tiempo = Collections.max(etapa.values());

                // Setteo
                corredor.setTiempo(tiempoActual + tiempo);

            }
            
        }
    }

    /**
     * ordena la lista de corredores por tiempo
     */
    public void ordenarCorredoresPorTiempo(){

        Collections.sort(this.listaCorredores);

    }

    /**
     * Busca un corredor por dorsal en la lista de corredores,
     * devuelve null si no lo encuentra
     * @param dorsal
     * @return
     */
    public Corredor buscarCorredorPorDorsal(int dorsal){

        Corredor corredor = null;

        for (Corredor elemento : this.listaCorredores) {

            if(elemento.getDorsal() == dorsal){

                corredor = elemento;
            }
            
        }

        return corredor;

    }

    /**
     * Devuelve la posicion actual de un corredor
     * @param corredor
     * @return
     */
    public int posicionCorredor(Corredor corredor){

        int posicion = -1;

        // Ordeno lista por tiempo
        this.ordenarCorredoresPorTiempo();

        // Recorro lista de corredores y comparo
        for (int i = 0; i < this.listaCorredores.size(); i++) {

            // Si lo encuentra devuelvo la posicion en la lista
            if(this.listaCorredores.get(i).equals(corredor)){

                posicion = i;
            }
            
        }

        // Sumo uno ya que empieza en 0
        return posicion + 1;

    }

    /**
     * devuelve el peloton completo ordenado por tiempo
     * @return
     */
    public String clasificacionCompleta(){

        String resultado = "";

        int posicion = 1;

        // Ordeno lista corredores por tiempo
        this.ordenarCorredoresPorTiempo();

        // Recorro lista
        for (Corredor corredor : this.listaCorredores) {
            
            resultado = resultado + posicion + "º - " + corredor.getDorsal() + " - " + corredor.getNombre() + 
            " (" + corredor.getCodigoEquipo() + "): " + corredor.getTiempo() + "\n";

            posicion++;

        }

        return resultado;

    }

    /**
     * devuelve una cadena con la clasificacion de equipos
     * @return
     */

    public String clasificacionPorEquipos(){

        int tiempoTotalEquipo = 0;

        HashMap<Equipo, Integer> tiemposEquipos = new HashMap<>();

        ArrayList<Corredor> corredoresDeEquipo = new ArrayList<>();

        // Recorro equipos
        for (Equipo equipo : this.listaEquipos) {

            // Reseteo variables
            tiempoTotalEquipo = 0;
            corredoresDeEquipo.clear();

            // Recorro corredores por cada equipo
            for (Corredor corredor : this.listaCorredores) {
                
                // Si el corredor es del equipo
                if(equipo.getCodigo().equals(corredor.getCodigoEquipo())){

                    corredoresDeEquipo.add(corredor);

                }
            }

            // Una vez añadidos todos los corredores de un equipo

            // Ordeno lista por tiempo y obtengo los 3 primeros

            Collections.sort(corredoresDeEquipo);

            for (int i = 0; i < 3; i++) {
                
                // Sumo tiempos
                tiempoTotalEquipo = tiempoTotalEquipo + corredoresDeEquipo.get(i).getTiempo();

            }

            // Añado equipo y tiempo al hashmap
            tiemposEquipos.put(equipo, tiempoTotalEquipo);
            
        }

        // En teoria tendria un HashMap con cada equipo y su respectivo tiempo, ahora falta ordenarlos

        // Declaro nuevo mapa que va a ser el resultado de ordenar
        LinkedHashMap<Equipo, Integer> mapaOrdenado = new LinkedHashMap<>();

        // voy a ordenar tiempos

        ArrayList<Integer> listaTiemposOrdenada = new ArrayList<>(tiemposEquipos.values());
        Collections.sort(listaTiemposOrdenada);

        // voy a ordenar equipos segun tiempos

        ArrayList<Equipo> listaEquiposOrdenada = new ArrayList<>(tiemposEquipos.keySet());


        // Recorro lista tiempo

        for (int index = 0; index < listaTiemposOrdenada.size(); index++) {

            // obtengo tiempos ordenados

            Integer tiempoOrdenado = listaTiemposOrdenada.get(index);

            // Recorro equipos
            for (Equipo elemento : listaEquiposOrdenada) {

                // obtengo el equipo de su correspondiente tiempo

                if(tiemposEquipos.get(elemento).equals(tiempoOrdenado)){

                    // Introduzco en nuevo mapa
                    mapaOrdenado.put(elemento, tiempoOrdenado);

                }
            }
            
        }

        // Mucho lio pero deberia estar ordenado

        // Obtengo el tiempo de cada equipo en orden de tiempo

        // Recorro keyset y añado

        String resultadoFinal = "";

        for (Equipo elemento : mapaOrdenado.keySet()) {

            resultadoFinal = resultadoFinal + elemento.toString() + " --> tiempo equipo: " + mapaOrdenado.get(elemento) + "\n";
            
        }

        return resultadoFinal;

    }



    /**
     * Devuelve una cadena con el podium
     * @return
     */
    public String podium(){

        String resultado = "";

        // Ordeno lista corredores por tiempo
        Collections.sort(this.listaCorredores);

        // Obtengo los 3 primeros
        for (int i = 0; i < 3; i++) {
            
            resultado = resultado + this.listaCorredores.get(i).toString() + "\n";

        }

        return resultado;

    }

    public String listaParticipantes(){

        String cadena = "";

        for (Corredor corredor : this.listaCorredores) {

            cadena = cadena + corredor.toString() + "\n";
            
        }

        return cadena;
    }

    // Getters y Setters

    

    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }
    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
    public ArrayList<Corredor> getListaCorredores() {
        return listaCorredores;
    }
    public void setListaCorredores(ArrayList<Corredor> listaCorredores) {
        this.listaCorredores = listaCorredores;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
