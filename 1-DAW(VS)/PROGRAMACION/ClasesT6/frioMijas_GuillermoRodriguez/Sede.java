package ClasesT6.frioMijas_GuillermoRodriguez;

import ClasesT6.frioMijas_GuillermoRodriguez.equiposFrigorificos.*;
import ClasesT6.frioMijas_GuillermoRodriguez.personal.*;

public class Sede {
    
    // Atributos

    private String ciudad;
    private String direccion;
    private String cp;
    private int codigoSede;

    private static int contador = 1;

    private JefeSede jefe;
    private Empleado[] trabajadores;

    private EquipoFrigorifico[] listadoEquipos;

    // Constructores

    public Sede(String ciudad, String direccion, String cp){

        this.ciudad = ciudad;
        this.direccion = direccion;
        this.cp = cp;
        
        this.codigoSede = contador;
        this.contador++;

        this.trabajadores = new Empleado[0];
        this.listadoEquipos = new EquipoFrigorifico[0];

    }

    public Sede(String ciudad, String direccion, String cp, JefeSede jefe){

        this(ciudad, direccion, cp);
        this.jefe = jefe;

    }


    // Metodos

    /**
     * añade un empleado a la sede
     * @return
     */

    public void addEmpleado(Empleado empleado){

        if(comprobarTrabajador(empleado) == true){

            System.out.println("El empleado ya trabaja en esta sede");
        }

        else{

            Empleado[] nuevo = new Empleado[this.getTrabajadores().length + 1];

            for (int i = 0; i < this.getTrabajadores().length; i++) {
                
                nuevo[i] = this.getTrabajadores()[i];
            }

            nuevo[this.getTrabajadores().length] = empleado;

            this.setTrabajadores(nuevo);

            System.out.println("Empleado añadido con exito");

        }
    
    }

    /**
     * comprueba si un empleado ya esta trabajando
     * en esta sede
     * @return
     */

    private boolean comprobarTrabajador(Empleado trabajador){

        boolean repetido = false;

        for (int i = 0; i < this.getTrabajadores().length; i++) {
            
            if(this.getTrabajadores()[i].equals(trabajador)){

                repetido = true;
            }
        }

        return repetido;
    }

    /**
     * añade el equipo a la lista de equipos frigorificos
     * @param equipo
     */

    public void addEquipo(EquipoFrigorifico equipo){

        EquipoFrigorifico[] nuevo = new EquipoFrigorifico[this.getListadoEquipos().length + 1];

            for (int i = 0; i < this.getListadoEquipos().length; i++) {
                
                nuevo[i] = this.getListadoEquipos()[i];
            }

            nuevo[this.getListadoEquipos().length] = equipo;

            this.setListadoEquipos(nuevo);;

            System.out.println("Equipo añadido con exito");

    }

    /**
     * Muestra la lista de equipos frigorificos
     */

    public void mostrarEquipos(){

        System.out.println("Sede " + this.getCodigoSede() + " - " + this.getCiudad()+ ": ");

        for (int i = 0; i < listadoEquipos.length; i++) {
            
            System.out.println(listadoEquipos[i]);
        }
    }

    @Override
    public String toString(){

        String resultado = "";

        resultado = "Sede: id (" + this.getCodigoSede() + ") // " + this.getCiudad() + ", " + this.getDireccion() + " " + this.getCp()
            + "\n Jefe: " + this.getJefe() + "\n Trabajadores: ";

        for (int i = 0; i < this.getTrabajadores().length; i++) {
            
            resultado = resultado + this.getTrabajadores()[i].toString() + " // ";

        }

        return resultado;

    }

    // Getters y Setters

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public JefeSede getJefe() {
        return jefe;
    }

    public void setJefe(JefeSede jefe) {
        this.jefe = jefe;
    }

    public Empleado[] getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(Empleado[] trabajadores) {
        this.trabajadores = trabajadores;
    }

    public EquipoFrigorifico[] getListadoEquipos() {
        return listadoEquipos;
    }

    public void setListadoEquipos(EquipoFrigorifico[] listadoEquipos) {
        this.listadoEquipos = listadoEquipos;
    }

    public  int getCodigoSede() {
        return codigoSede;
    }

    
}
