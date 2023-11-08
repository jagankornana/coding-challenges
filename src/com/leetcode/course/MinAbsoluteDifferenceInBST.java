package com.leetcode.course;

import java.util.ArrayList;
import java.util.List;

public class MinAbsoluteDifferenceInBST {

    private int min;
    private TreeNode prevNode;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node3.left = node2;
        node2.left = node1;
        node3.right = node4;
        node4.right = node5;

        MinAbsoluteDifferenceInBST obj = new MinAbsoluteDifferenceInBST();
        System.out.println(obj.getMinimumDifference(node3));
    }

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (prevNode != null) {
            min = Math.min(min, node.val - prevNode.val);
        }
        prevNode = node;
        inOrder(node.right);
    }
}
