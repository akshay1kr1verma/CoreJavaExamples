package org.example.corejava;

import java.time.LocalTime;

public class StaticInitialization {
    private static final LocalTime time1 = LocalTime.now();
    // first field is initialized here (time2). this happens at linking (preparation) phase
    private static LocalTime time2 = LocalTime.now();
    static {
        System.out.println(time2);
        //then static block is called, this happens at linking (preparation) phase, static block
        // is called later when compared to initialization during field declaration.
        time2 = LocalTime.now();
        System.out.println(time2);
    }

    public static void main(String args[]) {
        System.out.println("time1 : " + time1 + " time2 : " + time2);
    }
}
