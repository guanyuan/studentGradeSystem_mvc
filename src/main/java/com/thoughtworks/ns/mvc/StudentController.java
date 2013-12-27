package com.thoughtworks.ns.mvc;

import java.util.List;

public class StudentController {
    private Student student;
    private final View view;
    private List<Student> students;

    public StudentController(Student student, View view) {
        this.student = student;
        this.view = view;
    }

    public StudentController(List<Student> students, View view) {
        this.students = students;
        this.view = view;
    }

    public void printOneStudent() {
        view.printOneStudent(student);
    }

    public void printStudents() {
        view.printStudents(students);
    }
}
