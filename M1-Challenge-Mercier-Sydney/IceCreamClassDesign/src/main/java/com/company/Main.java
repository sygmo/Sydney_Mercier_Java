package com.company;

public class Main {
    public static void main(String[] args) {

        com.company.factory.IceCream factoryIceCream = new com.company.factory.IceCream();
        com.company.pointofsale.IceCream shopIceCream = new com.company.pointofsale.IceCream();

        factoryIceCream.setFlavor("chocolate");
        factoryIceCream.setPackaging("tub");
        factoryIceCream.setWeight(5.5d);

        factoryIceCream.callFactoryManager();
        System.out.println(factoryIceCream.whatFlavor());
        System.out.println(factoryIceCream.bulkOrder());

        shopIceCream.setFlavor("vanilla");
        shopIceCream.setContainer("cone");
        shopIceCream.setNumberOfScoops(3);

        com.company.pointofsale.IceCream shopIceCream2 = new com.company.pointofsale.IceCream();
        shopIceCream2.setFlavor("pumpkin");

        shopIceCream.greetCustomer();
        System.out.println(shopIceCream.sampleOrder());
        System.out.println(shopIceCream.swirl(shopIceCream2));
    }
}