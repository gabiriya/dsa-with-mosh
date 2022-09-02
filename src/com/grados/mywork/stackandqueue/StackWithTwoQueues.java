package com.grados.mywork.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();


    public void push(int item) {
        if (queue1.isEmpty()) {
            queue2.add(item);
        } else {
            queue2.add(item);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
        }
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop(){
        return queue1.poll();
    }
}
