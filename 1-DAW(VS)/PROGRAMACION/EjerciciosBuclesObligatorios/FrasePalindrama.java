package EjerciciosBuclesObligatorios;

import java.util.Scanner;

public class FrasePalindrama {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        String entrada = "";
        String entradaAlReves = "";
        int longitudFrase = 0;

        System.out.println("introduce frases para saber si es palindrama, para salir escribe SALIR.");

        do{

            entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("salir")) salir = true;

            else{

                entrada = entrada.replace(" ", "");

                entradaAlReves = "";

                longitudFrase = entrada.length();


                for(int aux = longitudFrase - 1 ; aux >= 0 ; aux --){

                    entradaAlReves = entradaAlReves + entrada.charAt(aux);

                }

                if (entrada.equals(entradaAlReves)) System.out.println("la frase es palindrama");

                else System.out.println("la frase no es palindrama");
            }

        }while(!salir);
    }
}
