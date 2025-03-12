package Aggregation.Student;

public class StudentGades implements StudentInterface{
    String  subject;
    Integer grade;

    public StudentGades(String subject, Integer grade) {
        this.subject = subject;
        this.grade   = grade;
    }

    public String getSubject() {
        return subject;
    }

    public Integer getGrade() {
        return grade;
    }
}
