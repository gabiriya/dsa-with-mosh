package com.grados;

import com.grados.mosh.hashtable.FindChar;
import com.grados.mosh.hashtable.MyHashTable;


public class Main {

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable();
        hashTable.put(10,"youssef");
        hashTable.put(11,"anass");
        hashTable.put(13,"Andro");
        System.out.println(hashTable.get(10));
        System.out.println(hashTable.get(11));
        System.out.println(hashTable.get(13));
        System.out.println("Before");
        hashTable.remove(11);
        System.out.println(hashTable.get(10));
        System.out.println(hashTable.get(11));
        System.out.println(hashTable.get(13));

    }
}
