package com.ctci.linkedlists;

import java.util.Scanner;

public class LoopDetection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listSize, index;
        System.out.print("Enter number of elements in list: ");
        listSize = scanner.nextInt();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < listSize; i++) {
            linkedList.add(scanner.nextInt());
        }
        System.out.print("Enter circular list index: ");
        index = scanner.nextInt();
        LinkedList.Node node = linkedList.get(index);
        linkedList.add(node);
        LinkedList.Node loopExistAtNode = findLoopNode(linkedList.head);
        if (loopExistAtNode != null) {
            int count = 0;
            LinkedList.Node headNode = linkedList.head;
            while (headNode != loopExistAtNode) {
                headNode = headNode.next;
                loopExistAtNode = loopExistAtNode.next;
                count++;
            }
            System.out.println("Loop found at " + count);
        } else {
            System.out.println("Loop not found");
        }
    }

    private static LinkedList.Node findLoopNode(LinkedList.Node head) {
        LinkedList.Node slowPointer = head;
        LinkedList.Node fastPointer = head;
        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
            if (slowPointer == fastPointer) {
                return slowPointer;
            }
        }
        return fastPointer;
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

        void add(Node node) {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
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
