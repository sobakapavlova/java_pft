package ru.stqa.pft.sandbox;

public class Homework2 {

    public static void main(String[] args) {
        Point p1 = new Point(4,3);
        Point p2 = new Point(1,2);

//        Square s = new Square(5);
//        Rectangle r = new Rectangle(4,2);

//        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());
//        System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + " равна " + r.area());
        System.out.println("Расстояние между двумя точками (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") = " + p1.distance(p2));

        Point p3 = new Point(2,1);
        Point p4 = new Point(1,2);
        System.out.println("Расстояние между двумя точками (" + p3.x + "," + p3.y + ") и (" + p4.x + "," + p4.y + ") = " + p3.distance(p4));
    }
// Создать функцию которая вычисляет расстояние между двумя точками.
//    public static double distance(Point p1, Point p2){
//        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y)  * (p2.y - p1.y));
//    }
}