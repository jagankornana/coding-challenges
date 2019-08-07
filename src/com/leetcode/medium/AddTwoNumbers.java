package com.leetcode.medium;

import java.math.BigInteger;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;

        ListNode result = addTwoNumbers(a1, b1);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print("null");
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = BigInteger.ZERO, num2 = BigInteger.ZERO, finalSum, x = BigInteger.ONE;
        for (int i = 0; l1 != null; i++) {
            num1 = num1.add(x.multiply(BigInteger.valueOf(l1.val)));
            l1 = l1.next;
            x = x.multiply(BigInteger.TEN);
        }
        x = BigInteger.ONE;
        for (int i = 0; l2 != null; i++) {
            num2 = num2.add(x.multiply(BigInteger.valueOf(l2.val)));
            l2 = l2.next;
            x = x.multiply(BigInteger.TEN);
        }

        finalSum = num1.add(num2);
        if (finalSum.equals(BigInteger.ZERO)) {
            return new ListNode(0);
        }

        ListNode head = null;
        ListNode currentNode = null;
        while (finalSum.compareTo(BigInteger.ZERO) > 0) {

            ListNode newNode = new ListNode(finalSum.mod(BigInteger.TEN).intValue());
            if (head == null) {
                head = newNode;
                currentNode = newNode;
            } else {
                currentNode.next = newNode;
                currentNode = newNode;
            }
            finalSum = finalSum.divide(BigInteger.TEN);
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
