import com.google.common.collect.ImmutableList;

import java.util.Iterator;

public class StudentView {
    public final int Ten = 10;

    public String printOneStudentWithComma(Student student) {
        return student.getName()+","+student.getGrade();
    }

    public String printOneStudentWithColon(Student student) {
        return "{"+student.getName()+":"+student.getGrade()+"}";
    }


    public String printStudentsWithComma(StudentCollection studentCollection) {
        String result="";
        Iterator mapIterator = studentCollection.studentList.iterator();
        while (mapIterator.hasNext()) {
            Student student = (Student) mapIterator.next();
            result += student.getName()+","+student.getGrade()+"\n";
        }
        return result;
    }

    public String printPassedStudentsWithComma(StudentCollection studentCollection) {
        String result = "";
        Iterator mapIterator = studentCollection.studentList.iterator();
        while (mapIterator.hasNext()) {
            Student student = (Student) mapIterator.next();
            if (student.getGrade() > 60){
                result += student.getName()+","+student.getGrade()+"\n";
            }
        }
        return result;
    }

    public String printStudentsWithColon(StudentCollection studentCollection) {
        String result ="{";
        Iterator mapIterator = studentCollection.studentList.iterator();
        while (mapIterator.hasNext()) {
            Student student = (Student) mapIterator.next();
            result += student.getName() + ":" + student.getGrade();
            if (mapIterator.hasNext()) {
                result +=  ", ";
            } else {
                result += "}";
            }
        }
        return  result;
    }



    public String printOneRomanStudentWithComma(Student student) {
        return student.getName() + "," + ArabicToRoman(student.getGrade());
    }

    private String ArabicToRoman(int grade) {
        ImmutableList<String> ones = ImmutableList.of("","I","II","III","IV","V","VI","VII","VIII","IX");
        ImmutableList<String> tens = ImmutableList.of("","X","XX","XXX","XL","L","LX","LXX","LXXX","XC");
        return tens.get(grade / Ten) + ones.get(grade % Ten);
    }

    public String printOneRomanStudentWithColon(Student student) {
        return "{" + student.getName() + ":" + ArabicToRoman(student.getGrade()) + "}";
    }


    public String printStudentsWithCommaByConcernRomans(StudentCollection studentCollection) {
        String result ="";
        Iterator listIterator = studentCollection.studentList.iterator();
        while (listIterator.hasNext()) {
            Student student = (Student)listIterator.next();
            result += student.getName() + ",";
            if (student.isRoman()) {
                result += ArabicToRoman(student.getGrade());
            } else {
                result += student.getGrade();
            }
            result += "\n";

        }
        return result;
    }


    public String printStudentsWithColonByConcernRomans(StudentCollection studentCollection) {
        String result ="{";
        Iterator listIterator = studentCollection.studentList.iterator();
        while (listIterator.hasNext()) {
            Student student = (Student)listIterator.next();
            result += student.getName() + ":";
            if (student.isRoman()) {
                result += ArabicToRoman(student.getGrade());
            } else {
                result += student.getGrade();
            }
            if (listIterator.hasNext()) {
                result += ", ";
            } else {
                result += "}";
            }

        }
        return result;
    }

    public String printPassedStudentsWithCommaByConcernRomans(StudentCollection studentCollection) {
        String result = "";
        Iterator<Student> studentIterator = studentCollection.studentList.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getGrade() > 60) {
                result += student.getName() + ",";
                if (student.isRoman()) {
                    result += ArabicToRoman(student.getGrade());
                } else {
                    result +=student.getGrade();
                }
                result += "\n";
            }
        }
        return result;
    }

    public String printPassedStudentsWithColonByConcernRomans(StudentCollection studentCollection) {
        String result = "{";
        Iterator<Student> studentIterator = studentCollection.studentList.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.getGrade() > 60) {
                result += student.getName() + ":";
                if (student.isRoman()) {
                    result += ArabicToRoman(student.getGrade());
                } else {
                    result +=student.getGrade();
                }
                result += ", ";
            }
        }
        result = result.substring(0, result.length()-2);
        result += "}";
        return result;
    }
}
