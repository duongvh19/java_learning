package com.duongvh19;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args)  {
        Employee john = new Employee("John Dick", 23);
        Employee tim = new Employee("Tim Cook", 31);
        Employee nathan = new Employee("Nathan Lee", 27);
        Employee tom = new Employee("Tom Hill", 33);
        Employee jack = new Employee("Jack River", 40);
        Employee hill = new Employee("Hill Garden", 23);
        Employee david = new Employee("David Son", 35);

        List<Employee> employees = new ArrayList<>();

        employees.add(john);
        employees.add(tim);
        employees.add(nathan);
        employees.add(tom);
        employees.add(jack);
        employees.add(hill);
        employees.add(david);

        printEmployeesByAge(employees, "Employees over 30.", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);

        //Functional Interface
        Total t = (a, b) -> a+b;
        System.out.println(t.add(john.getAge(), tom.getAge()));

        //Predicate
        Predicate<Integer> lessThan100 = i -> i <=100;
        System.out.println(lessThan100.test(15));

        System.out.println("lessThan100 and greaterThan25: ");
        Predicate<Integer> greaterThan25 = i -> i >25;
        System.out.println(lessThan100.and(greaterThan25).test(50));


        // Supplier
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(100);
        System.out.println(randomSupplier.get());

        // Function
        Function<Integer,Integer> func = i -> i * 2;
        System.out.println("i * 2 = " + func.apply(5));

    }

    public static void printEmployeesByAge(List<Employee> employees,
                                           String ageText,
                                           Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=====================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}

interface Total {
    int add(int a, int b);
}
