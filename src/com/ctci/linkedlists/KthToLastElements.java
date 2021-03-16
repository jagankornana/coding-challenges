package com.ctci.linkedlists;

import java.util.Scanner;

/* Find the elements from the n-k position in the LinkedList, where n is the size and k is from 0 to n-1 */

public class KthToLastElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k;
        System.out.print("Enter number of elements: ");
        n = scanner.nextInt();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < n; i++) {
            linkedList.add(scanner.nextInt());
        }
        System.out.println("Elements in LinkedList: ");
        display(linkedList.head);
        System.out.print("Enter k value (k<n): ");
        k = scanner.nextInt();
        LinkedList.Node kthElement = findKthElement(linkedList.head, k);
        LinkedList.Node node = returnKthToLastElements(linkedList.head, kthElement);

        System.out.println("Elements from " + (n - k) + " position: ");
        display(node);
    }

    private static LinkedList.Node returnKthToLastElements(LinkedList.Node head, LinkedList.Node kthElement) {
        while (kthElement != null) {
            head = head.next;
            kthElement = kthElement.next;
        }
        return head;
    }

    private static LinkedList.Node findKthElement(LinkedList.Node head, int k) {
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return head;
            }
            head = head.next;
        }
        return head;
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