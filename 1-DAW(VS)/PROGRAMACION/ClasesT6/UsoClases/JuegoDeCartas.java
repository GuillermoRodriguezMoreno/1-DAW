package ClasesT6.UsoClases;

import java.util.Arrays;
import java.util.Scanner;

import ClasesT6.Clases.Baraja;
import ClasesT6.Clases.Carta;

public class JuegoDeCartas {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner((System.in));
        
        Baraja baraja = new Baraja();

        baraja.barajar();

        int opcion = 0;

        int contador = 0;

        Carta cartaAux2 = new Carta();

        boolean esMayor = false;


        do{
            System.out.println(baraja);

            System.out.println("1- sacar carta");
            System.out.println("2 - salir");

            esMayor = false;

            opcion = sc.nextInt();

            if(opcion == 1){

                Carta cartaSacada = baraja.pop();

                Carta cartaAux1 = cartaAux2;

                cartaAux2 = cartaSacada;

                System.out.println(cartaSacada);
                System.out.println(cartaAux1);

                if(cartaSacada.getNumero() >= cartaAux1.getNumero()){

                    esMayor = true;
                    contador++;
                }
            }


        }while(opcion != 2  && esMayor);

    }
}
