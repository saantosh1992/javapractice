package com.icode.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSort {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        Employee e1 = new Employee(1, "Santosh", 140000);
        Employee e2 = new Employee(3, "Ram", 100000);
        Employee e3 = new Employee(2, "Shayam", 130000);
        Employee e4 = new Employee(5, "Mohan", 160000);
        Employee e5 = new Employee(10, "Krishna", 110000);
        Employee e6 = new Employee(19, "Bharti", 120000);
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);

        // Sort Employee by salary in DESC
        List<Employee> sortedEmpListBySalary = employeeList.stream()
                                                            .sorted((emp1, emp2) -> emp2.getSalary() - emp1.getSalary())
                                                            .collect(Collectors.toList());
        System.out.println(sortedEmpListBySalary);

        // Only three highest max salary employee.
        List<Employee> sortedMaxEmpListBySalary = employeeList.stream()
                .sorted((emp1, emp2) -> emp2.getSalary() - emp1.getSalary())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(sortedMaxEmpListBySalary);

        // All employee whose salary less than third highest.
        List<Employee> sortedThirdHighestEmpListBySalary = employeeList.stream()
                .sorted((emp1, emp2) -> emp2.getSalary() - emp1.getSalary())
                .skip(3)
                .collect(Collectors.toList());

        System.out.println(sortedThirdHighestEmpListBySalary);


    }
}
