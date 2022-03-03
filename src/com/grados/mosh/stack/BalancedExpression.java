package com.grados.mosh.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpression {

    private final List<Character> leftBracket = Arrays.asList('(','<','{','[');
    private final List<Character> rightBracket = Arrays.asList(')','>','}',']');

    public boolean isItBalanced(String expression){
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()){
            if (isLeftBracket(ch))
                stack.push(ch);
            if (isRightBracket(ch)) {
                if (stack.isEmpty()) return false;
                var top = stack.pop();
                if (!isMatch(ch, top)
                ) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        return leftBracket.indexOf(left) == rightBracket.indexOf(right);
    }

    private boolean isRightBracket(char ch) {
        return rightBracket.contains(ch);
    }

    private boolean isLeftBracket(char ch) {
        return leftBracket.contains(ch);
    }
}
