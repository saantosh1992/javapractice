package com.icode.array;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String str = "(]";

        boolean isValid = isValidParenthesis(str);
        System.out.println(isValid);
    }

    private static boolean isValidParenthesis(String str) {

        if (str == null || str.isBlank())
            return false;


        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()){

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty())
                return false;
            switch (ch) {
                case ')':
                case '}':
                case ']':
                    if (stack.peek() == ch) {
                        stack.pop();
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + ch);
            }
        }
        return stack.isEmpty();
    }
}
