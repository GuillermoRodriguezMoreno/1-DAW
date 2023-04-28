package clase.utiles;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LecturaTeclado {
        
        // Atributos
    
        private Scanner sc;
    
        // Constructor
    
        public LecturaTeclado(){
    
            this.sc = new Scanner(System.in);

        }

        // Metodos

        public String leerCadena(){

            String entrada = null;
            boolean ok = false;

            do{

                try {

                    entrada = sc.nextLine();
                    ok = true;

                }
                catch (IllegalStateException e){

                    System.out.println("Scanner cerrado");
                    ok = true;
                    entrada = "";

                }
                
                catch (NoSuchElementException e) {

                    System.out.println("Error al leer el dato");

                }

                catch (Exception e){

                    System.out.println("Error al leer el dato (cod 0-2)");

                }

            }while(ok == false);


            return entrada;

        }

        public Integer leerInt(){

            boolean ok = false;
            Integer resultado = null;

            do{

                try {

                    String entrada = sc.nextLine();
                
                    resultado =  Integer.valueOf(entrada);

                    ok = true;
    
                }

                catch (IllegalStateException e){

                    System.out.println("Scanner cerrado");
                    ok = true;
                    resultado = 0;

                }
                
                catch (NumberFormatException e) {
                    
                    System.out.println("introduce un numero entero por favor");
    
                }

                catch (Exception e){

                    System.out.println("Error al leer el dato (cod 0-2)");
                    
                }

            }while(ok == false);

            return resultado;
            
        }

        public float leerFloat(){

            boolean ok = false;
            Float resultado = null;

            do{

                try {

                    String entrada = sc.nextLine();
                
                    resultado =  Float.valueOf(entrada);

                    ok = true;
    
                } 
                
                catch (IllegalStateException e){

                    System.out.println("Scanner cerrado");
                    ok = true;
                    resultado = 0.0f;

                }
                
                catch (NumberFormatException e) {
                    
                    System.out.println("introduce un numero decimal por favor");
    
                }

                catch (Exception e){

                    System.out.println("Error al leer el dato (cod 0-2)");
                    
                }

            }while(ok == false);

            return resultado;
            
        }

        public Double leerDouble(){

            boolean ok = false;
            Double resultado = null;

            do{

                try {

                    String entrada = sc.nextLine();
                
                    resultado =  Double.valueOf(entrada);

                    ok = true;
    
                } 
                
                catch (IllegalStateException e){

                    System.out.println("Scanner cerrado");
                    ok = true;

                    resultado = 0.0;

                }

                catch (NumberFormatException e) {
                    
                    System.out.println("introduce un numero decimal por favor");
    
                }

                catch (Exception e){

                    System.out.println("Error al leer el dato (cod 0-2)");
                    
                }

            }while(ok == false);

            return resultado;
            
        }

        public void finalizarLectura(){

            try {
                
                sc.close();

            } catch (Exception e) {

                System.out.println("Error al cerrar el Scanner");

            }
        }
    
}
