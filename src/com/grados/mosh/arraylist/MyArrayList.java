package com.grados.mosh.arraylist;

import java.util.NoSuchElementException;

public class MyArrayList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // add first


    public void addFirst(int data) {
        Node node = new Node(data);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    // add last
    public void addLast(int data) {
        var node = new Node(data);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // isEmpty
    private boolean isEmpty(){
        return first == null;
    }
    // delete first
    public void deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last){
            first = last = null;
        }else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    // delete last
    public void deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        }else {
            Node previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node){
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }


    // contains
    public boolean contains(int item) {
        var current = first;
        while (current != null) {
            if (item == current.value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    // index of
    public int indexOf(int item) {
        var current = first;
        int i = 0;
        while (current != null) {
            if (current.value == item)
                return i;
            current = current.next;
            i++;
        }
        return -1;
    }

    public void printIt(){
        var current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public int size() {
        return size;
    }

    public int [] toArray(){
        if (isEmpty())
            return null;
        int[] array = new int[size];
        var current = first;
        int i = 0;
        while (current != null){
            array[i++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;

        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

    public void myReverse(){
        // [ 10 <- 20 -> 30 -> 40 -> 50]
        //
        if (isEmpty()) return;
        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;

    }

    public int getKthFromTheEnd(int k){
        // [ 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70 -> 80 ]
        //                                       a      b
        if (isEmpty())
            throw new IllegalArgumentException();

        var a = first;
        var b = first;
        for (int i = 0 ; i< k-1 ; i++){
            b = b.next;
            if (b == null)
                throw new IllegalArgumentException();
        }
        while (b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle(){
        // [ 10 -> 20 -> 30 -> 40 ]
        if (isEmpty()) return;
        var a = first;
        var b = first;

        int i = 1;
        while (b != last){
            if (b.next.next == null) {
                System.out.println(a.value +"  " + a.next.value);
                return;
            }
            a = a.next;
            b = b.next.next;
            i++;
        }
        if (i == 1 || i == 2) {
            System.out.println(a.value);
            return;
        }
        if (i % 2 == 0)
            System.out.println( a.value + " " + a.next.value);
        if (i % 2 == 1)
            System.out.println(a.value);
    }

    public void hasLoop(){
        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                System.out.println("yeah , has loop !!");
                return;
            }
        }
        System.out.println("nope , hasn't anything!");
    }
}
