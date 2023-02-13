package ClasesT6.Clases;

public class Incidencia {
    
    // Atributos 

    private int codigo;
    private String estado;
    private int puesto;
    private String problema;
    private String solucion;
    private static int pendientes;

    private static int contador;

    // Constructores

    public Incidencia(int puesto, String informacion){

        this.puesto = puesto;
        this.problema = informacion;
        this.solucion = "";
        this.codigo = contador + 1;
        this.estado = "pendiente";
        this.pendientes = this.pendientes + 1;

        this.contador++;

    }

    // Metodos

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }


  
    

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public static int getPendientes() {
        return pendientes;
    }

    public static void setPendientes(int pendientes) {
        Incidencia.pendientes = pendientes;
    }    

    public void resuelve(String solucion){

        this.setPendientes(this.pendientes - 1);

        this.setEstado("Resuelta");

        this.setSolucion(solucion);
    }

    @Override
    public String toString(){

        String resultado = "Incidencia " + this.getCodigo() + " - Puesto " + this.getPuesto() + " - " + this.getProblema() + " - " + this.getEstado();

        if(this.getEstado().equals("Resuelta")){

            resultado = resultado + " - " + this.getSolucion();

        } 
        
        return resultado;
    }
}
