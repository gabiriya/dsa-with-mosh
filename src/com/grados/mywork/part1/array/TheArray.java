package com.grados.mywork.part1.array;

public class TheArray {
    private int count = 0;
    private int[] array;

    public TheArray(int size) {
        this.array = new int[size];
    }

    public void insert(int value) {
        if (count == array.length)
            expandArray();
        array[count++] = value;
    }

    public void removeAt(int index) {
        if (index > count || index < 0) {
            throw new IllegalArgumentException();
        }
        count--;
        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }
    }

    public void printIt() {
        for (int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }
    }

    // O(n)
    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (value == array[i])
                return i;
        }
        return -1;
    }

    // O(n)
    public int max() {
        if (count == 0)
            return -1;
        int max = array[0];
        for (int i = 1; i < count; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public int[] intersect(int[] paramArray) {
        if (paramArray.length == 0)
            throw new IllegalArgumentException();

        TheArray list = new TheArray(1);
        for (int i = 0; i < count; i++) {
            for (int k : paramArray) {
                if (array[i] == k)
                    list.insert(array[i]);
            }
        }
        return list.array;
    }

    //O(n)
    public void reverse() {
        if (count == 0)
            return;
        if (count == 1)
            return;
        int[] newArr = new int[count];
        for (int i = 0, j = count - 1; i < count; i++, j--) {
            newArr[i] = array[j];
        }
        array = newArr;
    }

    public void insertAt(int item, int index) {
        if (index > count || index < 0)
            throw new IllegalArgumentException();
        if (count == array.length)
            expandArray();
//        if (index == count) {
//            insert(item);
//            return;
//        }
        count++;
        for (int i = count; i >= index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
    }

    private void expandArray() {
        int[] newArray = new int[count * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

    }
}
