package com.thoughtworks.ns.mvc;

import java.util.ArrayList;

public class StudentCollection {

    public ArrayList<Student> studentList = new ArrayList<>();

    public StudentCollection(){
    }

    public void add(Student student) {
        studentList.add(student);
    }
}
