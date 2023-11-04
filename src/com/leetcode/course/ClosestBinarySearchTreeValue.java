package com.poc.practice;

public class ClosestBinarySearchTreeValue {

    double minDiff;
    TreeNode minDiffNode;

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

        ClosestBinarySearchTreeValue obj = new ClosestBinarySearchTreeValue();
        System.out.println(obj.closestValue(node3, 5.5));
    }

    public int closestValue(TreeNode node, double target) {
        minDiff = Integer.MAX_VALUE;
        minDiffNode = node;
        findClosestValue(node, target);
        return minDiffNode.val;
    }

    private void findClosestValue(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        if (Math.abs(node.val - target) < minDiff) {
            minDiff = Math.abs(node.val - target);
            minDiffNode = node;
        } else if (Math.abs(node.val - target) == minDiff) {
            minDiffNode = node.val < minDiffNode.val ? node : minDiffNode;
        }
        if (target < node.val) {
            findClosestValue(node.left, target);
        } else {
            findClosestValue(node.right, target);
        }
    }
}
