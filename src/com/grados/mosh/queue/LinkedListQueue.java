package com.grados.mosh.queue;

public class LinkedListQueue {
    // Node class
    private static class Node{
        private int value;
        private Node next;
        public Node(int data){
            this.value = data;
        }
    }
    private Node first;
    private Node last;
    private int size;


    // to be implemented
    // enqueue
    public void enqueue(int data){
        // add last - remove first
        Node node = new Node(data);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // dequeue
    public int dequeue(){
        var deq = first.value;
        first = first.next;
        size--;
        return deq;
    }

    // peek
    public int peek(){
        return first.value;
    }
    // size
    public int size(){
        return size;
    }
    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String  toString(){
        Node current = first;
        while (current.next != null){
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println(current.value);
        return "end";
    }
}
