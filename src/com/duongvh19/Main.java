package com.duongvh19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N38", "N27",
                "A26", "A45",
                "B15", "B17", "B45",
                "G54", "G48", "G67", "G37", "G25", "g55"
        );

        someBingoNumbers
                .stream()
                .map(s-> s.toUpperCase())
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(s -> System.out.println(s));
        System.out.println("============");

        Stream<String> ioNumberStream = Stream.of("I26", "I27", "I45", "I60");
        Stream<String> inNumberStream = Stream.of("N40", "N48", "I26", "I27", "I45", "I60");
        Stream<String> concatStreams = Stream.concat(ioNumberStream,inNumberStream);

        System.out.println(concatStreams
                .distinct()
                .peek(s -> System.out.println(s))
                .count());

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Haven", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 27);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployee().stream())
                .forEach(d -> System.out.println(d));

        //sortedGNumbers
        System.out.println("-----------------------");
        List<String> sortedGNumbers = someBingoNumbers.stream()
                .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

    }
}
