package com.icode.string;

public class StringCompression {

    public static void main(String[] args) {
        String str = "aabcccaaa";

        String compressedStr = stringCompression(str);
        System.out.println(compressedStr);
    }

    private static String stringCompression(String str) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length()-1; i++) {
            count++;

            if (str.charAt(i) != str.charAt(i+1) || (i+1) >= str.length()) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        return sb.length() < str.length() ? sb.toString(): str;
    }
}
