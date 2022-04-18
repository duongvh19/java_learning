package com.duongvh19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("01","Alis", 18);
        Student s2 = new Student("02","Jim", 19);
        Student s3 = new Student("03","Tom", 20);
        Student s4 = new Student("04","Buggy", 16);
        Student s5 = new Student("05","Shank", 20);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        System.out.println("Before sort:");
        printStudents(students);

        System.out.println("===================");
        Collections.sort(students);
        System.out.println("After sort - age");
        printStudents(students);

        System.out.println("===================");
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        System.out.println("After sort - name");
        printStudents(students);
    }

    public static void printStudents (List<Student> students) {
        for(Student s : students) {
            System.out.println(s.toString());
        }
    }
}
