public class StudentGrade {
    private final String name;
    private final int grade;

    public StudentGrade(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String printNameAndGrade() {
        return name+","+grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
