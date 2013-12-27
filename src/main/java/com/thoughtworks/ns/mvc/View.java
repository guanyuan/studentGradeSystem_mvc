package com.thoughtworks.ns.mvc;

import java.util.List;

public interface View {
    String printOneStudent(Student student);

    String printStudents(List<Student> students);
}
