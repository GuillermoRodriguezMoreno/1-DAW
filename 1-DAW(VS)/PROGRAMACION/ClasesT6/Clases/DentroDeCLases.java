package ClasesT6.Clases;

public class DentroDeCLases {
    
    public static void main(String[] args) {
        
        Persona yo = new Persona();

        Persona p;

        yo.dni = "7903";
        yo.nombre = "Guillermo";
        yo.apellido = "Rodriguez";
        yo.estatura = 173;
        yo.edad = 29;

        System.out.println("mi dni es: " + yo.dni);
        System.out.print("mi nombre es: " + yo.nombre);
        System.out.println(" " + yo.apellido);
        System.out.println("mi edad es: " + yo.edad);
        System.out.println("mido: " + yo.estatura);

        System.out.println("-----------------");

        yo.saludar();

        //yo.nombre = yo.cambiarNombre("otro nombre");
    }
}
