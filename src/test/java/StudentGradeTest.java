import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentGradeTest {
    StudentGrade stuInfo;
    StudentGradeGroup studentGroup;
    StudentView studentView;


    @Before
    public void setUp() throws Exception {
        stuInfo = new StudentGrade("A", 100);
        studentGroup = new StudentGradeGroup();
        studentView = new StudentView();


    }

    @Test
    public void should_print_student_A_and_his_grade() throws Exception {
        assertThat(stuInfo.printNameAndGrade(), is("A,100"));
    }

    @Test
    public void should_print_student_info_with_comma() throws Exception {
        StudentView studentView = new StudentView();
        assertThat(studentView.printNameAndGradeWithComma(stuInfo), is("A,100"));
    }

    @Test
    public void should_print_all_student_info_with_enter() throws Exception {

        String result = "A,100\nB,80\nC,59\n";
        assertThat(studentView.printAllStudentInfo(studentGroup.nameGradeMap), is(result));
    }

    @Test
    public void should_print_all_passed_student_info_with_enter() throws Exception {

        String result = "A,100\nB,80\n";
        assertThat(studentView.printAllPassedStudentInfo(studentGroup.nameGradeMap), is(result));
    }

    @Test
    public void should_print_a_student_with_colon() throws Exception {
        assertThat(studentView.printNameAndGradeWithColon(stuInfo), is("{A:100}"));
    }
}
