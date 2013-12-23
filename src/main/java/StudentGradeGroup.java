import com.google.common.base.Function;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StudentGradeGroup {

    public Map<String, Integer> nameGradeMap = new HashMap<String, Integer>();

    public StudentGradeGroup(Map<String, Integer> nameGradeMap) {
        this.nameGradeMap = nameGradeMap;
    }

    public StudentGradeGroup(){
        nameGradeMap.put("A",100);
        nameGradeMap.put("B",80);
        nameGradeMap.put("C",59);

    }

    private Function<Map.Entry<String, Integer>, String> getStudentInfo() {
        return new Function<Map.Entry<String, Integer>, String>() {
            @Override
            public String apply(Map.Entry<String, Integer> studentGrade) {
                return studentGrade.getKey()+","+studentGrade.getValue()+"\n";
            }
        };
    }

    public String printAllStudentInfo() {
        String result="";
        Iterator mapIterator = nameGradeMap.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> ele = (Map.Entry<String, Integer>) mapIterator.next();
            result += ele.getKey()+","+ele.getValue()+"\n";
        }
        return result;
        /*String result = "";
        transform((Iterable<Map.Entry<String, Integer>>) nameGradeMap, getStudentInfo());*/
    }

    public String printAllPassedStudentInfo() {
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
