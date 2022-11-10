package EjerciciosCondicional;

import java.util.Scanner;

public class ejercicio20 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(num%10 + " " + num/10);

        if ((num < 100)&&(num%10 == num/10)) System.out.println("es capicua --- " + num%10 + " " + num/10);

        else if (((num < 1000)&&(num >=100)) && (num%10 == num/100)) System.out.println("es capicua --- " + (num%10 + " " + num/100));

        else if ((num >= 1000)&&(num < 10000)){

            if ((num%10 == num/1000)&&((num/10)%10 == (num/100)%10)) System.out.println("es capicua");
            else System.out.println("no es capicua");
        }

        else if ((num >= 10000)){

            if ((num%10 == num/10000)&&((num/10)%10 == (num/1000)%10)) System.out.println("es capicua");

            else System.out.println("no es capicua");
        }   
    }
}
