package com.company.factory;

public class IceCream {

    private String flavor;
    private String packaging;
    private double weight;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void callFactoryManager() {
        System.out.println("Hey boss, everything good on the factory floor today!");
    }

    public String whatFlavor() {
        return "This is " + flavor + "-flavored ice cream in a " + packaging + ".";
    }

    public double bulkOrder() {
        return 100 * weight;
    }
}
