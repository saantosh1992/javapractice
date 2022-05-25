package com.icode.general;

public class SprialMatrixPrint {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};

        printSpiral(matrix);

        // 1 2 3
        // 4 5 6
        // 7 8 9 ---. 1 2 3 6 9 8 7 4 5
    }

    private static void printSpiral(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row -1;

        for( int i = 0; i < row * col; i++) {

            for(int x = left; x <= right; x++) {
                System.out.println(matrix[top][x]);
            }
            top++;
            for(int y = top; y <= bottom; y++) {
                System.out.println(matrix[y][right]);
            }
            right--;
            for(int z = right; z >= left; z--) {
                System.out.println(matrix[bottom][z]);
            }
            bottom--;
            for(int a = bottom; a >= top; a--) {
                System.out.println(matrix[a][left]);
            }
            left++;
        }
    }
}
