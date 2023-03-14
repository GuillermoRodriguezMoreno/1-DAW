package ClasesT6.frioMijas_GuillermoRodriguez.personal;

public class JefeSede extends Empleado{
    
    // Atributos

    private Password clave;

    // Constructores

    public JefeSede(String nombre, String apellidos, int edad, float sueldo, String dni){

        super(nombre, apellidos, edad, sueldo, dni);
        this.clave = new Password();

    }

    // Metodos

    /**
     * Genera una contraseña para jefe
     */

    public void generarPassword(){

        clave.generarPassword();

    }

    /**
     * Genera una contraseña para jefe de una determinada
     * longitud
     * @param longitud
     */

    public void generarPassword(int longitud){

        clave.generarPassword(longitud);

    }

    /**
     * Muestra si la contraseña es fuerte o no
     */

    public void esFuerte(){

        boolean esFuerte = this.clave.esFuerte();

        if(esFuerte){

            System.out.println("la contraseña de " + this.getNombre() + " es fuerte");

        } 
        
        else{

            System.out.println("la contraseña de " + this.getNombre() + " es debil");
        }

    }

    /**
     * Genera una contraseña fuerte
     * de longitud 10
     */

    public void generarPassFuerte(){

        do{

            this.generarPassword(10);

        }while(this.clave.esFuerte() == false);
    }


    @Override
    public String toString(){

        return super.toString() + ", Contraseña: " + this.clave.getContraseña();
    }

    // Getters y Setters

    public Password getClave() {
        return clave;
    }

    public void setClave(Password clave) {
        this.clave = clave;
    }

}
