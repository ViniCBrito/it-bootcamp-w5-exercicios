package br.com.meli.codigomorse.controllers;

import br.com.meli.codigomorse.utils.MorseTranslation;

public class Test {
    public static void main(String[] args) {
        for (MorseTranslation value : MorseTranslation.values()) {
            System.out.println(value.getMorse().getTranslation());
        }
    }
}
