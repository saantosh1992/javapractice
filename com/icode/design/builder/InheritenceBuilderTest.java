package com.icode.design.builder;

public class InheritenceBuilderTest {

    public static void main(String[] args) {


        Student student = Student.builder().name("Santosh").age(19).school("abc").build();

        System.out.println(student);
        People people = People.builder().name("Ram").age(20).build();
        System.out.println(people);

    }
}
