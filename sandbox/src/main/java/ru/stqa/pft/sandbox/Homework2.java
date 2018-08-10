package ru.stqa.pft.sandbox;

public class Homework2 {

    public static void main(String[] args) {
        Point p1 = new Point(4,3);
        Point p2 = new Point(1,2);
        System.out.println("Расстояние между двумя точками (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") = " + p1.distance(p1,p2));

    }

// Создать функцию которая вычисляет расстояние между двумя точками.
//    public static double distance(Point p1, Point p2){
//        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y)  * (p2.y - p1.y));
//    }




}