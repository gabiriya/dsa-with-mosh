package com.grados.mosh.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
    // TODO : to be implemented
    // q1 : [50]
    // q2 : [40, 30, 20, 10]
    //
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();

    // push
    public void push(int item){
        q2.add(item);
        while (!q1.isEmpty())
            q2.add(q1.remove());
        swipeQueues();
    }

    // pop
    public int pop(){
        if (q1.isEmpty())
            throw new IllegalStateException();

        return q1.remove();
    }
    private void swipeQueues(){
        var temp = q1;
        q1 = q2;
        q2 = temp;
    }

    @Override
    public String toString(){
        return Arrays.toString(q1.toArray());
    }
}
