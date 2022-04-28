package com.grados.mosh.hashtable;

import java.util.*;

public class FindChar {
    // find first non-repeated char
    // a green apple => g

    public char findFirstNonRepeatedChar(String text){
        Map<Character,Integer> map = new HashMap<>();
        var chars = text.toCharArray();

        for (var c:chars){
            if (map.containsKey(c)){
                var count = map.get(c);
                map.put(c,++count);
            }else {
                map.put(c,1);
            }
        }
        for (var c:chars)
            if (map.get(c)==1)
                return c;
        return 0;
    }
    public char findFirstRepeatedChar(String text){
        Set<Character> set = new HashSet<>();
        var chars = text.toCharArray();
        for (var c:chars){
            if (!set.contains(c))
                set.add(c);
            else
                return c;
        }
        return 0;
    }
}
