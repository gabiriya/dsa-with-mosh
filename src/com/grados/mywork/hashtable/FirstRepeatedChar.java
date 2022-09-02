package com.grados.mywork.hashtable;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {

    public char find(String input) {
        var chars = input.toCharArray();
        Set<Character> list = new HashSet<>();
        for (var c : chars) {
            if (list.contains(c))
                return c;
            list.add(c);
        }
        return Character.MAX_HIGH_SURROGATE;
    }
}
