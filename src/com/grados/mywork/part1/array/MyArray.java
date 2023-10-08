package com.grados.mywork.part1.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray extends ArrayList<Integer> {

    public int max() {
        int max = this.get(0);
        for (Integer integer : this) {
            if (integer > max)
                max = integer;
        }
        return max;
    }
    // O(n)


    public int[] intersect(int[] array2) {
        int[] temp = new int[this.size()];
        int c = 0;
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < array2.length; j++) {
                if (this.get(i).equals(array2[j])) {
                    temp[c++] = this.get(i);
                }
            }
        }
        int[] intersect = new int[c];
        for (int i = 0; i < c; i++) {
            intersect[i] = temp[i];
        }
        return intersect;
    }

    public int[] reverse() {
        int c = 0;
        int[] temp = new int[this.size()];
        for (int i = this.size(); i > 0; i--) {
            temp[c++] = this.get(i - 1);
        }

        return temp;
    }

    public void insertAt(int item, int index) {
        int[] newArr = new int[this.size() + 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = this.get(i);
        }

        newArr[index] = item;

        for (int i = index ; i < this.size(); i++) {
            newArr[i+1] = this.get(i);
        }

        System.out.println(Arrays.toString(Arrays.stream(newArr).toArray()));
    }
}


