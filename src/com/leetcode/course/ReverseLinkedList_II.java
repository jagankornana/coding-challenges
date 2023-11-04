package com.poc.practice;

public class ReverseLinkedList_II {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ReverseLinkedList_II obj = new ReverseLinkedList_II();
        ListNode result = obj.reverseBetween(node4, 3, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) {
            return head;
        }

        ListNode prev = null, curr = head;
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        ListNode conn = prev, tail = curr, next = null;
        while (right > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        if (conn != null) {
            conn.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;

        return head;
    }
}
