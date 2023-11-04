package com.poc.practice;

public class PracticeLinkedList {

    public static void main(String[] args) {
        SingleListNode singleListNode = new SingleListNode(1);
        System.out.println(singleListNode.data);
        singleListNode.addToEnd(singleListNode, 2);
        System.out.println(singleListNode.data);
        singleListNode.addToEnd(singleListNode, 3);
        System.out.println(singleListNode.data);
        singleListNode.addToEnd(singleListNode, 4);
        singleListNode.addToEnd(singleListNode, 5);

        SingleListNode temp = singleListNode;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        singleListNode.removeFromEnd(singleListNode);
        System.out.println(singleListNode.data);
        singleListNode.removeFromEnd(singleListNode);
        System.out.println(singleListNode.data);
        singleListNode.removeFromEnd(singleListNode);
        System.out.println(singleListNode.data);
        singleListNode.removeFromEnd(singleListNode);
        System.out.println(singleListNode.data);
        singleListNode.removeFromEnd(singleListNode);
        System.out.println(singleListNode.data);

        temp = singleListNode;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        DoubleListNode head;
    }
}

class SingleListNode {
    int data;
    SingleListNode next;

    SingleListNode(int data) {
        this.data = data;
    }

    void addToEnd(SingleListNode head, int value) {
        while (head.next != null) {
            head = head.next;
        }
        head.next = new SingleListNode(value);
    }

    void removeFromEnd(SingleListNode head) {
        if (head == null) {
            return;
        }
        SingleListNode prev = head;
        while (head.next != null) {
            prev = head;
            head = head.next;
        }
        prev.next = null;
    }
}

class DoubleListNode {
    DoubleListNode prev;
    int data;
    DoubleListNode next;

    void addToStart(DoubleListNode node) {

    }

    void addToEnd(DoubleListNode node) {

    }

    void removeFromStart() {

    }

    void removeFromEnd() {

    }
}
