package com.company;

public class Main {

    public static void main(String[] args) {
        new Main().nimmZahl(19);
    }

    public void nimmZahl(int zahl) {
        char[] zahlenArray = String.valueOf(zahl).toCharArray();
        int sum = 0;

        for (int i = 0; i <= zahlenArray.length - 1; i++) {
            double exponent =  Math.pow(Integer.parseInt(String.valueOf(zahlenArray[i])), 2);
            sum += exponent;
        }

        if(sum ==1) {
            System.out.println(sum + " ist eine glückliche Zhal");
        }else if(sum == 4){
            System.out.println(sum + " ist keine glückliche zahl.");
        }else {
            System.out.println(sum);
            nimmZahl(sum);
        }
    }
}
