package org.example.inheritance;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        byte a = 1;
        byte b = 127;
        byte c = (byte) (a + b);
        System.out.println(c);
        int d =  a + b;
        System.out.println(d);
        CarParentMethodOverideExample carObject = new AudiCarChildMethodOverideExample();
        carObject.nonStaticPaintMethod();
        carObject.finalPaintMethod();
        CarParentMethodOverideExample.staticPaintMethod();
        carObject.staticPaintMethod();
        AudiCarChildMethodOverideExample audiCar = (AudiCarChildMethodOverideExample)carObject;
        System.out.println("*********************************************");
        audiCar.finalPaintMethod();
        audiCar.finalPaintMethod1();
        audiCar.nonStaticPaintMethod();
        AudiCarChildMethodOverideExample.staticPaintMethod();
        audiCar.staticPaintMethod();
        }


}