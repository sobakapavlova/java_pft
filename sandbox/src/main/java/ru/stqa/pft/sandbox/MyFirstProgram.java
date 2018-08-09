package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("Anastasija");
        hello("user");

        double l = 5;
        double a = 4;
        double b = 6;

        System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));
        System.out.println("Площадь треугольника со сторонами " + a + " и " + b + " = " + area(a, b));

    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody + "!");
    }

    public static double area(double l) {
        return l * l;
    }

    public static double area(double a, double b) {
        return a * b;
    }
}