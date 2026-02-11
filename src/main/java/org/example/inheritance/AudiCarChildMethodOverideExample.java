package org.example.inheritance;

public class AudiCarChildMethodOverideExample extends CarParentMethodOverideExample {

    @Override
    public void nonStaticPaintMethod()  {
        System.out.println("AudiCarChildMethodOverideExample paint method called");
    }


    public static void staticPaintMethod()  {
        System.out.println("AudiCarChildMethodOverideExample static paint method called");
    }

    public final void finalPaintMethod1()  {
        System.out.println("AudiCarChildMethodOverideExample final paint method called");
    }
}
