package com.company;

public class Constable extends Character {
    private String jurisdiction;

    public Constable(String name, String jurisdiction) {
        super(name, 60, 100, 60, 20, 5, false, false);
        this.jurisdiction = jurisdiction;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void arrestAnotherCharacter(Character otherChar) {
        otherChar.setArrested(true);
    }
}
