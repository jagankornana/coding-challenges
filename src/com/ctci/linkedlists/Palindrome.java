package com.ctci.linkedlists;

import java.util.Scanner;

/* Implement a function to check if a linked list is a palindrome */

public class Palindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listSize;
        System.out.print("Enter number of elements: ");
        listSize = scanner.nextInt();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < listSize; i++) {
            linkedList.add(scanner.nextInt());
        }
        System.out.println("Elements in LinkedList: ");
        display(linkedList.head);
        PalindromeNode palindromeNode = isPalindrome(linkedList.head, linkedList.head);
        if (palindromeNode.flag) {
            System.out.println("LinkedList is Palindrome");
        } else {
            System.out.println("LinkedList is not Palindrome");
        }
    }

    private static PalindromeNode isPalindrome(LinkedList.Node head, LinkedList.Node node) {
        if (node.next == null) {
            if (head.data == node.data) {
                return new PalindromeNode(head.next, true);
            } else {
                return new PalindromeNode(head.next, false);
            }
        }
        PalindromeNode palindromeNode = isPalindrome(head, node.next);
        if (palindromeNode.flag) {
            if (palindromeNode.node.data == node.data) {
                return new PalindromeNode(palindromeNode.node.next, true);
            }
        }
        return palindromeNode;
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

    static class PalindromeNode {
        LinkedList.Node node;
        boolean flag;

        PalindromeNode(LinkedList.Node node, boolean flag) {
            this.node = node;
            this.flag = flag;
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
            Node next = null;

            Node(int data) {
                this.data = data;
            }
        }
    }
}
