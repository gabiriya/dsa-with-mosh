package com.grados.mosh.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class StackWithTwoQueues {

    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int size;

    // push
    public void push(int item){
        q2.add(item);
        while (!q1.isEmpty())
            q2.add(q1.remove());
        swipeQueues();
        size++;
    }

    // pop
    public int pop(){
        if (q1.isEmpty())
            throw new IllegalStateException();

        size--;
        return q1.remove();
    }
    private void swipeQueues(){
        var temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public boolean isEmpty(){
        return q1.isEmpty();
    }

    public int size(){
        return size;
    }

    public int peek(){
        if (q1.isEmpty())
            throw new IllegalStateException();
        return q1.peek();
    }
    @Override
    public String toString(){
        return Arrays.toString(q1.toArray());
    }
}
