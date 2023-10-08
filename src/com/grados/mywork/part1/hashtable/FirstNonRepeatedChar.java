package com.grados.mywork.part1.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

    private Map<Character,Integer> text = new HashMap<>();


    public Character find(String input){
        var chars = input.replace(" ","").toCharArray();
        for (char c : chars) {
            if (text.containsKey(c)) {
                var i = text.get(c);
                text.put(c, ++i);
            } else {
                text.put(c, 1);
            }
        }

        for (var c : chars){
            if (text.get(c) == 1)
                return c;
        }
        return null;
    }
}
