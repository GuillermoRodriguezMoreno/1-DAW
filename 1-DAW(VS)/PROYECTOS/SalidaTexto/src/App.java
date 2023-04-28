import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");

        String path = "src/recursos/prueba.txt";

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(path));
            BufferedReader bReader = new BufferedReader(new FileReader(path));
            Scanner sc = new Scanner(System.in)) {

            String linea = "";

            do{

                linea = sc.nextLine();

                if(!linea.equals("fin")){

                    bWriter.write(linea + "\n");

                }

            } while(!linea.equals("fin"));

            bWriter.close();

            System.out.println("Salida por pantalla");

            String lineaLeer = "";

            lineaLeer = bReader.readLine();

            while(lineaLeer != null){

                System.out.println(lineaLeer);

                lineaLeer = bReader.readLine();
            }


            
        } 
        
        catch (Exception e) {

            System.out.println(e.getMessage());
            
        }
        
    }
}
