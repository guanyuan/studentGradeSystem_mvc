package com.thoughtworks.ns.mvc;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentViewWithCommaTest {
    private Student studentA;
    private List<Student> studentCollection;
    private StudentViewWithComma studentViewWithComma;

    @Before
    public void setUp() throws Exception {
        studentA = new Student("A", 100);
        studentCollection = newArrayList(of(
                studentA,
                new Student("B", 80),
                new Student("C", 59)
        ));
        studentViewWithComma = new StudentViewWithComma();
    }

    @Test
    public void should_print_a_student_info_with_comma() throws Exception {
        String result = "A,100";
        assertThat(studentViewWithComma.printOneStudent(studentA), is(result));
    }

    @Test
    public void should_print_all_students_info_with_comma() throws Exception {
        String result = "A,100\n" +
                "B,80\n" +
                "C,59";
        assertThat(studentViewWithComma.printStudents(studentCollection), is(result));
    }

}
