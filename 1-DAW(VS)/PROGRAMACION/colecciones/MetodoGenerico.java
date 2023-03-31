package colecciones;

import java.util.Arrays;

public class MetodoGenerico {
    
    public static <U> U[] add(U[] tabla, U e){

        U[] nuevaTabla = Arrays.copyOf(tabla, tabla.length + 1);

        nuevaTabla[tabla.length] = e;

        return nuevaTabla;
    }
}
