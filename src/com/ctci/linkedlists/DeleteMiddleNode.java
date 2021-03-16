package com.ctci.linkedlists;

import java.util.Scanner;

/* Delete middle element from the LinkedList */

public class DeleteMiddleNode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter number of elements: ");
        n = scanner.nextInt();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            linkedList.add(scanner.nextInt());
        }
        System.out.println("Elements in LinkedList: ");
        display(linkedList.head);
        removeMiddleNode(linkedList.head);
        display(linkedList.head);
    }

    private static void removeMiddleNode(LinkedList.Node head) {
        LinkedList.Node prevNode = head;
        LinkedList.Node slowPointer = head;
        LinkedList.Node fastPointer = head.next;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                prevNode = slowPointer;
                slowPointer = slowPointer.next;
            }
        }
        prevNode.next = slowPointer.next;
    }

    private static void display(LinkedList.Node head) {
        if (head == null) {
            System.out.println("LinkedList is empty.");
        } else {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    static class LinkedList {
        Node head;

        void add(int newData) {
            Node newNode = new Node(newData);
            if (head == null) {
                head = newNode;
                return;
            }
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }

        class Node {
            int data;
            Node next = null;

            Node(int data) {
                this.data = data;
            }
        }
    }
}
