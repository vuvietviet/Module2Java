package com.codegym;

public class Calculator {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';

    public static int calculate(int firstOperand, int secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println(Calculator.calculate(5,5,'+'));
        System.out.println(Calculator.calculate(5,5,'-'));
        System.out.println(Calculator.calculate(5,5,'*'));
        System.out.println(Calculator.calculate(5,5,'/'));
        System.out.println(Calculator.calculate(5,5,'='));
    }
}
