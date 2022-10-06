package com.company;

public class Main {
    public static void main(String[] args) {

        // is the common base class a normal class, an abstract class, or an interface?
        // use any you want, but interface is NOT recommended

        Farmer farmer = new Farmer("Roger");
        Farmer otherFarmer = new Farmer("Jason");

        System.out.println(farmer.getHealth());
        otherFarmer.attackAnotherCharacter(farmer);
        System.out.println(farmer.getHealth());
    }
}