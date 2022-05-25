package com.icode.general;

public class DiagonalMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};

        for(int i =0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {

                if( i == j) {
                    System.out.println(matrix[i][j]);
                }
            }
        }

        printDiagonal(matrix);
    }

    private static void printDiagonal(int[][] matrix) {
        System.out.println("Efficient way..");
        for (int i =0; i < matrix.length; i++) {
            System.out.println(matrix[i][i]);
        }
    }


}
