package pruebas;

import java.util.Random;

public class Pruebas {
    public static void main(String[] args) {
        Random r = new Random();

        int num = 3;
/* 
        for (int i = 0; i < 100; i++) {
            int n = r.nextInt(1000-(-500)) -500;
            System.out.println(i + ": " + n);
        }

        for (int i = 0; i < 100; i++) {
            int n = r.nextInt(3) +1;
            System.out.println(i + ": " + n);
        }

        for (int i = 0; i < 100; i++) {
            int n = (int)Math.round((Math.random()*2) +1) * 1000;
            System.out.println(i + ": " + n);
        }*/

        while(num >= 3) {
            System.out.println("hola");
            break;
        }
    }
}
