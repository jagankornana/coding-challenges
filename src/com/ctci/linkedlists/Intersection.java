package com.ctci.linkedlists;

/* Given two singly linked lists, determine if the two lists intersect */

import java.util.Scanner;

public class Intersection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstListSize, secondListSize, index;
        System.out.print("Enter number of elements in first list: ");
        firstListSize = scanner.nextInt();
        LinkedList firstList = new LinkedList();
        for (int i = 0; i < firstListSize; i++) {
            firstList.add(scanner.nextInt());
        }
        System.out.print("Enter number of elements in second list: ");
        secondListSize = scanner.nextInt();
        LinkedList secondList = new LinkedList();
        for (int i = 0; i < secondListSize; i++) {
            secondList.add(scanner.nextInt());
        }
        System.out.println("Enter intersection index in first list: ");
        index = scanner.nextInt();
        LinkedList.Node nodeAtIndex = firstList.get(index);
        secondList.add(nodeAtIndex);

        System.out.println();
        System.out.println("Elements in first list: ");
        display(firstList.head);
        System.out.println("Elements in second list: ");
        display(secondList.head);

        System.out.println();
        LinkedList.Node intersectionNode = findIntersection(firstList, secondList);
        if (intersectionNode != null) {
            System.out.println("Two lists intersected at " + intersectionNode.data);
        } else {
            System.out.println("Two lists not intersected");
        }
    }

    private static LinkedList.Node findIntersection(LinkedList firstList, LinkedList secondList) {
        int firstListLength = findLength(firstList.head);
        int secondListLength = findLength(secondList.head);
        LinkedList.Node movedHead, head;
        if (firstListLength > secondListLength) {
            movedHead = firstList.get(firstListLength - secondListLength);
            head = secondList.head;
        } else {
            movedHead = secondList.get(secondListLength - firstListLength);
            head = firstList.head;
        }

        while (movedHead.next.next != null) {
            if (movedHead.next == head.next) {
                return movedHead.next;
            }
            movedHead = movedHead.next;
            head = head.next;
        }
        return null;
    }

    private static int findLength(LinkedList.Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
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
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

        void add(Node nodeAtIndex) {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = nodeAtIndex;
        }

        Node get(int index) {
            Node node = head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.next;
            }
            return node;
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
