package org.example.inheritance;

public class CarParentMethodOverideExample {
    public void nonStaticPaintMethod()  {
        System.out.println("CarParentMethodOverideExample paint method called");
    }

    public static void staticPaintMethod()  {
        System.out.println("CarParentMethodOverideExample static paint method called");
    }

    public final void finalPaintMethod()  {
        System.out.println("CarParentMethodOverideExample final paint method called");
    }
}
