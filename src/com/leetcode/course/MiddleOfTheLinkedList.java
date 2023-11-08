package com.leetcode.course;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        MiddleOfTheLinkedList obj = new MiddleOfTheLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode middleNode = obj.middleNode(node1);
        while (middleNode != null) {
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
