package com.grados.edabit.arrays;

public class Switcharoo {
    // done!!
    public String flipEndChars(String s) {
        int len = s.length();
        if (len < 2) {
            return "Incompatible";
        }
        char first = s.charAt(0);
        char last = s.charAt(len - 1);
        if (first == last) {
            return "Two's a pair.";
        }
        String ss = last + s.substring(1, len - 1) + first;//+ s.charAt(len-1);
        System.out.println("s : " + ss);
        return s;
    }
}

