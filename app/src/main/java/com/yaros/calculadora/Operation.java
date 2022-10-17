package com.yaros.calculadora;

public class Operation {
    private double number1;
    private double number2;
    private char c;

    public Operation() {
    }
    public Operation(double number1, double number2, char c) {
        this.number1 = number1;
        this.number2 = number2;
        this.c = c;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public double getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public double makeOperation(){
        if(c == 'x')
            return number1 * number2;
        else if(c == '/')
            return number1 / number2;
        else if(c == '%')
            return number1 % number2;
        else if(c == '+')
            return number1 + number2;
        else if(c == '-')
            return number1 - number2;
        else
            return 0;
    }
}
