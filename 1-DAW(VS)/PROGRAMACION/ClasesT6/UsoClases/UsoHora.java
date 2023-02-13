package ClasesT6.UsoClases;

import java.util.Scanner;
import java.util.Set;

import ClasesT6.Clases.Hora;

public class UsoHora {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("hora");

        int hora1 = sc.nextInt();

        System.out.println("numero segundos");

        int segundos = sc.nextInt();

        Hora hora = new Hora(hora1, 0, 0);


            for(int i = 0; i < segundos; i++){

                hora.segundo++;

                if(hora.segundo > 59){

                    hora.setSegundo(0);
                    hora.minuto++;
                }

                if(hora.minuto > 59){

                    hora.setMinuto(0);
                    hora.hora++;
                }

                else 

                System.out.println(hora.hora + ": " + hora.minuto + " : " + hora.segundo);

            }
        
    }
}
