package com.grados.mywork;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class TheArrayQueue {
    // exercise 1 - reverse a Queue

    public void reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.push(q.remove());
        }

        while (!stack.isEmpty())
            q.add(stack.pop());
    }


    // exercise 2 - implement a queue using array
    private int front = 0;
    private int rear = 0;
    private int size;
    private int[] items;
    private int count;

    public TheArrayQueue(int size) {
        this.size = size;
        items = new int[size];
    }

    public void enqueue(int data) {
        if (count == items.length)
            throw new IllegalArgumentException();

        items[rear] = data;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException();

        var item = items[front];
        items[front] = 0;
        count--;
        front = (front + 1) % items.length;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void printQueue() {
        for (int i = front; i < rear; i++) {
            System.out.println(items[i]);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
