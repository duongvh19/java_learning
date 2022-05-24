package com.duongvh19;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
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
