package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	     ArbolBinario ab = new ArbolBinario();
	     Random randy = new Random();
        for (int i = 0; i < 20; i++) {
            ab.agregarValor(randy.nextInt(100));
        }

    }
}
