package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    Farmer farmer;
    Constable constable;
    Warrior warrior;

    @Before
    public void setUp() throws Exception {
        farmer = new Farmer("William");
        constable = new Constable("Duncan", "Thedas");
        warrior = new Warrior("Hawke");
    }

    @Test
    public void shouldInitializeDefaultValues() {
        assertEquals("William", farmer.getName());
        assertEquals(false, farmer.isPlowing());
        assertEquals(false, farmer.isHarvesting());
        assertEquals(75, farmer.getStrength());

        assertEquals("Duncan", constable.getName());
        assertEquals("Thedas", constable.getJurisdiction());
        assertEquals(100, constable.getHealth());
        assertEquals(60, constable.getStamina());

        assertEquals("Hawke", warrior.getName());
        assertEquals(100, warrior.getShieldStrength());
        assertEquals(50, warrior.getSpeed());
        assertEquals(10, warrior.getAttackPower());
    }

    @Test
    public void shouldBeAbleToAttackAnotherCharacter() {
        assertEquals(100, farmer.getHealth());
        assertEquals(100, constable.getHealth());
        assertEquals(100, warrior.getHealth());

        farmer.attackAnotherCharacter(constable);
        constable.attackAnotherCharacter(warrior);
        warrior.attackAnotherCharacter(farmer);

        assertEquals(90, farmer.getHealth());
        assertEquals(99, constable.getHealth());
        assertEquals(95, warrior.getHealth());

        farmer.attackAnotherCharacter(warrior);
        constable.attackAnotherCharacter(farmer);
        warrior.attackAnotherCharacter(constable);

        assertEquals(85, farmer.getHealth());
        assertEquals(89, constable.getHealth());
        assertEquals(94, warrior.getHealth());
    }

    @Test
    public void shouldBeAbleToArrestAnotherCharacter() {
        assertEquals(false, farmer.isArrested());
        assertEquals(false, warrior.isArrested());

        constable.arrestAnotherCharacter(farmer);
        constable.arrestAnotherCharacter(warrior);

        assertEquals(true, farmer.isArrested());
        assertEquals(true, warrior.isArrested());
    }
}