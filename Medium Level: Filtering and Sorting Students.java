import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + '}';
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 85));
        students.add(new Student("Alice", 70));
        students.add(new Student("Bob", 78));
        students.add(new Student("David", 65));
        students.add(new Student("Eva", 92));

        System.out.println("Original List:");
        students.forEach(System.out::println);

        // Filter and sort using streams
        List<String> topStudents = students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .map(s -> s.name)
                .collect(Collectors.toList());

        System.out.println("\nStudents scoring above 75% (sorted by marks):");
        topStudents.forEach(System.out::println);
    }
}
