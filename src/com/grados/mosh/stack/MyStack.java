package com.grados.mosh.stack;

public class MyStack {

    private int size = 1;
    public int[] array;

    public MyStack() {
        array = new int[size];
    }

    // push
    public void push(int data){
        array[size++ - 1] = data;
        int[] arr = new int[size];
        System.arraycopy(array, 0, arr, 0, size-1);
        array = arr;
    }

    // pop
    public int pop(){
        int[] arr = new int[size-1];
        var last = array[size-2];
        System.arraycopy(array, 0, arr, 0, size-2);
        array = arr;
        return last;
    }

    // peek
    public int peek(){
        if (!isEmpty())
            return array[size-2];
        else throw new IllegalArgumentException();
    }


    // isEmpty
    public boolean isEmpty(){
        return size == 1;
    }
    // printIt
    public void printIt(){
        System.out.print("[");
        for (int i= 0; i< size-2 ; i++){
            System.out.print( array[i] + ",");
        }
        System.out.print("]");
    }
}

