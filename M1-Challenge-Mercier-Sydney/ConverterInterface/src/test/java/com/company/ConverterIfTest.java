package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConverterIfTest {

    private ConverterIf converterIf;

    @Before
    public void setUp() {
        converterIf = new ConverterIf();
    }

    @Test
    public void convertMonth() {
        assertEquals("February", converterIf.convertMonth(2));
        assertEquals("January", converterIf.convertMonth(1));
        assertEquals("December", converterIf.convertMonth(12));
    }

    @Test
    public void shouldReturnMonthErrorMessage() {
        assertEquals("Number must be between 1 and 12 inclusive.", converterIf.convertMonth(13));
        assertEquals("Number must be between 1 and 12 inclusive.", converterIf.convertMonth(0));
    }

    @Test
    public void convertDay() {
        assertEquals("Friday", converterIf.convertDay(6));
        assertEquals("Sunday", converterIf.convertDay(1));
        assertEquals("Saturday", converterIf.convertDay(7));
    }

    @Test
    public void shouldReturnDayErrorMessage() {
        assertEquals("Number must be between 1 and 7 inclusive.", converterIf.convertDay(0));
        assertEquals("Number must be between 1 and 7 inclusive.", converterIf.convertDay(8));
    }
}