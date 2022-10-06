package com.company.pointofsale;

public class IceCream {

    private String flavor;
    private String container;
    private int numberOfScoops;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public int getNumberOfScoops() {
        return numberOfScoops;
    }

    public void setNumberOfScoops(int numberOfScoops) {
        this.numberOfScoops = numberOfScoops;
    }

    public void greetCustomer() {
        System.out.println("Hello! What can I get for you today?");
    }

    public String sampleOrder() {
        return "I'll have " + numberOfScoops + " scoops of " + flavor + ".";
    }

    public String swirl(IceCream otherIceCream) {
        return "Mmmm, " + this.flavor + " and " + otherIceCream.getFlavor() + " swirl.";
    }
}
