package com.icode.array;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisGenerator {
    public static void main(String[] args) {

        int n = 2;

        List<String> parenthesisList = new ParenthesisGenerator().generateParenthesis(n);
        System.out.println(parenthesisList);
    }

    private  List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        getParenthesisHelper(result, n, "", 0, 0);
        return result;
    }

    private void getParenthesisHelper(List<String> result, int n, String ans, int open, int close) {

        if (ans.length() == 2 * n) {
            result.add(ans);
            return;
        }

        if(open < n) {
            getParenthesisHelper(result, n, ans +"(", open + 1, close);
        }

        if (open > close) {
            getParenthesisHelper(result, n, ans + ")", open, close + 1);
        }

    }
}
