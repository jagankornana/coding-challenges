package com.leetcode.course;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        SwapNodesInPairs obj = new SwapNodesInPairs();
        ListNode result = obj.swapPairs(node1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode startNode = head.next, prevNode, nextNode;
        while (head != null && head.next != null) {
            prevNode = head;
            nextNode = head.next.next;
            head.next.next = head;
            head = nextNode;

            if (head == null || head.next == null) {
                prevNode.next = head;
            } else {
                prevNode.next = head.next;
            }
        }

        return startNode;
    }
}
