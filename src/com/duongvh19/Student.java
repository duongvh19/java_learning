package com.duongvh19;

public class Student implements Comparable{

    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student: " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age;
    }


    // compare - id

    @Override
    public int compareTo(Object o) {
        if (o instanceof Student){
            Student s = (Student) o;
            return this.getAge() > s.getAge() ? 1 : -1;
        }
        return 0;
    }
}
