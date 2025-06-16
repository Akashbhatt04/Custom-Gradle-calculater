package com.calculator;

import java.util.Scanner;

public class App {

    public static double calculate(double a, double b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    yield Double.NaN;
                }
                yield a / b;
            }
            default -> {
                System.out.println("Error: Invalid operator.");
                yield Double.NaN;
            }
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.println("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = calculate(num1, num2, operator);
        System.out.println("Result: " + result);
    }
}
