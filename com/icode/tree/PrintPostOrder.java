package com.icode.tree;

public class PrintPostOrder {
    static int preIndex = 0;
    public static void main(String[] args) {
        int [] in = { 4, 2, 5, 1, 3, 6};
        int [] pre = {1, 2, 4, 5, 3, 6};
        int n = in.length;
        postOrder(in, pre, 0, n-1);

    }

    private static void postOrder(int[] in, int[] pre, int start, int end) {

        if (start > end && preIndex > end)
            return;

        int index = search(in, start, end, pre[preIndex++]);

        postOrder(in, pre, start, index -1);
        postOrder(in, pre, index + 1, end);
        System.out.print(in[index] +" ");
    }

    private static int search(int[] in, int start, int end, int key) {

        int i = 0;
        for(i= start; i < end; i ++) {
            if (in[i] == key)
                return i;
        }
        return i;
    }
}
