package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test


public void testarea(){
    Point p1 = new Point(4,3);
    Point p2 = new Point(1,2);
    Point p3 = new Point(0,5);
    Point p4 = new Point(6,4);
    Point p5 = new Point(2,1);
    Point p6 = new Point(1,2);

    Assert.assertEquals(p1.distance(p1, p2) , 3.1622776601683795);
    Assert.assertEquals(p1.distance(p3, p4) , 6.082762530298219);
    Assert.assertEquals(p1.distance(p5, p6) , 1.4142135623730951);

    }


}
