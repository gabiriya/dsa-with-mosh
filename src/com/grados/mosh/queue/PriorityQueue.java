package com.grados.mosh.queue;

import java.util.Arrays;

public class PriorityQueue {
    // insert(2)
    private int[] arr = new int[7];
    private int count;

    public void add(int item){
        if (isEmpty()){
            arr[0] = item;
            count++;
            return;
        }
        if (count == 1) {
            if (arr[0] > item) {
                arr[1] = arr[0];
                arr[0] = item;
            }else if (arr[0]<item)
                arr[1] = item;
            count++;
            return;
        }
        if (isFull()){
            int[] arr2 = new int[count+1];
            System.arraycopy(arr,0,arr2,0,count);
            arr = arr2;
            var i =shift(item);
            arr[i] = item;
            return;
        }

        var i = shift(item);
        arr[i] = item;
        count++;
        }

    private boolean isFull() {
        return count == arr.length;
    }

    private int shift(int item){
        int i;
        for ( i = count - 1; i >= 0 ; i--) {
            if (arr[i] > item) {
                arr[i + 1] = arr[i];
            } else break;
        }
        return i+1;
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();
        return arr[--count];
    }

    public void reverse(int k){
        if (isEmpty())
            return;
        int temp;
        for (int i = 0 ; i<k/2 ; i++){
            temp = arr[k-i-1];
            arr[k-i-1] = arr[i];
            arr[i] = temp;
        }
    }
    public boolean isEmpty(){
        return count == 0;
    }
    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
