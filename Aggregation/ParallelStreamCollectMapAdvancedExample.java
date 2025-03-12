package Aggregation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Aggregation.Student.Student;
import Aggregation.Student.StudentGades;

public class ParallelStreamCollectMapAdvancedExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        // Список объектов анонимного класса StudentsGades
        List<StudentGades> gradeList = new ArrayList<>();

        students.forEach(student ->
            student.getGrades().entrySet().forEach(item ->
                gradeList.add(new StudentGades(item.getKey(), item.getValue()))
            )
        );

        // Группировка по предмету
        Map<String, List<StudentGades>> gradeListGrouping = gradeList.parallelStream()
                                                                     .collect(Collectors.groupingBy(StudentGades::getSubject));

        System.out.println("-----Средние оценки по предметам-----");
        gradeListGrouping.entrySet().forEach(entry -> {

            String subject = entry.getKey();
            Double avg     = entry.getValue()
                                  .stream()
                                  .collect(Collectors.averagingInt(StudentGades::getGrade));
            
            System.out.println(subject + " " + avg);
        });
    }
}
