package exercise.employeemanagement;

import java.util.Arrays;
import java.util.List;

public class DummyData {

  public static List<Employee> dummyData() {
    List<Employee> employees = Arrays.asList(
        new Employee(1L, "Aarav Mehta", "Engineering", 85000.0, 29, "Ahmedabad", true),
        new Employee(2L, "Priya Sharma", "HR", 62000.0, 34, "Mumbai", true),
        new Employee(3L, "Rohan Patel", "Finance", 78000.0, 31, "Pune", false),
        new Employee(4L, "Neha Verma", "Marketing", 54000.0, 27, "Delhi", true),
        new Employee(5L, "Karan Singh", "Engineering", 92000.0, 36, "Bangalore", true),
        new Employee(6L, "Sneha Iyer", "Sales", 50000.0, 25, "Chennai", false),
        new Employee(7L, "Vikram Joshi", "Operations", 67000.0, 40, "Hyderabad", true),
        new Employee(8L, "Ananya Desai", "Engineering", 88000.0, 30, "Ahmedabad", true),
        new Employee(9L, "Rahul Kapoor", "Support", 45000.0, 24, "Jaipur", true),
        new Employee(10L, "Meera Nair", "Finance", 81000.0, 33, "Kochi", false)
    );

    return employees;

  }

}
