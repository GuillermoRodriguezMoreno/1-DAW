package modelos;

public class Cliente {
    
    // Atributos

    private int codigo;
    private String nombre;
    private String direccion;
    private String email;

    // Constructor

    public Cliente(){

    }

    public Cliente(int codigo, String nombre, String direccion, String email){

        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;

    }

    // Metodos

    @Override
    public String toString() {
        
        return "(" + this.codigo + ")" + this.nombre;

    }

    @Override
    public boolean equals(Object obj) {
        
        Cliente c = (Cliente) obj;

        boolean iguales = false;

        if(this.nombre.equals(c.getNombre())){

            iguales = true;

        }

        return iguales;

    }

    @Override
    public int hashCode() {
        return 0;
    }

    // Getters y Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
