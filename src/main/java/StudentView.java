import java.util.Iterator;
import java.util.Map;

public class StudentView {

    public String printNameAndGradeWithComma(StudentGrade stuInfo) {
        return stuInfo.getName()+","+stuInfo.getGrade();
    }

    public String printNameAndGradeWithColon(StudentGrade stuInfo) {
        return "{"+stuInfo.getName()+":"+stuInfo.getGrade()+"}";
    }


    public String printAllStudentInfo(Map<String, Integer> nameGradeMap) {
        String result="";
        Iterator mapIterator = nameGradeMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> ele = (Map.Entry<String, Integer>) mapIterator.next();
            result += ele.getKey()+","+ele.getValue()+"\n";
        }
        return result;
    }

    public String printAllPassedStudentInfo(Map<String, Integer> nameGradeMap) {
        String result = "";
        Iterator mapIterator = nameGradeMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> ele = (Map.Entry<String, Integer>) mapIterator.next();
            if (ele.getValue() > 60){
                result += ele.getKey()+","+ele.getValue()+"\n";
            }
        }
        return result;
    }
}
