package org.example.corejava;

import java.time.LocalDate;

public class MyStaticBlockTest {
    static {
        System.out.println("Initialize block getting called at time : " + LocalDate.now());
        initialize();
    }

    private static int sum;

    public static int getSum() {
        System.out.println("Initialize block called sum value : " + sum + " initialized :" + initialized);
        initialize();
        return sum;
    }

    private static boolean initialized = false;

    private static void initialize() {
        if (!initialized) {
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            initialized = true;
        }
        System.out.println("Initialize block called sum value : " + sum + " initialized :" + initialized);
    }
}

