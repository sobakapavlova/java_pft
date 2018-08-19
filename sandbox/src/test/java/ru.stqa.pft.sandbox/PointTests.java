package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test


public void testarea(){
    Point p1 = new Point(4,3);
    Point p2 = new Point(1,2);
    Point p3 = new Point(2,1);
    Point p4 = new Point(1,2);

    Assert.assertEquals(p1.distance(p2) , 3.1622776601683795);
    Assert.assertEquals(p3.distance(p4) , 1.4142135623730951);
    }


}
