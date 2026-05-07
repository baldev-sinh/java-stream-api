package exercise.dtotransformation;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Employee> employees = List.of(
        new Employee(1L, "Alice Johnson", "HR", 55000.0, "alice123"),
        new Employee(2L, "Bob Smith", "IT", 75000.0, "bob@456"),
        new Employee(3L, "Charlie Brown", "Finance", 68000.0, "charlie789"),
        new Employee(4L, "David Wilson", "Marketing", 62000.0, "david@321"),
        new Employee(5L, "Emma Davis", "IT", 82000.0, "emmaSecure")
    );

//  Convert List<Employee> to List<EmployeeDTO>
    List<EmployeeDTO> list = employees.stream()
        .filter(emp -> emp.getSalary() > 50000)
        .map(emp -> new EmployeeDTO(
            emp.getName(), emp.getDepartment()
        ))
        .toList();

//    return only emp names
    List<String> list1 = employees.stream()
        .filter(e -> e.getSalary() > 50000)
        .map(e -> new EmployeeDTO(e.getName(), e.getDepartment()))
        .map(EmployeeDTO::name)
        .toList();


  }

}
