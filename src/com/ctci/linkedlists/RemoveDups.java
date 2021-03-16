package com.ctci.linkedlists;

import java.util.Scanner;

/* Remove duplicate elements from the single LinkedList */

public class RemoveDups {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.print("Enter num of elements: ");
        n = scanner.nextInt();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            linkedList.add(scanner.nextInt());
        }
        System.out.println("LinkedList elements: ");
        display(linkedList.head);
        LinkedList.Node head = mergeSort(linkedList.head);
        System.out.println("LinkedList sorted elements: ");
        display(head);
        removeDuplicates(head);
        System.out.println("After removing duplicate elements:");
        display(head);
    }

    private static LinkedList.Node mergeSort(LinkedList.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedList.Node midElement = getMidElement(head);
        LinkedList.Node midNextElement = midElement.next;
        midElement.next = null;
        LinkedList.Node left = mergeSort(head);
        LinkedList.Node right = mergeSort(midNextElement);
        return merge(left, right);
    }

    private static LinkedList.Node getMidElement(LinkedList.Node head) {
        LinkedList.Node slowPointer = head;
        LinkedList.Node fastPointer = head.next;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    private static LinkedList.Node merge(LinkedList.Node left, LinkedList.Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        LinkedList.Node result;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private static void removeDuplicates(LinkedList.Node head) {
        int data = head.data;
        LinkedList.Node current = head.next;
        while (current != null) {
            if (current.data != data) {
                head.next = current;
                head = current;
                data = current.data;
                current = current.next;
            } else {
                current = current.next;
                head.next = null;
            }
        }
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
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
    }
}