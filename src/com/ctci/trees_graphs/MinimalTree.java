package com.ctci.trees_graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class MinimalTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter array elements in sorted order: ");
        Stream<String> stringStream = Arrays.stream(br.readLine().split(" "));
        int[] sortedArr = stringStream.mapToInt(Integer::parseInt).toArray();
        Tree tree = new Tree();
        tree.setRoot(tree.buildMinimalTree(sortedArr, 0, sortedArr.length - 1));
        System.out.println("Tree Height: " + tree.findHeight(tree.getRoot()));
    }

    static class Tree {

        private Node root;

        private Node buildMinimalTree(int[] arr, int minIndex, int maxIndex) {
            Node parent = null;
            if (minIndex < maxIndex) {
                int midIndex = (minIndex + maxIndex) / 2;
                parent = new Node(arr[midIndex]);
                parent.setLeft(buildMinimalTree(arr, minIndex, midIndex - 1));
                parent.setRight(buildMinimalTree(arr, midIndex + 1, maxIndex));
            } else if (minIndex == maxIndex) {
                parent = new Node(arr[minIndex]);
            }
            return parent;
        }

        private int findHeight(Node node) {
            if (node == null) {
                return 0;
            }
            int depth = Math.max(findHeight(node.getLeft()), findHeight(node.getRight()));
            return depth + 1;
        }

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }
    }

    static class Node {
        private int data;
        private Node left;
        private Node right;

        private Node(int data) {
            this.data = data;
            left = right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}

