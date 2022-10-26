package com.icode.array;

public class PermutationOfEachOther {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "bda";

        boolean isPermute = isPermutation(str1, str2);
        System.out.println(isPermute);
    }

    private static boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        int[] arr = new int[128];

        for(char ch : str1.toCharArray()) {
            arr[ch]++;
        }

        for (char c : str2.toCharArray()) {
            arr[c]--;

            if(arr[c] < 0) {
                return false;
            }
        }

        return true;
    }
}
