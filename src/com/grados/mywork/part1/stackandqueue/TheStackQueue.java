package com.grados.mywork.part1.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class TheStackQueue {

    private int capacity;
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public TheStackQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if (stack1.empty() && stack2.empty())
            throw new IllegalArgumentException();

        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.pop();
    }

    @Override
    public String toString(){
        return Arrays.toString(stack1.toArray());
    }
}
