package org.example.enumeration;

public class EnumSamples {
    public static void main(String []args){

        for(Days day: Days.values()){
            System.out.println("Day " + day.ordinal() + " :: " + day.toString());
        }

        for(DaysEnumSampleWithCustomValues dayWithCustomValue: DaysEnumSampleWithCustomValues.values()){
            System.out.println("Day " + dayWithCustomValue + "day num :: " + dayWithCustomValue.getDay()
                    + " comment  " + dayWithCustomValue.getComment());
        }

        DaysEnumSampleWithCustomValues day = DaysEnumSampleWithCustomValues.valueOf(DaysEnumSampleWithCustomValues.class, "MONDAY");
        System.out.println("day :: " + day);

        /*
        *  Exception in thread "main" java.lang.IllegalArgumentException:
        *  No enum constant org.example.enumeration.DaysEnumSampleWithCustomValues.Monday
        DaysEnumSampleWithCustomValues day2 = DaysEnumSampleWithCustomValues.valueOf(DaysEnumSampleWithCustomValues.class, "Monday");
        System.out.println("day :: " + day2);
        *
        * */

        System.out.println(DaysEnumSampleWithCustomValues.MONDAY.getDaysFromSample1(2));
    }
}
