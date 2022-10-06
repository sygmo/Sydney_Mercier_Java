package com.company;

public class Calculator {

    public String add(int a, int b) {
        int sum = a + b;
        return a + " + " + b + " = " + sum;
    }

    public String subtract(int a, int b) {
        int difference = a - b;
        return a + " - " + b + " = " + difference;
    }

    public String multiply(int a, int b) {
        int product = a * b;
        return a + " * " + b + " = " + product;
    }

    public String divide(int a, int b) {
        int quotient = a / b;
        return a + " / " + b + " = " + quotient;
    }

    public String add(double a, double b) {
        String sum = String.format("%.2f", a + b);
        return a + " + " + b + " = " + sum;
    }

    public String subtract(double a, double b) {
        String difference = String.format("%.2f", a - b);
        return a + " - " + b + " = " + difference;
    }

    public String multiply(double a, double b) {
        String product = String.format("%.2f", a * b);
        return a + " * " + b + " = " + product;
    }

    public String divide(double a, double b) {
        String quotient = String.format("%.2f", a / b);
        return a + " / " + b + " = " + quotient;
    }
}
