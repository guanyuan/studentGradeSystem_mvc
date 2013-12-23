import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentGradeTest {
    Student studentA, studentB, studentC, studentD;
    StudentCollection studentCollection;
    StudentView studentView;

    @Before
    public void setUp() throws Exception {
        studentA = new Student("A", 100);
        studentB = new Student("B", 80);
        studentC = new Student("C", 59);
        studentD = new Student("D", 76);
        // student D is a Roman
        studentD.setRoman();

        studentCollection = new StudentCollection();
        studentCollection.add(studentA);
        studentCollection.add(studentB);
        studentCollection.add(studentC);
        studentView = new StudentView();
    }

    @Test
    public void should_print_a_student_info_with_comma() throws Exception {
        String result = "A,100";
        assertThat(studentView.printOneStudentWithComma(studentA), is(result));
    }

    @Test
    public void should_print_all_students_info_with_comma() throws Exception {
        String result = "A,100\n" +
                "B,80\n" +
                "C,59\n";
        assertThat(studentView.printStudentsWithComma(studentCollection), is(result));
    }

    @Test
    public void should_print_all_passed_student_info_with_comma() throws Exception {
        String result = "A,100\n" +
                "B,80\n";
        assertThat(studentView.printPassedStudentsWithComma(studentCollection), is(result));
    }

    @Test
    public void should_print_a_student_with_colon() throws Exception {
        assertThat(studentView.printOneStudentWithColon(studentA), is("{A:100}"));
    }

    @Test
    public void should_print_all_students_with_colon() throws Exception {
        String result = "{A:100, B:80, C:59}";
        assertThat(studentView.printStudentsWithColon(studentCollection), is(result));
    }

    @Test
    public void should_print_one_roman_student_with_comma() throws Exception {
        String result = "D,LXXVI";
        assertThat(studentView.printOneRomanStudentWithComma(studentD), is(result));
    }

    @Test
    public void should_print_one_roman_student_with_colon() throws Exception {
        String result = "{D:LXXVI}";
        assertThat(studentView.printOneRomanStudentWithColon(studentD), is(result));
    }

    @Test
    public void should_print_all_students_with_comma_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "A,100\n" +
                "B,80\n" +
                "C,59\n" +
                "D,LXXVI\n";
        assertThat(studentView.printStudentsWithCommaByConcernRomans(studentCollection),is(result));
    }

    @Test
    public void should_print_all_students_with_colon_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "{A:100, B:80, C:59, D:LXXVI}";
        assertThat(studentView.printStudentsWithColonByConcernRomans(studentCollection),is(result));
    }

    @Test
    public void should_print_all_passed_students_with_comma_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "A,100\n" +
                "B,80\n" +
                "D,LXXVI\n";
        assertThat(studentView.printPassedStudentsWithCommaByConcernRomans(studentCollection),is(result));
    }

    @Test
    public void should_print_all_passed_students_with_colon_by_concerning_roman() throws Exception {
        studentCollection.add(studentD);
        String result = "{A:100, B:80, D:LXXVI}";
        assertThat(studentView.printPassedStudentsWithColonByConcernRomans(studentCollection),is(result));
    }
}
