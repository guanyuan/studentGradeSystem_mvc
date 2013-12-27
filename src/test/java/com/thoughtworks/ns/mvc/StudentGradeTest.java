package com.thoughtworks.ns.mvc;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentGradeTest {
    private Student studentA;
    private Student studentD;
    private List<Student> studentCollection;
    private StudentViewWithComma studentViewWithComma;

    @Before
    public void setUp() throws Exception {
        studentA = new Student("A", 100);
        studentD = new Student("D", 76);
        // student D is a Roman
        studentD.setRoman();

        studentCollection = newArrayList(of(
                studentA,
                new Student("B", 80),
                new Student("C", 59)
        ));
        studentViewWithComma = new StudentViewWithComma();
    }

    @Test
    public void should_print_all_passed_student_info_with_comma() throws Exception {
        String result = "A,100\n" +
                "B,80";
        assertThat(studentViewWithComma.printPassedStudentsWithComma(studentCollection), is(result));
    }

    @Test
    public void should_print_a_student_with_colon() throws Exception {
        assertThat(studentViewWithComma.printOneStudentWithColon(studentA), is("{A:100}"));
    }

    @Test
    public void should_print_all_students_with_colon() throws Exception {
        String result = "{A:100, B:80, C:59}";
        assertThat(studentViewWithComma.printStudentsWithColon(studentCollection), is(result));
    }

    @Test
    public void should_print_one_roman_student_with_comma() throws Exception {
        String result = "D,LXXVI";
        assertThat(studentViewWithComma.printOneRomanStudentWithComma(studentD), is(result));
    }

    @Test
    public void should_print_one_roman_student_with_colon() throws Exception {
        String result = "{D:LXXVI}";
        assertThat(studentViewWithComma.printOneRomanStudentWithColon(studentD), is(result));
    }

    @Test
    public void should_print_all_students_with_comma_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "A,100\n" +
                "B,80\n" +
                "C,59\n" +
                "D,LXXVI\n";
        assertThat(studentViewWithComma.printStudentsWithCommaByConcernRomans(studentCollection),is(result));
    }

    @Test
    public void should_print_all_students_with_colon_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "{A:100, B:80, C:59, D:LXXVI}";
        assertThat(studentViewWithComma.printStudentsWithColonByConcernRomans(studentCollection),is(result));
    }

    @Test
    public void should_print_all_passed_students_with_comma_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "A,100\n" +
                "B,80\n" +
                "D,LXXVI\n";
        assertThat(studentViewWithComma.printPassedStudentsWithCommaByConcernRomans(studentCollection),is(result));
    }

    @Test
    public void should_print_all_passed_students_with_colon_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "{A:100, B:80, D:LXXVI}";
        assertThat(studentViewWithComma.printPassedStudentsWithColonByConcernRomans(studentCollection),is(result));
    }
}
