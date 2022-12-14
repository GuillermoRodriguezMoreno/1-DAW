package Funciones;

public class UtilesParaNumeros {
    
    public static void main(String[] args) {

        System.out.println(juntaNumeros(1234, 567));

    }

    // Funciones //

    // Voltear numero

    static int voltearNumero(int numero){

        int numeroVolteado = 0;

        while (numero > 0){

            numeroVolteado = numeroVolteado * 10 +  (numero%10);

            numero = numero / 10;
        }

        return numeroVolteado;
    }

    // es capicua

    static boolean esCapicua(int numero){

        boolean esCapicua = false;

        if (numero == voltearNumero(numero)){

            esCapicua = true;
        }

        return esCapicua;
    }

    // contador digitos

    static int digitos (int numero){

        int contador = 1;

        while(numero/10 > 0){

            numero = numero / 10;

            contador ++;
        }

        return contador;
    }

    // es primo

    static boolean esPrimo(int numero){

        boolean esPrimo = true;

        for (int i = 2 ; i < numero ; i++){

            if (numero%i == 0) esPrimo = false;
        }

        return esPrimo;
    }

    // siguiente primo

    static int siguientePrimo (int numero){

        int siguientePrimo = numero + 1;

        while(!esPrimo(siguientePrimo)){

            siguientePrimo ++;
        }


        return siguientePrimo;
    }

    // digito N

    static int digitoN (int numero, int posicion){

        int digito = 0;

        numero = voltearNumero(numero);

        for (int i = 0 ; i < posicion ; i++){

            numero = numero / 10;
        }

        digito = numero%10;

        return digito;
    }

    // posicion de digito

    static int posicionDeDigito(int numero, int digito){

        int posicion = 0;

        while(numero / 10 > 0){

            if (numero%10 == digito) posicion ++;

            else numero = numero/10;
        }

        return posicion;
    }

    // quita por detras

    static int quitaPorDetras (int numero, int digitos){

        for (int i = 1; i <= digitos; i++){

            numero = numero / 10;
        }

        return numero;
    }

    // quita por delante

    static int quitaPorDelante (int numero, int digitos){

        numero = voltearNumero(numero);

        numero = quitaPorDetras(numero, digitos);

        numero = voltearNumero(numero);

        return numero;
    }

    // pega por detras

    static int pegaPorDetras(int numero, int digito){

        numero = numero * 10 + digito;

        return numero;
    }

    // pega por delante

    static int pegaPorDelante(int numero, int digito){

        numero = voltearNumero(numero);

        numero = pegaPorDetras(numero, digito);

        numero = voltearNumero(numero);

        return numero;
    }

    // trozo de numero

    static int trozoDeNumero (int numero, int izq, int der){

        numero = quitaPorDelante(numero, izq);

        numero = quitaPorDetras(numero, der);

        return numero;
    }

    // junta numeros

    static int juntaNumeros(int numero1, int numero2){

        int numero = 0;

        int pegar = 0;

        numero2 = voltearNumero(numero2);

        numero = numero1;

        while (numero2 > 0){

            pegar = numero2%10;

            numero = pegaPorDetras(numero, pegar);

            numero2 = numero2/10;
        }

        return numero;
    }
}
