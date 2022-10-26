package com.icode.string;

class A {

    public static int i = 1;
}
public class StringConcat {

    public static void main(String[] args) {

        A a1 = new A();
        a1.i++;

        System.out.println(a1);

        String s = "Kumari";
        s.concat("Bharti");

        System.out.println(s);
    }
}
