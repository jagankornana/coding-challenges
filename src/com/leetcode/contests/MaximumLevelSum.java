package com.leetcode.contests;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MaximumLevelSum {

    public static void main(String[] args) {
        MaximumLevelSum levelSum = new MaximumLevelSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(8);
        System.out.println(levelSum.maxLevelSum(root));
    }

    private int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        levelOrder(root, 1, map);
        Optional<Map.Entry<Integer, Integer>> max = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        if (max.isPresent()) return max.get().getKey();
        return 0;
    }

    private void levelOrder(TreeNode node, int level, Map<Integer, Integer> map) {
        if (node == null) return;
        map.merge(level, node.val, Integer::sum);
        levelOrder(node.left, level + 1, map);
        levelOrder(node.right, level + 1, map);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
