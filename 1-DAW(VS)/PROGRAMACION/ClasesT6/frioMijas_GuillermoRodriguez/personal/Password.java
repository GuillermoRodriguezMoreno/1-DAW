package ClasesT6.frioMijas_GuillermoRodriguez.personal;

class Password {
    
    // Atributos

    private int longitud;
    private String contraseña;

    // Constructores
    
    public Password(){

        this.longitud = 8;
        generarPassword();
    }

    public Password(int longitud){

        this.longitud = longitud;
        generarPassword(longitud);
    }

    // Metodos

    /**
     * Genera una contraseña aleatoria
     */

    public void generarPassword(){

        int longitud = this.getLongitud();

        String cadena = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz0123456789";

        String nuevaConstraseña = "";

        for (int i = 0; i < longitud; i++) {
            
            char caracter = cadena.charAt((int) (Math.random() * cadena.length()));

            nuevaConstraseña = nuevaConstraseña + caracter;
        }

        this.setContraseña(nuevaConstraseña);

    }

    /**
     * Genera una contraseña aleatoria con la longitud indicada
     * @param longitud
     */

    public void generarPassword(int longitud){

        this.setLongitud(longitud);

        this.generarPassword();

    }

    /**
     * devuelve si la contraseña es fuerte o no.
     * es fuerte cuando tiene mas de 2 mayusculas,
     * mas de 1 minuscula y al menos 5 numeros
     * @return
     */

    public boolean esFuerte(){

        boolean esFuerte = false;

        int nMayus = 0;
        int nMinus = 0;
        int nNum = 0;

        String contraseña = this.getContraseña();
        String copiaContraseña = contraseña;

        for (int i = 0; i < contraseña.length(); i++) {

            // capturo cada caracter
            char caracterActual = contraseña.charAt(i);

            // si es un numero
            if(Character.isDigit(caracterActual)){

                nNum++;
            }

            // si se encuentra una minuscula
            else if(caracterActual == copiaContraseña.toLowerCase().charAt(i)){

                nMinus++;

            } 

            // si se encuentra una mayuscula
            else if(caracterActual == contraseña.toUpperCase().charAt(i)){

                nMayus++;
            }

        }

        if(nMayus > 2 && nMinus > 1 && nNum >= 5){

            esFuerte = true;

        }

        return esFuerte;
    }


    // Getter y Setters

    private int getLongitud() {

        return longitud;
    }

    public String getContraseña() {

        return contraseña;
    }

    private void setLongitud(int longitud) {

        this.longitud = longitud;
    }

    private void setContraseña(String contraseña) {

        this.contraseña = contraseña;
    }

}
