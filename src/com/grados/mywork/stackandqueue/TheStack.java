package com.grados.mywork.stackandqueue;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class TheStack {

    // todo - exercise 1
    // exercise reversing a string
    public String reverseAString(String text) {
        if (text == null) throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reverse = new StringBuilder();
        while (!stack.isEmpty())
            reverse.append(stack.pop());
        return reverse.toString();
    }

    // todo - exercise 2

    private final List<Character> leftBrackets = Arrays.asList('[', '{', '(', '<');
    private final List<Character> rightBrackets = Arrays.asList(']', '}', ')', '>');

    public boolean isBalanced(String input) {
        if (input == null)
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (isLeftBracket(c))
                stack.push(c);
            if (isRightBracket(c)) {
                if (stack.isEmpty()) return false;
                var top = stack.pop();
                if (!bracketMatch(c, top)) return false;

            }
        }
        return stack.isEmpty();
    }

    private boolean bracketMatch(char c, char top) {
        return leftBrackets.indexOf(c) == rightBrackets.indexOf(top);
    }

    private boolean isRightBracket(char c) {
        return rightBrackets.contains(c);
    }

    private boolean isLeftBracket(char c) {
        return leftBrackets.contains(c);
    }

    // todo - exercise 3 - build a stack using array

    private int size;
    private int count = 0;
    private int[] array;

    public TheStack(int size) {
        this.size = size;
        this.array = new int[size];
    }

    public void push(int item) {
        if (count == size)
            throw new StackOverflowError();
        array[count++] = item;
    }

    public int pop(){
        if (count==0)
            throw new IllegalArgumentException();
        return array[--count];
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException();
        return array[count-1];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(array,0,count);
        return Arrays.toString(content);
    }
}
