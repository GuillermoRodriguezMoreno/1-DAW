import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class App {

    public static void main(String[] args) throws Exception {


        try {

            FileReader fReader = new FileReader("src/recursos/numeros.txt");

            BufferedReader bf = new BufferedReader(fReader);

            FileWriter fWriter = new FileWriter("src/recursos/salida.txt");

            BufferedWriter out = new BufferedWriter(fWriter);

            int sumaTotal = 0;

            String linea = "";

            linea = bf.readLine();
            int suma = 0;
            int contadorLineas = 0;


            while(linea != null){

                contadorLineas ++;

                suma = 0;

                String[] trozos = linea.split(" ");

                for (int i = 0; i < trozos.length; i++) {

                    try {

                        suma = suma + Integer.valueOf(trozos[i]);

                    } catch (Exception e) {
                        
                        System.out.println("linea vacia");
                    }


                }

                linea = "Suma linea " + contadorLineas + ": " + suma;
                System.out.println(linea);

                out.write(linea);
                out.newLine();
                
                linea = bf.readLine();
            }

            out.write("Esto es un fichero de salida");

            bf.close();
            fReader.close();
            out.close();
            fWriter.close();

            System.out.println("---------- LECTURA DEL NUEVO ARCHIVO --------------");

            fReader = new FileReader("src/recursos/salida.txt");

            bf = new BufferedReader(fReader);

            linea = bf.readLine();

            while(linea != null){

                System.out.println(linea);

                linea = bf.readLine();

            }
            
            bf.close();
            fReader.close();

        } catch (FileNotFoundException e) {
            
            System.out.println(e.getMessage());
        }

        

    }
}
