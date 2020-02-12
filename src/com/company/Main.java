package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Lutador l[] = new Lutador[3];
        l[0] = new Lutador("Rodrigo", "Brasileiro", 23, 7, 7, 7, 1.75f, 70);
        l[1] = new Lutador("Ylan", "Japonês", 18, 8,1, 3, 1.75f, 60);
        l[2] = new Lutador("Ivan", "Brasileiro", 25, 1,0, 0, 1.65f, 80);

        for (int i = 0; i < l.length; i++){
            l[i].apresentar();
        }

        Luta luta[] = new Luta[3];
        luta[0] = new Luta(l[1], l[0], 3, true);
        luta[0].marcarLuta();
        luta[0].lutar();




    }
}
