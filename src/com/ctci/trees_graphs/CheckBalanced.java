package com.ctci.trees_graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class CheckBalanced {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input array: ");
        Stream<String> stringStream = Arrays.stream(br.readLine().split(" "));
        Tree tree = new Tree();
        stringStream.mapToInt(Integer::parseInt).forEach(tree::add);
        System.out.print("In-Order: ");
        tree.inOrder(tree.root);
        System.out.println();
        if (tree.isBalanced(tree.root)) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }
    }

    static class Tree {
        Node root;

        void add(int element) {
            if (root == null) {
                root = new Node(element);
            } else {
                Node parent = null;
                Node temp = root;
                while (temp != null) {
                    parent = temp;
                    if (element <= temp.data) {
                        temp = temp.left;
                    } else {
                        temp = temp.right;
                    }
                }
                if (element <= parent.data) {
                    parent.left = new Node(element);
                } else {
                    parent.right = new Node(element);
                }
            }
        }

        void inOrder(Node node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }

        boolean isBalanced(Node root) {
            return treeHeight(root) != Integer.MIN_VALUE;
        }

        private int treeHeight(Node node) {
            if (node == null) {
                return -1;
            }
            int leftHeight = treeHeight(node.left);
            if (leftHeight == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            int rightHeight = treeHeight(node.right);
            if (rightHeight == Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return Integer.MIN_VALUE;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }

        /*Result isBalanced(Node node) {
            if (node == null) {
                return new Result(0, true);
            }
            int maxDepth = 0;
            Result leftResult = isBalanced(node.left);
            Result rightResult = isBalanced(node.right);
            maxDepth = Math.max(maxDepth, leftResult.depth);
            maxDepth = Math.max(maxDepth, rightResult.depth);
            boolean flag = false;
            if (leftResult.balanced && rightResult.balanced
                    && (leftResult.depth - rightResult.depth == 0
                    || Math.abs(leftResult.depth - rightResult.depth) == 1)) {
                flag = true;
            }
            return new Result(maxDepth + 1, flag);
        }*/
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /*static class Result {
        int depth;
        boolean balanced;

        public Result() {
        }

        Result(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }
    }*/
}
