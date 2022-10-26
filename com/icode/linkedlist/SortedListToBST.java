package com.icode.linkedlist;

class LNode {
    int data;
    LNode next;
    LNode(int d) {
        data = d;
        next = null;
    }
}

class TNode {
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }

}

public class SortedListToBST {


    public static TNode createBST(LNode head) {

        int count = 0;
        LNode temp = head;

        while(temp != null) {
            count++;
            temp = temp.next;
        }
        int[] arr = new int[count];
        LNode ptr = head;
        int index = 0;
        while (ptr!= null) {
            arr[index++] = ptr.data;
            ptr = ptr.next;
        }

        return createTree(arr, 0, count-1);

    }

    private static TNode createTree(int[] arr, int low, int high) {

        if (low > high) {
            return null;
        }
        int mid = (low + high)/2;
        TNode node = new TNode(arr[mid]);
        node.left = createTree(arr, low, mid-1);
        node.right = createTree(arr, mid +1, high);

        return node;
    }

    public static LNode createSortedList(int n) {
        LNode head = new LNode(1);
        LNode tail = head;
        for (int i = 2; i <= n; i++) {
            tail.next = new LNode(i);
            tail = tail.next;
        }
        return head;
    }

    public static void displayList(LNode head) {
        if (head == null){
            return;
        }

        LNode temp = head;
        while(temp!= null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }

    }

    public static void preOrder(TNode root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data+",");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        LNode head = createSortedList(2);
        displayList(head);

        TNode root = createBST(head);
        preOrder(root);
    }
}
