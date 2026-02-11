package org.example.javastreams;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class JavaLambdaExpression {
    public static void main(String[] args) {

        List<Integer> sum = new ArrayList<>();
        sum.add(1);
        sum.add(2);
        sum.add(3);
        sum.add(4);
        sum.add(5);
        sum.add(6);
        sum.add(7);
        sum.add(8);
        sum.add(9);
        sum.add(10);
        sum.add(11);
        sum.add(12);
        sum.add(13);
        sum.add(14);
        sum.add(15);
        sum.add(16);
        sum.add(17);
        sum.add(18);
        sum.add(19);
        sum.add(20);
        sum.add(20);
        sum.add(20);
        List<Integer> sumDoubled = sum.stream().map(a -> a * a).toList();

        System.out.println(sum.stream().collect(toUnmodifiableSet()));
        System.out.println();


        Employee e1 = new Employee("akshay1", 1, "SD1");
        Employee e2 = new Employee("akshay2", 2, "SD1");
        Employee e3 = new Employee("akshay3", 3, "SD1");
        Employee e4 = new Employee("akshay4", 4, "SD2");
        Employee e5 = new Employee("akshay5", 5, "SD2");
        Employee e6 = new Employee("akshay6", 6, "SD2");
        Employee e7 = new Employee("akshay6", 7, "SD3");
        Employee e8 = new Employee("akshay7", 8, "SD3");
        Employee e9 = new Employee("akshay8", 9, "SD3");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);
        employeeList.add(e8);
        employeeList.add(e9);

        System.out.println(employeeList.stream().collect(toMap(Function.identity(), Employee::employeeNameLength)));
        System.out.println();
        System.out.println(employeeList.stream().collect(toMap(Employee::getName, Employee::getPhoneNumber,
                Integer::sum)));
        System.out.println();
        Map<String, DepartmentSummary> result = employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,
                collectingAndThen(toList(), Employee::createSummary)));

        System.out.println(result);

        DoubleSummaryStatistics dss = employeeList.stream().collect(summarizingDouble(Employee::getPhoneNumber));


        System.out.println("max :: " + dss.getMax());

        Optional<Employee> result2 = employeeList.stream().collect(maxBy(Comparator.comparing(Employee::getName)));
        System.out.println(result2.get());


        System.out.println("    *****    *****  ******   ");
        System.out.println(employeeList.stream().collect(groupingBy(Employee::getDepartment,
                collectingAndThen(maxBy(Comparator.comparing(Employee::getPhoneNumber)), Optional::get))));
        List<String> empList = employeeList.stream().map(Employee::employeeNameInCaps).collect(toList());
        System.out.println(empList);


        sum.stream().collect(toCollection(LinkedList::new));
        //if we have to write return statement then curly braces is needed.
        SumFunctionalInterface sfi = (a, b) -> {
            return a + b;
        };
        //no need to explicitly mention return when we have defined logic in one line.
        SumFunctionalInterface sfi2 = (a, b) -> a + b;
        System.out.println(sfi.sumOfTwoValues(2, 3));

        System.out.println("akv123 :: " + sfi2.sumOfTwoValues(2, 3));

        Map<String, Consumer<String>> mapOfConsumer = new HashMap<String, Consumer<String>>();
        mapOfConsumer.put("hello", JavaLambdaExpression::changeString);

        Function<Integer, Integer> sum2 = (a) -> a + 10;
        BiFunction<Integer, Integer, Integer> bif = Integer::sum;
        BiFunction<Integer, Integer, Integer> bif2 = (a, b) -> a + b;

        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
        Set<String> result4 = listWithDuplicates.stream().collect(toSet());
        System.out.println(result4);
    }

    int calculateSum(int a, int b) {
        return a + b;
    }

    public <T extends Number> void test(T field) {

    }

    public static void changeString(String nameInSmall) {
        System.out.println(nameInSmall.toUpperCase());
    }

}
