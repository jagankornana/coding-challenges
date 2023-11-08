package com.leetcode.course;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result = obj.deleteDuplicates(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates_(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode prev = head;
        ListNode right = head.next;
        while (right != null) {
            if (left.val == right.val) {
                prev = right;
            } else {
                if (left != prev) {
                    left.next = right;
                    prev.next = null;
                }
                left = right;
                prev = left;
            }
            right = right.next;
        }
        left.next = null;

        return head;
    }
}
