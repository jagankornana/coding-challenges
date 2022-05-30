package com.leetcode.problems;

public class MergeTwoSortedLists {
  public static void main(String[] args) {
    ListNode list6 = new ListNode(8);
    ListNode list4 = new ListNode(5, list6);
    ListNode list2 = new ListNode(2, list4);

    ListNode list8 = new ListNode(8);
    ListNode list5 = new ListNode(5, list8);
    ListNode list1 = new ListNode(1, list5);

    MergeTwoSortedLists input = new MergeTwoSortedLists();
    ListNode listNode = input.mergeTwoLists(list5, list6);
    while (listNode != null) {
      System.out.print(listNode.val + " -> ");
      listNode = listNode.next;
    }
    System.out.print("null");
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    }
    ListNode head, pointer;
    if (list1.val <= list2.val) {
      head = list1;
      list1 = list1.next;
    } else {
      head = list2;
      list2 = list2.next;
    }
    pointer = head;
    while (true) {
      if (list1 == null) {
        pointer.next = list2;
        return head;
      } else if (list2 == null) {
        pointer.next = list1;
        return head;
      }
      if (list1.val <= list2.val) {
        pointer.next = list1;
        list1 = list1.next;
      } else {
        pointer.next = list2;
        list2 = list2.next;
      }
      pointer = pointer.next;
    }
  }
}
