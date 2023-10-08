package com.grados;


import com.grados.mywork.part1.trees.BinaryTree;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(7);
        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(1);
        System.out.println("printing min val");
        var x = tree.minValue();
        System.out.println(x);
    }
}
