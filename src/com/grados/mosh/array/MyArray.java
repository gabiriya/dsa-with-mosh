package com.grados.mosh.array;

public class MyArray {

    private int [] array ;
    private int count;

    public MyArray(int length){
        array = new int[length];
    }

    public void insert(int number) {
        if (array.length == count) {
            int[] array2 = new int[count * 2];
            System.arraycopy(array, 0, array2, 0, array.length);
            array = array2;
        }
        array[count++] = number;
    }

    public void print(){
        for (int j =0; j< count ;j++) {
            System.out.println(array[j]);
        }
    }

    public void removeAt(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        System.arraycopy(array, index + 1, array, index, count - index);
        count--;
    }

    public int indexOf(int item){
        for (int i =0 ; i < count ; i++){
            if (array[i] == item) {
                System.out.println("the index of " + item + " is :" + i);
                return i;
            }
        }
        System.out.println("Item is not exist!!");
        return -1;
    }

    public int max(){
        if (count == 0){
            return -1;
        }
        int maxI = 0;
        for (int i: array){
            if (i > maxI)
                maxI = i;
        }
        return maxI;
    }

    public MyArray intersect(int[] arr2){
        if (count == 0 || arr2.length == 0)
            return null;
        MyArray intersected = new MyArray(1);
        for (int i: array){
            for (int j: arr2){
                if (i == j ) {
                    intersected.insert(i);
                }
            }
        }
        System.out.println("Printing intersected Array : ");
        intersected.print();
        return intersected;
    }

    public MyArray reverse(){
        if (count == 0)
            return null;
        MyArray reversedArray = new MyArray(1);
        for (int i = count-1; i>=0 ; i--){
            reversedArray.insert(array[i]);
        }
        return reversedArray;
    }
}
