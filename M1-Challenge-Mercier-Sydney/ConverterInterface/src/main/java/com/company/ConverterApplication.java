package com.company;

public class ConverterApplication {
    public static void main(String[] args) {

        /* This is all my original code, but I discussed the implementation
        * with fellow students Uziel Carranza and Nara Davaasuren during a
        * class activity. */

        ConverterIf convertIf = new ConverterIf();
        ConverterSwitch convertSwitch = new ConverterSwitch();

        System.out.println(convertIf.convertMonth(9));
        System.out.println(convertIf.convertDay(2));

        System.out.println(convertSwitch.convertMonth(3));
        System.out.println(convertSwitch.convertDay(6));
    }
}