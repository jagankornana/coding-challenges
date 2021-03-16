package com.ctci.linkedlists;

import java.util.Scanner;

/* Partition the elements based on pivot, such that all the nodes less than pivot comes before all nodes grater than or equal to pivot */

public class Partition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, x;
        System.out.print("Enter number of elements: ");
        n = scanner.nextInt();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            linkedList.add(scanner.nextInt());
        }
        System.out.println("Elements in LinkedList: ");
        display(linkedList.head);
        System.out.print("Enter partition value: ");
        x = scanner.nextInt();
        LinkedList.Node partitionList = partition(linkedList.head, x);
        System.out.println("LinkedList after partition: ");
        display(partitionList);
    }

    private static LinkedList.Node partition(LinkedList.Node head, int x) {
        LinkedList.Node left = null;
        LinkedList.Node nextToLeft = null;
        LinkedList.Node pointer = head;
        LinkedList.Node prevToPointer = null;
        while (pointer != null) {
            if (pointer.data < x) {
                if (left == null) {
                    left = pointer;
                    if (prevToPointer != null) {
                        prevToPointer.next = pointer.next;
                        left.next = head;
                        head = left;
                    } else {
                        prevToPointer = pointer;
                    }
                } else if (left.next != pointer) {
                    prevToPointer.next = pointer.next;
                    left.next = pointer;
                    pointer.next = nextToLeft;
                    left = pointer;
                } else {
                    left = pointer;
                    prevToPointer = pointer;
                }
                nextToLeft = left.next;
                pointer = prevToPointer.next;
            } else {
                prevToPointer = pointer;
                pointer = pointer.next;
            }
        }
        return head;
    }

    private static void display(LinkedList.Node head) {
        if (head == null) {
            System.out.println("LinkedList is empty");
        } else {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.print("null\n");
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
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
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
