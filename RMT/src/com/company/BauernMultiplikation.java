package com.company;

import static java.lang.Math.floor;

public class BauernMultiplikation {
    public double multipliziereWieRussischeBauern(double zahl1, double zahl2) {
        double[] doppelteVonZahl2 = new double[10];
        int counter = 0;
        int ergebnis = 0;

        while (zahl1 > 1) {
            if (zahl1 % 2 == 0) {
                doppelteVonZahl2[counter] = 0;
            } else {
                doppelteVonZahl2[counter] = zahl2;
            }
            zahl1 = floor(zahl1 / 2);
            zahl2 = zahl2 * 2;
            counter += 1;
        }
        doppelteVonZahl2[counter] = zahl2;
        for (double v : doppelteVonZahl2) {
            ergebnis += v;
        }
        return ergebnis;
    }
}

