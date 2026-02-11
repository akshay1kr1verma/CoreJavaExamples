package org.example.enumeration;

public enum DaysEnumSampleWithCustomValues {
    MONDAY(1, "monday") {
        @Override
        public DaysEnumSampleWithCustomValues getDaysFromSample1(int i) {
            return DaysEnumSampleWithCustomValues.MONDAY;
        }
    },
    TUESDAY(2, "tuesday"),
    WEDNESDAY(3, "wednesday"),
    THURSDAY(4, "thursday"),
    FRIDAY(5, "friday"),
    SATURDAY(6, "saturday"),
    SUNDAY(7, "sunday");

    private int day;
    private String comment;

    public int getDay() {
        return day;
    }

    public String getComment() {
        return comment;
    }

    DaysEnumSampleWithCustomValues(int day, String comment) {
        this.day = day;
        this.comment = comment;
    }

    public static DaysEnumSampleWithCustomValues getDaysFromSample(int i) {
        DaysEnumSampleWithCustomValues day1;
        for (DaysEnumSampleWithCustomValues day : DaysEnumSampleWithCustomValues.values()) {
            if (day.getDay() == i) {
                return day;
            }
        }
        return null;
    }

    public DaysEnumSampleWithCustomValues getDaysFromSample1(int i) {
        DaysEnumSampleWithCustomValues day1;
        for (DaysEnumSampleWithCustomValues day : DaysEnumSampleWithCustomValues.values()) {
            if (day.getDay() == i) {
                return day;
            }
        }
        return null;
    }
}
