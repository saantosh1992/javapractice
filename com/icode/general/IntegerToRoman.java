package com.icode.general;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static void main(String[] args) {

        int num = 58;
        String romanNum = convertToRoman(num);
        System.out.println(romanNum);
    }

    private static String convertToRoman(int num) {

        Map<Integer, String> intToRoman = new HashMap<>();
        intToRoman.put(1, "I");
        intToRoman.put(5, "V");
        intToRoman.put(10, "X");
        intToRoman.put(50, "L");
        intToRoman.put(100, "C");
        intToRoman.put(500, "D");
        intToRoman.put(1000, "M");

        int digitCount = String.valueOf(num).length();
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int divisible = (int) Math.pow(10, digitCount);
            int digit = (int) (num / divisible);
            while (digit > 0) {
                String romanLetter = intToRoman.get(divisible);
                sb.append(romanLetter);
                digit--;
            }
            num = num % divisible;
            digitCount--;

        }
        return sb.toString();
    }
}
