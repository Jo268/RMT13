package com.company;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        new Main().verschluessele("?Hier! eingeben, was du willst!");
    }

    // ROT13 Methode
    public void verschluessele(String string) {

        String meinAlphabet = "?!., abcdefghijklmnopqrstuvwxyz";
        String rmtAlphabet = "?!., nopqrstuvwxyzabcdefghijklm";
        char[] charNormalAlphabet = meinAlphabet.toUpperCase(Locale.ROOT).toCharArray();
        char[] charRMTAlphabet = rmtAlphabet.toUpperCase(Locale.ROOT).toCharArray();
        char[] eingabe = string.toUpperCase(Locale.ROOT).toCharArray();
        char[] ausgabe = new char[eingabe.length];
        int zeiger = 0;
        // Test für Umlaute
        for(char c : eingabe){
            if(c == 'ö'){

            }
        }
        // Verschlüsselung
        for (int i = 0; i < eingabe.length; i++) {
            char value = eingabe[i];
            for (int j = 0; j < charNormalAlphabet.length; j++) {
                if (value == charNormalAlphabet[j]) {
                    zeiger = j;
                }
            }
            ausgabe[i] = charRMTAlphabet[zeiger];
        }
        System.out.println(ausgabe);
    }

}

