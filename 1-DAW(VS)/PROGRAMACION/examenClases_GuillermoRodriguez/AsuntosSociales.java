package examenClases_GuillermoRodriguez;

import java.time.LocalDate;

import examenClases_GuillermoRodriguez.trabajadores.Trabajador;
import examenClases_GuillermoRodriguez.usuarios.Usuario;

public class AsuntosSociales {
    
    // Atributos

    private String nombre;
    private String direccion;
    private Trabajador[] listaTrabajadores;
    private Usuario[] listaUsuarios;

    // Constructores

    public AsuntosSociales(String nombre, String direccion){

        this.nombre = nombre;
        this.direccion = direccion;

        this.listaTrabajadores = new Trabajador[0];
        this.listaUsuarios = new Usuario[0];

    }

    // Metodos

    /**
     * contrata un trabajador
     * @param trabajador
     * @return
     */

    public boolean contratarTrabajador(Trabajador trabajador){

        boolean añadido = false;

        // compruebo si ya esta contratado

        if(comprobarTrabajador(trabajador) == false){

            Trabajador[] nuevaLista = new Trabajador[this.listaTrabajadores.length + 1];

            for (int i = 0; i < this.listaTrabajadores.length; i++) {

                nuevaLista[i] = this.listaTrabajadores[i];
                
            }

            nuevaLista[nuevaLista.length - 1] = trabajador;

            this.listaTrabajadores = nuevaLista;

            añadido = true;

            System.out.println("contratado con exito");

            return añadido;

        }

        else {

            System.out.println("Ya esta contratado");
            
            añadido = false;

            return añadido;
        }

    }

    /**
     * despide al trabajador mas antiguo, es decir, el primero en la lista
     * @return
     */

    public boolean despedirTrabajador(){

        // si no hay trabajadores contratados

        if(this.listaTrabajadores.length == 0){

            System.out.println("no hay trabajadores contratados");

            return false;
        }

        else{

            Trabajador[] nuevaLista = new Trabajador[this.listaTrabajadores.length - 1];

            for (int i = 0; i < nuevaLista.length; i++) {
                
                // obvio la primera posicion
                
                nuevaLista[i] = this.listaTrabajadores[i+1];

            }

            System.out.println("Trabajador despedido: " + this.listaTrabajadores[0]);

            this.listaTrabajadores = nuevaLista;

            return true;
        }
    }


    /**
     * muestra la informacion de todos los trabajadores
     */

    public void muestraTrabajadores(){

        for (int i = 0; i < this.listaTrabajadores.length; i++) {
            
            System.out.println(this.listaTrabajadores[i].getNombre() + " (" + this.listaTrabajadores[i].getDni() + ") " +
            this.listaTrabajadores[i].getTitulacion() + " (" + this.listaTrabajadores[i].getAñoTitulacion() + ") " + 
            this.listaTrabajadores[i].getSueldo() + " // ");

        }
    }

    /**
     * inserta un usuario
     * @param usuario
     * @return
     */

    public boolean insertarUsuario(Usuario usuario){

        boolean añadido = false;

        // compruebo si ya esta en la lista

        if(comprobarUsuario(usuario) == false){

            Usuario[] nuevaLista = new Usuario[this.listaUsuarios.length + 1];

            for (int i = 0; i < this.listaUsuarios.length; i++) {

                nuevaLista[i] = this.listaUsuarios[i];
                
            }

            nuevaLista[nuevaLista.length - 1] = usuario;

            this.listaUsuarios = nuevaLista;

            añadido = true;

            System.out.println("añadido con exito");

            return añadido;

        }

        else {

            System.out.println("Ya esta en la lista");
            
            añadido = false;

            return añadido;
        }
    }

    /**
     * muestra la informacion de un usuario
     * @param usuairo
     */

    public void muestraInfoUsuario(Usuario usuairo){

        System.out.println("Usuario " + usuairo.getTipo() + " " + usuairo.getNombre() + " " + usuairo.getApellidos() + " (" + usuairo.getDni() +
            ") trabajador asociado: " + usuairo.getTrabajadorAsignado().getNombre());

    }

    /**
     * obtiene usuario por dni sino devuelve null
     * @param dni
     * @return
     */

    public Usuario obtenerUsuario(String dni){

        for (int i = 0; i < this.listaUsuarios.length; i++) {
            
            if(this.listaUsuarios[i].getDni().equals(dni)){

                return this.listaUsuarios[i];

            }

        }

        return null;
    }

    /**
     * obtiene usuario por codigo
     * @param codigo
     * @return
     */

    public Usuario obtenerUsuario(int codigo){

        for (int i = 0; i < this.listaUsuarios.length; i++) {
            
            if(this.listaUsuarios[i].getCodigo() == codigo){

                return this.listaUsuarios[i];

            }

        }

        return null;
    }

    /**
     * muestra todo los usuarios
     */
    public void mostrarUsuarios(){

        for (int i = 0; i < listaUsuarios.length; i++) {
            
            System.out.println(listaUsuarios[i].muestraInformacion() + " // ");
        }
    }

    /**
     * muestra la lista de tipos de usuario
     * @return
     */
    public String listadoUsuarios(){

        String resultado = "";
        int menor = 0;
        int mujer = 0;
        int familia = 0;

        for (int i = 0; i < this.listaUsuarios.length; i++) {
            
            switch(this.listaUsuarios[i].getTipo()){

                case MUJER:

                    mujer++;
                    break;
                
                case MENOR:

                    menor++;
                    break;
                
                case FAMILIA:

                    familia++;
            }

        }

        resultado = "Menores: " + menor +"\nMujeres: " + mujer + "\nfamilias: " + familia;

        return resultado;

    }

    /**
     * obtiene un trabajador por dni, si no lo encuentra devuelve null
     * @param dni
     * @return
     */

    public Trabajador buscarTrabajador(String dni){

        for (int i = 0; i < this.listaTrabajadores.length; i++) {
            
            if(this.listaTrabajadores[i].equals(dni)){

                return this.listaTrabajadores[i];

            }

        }

        return null;
    }

    public void hacerVisita(){

        Usuario antiguo = this.listaUsuarios[0];

        antiguo.setUltimaVisita(LocalDate.now());

        Usuario[] nuevaLista = new Usuario[this.listaUsuarios.length - 1];

        // Vuelco todos los valores menos el primero

        for (int i = 0; i < nuevaLista.length; i++) {
            
            nuevaLista[i] = this.listaUsuarios[i+1];

        }

        // vuelvo a volcar los valores y añado el inical a la ultima posicion

        for (int i = 0; i < nuevaLista.length; i++) {
            
            this.listaUsuarios[i] = nuevaLista[i];

        }

        this.listaUsuarios[this.listaUsuarios.length - 1] = antiguo;

        System.out.println("Visita de usuario: " + antiguo.muestraInformacion());
    }

    /**
     * comprueba si un usuario esta repetido
     * @param u1
     * @return
     */

    public boolean comprobarUsuario(Usuario u1){

        boolean repetido = false;

        for (int i = 0; i < this.listaUsuarios.length; i++) {

            if(u1.equals(this.listaUsuarios[i])){

                repetido = true;
                return repetido;
            }
        }

        return repetido;
    }

    /**
     * comprueba si el trabajador ya esta contratado
     * @param t1
     * @return
     */

    public boolean comprobarTrabajador(Trabajador t1){

        boolean repetido = false;

        for (int i = 0; i < this.listaTrabajadores.length; i++) {

            if(t1.equals(this.listaTrabajadores[i])){

                repetido = true;
                return repetido;
            }
        }

        return repetido;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Trabajador[] getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(Trabajador[] listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public Usuario[] getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Usuario[] listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    
}
