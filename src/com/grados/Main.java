package com.grados;

import com.grados.mosh.stack.BalancedExpression;
import com.grados.mosh.stack.MyStack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.pop();
        stack.printIt();
    }
}
