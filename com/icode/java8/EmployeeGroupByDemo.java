package com.icode.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeGroupByDemo {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee e1 = new Employee(1, "Santosh", 140000);
        Employee e2 = new Employee(3, "Ram", 100000);
        Employee e3 = new Employee(2, "Shayam", 130000);
        Employee e4 = new Employee(5, "Mohan", 160000);
        Employee e5 = new Employee(10, "Krishna", 110000);
        Employee e6 = new Employee(19, "Bharti", 120000);
        Employee e7 = new Employee(30, "Rohan", 120000);
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);
        employeeList.add(e7);

        // GroupBy salary

         Map<Integer, List<Employee>> salaryToEmployees = employeeList.stream()
                                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.filtering(emp -> emp.getSalary() > 120000, Collectors.toList())));

        System.out.println(salaryToEmployees);
    }
}
