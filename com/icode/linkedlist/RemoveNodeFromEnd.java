package com.icode.linkedlist;

class ListNode {
    int data;
    ListNode next;

    public ListNode() {

    }

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {

    ListNode head = null;

    public void add(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = node;

    }

    public ListNode removeNthNode(ListNode head, int n) {

        ListNode first = head;
        ListNode second = head;

        for(int i = 1; i <= n; i++) {

            if(second.next == null && i == n) {
                head = head.next;
                return head;
            }
            second = second.next;
        }

        while (second.next != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }

    public void display(ListNode head) {

        if (head == null)
            return;
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println();
    }


}

public class RemoveNodeFromEnd {

    ListNode head = null;

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display(list.head);
        ListNode head = list.removeNthNode(list.head, 2);
        list.display(head);

    }

}
