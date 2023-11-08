package com.leetcode.course;

public class RangeSumOfBST {

    int ans;

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

        RangeSumOfBST obj = new RangeSumOfBST();
        System.out.println(obj.rangeSumBST(node3, 2, 5));
    }

    public int rangeSumBST(TreeNode node, int low, int high) {
        ans = 0;
        rangeSum(node, low, high);
        return ans;
    }

    public void rangeSum(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (low <= node.val && node.val <= high) {
            ans += node.val;
        }
        if (low < node.val) {
            rangeSum(node.left, low, high);
        }
        if (node.val < high) {
            rangeSum(node.right, low, high);
        }
    }
}
