package com.icode.tree;

import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }
}

class BinaryTree {
    Node root;
    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int data) {
        this.root = new Node(data);
    }
}

public class TreeTraversal {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.right = new Node(2);
        tree.root.right.left = new Node(3);

        inOrderTraversalWithoutRec(tree.root);
        inOrderTraversal(tree.root);

    }

    private static void inOrderTraversal(Node root) {

        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data +" ");
        inOrderTraversal(root.right);
    }

    private static void inOrderTraversalWithoutRec(Node root) {

        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();

        Node curr = root;
        while(curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data +" ");
            curr = curr.right;
        }
        System.out.println("\n");
    }
}
