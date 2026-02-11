package org.example.javastreams;

import java.util.List;

public class Employee {
    private String name;
    private int phoneNumber;
    private String department;

    public Employee(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String employeeNameInCaps() {
        return this.getName().toUpperCase();
    }

    public int employeeNameLength() {
        return this.getName().length();
    }

    public Employee(String name, int phoneNumber, String department) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", department='" + department + '\'' +
                '}';
    }

    public static DepartmentSummary createSummary(List<Employee> employees) {
        int total = employees.size();
        double avgSalary = employees.stream().mapToInt(Employee::getPhoneNumber).average().orElse(0);
        return new DepartmentSummary(employees.get(0).getDepartment(), total, avgSalary);
    }
}
