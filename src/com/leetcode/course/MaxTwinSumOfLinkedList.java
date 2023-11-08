package com.leetcode.course;

public class MaxTwinSumOfLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(12);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        MaxTwinSumOfLinkedList obj = new MaxTwinSumOfLinkedList();
        System.out.println(obj.pairSum(node1));
    }

    public int pairSum(ListNode head) {
        if (head.next.next == null) {
            return head.val + head.next.val;
        }
        ListNode slow = head, fast = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prevNode = null, current = slow;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        prev.next = prevNode;

        int maxSum = 0;
        while (prevNode != null) {
            maxSum = Math.max(maxSum, head.val + prevNode.val);
            head = head.next;
            prevNode = prevNode.next;
        }

        return maxSum;
    }
}
