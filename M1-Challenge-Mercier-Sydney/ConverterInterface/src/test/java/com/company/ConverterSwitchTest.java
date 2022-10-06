package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterSwitchTest {

    ConverterSwitch converterSwitch;

    @Before
    public void setUp() {
        converterSwitch = new ConverterSwitch();
    }

    @Test
    public void convertMonth() {
        assertEquals("March", converterSwitch.convertMonth(3));
        assertEquals("January", converterSwitch.convertMonth(1));
        assertEquals("December", converterSwitch.convertMonth(12));
    }

    @Test
    public void shouldReturnMonthErrorMessage() {
        assertEquals("Number must be between 1 and 12 inclusive.", converterSwitch.convertMonth(0));
        assertEquals("Number must be between 1 and 12 inclusive.", converterSwitch.convertMonth(13));
    }

    @Test
    public void convertDay() {
        assertEquals("Wednesday", converterSwitch.convertDay(4));
        assertEquals("Sunday", converterSwitch.convertDay(1));
        assertEquals("Saturday", converterSwitch.convertDay(7));
    }

    @Test
    public void shouldReturnDayErrorMessage() {
        assertEquals("Number must be between 1 and 7 inclusive.", converterSwitch.convertDay(8));
        assertEquals("Number must be between 1 and 7 inclusive.", converterSwitch.convertDay(0));
    }
}