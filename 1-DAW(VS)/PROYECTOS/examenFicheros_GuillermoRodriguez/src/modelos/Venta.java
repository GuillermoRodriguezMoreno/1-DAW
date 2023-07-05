package modelos;

import java.util.ArrayList;

public class Venta {
    
    // Atributos

    private int codigoCliente;
    private String fecha;
    private ArrayList<Linea> lineas;

    // Constructor

    public Venta(){

    }

    public Venta (int codigo, String fecha, ArrayList<Linea> lineas){

        this.codigoCliente = codigo;
        this.fecha = fecha;
        this.lineas = lineas;

    }

    // Metodos

    @Override
    public String toString() {
        
        return "Cliente: " + this.codigoCliente + " ,fecha: " + this.fecha + " , lineas:" + this.lineas.toString();
        
    }

    // Getters y Setters

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<Linea> lineas) {
        this.lineas = lineas;
    }

    
}
