package com.thoughtworks.ns.mvc;

public class Student {
    private final String name;
    private final int grade;
    private boolean isRoman = false;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setRoman() {
        isRoman = true;
    }

    public boolean isRoman() {
        return isRoman;
    }
}
