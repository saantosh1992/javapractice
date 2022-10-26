package com.icode.general;

public class PowerOfTwo {
    public static void main(String[] args) {

        int n = 16;

        boolean isPowerOfTwo = isPowerOfTwo(n);
        boolean isPowerOfTwo2 = isPowerOfTwo2(n);
        System.out.println(isPowerOfTwo);
        System.out.println(isPowerOfTwo2);
    }

    private static boolean isPowerOfTwo2(int n) {
        // if a number is power of 2, it has only ONE set bit.
        // so count the set bit, if it is one, then true, else false.
        // Method 2 - 4 (100) and 3(011) it means - (n) & (n-1) == 0

        return n != 0 && ( n & (n-1)) == 0;
    }

    private static boolean isPowerOfTwo(int n) {

        if (n == 1) {
            return true;
        }

        while (n != 1) {

            if (n%2 != 0) {
                return false;
            }
            n = n/2;
        }
        return true;
    }
}
