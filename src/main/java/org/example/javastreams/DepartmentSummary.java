package org.example.javastreams;

public class DepartmentSummary {
    private String departmentName;
    private int total;
    private double avgSalary;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public DepartmentSummary(String departmentName, int total, double avgSalary) {
        this.departmentName = departmentName;
        this.total = total;
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "DepartmentSummary{" +
                "departmentName='" + departmentName + '\'' +
                ", total=" + total +
                ", avgSalary=" + avgSalary +
                '}';
    }
}
