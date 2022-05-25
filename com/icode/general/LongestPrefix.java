package com.icode.general;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] strArr = {"flower","flow","flight"};

        String longestPrefix = findLongestPrefix(strArr);
        System.out.println(longestPrefix);
    }

    private static String findLongestPrefix(String[] strArr) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strArr[0].length(); i++) {
            char ch = strArr[0].charAt(i);
            boolean isCharSame = true;
            for(int j = 1; j < strArr.length; j++) {
                if(strArr[j].charAt(i) != ch || strArr[j].length() == i) {
                    isCharSame = false;
                    break;
                }
            }
            if (isCharSame) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
