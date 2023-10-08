package com.grados.mywork.part1.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListQueue {
    // implement queue using linked list
    // enqueue
    // dequeue
    // peek
    // size
    // isEmpty

    private LinkedList<Integer> queue = new LinkedList<>();
    private int capacity;


    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(int item) {
        if (size() == capacity)
            throw new IllegalArgumentException();
        queue.add(item);
    }

    public void dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException();
        queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }

    public int size(){
        return queue.size();
    }

    public int peek(){
        return queue.getFirst();
    }

    @Override
    public String toString() {
        return Arrays.toString(queue.toArray());
    }
}
