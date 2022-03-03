package com.grados;

import com.grados.mosh.stack.BalancedExpression;

public class Main {

    public static void main(String[] args) {
        BalancedExpression b = new BalancedExpression();
        System.out.println(b.isItBalanced("({}{}{})"));
    }
}
