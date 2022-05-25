package com.icode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhone {

    public static void main(String[] args) {

        Map<Integer, String> digitToLetter = new HashMap<>();
        digitToLetter.put(2, "abc");
        digitToLetter.put(3, "def");
        digitToLetter.put(4, "ghi");
        digitToLetter.put(5, "jkl");
        digitToLetter.put(6, "mno");
        digitToLetter.put(7, "pqrs");
        digitToLetter.put(8, "tuv");
        digitToLetter.put(9, "wxyz");

        String digits = "23";

        List<String> list = letterCombination(digits, digitToLetter);
        System.out.println(list);
    }

    private static List<String> letterCombination(String digits, Map<Integer, String> digitToLetter) {

        List<String> temp = new ArrayList<>();
        temp.add("");
        for(int i = digits.length()-1; i >= 0; i--){
            temp = getCombination(digitToLetter.get(Integer.valueOf(digits.charAt(i)+"")), temp);
        }
        return temp;
    }

    private static List<String> getCombination(String currStr, List<String> temp) {
        List<String> comList = new ArrayList<>();
        for(int i = 0; i < currStr.length(); i++) {
            for(int j = 0; j < temp.size(); j++) {
                comList.add(currStr.charAt(i) + temp.get(j));
            }
        }
        return comList;
    }
}
