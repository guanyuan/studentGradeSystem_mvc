package com.thoughtworks.ns.mvc;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class StudentControllerTest {
    @Mock
    private View view;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_dispatch_to_view_when_print_one_student() throws Exception {
        Student student = new Student("a name", 90);
        StudentController controller = new StudentController(student, view);
        controller.printOneStudent();

        verify(view, times(1)).printOneStudent(student);
    }

    @Test
    public void should_dispatch_to_view_when_print_students() throws Exception {
        List<Student> students = of();
        StudentController controller = new StudentController(students, view);
        controller.printStudents();

        verify(view, times(1)).printStudents(students);
    }
}
