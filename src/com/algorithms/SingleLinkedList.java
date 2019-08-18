package com.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleLinkedList {

    private int data;
    private SingleLinkedList next;

    private SingleLinkedList(int data, SingleLinkedList next) {
        this.data = data;
        this.next = next;
    }

    private static SingleLinkedList createNode(int data) {
        return new SingleLinkedList(data, null);
    }

    public static SingleLinkedList add(SingleLinkedList head, SingleLinkedList node) {
        SingleLinkedList temp = head;

        if (head == null) {
            head = node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        return head;
    }

    private static void display(SingleLinkedList head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter n value: ");
        int n = Integer.parseInt(br.readLine());
        SingleLinkedList head = null;
        for (int i = 0; i < n; i++) {
            SingleLinkedList node = createNode(Integer.parseInt(br.readLine()));
            head = add(head, node);
        }

        display(head);

    }
}
