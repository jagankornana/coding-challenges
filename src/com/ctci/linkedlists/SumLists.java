package com.ctci.linkedlists;

import java.util.Scanner;

/* You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list. */

public class SumLists {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstListSize, secondListSize;
        LinkedList firstList = new LinkedList();
        LinkedList secondList = new LinkedList();
        System.out.print("Enter number of elements in the first list: ");
        firstListSize = scanner.nextInt();
        for (int i = 0; i < firstListSize; i++) {
            firstList.add(scanner.nextInt());
        }
        System.out.print("Enter number of elements in the second list: ");
        secondListSize = scanner.nextInt();
        for (int i = 0; i < secondListSize; i++) {
            secondList.add(scanner.nextInt());
        }
        System.out.println("Elements in first list: ");
        display(firstList.head);
        System.out.println("Elements in second list: ");
        display(secondList.head);

        LinkedList.Node sumListHead = computeSum(firstList.head, secondList.head);
        System.out.println("Elements in sum list: ");
        display(sumListHead);
    }

    private static LinkedList.Node computeSum(LinkedList.Node firstNode, LinkedList.Node secondNode) {
        int buffer = 0;
        LinkedList sumList = new LinkedList();
        while (firstNode != null || secondNode != null || buffer > 0) {
            int sum = 0;
            if (firstNode != null) {
                sum += firstNode.data;
                firstNode = firstNode.next;
            }
            if (secondNode != null) {
                sum += secondNode.data;
                secondNode = secondNode.next;
            }
            sum += buffer;
            buffer = sum / 10;
            sum %= 10;
            sumList.add(sum);
        }
        return sumList.head;
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
