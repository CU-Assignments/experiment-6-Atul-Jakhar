import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 25, 50000));
        employees.add(new Employee("Alice", 30, 70000));
        employees.add(new Employee("Bob", 22, 40000));
        employees.add(new Employee("David", 28, 60000));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        // Sort by name
        employees.sort(Comparator.comparing(emp -> emp.name));
        System.out.println("\nSorted by Name:");
        employees.forEach(System.out::println);

        // Sort by age
        employees.sort(Comparator.comparingInt(emp -> emp.age));
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        // Sort by salary
        employees.sort(Comparator.comparingDouble(emp -> emp.salary));
        System.out.println("\nSorted by Salary:");
        employees.forEach(System.out::println);
    }
}
