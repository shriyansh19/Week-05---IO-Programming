package com.csvhandling.problem9;

public class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', age=%d, marks=%d}", id, name, age, marks);
    }


}