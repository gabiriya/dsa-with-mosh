package com.grados.mosh.queue;

import java.util.*;

public class ReverseQueue {
    // you can only use
    // add
    // remove
    // isEmpty

    public void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.push(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
