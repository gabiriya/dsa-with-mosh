package com.grados.mosh.queue;


import java.util.Arrays;

public class MyArrayQueue {
    // enqueue
    // dequeue
    // peek
    // isEmpty
    // is full

    private int front;
    private int rear;


    private int[] items ;
    private int count;
    private int size;

    public MyArrayQueue(int capacity){
        items = new int[capacity];
        count = 0;
    }

    public void enqueue(int data){
        if (count == items.length)
            throw new IllegalArgumentException();

        items[rear] = data;
        rear = (rear +1) % items.length;
        count++;
    }

    public int dequeue(){
        var item = items[front];
        items[front] = 0;
        front= (front + 1) % items.length;
        count--;
        return item;
    }



    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull(){
        return count >= items.length;
    }

    public void print(){
        for (int i = front; i < rear; i++){
            System.out.println(items[i]);
        }
    }

    public int peek(){
        if (isEmpty())
            throw new IllegalArgumentException();
        System.out.println("peek :"+items[rear -1]);
        return items[rear -1];
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
