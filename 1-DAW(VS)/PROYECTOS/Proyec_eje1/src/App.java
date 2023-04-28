import clases.Gato;

public class App {
    public static void main(String[] args) throws Exception {


        Gato garfil = new Gato("garfil", "marron", "macho");
        Gato lisa = new Gato("lisa", "negro", "hembra");
        Gato pepe = new Gato("pepe", "negro", "macho");

        System.out.println(garfil.apareaCon(lisa)); 
        garfil.apareaCon(pepe);
    }
}
