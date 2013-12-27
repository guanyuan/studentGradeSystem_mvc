package com.thoughtworks.ns.mvc;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;

public class StudentViewWithComma implements View {

    private static final Joiner JOINER_ON_NEW_LINE = Joiner.on('\n');
    private static int PASSING_GRADE = 60;

    @Override
    public String printOneStudent(Student student) {
        return student.getName()+","+student.getGrade();
    }

    @Override
    public String printStudents(List<Student> students) {
        return joinOutputWithNewLine(
                from(students)
                        .transform(toCommaStyle())
        );
    }

    public String printOneStudentWithColon(Student student) {
        return "{"+student.getName()+":"+student.getGrade()+"}";
    }

    private String joinOutputWithNewLine(Iterable<String> eachLine) {
        return JOINER_ON_NEW_LINE.join(eachLine);
    }

    private Function<Student, String> toCommaStyle() {
        return new Function<Student, String>() {
            @Override
            public String apply(Student input) {
                return input.getName() + "," + input.getGrade();
            }
        };
    }

    public String printPassedStudentsWithComma(List<Student> students) {
        return joinOutputWithNewLine(
                from(students)
                        .filter(passedStudent())
                        .transform(toCommaStyle())
        );
    }

    private Predicate<Student> passedStudent() {
        return new Predicate<Student>() {
            @Override
            public boolean apply(Student input) {
                return input.getGrade() >= PASSING_GRADE;
            }
        };
    }

    public String printStudentsWithColon(List<Student> students) {
        String result ="{";
        for (Student student : students) {
            result += student.getName() + ":" + student.getGrade();
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        return  result + "}";
    }

    public String printOneRomanStudentWithComma(Student student) {
        return student.getName() + "," + Conversion.arabicToRoman(student.getGrade());
    }

    public String printOneRomanStudentWithColon(Student student) {
        return "{" + student.getName() + ":" + Conversion.arabicToRoman(student.getGrade()) + "}";
    }

    public String printStudentsWithCommaByConcernRomans(List<Student> students) {
        String result ="";
        for (Student student : students) {
            result += student.getName() + ",";
            if (student.isRoman()) {
                result += Conversion.arabicToRoman(student.getGrade());
            } else {
                result += student.getGrade();
            }
            result += "\n";
        }
        return result;
    }


    public String printStudentsWithColonByConcernRomans(List<Student> students) {
        String result ="{";
        for (Student student : students) {
            result += student.getName() + ":";
            if (student.isRoman()) {
                result += Conversion.arabicToRoman(student.getGrade());
            } else {
                result += student.getGrade();
            }
            result += ", ";
        }
        result = result.substring(0, result.length() - 2);
        return result + "}";
    }

    public String printPassedStudentsWithCommaByConcernRomans(List<Student> students) {
        String result = "";
        for (Student student : students) {
            if (student.getGrade() > PASSING_GRADE) {
                result += student.getName() + ",";
                if (student.isRoman()) {
                    result += Conversion.arabicToRoman(student.getGrade());
                } else {
                    result += student.getGrade();
                }
                result += "\n";
            }
        }
        return result;
    }

    public String printPassedStudentsWithColonByConcernRomans(List<Student> students) {
        String result = "{";
        for (Student student : students) {
            if (student.getGrade() > PASSING_GRADE) {
                result += student.getName() + ":";
                if (student.isRoman()) {
                    result += Conversion.arabicToRoman(student.getGrade());
                } else {
                    result += student.getGrade();
                }
                result += ", ";
            }
        }
        result = result.substring(0, result.length()-2);
        result += "}";
        return result;
    }
}
