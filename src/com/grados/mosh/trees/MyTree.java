package com.grados.mosh.trees;

import com.sun.source.tree.Tree;

public class MyTree {
    // Tree (root)
    //Node(value,leftChild,rightChild)
    // insert(value)
    // find (value) : bool

    // var current = root
    // current  = current.leftChild

    private static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;


    public void insert(int data) {
        var node = new Node(data);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (current.value > data) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }


    public boolean find(int data) {
        var current = root;
        while (current != null) {
            if (data < current.value)
                current = current.leftChild;
            else if (data > current.value)
                current = current.rightChild;
            else return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        // base condition
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }


    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }


    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    //                   10
    //             5            15
    //          2     8     13      17

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        // base condition
        if (root == null) return -1;
        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(height(root.rightChild), height(root.leftChild));
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node root) {
        if (root == null) {
            return -1;
        } else {
            int lDepth = depth(root.leftChild);
            int rDepth = depth(root.rightChild);

            return 1 + Math.max(lDepth, rDepth);
        }
    }

    public int min() {
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    private int min(Node root) {
        // base condition
        if (isLeaf(root))
            return root.value;
        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean areEquals(MyTree node) {
        if (node == null)
            return false;
        return equals(node.root, root);
    }

    private boolean equals(Node node, Node root) {

        if (node == null && root == null)
            return true;
        if (node != null && root != null)
            return node.value == root.value
                    && equals(node.rightChild, root.rightChild)
                    && equals(node.leftChild, root.leftChild);
        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBinarySearchTree(Node root, int min , int max){
        // base condition
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return isBinarySearchTree(root.leftChild,min , root.value - 1) && isBinarySearchTree(root.rightChild,root.value +1,max);
    }
}

