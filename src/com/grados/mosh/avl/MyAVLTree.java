package com.grados.mosh.avl;

public class MyAVLTree {
    private static class Node {
        private int value;
        private Node leftNode;
        private Node rightNode;

        Node(int value) {
            this.value = value;
        }
    }


    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);
        // base condition
        if (root.value > value)
            root.leftNode = insert(root.leftNode, value);
        else
            root.rightNode = insert(root.rightNode, value);

        return root;
    }
}
