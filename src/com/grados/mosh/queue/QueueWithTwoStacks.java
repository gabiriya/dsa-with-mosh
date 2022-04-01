package com.grados.mosh.queue;

import java.util.Arrays;
import java.util.Stack;

public class QueueWithTwoStacks {
    private int count;
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // enqueue
    // dequeue
    // peek
    // isEmpty
    // is full

    public QueueWithTwoStacks(int count) {
        this.count = count;
    }


    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();
        MoveStack1ToStack2();
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();
        MoveStack1ToStack2();
        return stack2.peek();
    }

    private void MoveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    @Override
    public String toString(){
        return Arrays.toString(stack1.toArray());
    }
}
