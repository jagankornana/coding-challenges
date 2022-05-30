package com.leetcode.problems;

public class Practice {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.add(4);
    linkedList.print();
  }
}

class LinkedList {
  Node head;

  void add(int data) {
    Node newNode = new Node(data);
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

  void print() {
    Node node = head;
    while (node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.print("null");
  }

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }
}
