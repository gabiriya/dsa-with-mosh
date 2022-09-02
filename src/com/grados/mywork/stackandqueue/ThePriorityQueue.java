package com.grados.mywork.stackandqueue;

import java.util.Arrays;

public class ThePriorityQueue {

    private int count;
    private int[] items;
    private int capacity;

    public ThePriorityQueue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == capacity) {
            throw new IllegalArgumentException();
        }
        if (count == 0 && count < capacity) {
            items[0] = item;
        } else if (count == 1) {
            if (items[0] > item) {
                var temp = items[0];
                items[1] = temp;
                items[0] = item;
            } else items[1] = item;
        } else {
            for (int i = count - 1; i >= 0; i--) {
                if (items[i] < item) {
                    items[i + 1] = item;
                    break;
                }
                items[i + 1] = items[i];
                if (i == 0) {
                    items[0] = item;
                }
            }
        }
        count++;
    }

    public int dequeue() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        var item = items[0];
        for (int i = 0; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
        return item;
    }
    
    public void reverse(int k){
        int temp;
        for (int i = 0,j=k; i < (k+1)/2; i++) {
            temp = items[i];
            items[i] = items[--j];
            items[j] = temp;
        }
    }

    @Override
    public String toString() {
        int[] nut = new int[count];
        System.arraycopy(items, 0, nut, 0, count);
        return Arrays.toString(nut);
    }
}
