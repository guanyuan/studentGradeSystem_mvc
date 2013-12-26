package com.thoughtworks.ns.mvc;

public class StudentView {

    public static int PASSING_GRADE = 60;
    
    public String printOneStudentWithComma(Student student) {
        return student.getName()+","+student.getGrade();
    }

    public String printOneStudentWithColon(Student student) {
        return "{"+student.getName()+":"+student.getGrade()+"}";
    }


    public String printStudentsWithComma(StudentCollection studentCollection) {
        //transform(studentCollection.studentList, com.thoughtworks.ns.mvc.Conversion.studentToCommaInfo());
        String result="";
        for (Student student : studentCollection.studentList) {
            result += student.getName() + "," + student.getGrade() + "\n";
        }
        return result;
    }

    public String printPassedStudentsWithComma(StudentCollection studentCollection) {
        String result = "";
        for (Student student : studentCollection.studentList) {
            if (student.getGrade() > PASSING_GRADE) {
                result += student.getName() + "," + student.getGrade() + "\n";
            }
        }
        return result;
    }

    public String printStudentsWithColon(StudentCollection studentCollection) {
        String result ="{";
        for (Student student : studentCollection.studentList) {
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


    public String printStudentsWithCommaByConcernRomans(StudentCollection studentCollection) {
        String result ="";
        for (Student student : studentCollection.studentList) {
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


    public String printStudentsWithColonByConcernRomans(StudentCollection studentCollection) {
        String result ="{";
        for (Student student : studentCollection.studentList) {
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

    public String printPassedStudentsWithCommaByConcernRomans(StudentCollection studentCollection) {
        String result = "";
        for (Student student : studentCollection.studentList) {
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

    public String printPassedStudentsWithColonByConcernRomans(StudentCollection studentCollection) {
        String result = "{";
        for (Student student : studentCollection.studentList) {
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
